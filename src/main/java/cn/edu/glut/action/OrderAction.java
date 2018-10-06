package cn.edu.glut.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.glut.component.service.OrderService;
import cn.edu.glut.model.Car;
import cn.edu.glut.model.EnsureOrderVo;
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
}
