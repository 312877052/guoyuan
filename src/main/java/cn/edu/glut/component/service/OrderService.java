package cn.edu.glut.component.service;

import java.util.Map;

import cn.edu.glut.model.EnsureOrderVo;

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
	 */
	EnsureOrderVo ensureOrderInfoDirect(Integer userId, Long commodityId, Integer buyNumber);

}
