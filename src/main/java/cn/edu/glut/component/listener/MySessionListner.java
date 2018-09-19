package cn.edu.glut.component.listener;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
@Component
public class MySessionListner implements HttpSessionListener,ServletContextListener{
	Connection con;
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("初始化"+this.getClass().getName());
		ServletContext application = sce.getServletContext();
		WebApplicationContext appctx = WebApplicationContextUtils.getWebApplicationContext(application);
		con = (Connection) appctx.getBean("jmsConnection");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			con.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute("jmsConnection", con);
		System.out.println("session创建完成,con:"+con);
		
	}
	
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}
	
	
	
}
