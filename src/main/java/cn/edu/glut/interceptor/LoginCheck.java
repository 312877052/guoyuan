package cn.edu.glut.interceptor;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

import cn.edu.glut.model.UserInfo;
import cn.edu.glut.util.DebugOut;
import net.sf.json.JSONObject;

/**
 * 拦截器类 用作请求之前判断是否已经登录
 * @author 于金彪
 *
 */
public class LoginCheck implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("拦截器:"+request.getServletPath());
		UserInfo user=(UserInfo) request.getSession().getAttribute("user");
		if(user==null) {
			//思路一 取出目标路径和参数放到session中 登录成功后从session中取出转发
			String targetPath=request.getServletPath();
			request.getSession().setAttribute("targetPath", targetPath);
			DebugOut.print(targetPath);
			Map<String, String[]> targetParam=request.getParameterMap();
			JSONObject obj=JSONObject.fromObject(targetParam);
			request.getSession().setAttribute("targetParam", obj.toString());
			DebugOut.print(obj.toString());
			//未登录 返回登录页面
			request.getRequestDispatcher("/common/login.action").forward(request, response);
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		DebugOut.print("后置处理器:"+request.getServletPath());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		DebugOut.print("完成处理:"+request.getServletPath()+request.toString());
	}

}
