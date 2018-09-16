package cn.edu.glut.model;

import java.math.BigDecimal;

public class OrderItem {
	private Long id;   //订单项id

    private Long orderId; //订单id
    
    private Integer userId; //用户id

    private Long commodityId; //商品id

    private Integer buyNum; //商品购买数目

    private String commodityName; //商品名称

    private String commodityMainPho; //商品主图

    private BigDecimal totalFee;  //总金额

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityMainPho() {
        return commodityMainPho;
    }

    public void setCommodityMainPho(String commodityMainPho) {
        this.commodityMainPho = commodityMainPho;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}