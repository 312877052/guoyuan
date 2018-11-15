package cn.edu.glut.model;

/**
 * 要购买的商品信息
 * @author jones
 *
 */
public class BuyList {
	private Long commodityId;
	private int buyNumber;
	public Long getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}
	public int getBuyNumber() {
		return buyNumber;
	}
	public void setBuyNumber(int buyNumber) {
		this.buyNumber = buyNumber;
	}
	
	
}
