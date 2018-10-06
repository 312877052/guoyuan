package cn.edu.glut.component.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.net.ssl.HttpsURLConnection;

import org.apache.catalina.User;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
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
import cn.edu.glut.util.AppUtil;
import cn.edu.glut.util.SendSMSCode;
/**
 * 
 * @author jones
 *
 */
@Service("userService")
public class UserServiceIml implements UserService{

	Logger log=LogManager.getLogger();
	
	
	@Resource(name="jmsConnection")
	Connection con;
	
	
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

	public UserInfo regist(UserInfo user) {
		//调用dao层保存,先保存userinfo,再保存userGrant
		userDao.addUserInfo(user);
		List<UserGrant> grants=user.getGrants();
		for (UserGrant userGrant : grants) {
			userGrant.setUserId(user.getUserId());
			userDao.addUserGrant(userGrant);
		}
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

	@Override
	public MessageConsumer registMessageConsumer(UserInfo user) {
		//1创建session
		MessageConsumer consumer = null;
		try {
			Session  session=con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//2创建目标
			Destination destination = session.createQueue(user.getTelephone());
			//3创建消费者
			consumer = session.createConsumer(destination);
		} catch (JMSException e) {
			log.error(e,e);
			e.printStackTrace();
		}
		
		
		return consumer;
	}

	/**
	 * 调用微信接口获取openID
	 * https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
	 */
	public String getOpenId(String code) {
		String openId=null;
		try {
			URL wxAPI=new URL("https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AppUtil.AppID+"&secret="+AppUtil.secret+"&code="+code+"&grant_type=authorization_code");
			HttpURLConnection connection=(HttpURLConnection) wxAPI.openConnection();
			//获取输入流
			InputStream in =connection.getInputStream();
			
			InputStreamReader reader= new InputStreamReader(in);
			
			char buffer[] =new char[512];
			reader.read(buffer);
			reader.close();
			in.close(); 
			System.out.println("返回数据"+new String(buffer));
			JSONObject data=new JSONObject(new String(buffer));
			openId=data.getString("openid");
			
		} catch (MalformedURLException e) {
			
			log.error(e,e);
		} catch (IOException e) {
			log.error(e,e);
		}
		
		return openId;
	}

	@Override
	public UserInfo getUserByOpenId(String openId) {
		
		return userDao.getUserByOpenId(openId);
	}

	@Override
	public JSONObject queryExpressInfo(String number,String exp) {
		String api="http://api.56jiekou.com/index.php/openapi-api.html?key="+AppUtil.KEY+"&num="+number;
		if(exp!=null) api=api+"&exp="+exp;
		JSONObject obj=null;
		try {
			URL apiUrl=new URL(api);
			HttpURLConnection con=(HttpURLConnection) apiUrl.openConnection();
			InputStream in = con.getInputStream();
			InputStreamReader read=new InputStreamReader(in,"utf-8");
			char[] buffer=new char[1024];
			int a=read.read(buffer);
			StringBuffer sb=new StringBuffer();
			while(a!=-1) {
				sb.append(buffer);
				buffer=new char[buffer.length];
				a=read.read(buffer);
				
			}
			obj=new JSONObject(new String(buffer).trim());
			System.out.println(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}

	
	
}
