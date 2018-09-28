package cn.edu.glut.component.dao;

import cn.edu.glut.model.UserGrant;
import cn.edu.glut.model.UserInfo;

/**
 * 
 * @author 于金彪
 * 
 */
public interface UserDao {

	Integer addUserInfo(UserInfo  user);
	
	Integer addUserGrant(UserGrant userGrant);

	UserInfo getUserByTel(String tel);

	UserGrant getUserGrantByTel(String tel);

	UserInfo getUserByOpenId(String openId);
	
}
