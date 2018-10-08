package cn.edu.glut.component.dao;

import java.util.List;

import cn.edu.glut.model.Order;
import cn.edu.glut.model.OrderItem;

public interface OrderDao {
	/**
	 * 插入部分订单数据
	 * @author Kuang
	 * @param order
	 * @return
	 */
	int insertSelective(Order order);

	Order selectById(Long id);

	void update(Order order);

	List<OrderItem> getAllNotFinshed(Integer userId);

}
