package guoyuan;


import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
import cn.edu.glut.util.DebugOut;

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
		//202.193.89.67
		DebugOut.Debug=true;
		BigDecimal a=new BigDecimal(100);
		System.out.println(a);
		System.out.println(a.equals(new BigDecimal(100)));
	}
	@Test
	public void test3() {	
	}
}
