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
import cn.edu.glut.model.ReceiverAddress;
import cn.edu.glut.model.UserInfo;
@ContextConfiguration(value= {"/spring-mvc.xml","/spring-common.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestApp {
	
	
	
	@Resource
	MockHttpServletRequest request;
	
	@Resource
	MockHttpServletResponse response;
	
	@Resource
	WebApplicationContext wac;
	
	MockMvc mvc;
	
	@Resource
	MockHttpSession session;
	@Resource
	ReceiverAddressMapper ram;
	
	@Before
	public void before() {
		mvc=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void test() {
		
		
		try {
			
			//模拟登陆
			HttpSession session;
			session=mvc.perform(MockMvcRequestBuilders.post("/user/login.action")
					.param("tel", "13152533129")
					.param("pwd", "123456")
					).andReturn().getRequest().getSession();
			UserInfo user= (UserInfo) session.getAttribute("user");
			ResultActions res=mvc.perform(
					MockMvcRequestBuilders.get("/user/address.action")
					.characterEncoding("utf-8")
					.sessionAttr("user", user)
					);
	
			ModelAndView mv =res.andReturn().getModelAndView();
			List<ReceiverAddress> addrs=(List<ReceiverAddress>)mv.getModel().get("addrs");
			System.out.println(addrs);
			for (ReceiverAddress receiverAddress : addrs) {
				System.out.println(receiverAddress.getReceiverName());
			}
			//模拟添加


//			
//			
//			
//			receiver_postalcode
//			is_default_address
			mvc.perform(MockMvcRequestBuilders.post("/user/addShippingAddr.action")
					.sessionAttr("user", user)
					.param("receiverName", "李狗蛋")
					.param("receiverMobile", "15036171234")
					.param("receiverState", "广西")
					.param("receiverCity", "桂林")
					.param("receiverDistrict", "雁山")
					.param("receiverAddress", "桂林理工大学")
					);
			
			System.out.println(res.andReturn().getResponse().getStatus()+":72");
			String result=res.andReturn().getResponse().getContentAsString();
			System.out.println(result.length());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
	}
	
	
}
