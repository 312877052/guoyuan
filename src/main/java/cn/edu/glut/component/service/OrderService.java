package cn.edu.glut.component.service;

import java.util.List;
import java.util.Map;

import cn.edu.glut.exception.LackofstockException;
import cn.edu.glut.exception.NoCommodityException;
import cn.edu.glut.model.Car;
import cn.edu.glut.model.EnsureOrderVo;
import cn.edu.glut.model.Order;
import cn.edu.glut.model.OrderItem;
import cn.edu.glut.model.UserInfo;

public interface OrderService {
	/**
	 * 提交订单处理逻辑
	 * @author Kuang
	 * @return
	 */
	Object productOrder();
	/**
	 * 确定订单信息信息处理逻辑
	 * @author Kuang 
	 * @param buyInfo
	 * @param userId
	 * @return
	 */
	Object ensureOrderInfo(Map<Long, Integer> buyInfo,Integer userId);
	/**
	 * 直接购买单个商品订单处理逻辑
	 * @author Kuang
	 * @param userId
	 * @param commodityId
	 * @param buyNumber
	 * @throws Exception 
	 */
	EnsureOrderVo ensureOrderInfoDirect(Integer userId, Long commodityId, Integer buyNumber) throws NoCommodityException,LackofstockException;
	
	/**
	 * 将商品信息添加到购物车
	 * @param car
	 * @return
	 */
	boolean addCar(Car car);
	
	boolean commitOrder(Order order, List<OrderItem> orderItems);
	boolean cancelTheOrder(Long id);
	List<OrderItem> getAllNotFinshed(Integer userId);
	Map<String, String> pay(Order order, UserInfo user,String ip);
	String payResult(String string);

}
