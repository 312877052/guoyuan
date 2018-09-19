package cn.edu.glut.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Message {
	
	@Resource(name="jmsConnection")
	Connection con;
	@RequestMapping("getMessage")
	public String get(HttpSession session,HttpServletResponse response) {
		MessageConsumer consumer=(MessageConsumer) session.getAttribute("jmsConsumer");
		//创建监听器 有消息发送 没有就hold住
		try {
			javax.jms.Message message=consumer.receive(10000);
			TextMessage tm=(TextMessage)message;
			if(tm!=null) {
				response.getWriter().println(tm.getText());
			}else {
				response.getWriter().println("noMessage");
			}
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
