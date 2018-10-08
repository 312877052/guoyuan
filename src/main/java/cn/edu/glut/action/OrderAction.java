package cn.edu.glut.action;


import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.glut.component.service.OrderService;
import cn.edu.glut.model.Car;
import cn.edu.glut.model.EnsureOrderVo;
import cn.edu.glut.model.Order;
import cn.edu.glut.model.OrderItem;
import cn.edu.glut.model.ReceiverAddress;
import cn.edu.glut.model.UserInfo;
import cn.edu.glut.util.ResponseCode;


@Controller
@RequestMapping("/order")
public class OrderAction {
	
	Logger log = LogManager.getLogger();
	
	@Resource(name="orderService")
	private OrderService orderService;
	/**
	 * 确认订单信息展示
	 * @param session
	 * @param commodityId
	 * @param buyMesNumber
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/ensureOrderDirect",method=RequestMethod.GET)
	public String ensureOrderDirect(HttpSession session,Long commodityId,Integer buyNumber,Model model) {
		//TODO 根据session获取用户id
		EnsureOrderVo ensureOrderVo = orderService.ensureOrderInfoDirect(1,commodityId,buyNumber);
		if(ensureOrderVo == null) {
			return null;
		}
		model.addAttribute("ensureOrderVo", ensureOrderVo);
		return "ensureBuyMessage";
	}
	
	/**
	 * 添加商品到购物车
	 * @param car
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping("/addCar")
	public String  addCar(Car car,HttpSession session,HttpServletResponse response) {
		UserInfo user=(UserInfo)session.getAttribute("user");
		car.setUserId(user.getUserId());
		boolean result=orderService.addCar(car);
		try {
			if(result) {
				response.getWriter().println(ResponseCode.SUCCESS);
			}else {
				response.getWriter().println(ResponseCode.ERROR);
			}
		}catch (Exception e) {
			log.error(e,e);
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
	public String commitOrder(Order order,HttpServletResponse response,HttpSession session) {
		
		UserInfo user=(UserInfo)session.getAttribute("user");
		if(user!=null) {
			order.setUserId(user.getUserId());
		}
		//提交订单
		 boolean result=orderService.commitOrder(order);
		 //调用支付接口
		 
		return null;
	}
	
	/**
	 * 取消订单 ajax 
	 * @return
	 */
	@RequestMapping("cancelTheOrder")
	public String cancelTheOrder(@RequestParam("orderId")String orderId,HttpServletResponse response) {
		Long id=null;
		try {
			 id= Long.valueOf(orderId);
			boolean result=orderService.cancelTheOrder(id);
			if(result) {
				response.getWriter().println("success");
			}else {
				response.getWriter().println("error");
			}
		}catch (NumberFormatException | IOException e) {
			
		}
		
		return null;
	}
	/**
	 * 查看未完成订单 应显示商品名 发货状态 数量 果苗类商品可以查看果苗状态
	 * @return
	 */
	@RequestMapping("buyList")
	public ModelAndView viewOrder(HttpSession session) {
		UserInfo user=(UserInfo)session.getAttribute("user");
		//查询出所有未完成订单
		List<OrderItem> items=orderService.getAllNotFinshed(user.getUserId());
		ModelAndView mv =new ModelAndView("buyList");
		mv.addObject("orderItems", items);
		return mv;
	}
	     
}
