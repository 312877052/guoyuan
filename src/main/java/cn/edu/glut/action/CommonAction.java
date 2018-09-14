package cn.edu.glut.action;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
