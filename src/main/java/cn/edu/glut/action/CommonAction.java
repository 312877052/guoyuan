package cn.edu.glut.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 界面跳转支持 控制页面跳转基本逻辑
 * @author jones
 *
 */
@Controller
@RequestMapping("common")
public class CommonAction {
	
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
	/*@RequestMapping("home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("video")
	public String video() {
		return "video";
	}

	@RequestMapping("buylist")
	public String buylist() {
		return "buyList";
	}

	@RequestMapping("my")
	public ModelAndView my(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("my");
		mv.addObject("user", session.getAttribute("user"));
		return mv;
	}
	
	@RequestMapping("message")
	public String message() {
		return "message";
	}
	
	@RequestMapping("fruitSupermarket")
	public String fruitSupermarket() {
		return "fruitSupermarket";
	}
	
	@RequestMapping("login")
	public String login() {
		System.out.println("轻轻地我来过");
		return "login";
	}
	@RequestMapping("regist")
	public String regist() {
		return "register";
	}
	*/
}
