package guoyuan;


import java.util.List;

import javax.annotation.Resource;



import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import cn.edu.glut.component.dao.VCategoryDao;

import cn.edu.glut.component.service.VCategoryService;
import cn.edu.glut.component.service.impl.OrderServiceImpl;
import cn.edu.glut.model.OrderItem;

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
	}
}
