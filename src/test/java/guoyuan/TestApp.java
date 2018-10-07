package guoyuan;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.glut.component.dao.ReceiverAddressMapper;
import cn.edu.glut.component.service.UserService;
import cn.edu.glut.component.service.impl.OrderServiceImpl;
import cn.edu.glut.model.ReceiverAddress;
import cn.edu.glut.model.UserInfo;
@ContextConfiguration(value= {"/spring-mvc.xml","/spring-common.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestApp {
	
	@Resource()
	OrderServiceImpl orderService;
	
	
	@Test
	public void test2() {
		orderService.cancelTheOrder(15370239886906508L);
		
	}
	
}
