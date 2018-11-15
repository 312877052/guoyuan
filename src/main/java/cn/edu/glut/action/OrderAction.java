package cn.edu.glut.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.xdevapi.JsonArray;

import cn.edu.glut.component.dao.OrderDao;
import cn.edu.glut.component.service.CommodityService;
import cn.edu.glut.component.service.OrderService;
import cn.edu.glut.component.service.impl.CommodityServiceImpl;
import cn.edu.glut.exception.LackofstockException;
import cn.edu.glut.exception.NoCommodityException;
import cn.edu.glut.model.BuyList;
import cn.edu.glut.model.Car;
import cn.edu.glut.model.Commodity;
import cn.edu.glut.model.EnsureOrderVo;
import cn.edu.glut.model.Order;
import cn.edu.glut.model.OrderItem;
import cn.edu.glut.model.ReceiverAddress;
import cn.edu.glut.model.UserInfo;
import cn.edu.glut.util.AppUtil;
import cn.edu.glut.util.DebugOut;
import cn.edu.glut.util.ResponseCode;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/order")
public class OrderAction {

	Logger log = LogManager.getLogger();

	@Resource(name = "orderService")
	private OrderService orderService;
	
	@Resource(name="commodityService")
	private CommodityService commodService;

	/**
	 * 确认订单信息展示
	 * 直接购买 传购买数量 和商品id
	 * @param session
	 * @param commodityId
	 * @param buyMesNumber
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ensureOrderDirect")
	public String ensureOrderDirect(HttpSession session, Model model,HttpServletRequest request, BuyList buy) {
		
		
		// TODO 根据session获取用户id
		UserInfo user=(UserInfo)session.getAttribute("user");
		//获取商品信息表
		Commodity commodity = commodService.getCommodityInfo(buy.getCommodityId());

		//转成json
		JSONObject commodityJson=JSONObject.fromObject(commodity);
		JSONObject obj=new JSONObject();
		obj.put("CommodityInfo", commodityJson);
		obj.put("buyInfo", JSONArray.fromObject(buy));
		//获取默认收货地址
		ReceiverAddress addr= orderService.getDefaultAddr(user.getUserId());

		obj.put("defaultAddr", addr);
		
		
		model.addAttribute("pageData", obj.toString());
		return "ensureBuyMessage";
	}

	/**
	 * 添加商品到购物车
	 * 
	 * @param car
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping("/addCar")
	public String addCar(Car car, HttpSession session, HttpServletResponse response) {
		UserInfo user = (UserInfo) session.getAttribute("user");
		car.setUserId(user.getUserId());
		boolean result = orderService.addCar(car);
		try {
			if (result) {
				response.getWriter().println(ResponseCode.SUCCESS);
			} else {
				response.getWriter().println(ResponseCode.ERROR);
			}
		} catch (Exception e) {
			log.error(e, e);
		}

		return null;
	}

	
	/**
	 * 提交订单
	 * @param order
	 * @param response
	 * @return
	 */
	@RequestMapping("commitOrder")
	@ResponseBody
	public String commitOrder(@RequestParam(name="order") String orderJson,@RequestParam("list")String itemJson,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		
		Order order=null;
		JSONObject jsonObject =JSONObject.fromObject(orderJson);
		order=(Order) JSONObject.toBean(jsonObject, Order.class);
		DebugOut.print(order.getPayState());
		JSONArray arry=JSONArray.fromObject(itemJson);
		List<OrderItem> orderItems=(List<OrderItem>) JSONArray.toCollection(arry, OrderItem.class);
		 
		
		UserInfo user=(UserInfo)session.getAttribute("user");
		if(user!=null) {
			order.setUserId(user.getUserId());
		}
		//提交订单
		boolean result=orderService.commitOrder(order,orderItems);
		
		String ip=request.getRemoteAddr();
		 //调用支付接口
		Map<String, Object> payResult= orderService.pay(order,user,ip);
		//添加key
		payResult.put("key", AppUtil.mch_key);
		payResult.put("order", order);
		JSONObject obj=new JSONObject();
		obj.accumulateAll(payResult);
		try {
			response.getWriter().print(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 取消订单 ajax
	 *   
	 * @return
	 */
	@RequestMapping("cancelTheOrder")
	public String cancelTheOrder(@RequestParam("orderId") String orderId, @RequestParam(name="page" ,required=false)String page,HttpServletResponse response) {
		DebugOut.print("进来了");
		Long id = null;
		try {
			id = Long.valueOf(orderId);
			boolean result = orderService.cancelTheOrder(id);
			DebugOut.print(result);
			if("true".equals(page)) {
				return "cancel";
			}
			if (result) {
				response.getWriter().println("success");
			} else {
				response.getWriter().println("error");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 查看未完成订单 应显示商品名 发货状态 数量 果苗类商品可以查看果苗状态
	 * 
	 * @return
	 */
	@RequestMapping("buyList")
	public ModelAndView viewOrder(HttpSession session) {
		UserInfo user = (UserInfo) session.getAttribute("user");
		// 查询出所有未完成订单
		List<OrderItem> items = orderService.getAllNotFinshed(user.getUserId());
		ModelAndView mv = new ModelAndView("buyList");
		mv.addObject("orderItems", items);
		return mv;
	}

	
	/**
	 * 异步接收支付结果
	 * @param reServletRequest
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("payResult")
	public String pay(HttpServletResponse response,HttpServletRequest request,HttpSession session) {
		DebugOut.print("\n\npayResult.action\n\n");
		try {
			InputStreamReader reader=new InputStreamReader(request.getInputStream());
			BufferedReader br=new BufferedReader(reader);
			String line=null;
			StringBuffer sb=new StringBuffer();
			
			while((line=br.readLine())!=null) {
				sb.append(line);
			}
			br.close();
			
			DebugOut.print(sb);
			
			//调用业务层处理
			String res=orderService.payResult(sb.toString());
			
			OutputStream out=response.getOutputStream();
			
			out.write(res.getBytes("UTF-8"));
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("payState")
	public void payState(@RequestParam("orderId")String orderId,HttpServletResponse response) {
		 
		DebugOut.print("请求结果");
		boolean trandeState=orderService.getTradeState(orderId);
		 response.setCharacterEncoding("utf-8");
		 try {
			if(trandeState) {
				response.getWriter().print("SUCCESS");
			}else {
				response.getWriter().print("FAILL");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}
	

