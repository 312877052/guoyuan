package cn.edu.glut.model;

import java.util.List;

/**
 * 实体类
 * @author jones
 *
 */
public class UserInfo {
	private Integer userId;
	
	private String telephone;
	
	private String nickname;
	
	private String identityNum;
	
	private String photo;
	
	private Integer state;
	
	private String  address;
	
	private String ip;
	
	private List<UserGrant> grants;
	
	private String signature;
	
	
	

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public List<UserGrant> getGrants() {
		return grants;
	}

	public void setGrants(List<UserGrant> grants) {
		this.grants = grants;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	

	public String getIdentityNum() {
		return identityNum;
	}

	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	
	
	
}
