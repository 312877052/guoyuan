package cn.edu.glut.model;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 订单bean
 * @author Kuang
 *
 */
public class Order {
    private Long orderId;

    private Integer userId;

    private String transactionNum;  //交易号：第三方支付的交易号

    private Integer paymentType;   //支付类型

    private BigDecimal postFee;   //运费

    private BigDecimal totalFee;  //订单总金额
    
    private BigDecimal preferFee; //优惠金额

    private BigDecimal payment; //实际付款

    private Integer payState; //支付状态

    private Integer deliverState; //物流状态

    private Date paymentTime; //支付时间
    
   
    private Date createTime; //订单创建时间
    
    private Date finishTime; //订单完成时间

    private String receiverName; //收货人

    private String receiverMobile; //收货手机号

    private String receiverAddress; //收货地址

    private String remark;  //备注

    
    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public BigDecimal getPreferFee() {
		return preferFee;
	}

	public void setPreferFee(BigDecimal preferFee) {
		this.preferFee = preferFee;
	}

	public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(String transactionNum) {
        this.transactionNum = transactionNum;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getPostFee() {
        return postFee;
    }

    public void setPostFee(BigDecimal postFee) {
        this.postFee = postFee;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Integer getDeliverState() {
        return deliverState;
    }

    public void setDeliverState(Integer deliverState) {
        this.deliverState = deliverState;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}