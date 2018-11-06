package cn.edu.glut.component.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.glut.component.dao.CarMapper;
import cn.edu.glut.component.dao.CommodityDao;
import cn.edu.glut.component.dao.OrderDao;
import cn.edu.glut.component.dao.OrderItemDao;
import cn.edu.glut.component.dao.ReceiverAddressDao;
import cn.edu.glut.component.dao.UserDao;
import cn.edu.glut.component.service.OrderService;
import cn.edu.glut.exception.LackofstockException;
import cn.edu.glut.exception.NoCommodityException;
import cn.edu.glut.model.Car;
import cn.edu.glut.model.CarExample;
import cn.edu.glut.model.Commodity;
import cn.edu.glut.model.CommodityOrderVo;
import cn.edu.glut.model.EnsureOrderVo;
import cn.edu.glut.model.Order;
import cn.edu.glut.model.OrderItem;
import cn.edu.glut.model.ReceiverAddress;
import cn.edu.glut.model.UserGrant;
import cn.edu.glut.model.UserInfo;
import cn.edu.glut.util.AppUtil;
import cn.edu.glut.util.BigDecimalUtil;
import cn.edu.glut.util.DebugOut;
import cn.edu.glut.util.IDUtils;
import cn.edu.glut.util.WX_API;
import cn.edu.glut.util.WX_API.SERVER_UNITE_PAY_Param;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrderItemDao orderItemDao;

	@Autowired
	private CommodityDao commodityDao;

	@Autowired
	private ReceiverAddressDao receiverAddressDao;

	@Resource
	private CarMapper carMapper;

	@Resource
	private UserDao useDao;

	Logger log = LogManager.getLogger();
	Logger record = LogManager.getLogger("recordFile");

	public Object productOrder() {

		// 根据商品id和购买数量计算是否能够购买
		// 如果不能购买弹出提示

		// 如果能购买
		// 生成订单id
		// 根据商品id查询商品信息
		// 计算商品总金额
		// 生成订单项
		// 生成订单
		// 查询默认收货地址信息
		// 最后封装全部信息页面展示

		return null;
	}

	public Object ensureOrderInfo(Map<Long, Integer> buyInfo, Integer userId) {
		// 根据商品检查商品数量是否合法
		Set<Map.Entry<Long, Integer>> entry = buyInfo.entrySet();
		List<Commodity> commodityInfos = new ArrayList<>();
		BigDecimal totalPrice = new BigDecimal(0);
		for (Map.Entry<Long, Integer> buy : entry) {
			Long commodityId = buy.getKey();
			int commodityNum = commodityDao.selectCommodityNum(commodityId);
			if (commodityNum < buy.getValue()) {
				// 如果不合法弹出错误
				return null;
			}

			// 如果合法,查询每个商品的信息
			Commodity commodity = commodityDao.selectCommodityById(commodityId);
			BigDecimal commodityPrice = commodity.getCommodityPrice();
			// 计算商品的总金额
			totalPrice.add(commodityPrice);
			commodityInfos.add(commodity);
		}
		// 查询默认用户的默认收货地址
		ReceiverAddress receiverAddress = receiverAddressDao.selectAddressByDefault(userId);
		return null;
	}

	public EnsureOrderVo ensureOrderInfoDirect(Integer userId, Long commodityId, Integer buyNumber) throws NoCommodityException, LackofstockException  {
		CommodityOrderVo commodityOrderVo = commodityDao.selectCommodityOrderVoById(commodityId);
		// 商品状态不为1时，商品处于售完或者下架状态
		if (commodityOrderVo.getCommodityStatus() != 1) {
			throw new NoCommodityException();
		}
		if (buyNumber > commodityOrderVo.getCommodityCurrNum()) {
			throw new LackofstockException();//库存不足
		}
		commodityOrderVo.setBuyNumber(buyNumber);
		EnsureOrderVo ensureOrderVo = new EnsureOrderVo();
		ensureOrderVo.setCommodityOrderVo(commodityOrderVo);
		// 查询默认用户的默认收货地址
		ReceiverAddress receiverAddress = receiverAddressDao.selectAddressByDefault(userId);
		ensureOrderVo.setReceiverAddress(receiverAddress);
		return ensureOrderVo;
	}

	@Override
	public boolean addCar(Car car) {
		CarExample carExample = new CarExample();
		carExample.createCriteria().andCommodityIdEqualTo(car.getCommodityId()).andUserIdEqualTo(car.getUserId());
		List<Car> carList = carMapper.selectByExample(carExample);
		if (carList.size() == 0) {
			carMapper.insert(car);
		} else if (carList.size() == 1) {
			Car old = carList.get(0);
			Integer commodityNum = old.getCommodityNum();
			old.setCommodityNum(commodityNum + car.getCommodityNum());
			int effect = carMapper.updateByPrimaryKey(old);
			if (effect == 1)
				return true;
		} else {

		}

		if (car.getCarId() != null) {
			return true;

		}
		return false;
	}

	@Override
	public boolean commitOrder(Order order, List<OrderItem> orderItems) {
		order.setOrderId(IDUtils.genOrderId());
		int result = orderDao.insertSelective(order);

		for (OrderItem orderItem : orderItems) {
			orderItem.setOrderId(order.getOrderId());
			orderItem.setUserId(order.getUserId());
		}
		orderItemDao.insertList(orderItems);
		if (result == 1)
			return true;
		return false;
	}

	@Override
	public boolean cancelTheOrder(Long id) {
		// 找出订单
		Order order = orderDao.selectById(id);
		// 取消订单
		if (order != null) {
			order.setPayState(2);
			orderDao.update(order);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<OrderItem> getAllNotFinshed(Integer userId) {
		// 根据userid 找出所有未完成订单
		List<OrderItem> orders = orderDao.getAllNotFinshed(userId);

		return orders;
	}

	@Override
	public Map<String, Object> pay(Order order, UserInfo user, String ip) {
		WX_API payApi = new WX_API();
		WX_API.SERVER_UNITE_PAY_Param param = payApi.new SERVER_UNITE_PAY_Param();

		param.setBody("果缘果业-商品");
		param.setNotify_url("http://hy.aliquan.top/guoyuan/order/payResult.action");
		param.setOut_trade_no(order.getOrderId() + "");
		param.setSpbill_create_ip(ip);
		int fee = order.getTotalFee().multiply(new BigDecimal(100)).intValue();
		param.setTotal_fee(String.valueOf(fee));

		param.setOpenid(user.getOpenId());
		payApi.setServerPayParam(param);
		payApi.UPay();
		return payApi.getServerPayReturn().getInfo();

	}

	/**
	 * 处理接收数据并返回确认信息
	 * @param para api返回参数
	 */
	public String payResult(String para) {
		WX_API api = new WX_API();
		WX_API.NotifyPayResult npr = api.new NotifyPayResult(para);
		if ("SUCCESS".equals(npr.getReturn_code())) {
			// 取出orderid
			String orderid = npr.getOut_trade_no();
			// 取出金额
			String fee = npr.getTotal_fee();
			DebugOut.print("fee="+fee);
			BigDecimal money = new BigDecimal(fee);
			money=money.divide(new BigDecimal(100));
			DebugOut.print(money.toString());
			// 取出时间
			String time = npr.getTime_end();
			// 比对金额 不一致报错
			Order order = orderDao.getOrderById(Long.parseLong(orderid));
			//微信订单号作为交易号
			String transactionId=npr.getTransaction_id();
			
			if (!money.equals(order.getTotalFee())) {
				log.error("支付金额与订单金额不一致");
				DebugOut.print("支付金额与订单金额不一致\n"+money+" :"+order.getTotalFee());
				
			}
			Date finshTime = order.getPaymentTime();
			DebugOut.print(finshTime);
			try {
				if (finshTime == null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
					Date endTime = sdf.parse(time);
					order.setPaymentTime(endTime);  //支付时间
					order.setTransactionNum(transactionId);//交易号
					order.setPayState(1);  //已支付
					order.setPaymentType(1);//在线支付
					//存入数据库
					orderDao.update(order);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		String res="<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
		
		return res;
	}

	
	/**
	 * 查询是否交易成功
	 */
	public boolean getTradeState(String orderId) {
		WX_API api=new WX_API();
		WX_API.ORDER_QUERY_Param param=api.new ORDER_QUERY_Param();
		//从数据库中查询交易号
		DebugOut.print("orderId: "+orderId);
		Order order=null;
		order=orderDao.getOrderById(Long.parseLong(orderId));
		if(order==null) {
			DebugOut.print("出错");
			return false;
		}
		String transaction_id=order.getTransactionNum();
		param.setTransaction_id(transaction_id);
		api.setOrderQueryParam(param);
		String transacTionResul=api.getTransacTionResult();
		DebugOut.print("交易结果"+transacTionResul);
		if("SUCCESS".equals(transacTionResul)) {
			return true;
		}
		return false;
	}

}
