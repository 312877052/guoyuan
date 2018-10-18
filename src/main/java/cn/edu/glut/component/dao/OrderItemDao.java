package cn.edu.glut.component.dao;

import java.util.List;

import cn.edu.glut.model.OrderItem;

public interface OrderItemDao {
	/**
	 * 插入订单项
	 * @author Kuang
	 * @param orderItem
	 * @return
	 */
	int insertOrderItem(OrderItem orderItem);

	/**
	 * @author jones
	 * @param orderItems
	 * @return
	 */
	int insertList(List<OrderItem> orderItems);

}
