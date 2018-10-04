package cn.edu.glut.component.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.glut.component.dao.CarMapper;
import cn.edu.glut.component.dao.CommodityDao;
import cn.edu.glut.component.dao.OrderDao;
import cn.edu.glut.component.dao.OrderItemDao;
import cn.edu.glut.component.dao.ReceiverAddressDao;
import cn.edu.glut.component.service.OrderService;
import cn.edu.glut.model.Car;
import cn.edu.glut.model.CarExample;
import cn.edu.glut.model.Commodity;
import cn.edu.glut.model.CommodityOrderVo;
import cn.edu.glut.model.EnsureOrderVo;
import cn.edu.glut.model.ReceiverAddress;

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

	
	public Object productOrder() {
		
		//根据商品id和购买数量计算是否能够购买
		//如果不能购买弹出提示
		
		//如果能购买
		//生成订单id
		//根据商品id查询商品信息
		//计算商品总金额
		//生成订单项
		//生成订单
		//查询默认收货地址信息
		//最后封装全部信息页面展示
		
		
		return null;
	}

	public Object ensureOrderInfo(Map<Long, Integer> buyInfo,Integer userId) {
		//根据商品检查商品数量是否合法
		Set<Map.Entry<Long, Integer>> entry = buyInfo.entrySet();
		List<Commodity> commodityInfos = new ArrayList<>();
		BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Long, Integer> buy : entry) {
        	Long commodityId = buy.getKey();
        	int commodityNum = commodityDao.selectCommodityNum(commodityId);
        	if(commodityNum < buy.getValue()) {
        		//如果不合法弹出错误
        		return null;
        	}
        	
        	//如果合法,查询每个商品的信息
        	Commodity commodity = commodityDao.selectCommodityById(commodityId);
        	BigDecimal commodityPrice = commodity.getCommodityPrice();
        	//计算商品的总金额
        	totalPrice.add(commodityPrice);
        	commodityInfos.add(commodity);
        }			
		//查询默认用户的默认收货地址
        ReceiverAddress receiverAddress = receiverAddressDao.selectAddressByDefault(userId);
		return null;
	}

	public EnsureOrderVo ensureOrderInfoDirect(Integer userId, Long commodityId, Integer buyNumber) {
		CommodityOrderVo commodityOrderVo = commodityDao.selectCommodityOrderVoById(commodityId);
		//商品状态不为1时，商品处于售完或者下架状态
		if(commodityOrderVo.getCommodityStatus()!=1) {
			return null;
		}
		if(buyNumber > commodityOrderVo.getCommodityCurrNum()) {
			return null;
		}
		commodityOrderVo.setBuyNumber(buyNumber);
		EnsureOrderVo ensureOrderVo = new EnsureOrderVo();
		ensureOrderVo.setCommodityOrderVo(commodityOrderVo);
		//查询默认用户的默认收货地址
        ReceiverAddress receiverAddress = receiverAddressDao.selectAddressByDefault(userId);
        ensureOrderVo.setReceiverAddress(receiverAddress);
        return ensureOrderVo;	
	}

	@Override
	public boolean addCar(Car car) {
		CarExample carExample=new CarExample();
		carExample.createCriteria().andCommodityIdEqualTo(car.getCommodityId());
		List<Car> carList=carMapper.selectByExample(carExample);
		if(carList.size()==0) {
			carMapper.insert(car);
		}else if(carList.size()==1) {
			Car old = carList.get(0);
			Integer commodityNum=old.getCommodityNum();
			old.setCommodityNum(commodityNum+car.getCommodityNum());
			int effect=carMapper.updateByPrimaryKey(old);
			if(effect==1)return true;
		}else {
			
		}
		
		if(car.getCarId()!=null) {
			return true;
			
		}
		return false;
	}

}
