package cn.edu.glut.component.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import cn.edu.glut.component.dao.ReceiverAddressMapper;
import cn.edu.glut.component.dao.UserDao;
import cn.edu.glut.component.service.UserService;
import cn.edu.glut.model.ReceiverAddress;
import cn.edu.glut.model.ReceiverAddressExample;
import cn.edu.glut.model.UserGrant;
import cn.edu.glut.model.UserInfo;
import cn.edu.glut.util.SendSMSCode;
//           ↓ bean id
@Service("userService")
public class UserServiceIml implements UserService{

	Logger log=LogManager.getLogger();
	@Resource
	UserDao userDao;
	@Resource
	ReceiverAddressMapper rece;
	@Override
	public boolean smsCode(String tel, String checkCode) {
		SendSmsResponse sendSms=null;
		try {
			sendSms = SendSMSCode.sendSms(tel, checkCode);
			if(sendSms!=null&&sendSms.getCode().equals("OK")) {
				return true;
			}
		} catch (ClientException e) {
			
			//***完善日志功能后加入日志**********
			e.printStackTrace();
			log.error("ClientException",e);
		}
		if(sendSms!=null) {
			log.error("短信发送失败"+sendSms.getCode()+"#"+sendSms.getMessage());
		}
		return false;
	}

	@Override
	public UserInfo regist(UserGrant userGrant , UserInfo user) {
		//调用dao层保存,先保存userinfo,再保存userGrant
		userDao.addUserInfo(user);
		userGrant.setUserId(user.getUserId());
		userDao.addUserGrant(userGrant);
		List<UserGrant> grants=new ArrayList<>();
		grants.add(userGrant);
		user.setGrants(grants);
		
		
		return user;
	}

	@Override
	public UserInfo getUserByTel(String tel) {
		UserInfo user =userDao.getUserByTel( tel);
		List<UserGrant> grants=null;
		if(user==null) {
			//未注册 记录日志
			return null;
		}else {
			//已注册
			grants=user.getGrants();
		}
		if(grants==null||grants.size()==0) {
			//出错 由用户没有授权方式
			//记录日志
			return null;
		}
		return user;
	}

	@Override
	public UserGrant getUserGrantByTel(String tel) {
		
		return userDao.getUserGrantByTel(tel);
	}

	@Override
	public List<ReceiverAddress> addAddr(ReceiverAddress ra) {
		rece.insert(ra);
		ReceiverAddressExample example=new ReceiverAddressExample();
		example.createCriteria().andUserIdEqualTo(ra.getUserId());
		List<ReceiverAddress> addrs=rece.selectByExample(example);
		return addrs;
	}

	@Override
	public List<ReceiverAddress> getReceiverAddress(Integer userId) {
		ReceiverAddressExample example= new ReceiverAddressExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<ReceiverAddress> addrs=rece.selectByExample(example);
		return addrs;
	}

	
	
}
