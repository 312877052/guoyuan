package cn.edu.glut.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品列表输出vo
 * @author Kuang
 *
 */
public class CommodityOrderVo implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private Long commodityId; //商品id

    private String commodityName; //商品名称+期数

    private Integer commodityTerm; //果苗种植期限（天）
    
    private Integer commodityCurrNum; //当前商品数量 

    private String commodityProduct; //产量
    
    private BigDecimal commodityPrice; //价格

    private Integer commodityStatus; //1:在售   2:售完   3:下架

    private String commodityMainPho; //主图url
    
    private Integer buyNumber;  //购买数量
    
	public Integer getBuyNumber() {
		return buyNumber;
	}

	public void setBuyNumber(Integer buyNumber) {
		this.buyNumber = buyNumber;
	}

	public Integer getCommodityCurrNum() {
		return commodityCurrNum;
	}

	public void setCommodityCurrNum(Integer commodityCurrNum) {
		this.commodityCurrNum = commodityCurrNum;
	}

	public Long getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Long commodityId) {
		this.commodityId = commodityId;
	}
	
	public String getCommodityProduct() {
		return commodityProduct;
	}

	public void setCommodityProduct(String commodityProduct) {
		this.commodityProduct = commodityProduct;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Integer getCommodityTerm() {
		return commodityTerm;
	}

	public void setCommodityTerm(Integer commodityTerm) {
		this.commodityTerm = commodityTerm;
	}

	public BigDecimal getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(BigDecimal commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public Integer getCommodityStatus() {
		return commodityStatus;
	}

	public void setCommodityStatus(Integer commodityStatus) {
		this.commodityStatus = commodityStatus;
	}

	public String getCommodityMainPho() {
		return commodityMainPho;
	}

	public void setCommodityMainPho(String commodityMainPho) {
		this.commodityMainPho = commodityMainPho;
	}
}
