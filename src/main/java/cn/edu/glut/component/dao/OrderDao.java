package cn.edu.glut.component.dao;

import cn.edu.glut.model.Order;

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

}
