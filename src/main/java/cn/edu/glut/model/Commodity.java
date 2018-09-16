package cn.edu.glut.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 商品信息表
 * @author Kuang
 *
 */
public class Commodity implements Serializable{
 

	private static final long serialVersionUID = 6598270462911167180L;

	private Long commodityId; //商品id

    private Long cid;   //类别id

    private String commodityName; //商品名称+期数

    private Integer commodityTerm; //果苗种植期限（天）

    private Integer commodityNum;  //商品总数量
    
    private Integer commodityCurrNum; //当前商品数量 

    private String commodityVideoUrl; //视频url

    private BigDecimal commodityPrice; //价格

    private String commodityProduct; //产量

    private Integer commodityStatus; //1:在售   2:售完   3:下架

    private String commodityMainPho; //主图url

    private String commoditySubPho1; //子图url

    private String commoditySubPho2;

    private String commoditySubPho3;

    private String commoditySubPho4;

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

    public Integer getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(Integer commodityNum) {
        this.commodityNum = commodityNum;
    }

    public String getCommodityVideoUrl() {
        return commodityVideoUrl;
    }

    public void setCommodityVideoUrl(String commodityVideoUrl) {
        this.commodityVideoUrl = commodityVideoUrl;
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityProduct() {
        return commodityProduct;
    }

    public void setCommodityProduct(String commodityProduct) {
        this.commodityProduct = commodityProduct;
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

    public String getCommoditySubPho1() {
        return commoditySubPho1;
    }

    public void setCommoditySubPho1(String commoditySubPho1) {
        this.commoditySubPho1 = commoditySubPho1;
    }

    public String getCommoditySubPho2() {
        return commoditySubPho2;
    }

    public void setCommoditySubPho2(String commoditySubPho2) {
        this.commoditySubPho2 = commoditySubPho2;
    }

    public String getCommoditySubPho3() {
        return commoditySubPho3;
    }

    public void setCommoditySubPho3(String commoditySubPho3) {
        this.commoditySubPho3 = commoditySubPho3;
    }

    public String getCommoditySubPho4() {
        return commoditySubPho4;
    }

    public void setCommoditySubPho4(String commoditySubPho4) {
        this.commoditySubPho4 = commoditySubPho4;
    }

	public Integer getCommodityCurrNum() {
		return commodityCurrNum;
	}

	public void setCommodityCurrNum(Integer commodityCurrNum) {
		this.commodityCurrNum = commodityCurrNum;
	}
     
}