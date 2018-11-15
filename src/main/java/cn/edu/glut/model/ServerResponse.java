package cn.edu.glut.model;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * 服务器相应json 对象模型
 * @author jones
 *
 */
public class ServerResponse {
	private String return_code ; //状态码 SUCCESS/FAIL
	
	private String return_msg; //状态信息
		
	private Map data;
	
	public ServerResponse() {
		data=new HashMap<>();
	}
	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public Map getData() {
		return data;
	}

	public void setData(Map data) {
		this.data = data;
	}
	
	

	
}
