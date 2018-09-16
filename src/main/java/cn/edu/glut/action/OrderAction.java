package cn.edu.glut.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.glut.component.service.OrderService;
import cn.edu.glut.model.EnsureOrderVo;


@Controller
@RequestMapping("/order")
public class OrderAction {
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
}
