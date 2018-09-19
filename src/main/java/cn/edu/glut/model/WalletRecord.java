package cn.edu.glut.model;

import java.math.BigDecimal;
import java.util.Date;

public class WalletRecord {
    private Integer walletRecordId;

    private String walletId;

    private BigDecimal income;

    private Date transactTime;

    private String remark;

    public Integer getWalletRecordId() {
        return walletRecordId;
    }

    public void setWalletRecordId(Integer walletRecordId) {
        this.walletRecordId = walletRecordId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId == null ? null : walletId.trim();
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public Date getTransactTime() {
        return transactTime;
    }

    public void setTransactTime(Date transactTime) {
        this.transactTime = transactTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}