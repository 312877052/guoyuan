package guoyuan;


import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.edu.glut.component.dao.CommodityDao;
import cn.edu.glut.component.dao.VCategoryDao;

import cn.edu.glut.component.service.VCategoryService;
import cn.edu.glut.component.service.impl.OrderServiceImpl;
import cn.edu.glut.model.Commodity;
import cn.edu.glut.model.OrderItem;
import cn.edu.glut.model.ServerResponse;
import cn.edu.glut.model.UserInfo;
import cn.edu.glut.util.DebugOut;
import net.sf.json.JSONObject;

@ContextConfiguration(value= {"/spring-mvc.xml","/spring-common.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestApp {
	
	@Resource
	OrderServiceImpl orderService;
	@Resource
	CommodityDao commodityDao;
	@Resource
	VCategoryDao vc;
	@Resource
	VCategoryService scs;
	
	@Test
	public void test2() {
		List<Long> ids=new ArrayList<>();
		ids.add(153569224283547L);
		ids.add(153569211716478L);
		List<Commodity> commodities=commodityDao.getCommodityListByIds(ids);
		
		for (Commodity commodity : commodities) {
			System.out.println(commodity.getCommodityName());
		}
	}
	
}
