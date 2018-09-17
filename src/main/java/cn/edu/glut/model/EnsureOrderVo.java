package cn.edu.glut.model;

import java.io.Serializable;
import java.util.List;
/**
 * 确认订单提示信息bean
 * @author Kuang
 *
 */
public class EnsureOrderVo implements Serializable{

	private static final long serialVersionUID = -4137751008156728248L;
	private ReceiverAddress receiverAddress; //收货地址
	private CommodityOrderVo commodityOrderVo;     //订单商品信息
	public ReceiverAddress getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(ReceiverAddress receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public CommodityOrderVo getCommodityOrderVo() {
		return commodityOrderVo;
	}
	public void setCommodityOrderVo(CommodityOrderVo commodityOrderVo) {
		this.commodityOrderVo = commodityOrderVo;
	}
	
}
