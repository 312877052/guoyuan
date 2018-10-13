package guoyuan;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

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
import cn.edu.glut.component.dao.VCategoryDao;
import cn.edu.glut.component.service.UserService;
import cn.edu.glut.component.service.VCategoryService;
import cn.edu.glut.component.service.impl.OrderServiceImpl;
import cn.edu.glut.model.OrderItem;
import cn.edu.glut.model.ReceiverAddress;
import cn.edu.glut.model.UserInfo;
import cn.edu.glut.model.Vid;
import cn.edu.glut.util.ServerResponse;
@ContextConfiguration(value= {"/spring-mvc.xml","/spring-common.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestApp {
	
	@Resource
	OrderServiceImpl orderService;
	
	@Resource
	VCategoryDao vc;
	@Resource
	VCategoryService scs;
	
	@Test
	public void test2() {
		List<OrderItem> items=orderService.getAllNotFinshed(1);
		System.out.println("hshs");
		for (OrderItem orderItem : items) {
			System.out.println(orderItem.getId());
		}
		
	}
	@Test
	public void test3() {
		@SuppressWarnings("unused")
		ServerResponse<List<Integer>> categoryAndChildrenById = scs.getCategoryAndChildrenById(1);
		System.out.println();
		
	}
}
