package cn.edu.glut.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;


public class WX_API {
	
	//统一支付api
	private final String SERVER_UNITE_PAY="https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	//查询支付结果api
	private final String ORDER_QUERY="https://api.mch.weixin.qq.com/pay/orderquery";
	
	
	
	
	private SERVER_UNITE_PAY_Param serverPayParam;
	
	private SERVER_UNITE_PAY_Return serverPayReturn;
	
	private ORDER_QUERY_Param orderQueryParam;
	
	
	
	public void setOrderQueryParam(ORDER_QUERY_Param orderQueryParam) {
		this.orderQueryParam = orderQueryParam;
	}

	/**
	 * 查询支付结果api参数
	 * @author jones
	 *
	 */
	public class ORDER_QUERY_Param{
		private String appid;
		private String mch_id;
		private String transaction_id; //wx订单号
		private String nonce_str;
		private String sign;
		
		public ORDER_QUERY_Param() {
			appid=AppUtil.AppID;
			mch_id=AppUtil.mch_id;
			Random random=new Random(System.currentTimeMillis());
			
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<32;i++) {
				int value=random.nextInt(25);
				char ch=(char) ('A'+value);
				sb.append(ch);
			}
			nonce_str=sb.toString();
		}
		
		public String getTransaction_id() {
			return transaction_id;
		}
		public void setTransaction_id(String transaction_id) {
			this.transaction_id = transaction_id;
		}
		
		public String getParam() {
			Map<String, String> Params=new TreeMap<>();
			Params.put("appid", appid);
			Params.put("mch_id",mch_id );
			Params.put("nonce_str", nonce_str);
			Params.put("transaction_id", transaction_id);
			//迭代map拼接字符串
			Iterator<String> it=Params.keySet().iterator();
			StringBuffer sb=new StringBuffer();
			if(it.hasNext()) {
				String key=it.next();
				sb.append(key+"="+Params.get(key));
			}
			while(it.hasNext()) {
				String key=it.next();
				sb.append("&"+key+"="+Params.get(key));
			}
			//添加key
			sb.append("&key="+AppUtil.mch_key);
			//计算md5
			Md5PasswordEncoder m5=new Md5PasswordEncoder();
			System.out.println("md5 yuan:"+sb);
			String sign=m5.encodePassword(sb.toString(), null);
			this.sign=sign.toUpperCase();
			
			//构造xml
			Document doc=DocumentHelper.createDocument();
			Element root=doc.addElement("xml");
			
			it=Params.keySet().iterator();
			
			while(it.hasNext()) {
				String key=it.next();
				Element e=root.addElement(key);
				e.setText(Params.get(key));
				
			}
			
			//添加签名
			Element element=root.addElement("sign");
			element.setText(this.sign);
			
			StringWriter sw = new StringWriter();
	        OutputFormat format = OutputFormat.createPrettyPrint();
	        format.setEncoding("utf-8");
	        XMLWriter xw=new XMLWriter(sw,format);
	        try {
				xw.write(doc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	        String xml=sw.toString();
			return xml;
		}
		
	}
	/**
	 * 查询支付结果api返回参数
	 * @author jones
	 *
	 */
	public class ORDER_QUERY_Return{
		private String return_code; //状态码 	SUCCESS/FAIL 
		private String return_msg;//返回信息
		private String result_code;//业务结果
		private String err_code;//错误代码
		private String err_code_des;//错误代码描述
		/**
		 * SUCCESS—支付成功
		 * REFUND—转入退款
		 * NOTPAY—未支付
		 * CLOSED—已关闭
		 * REVOKED—已撤销（刷卡支付）
		 * USERPAYING--用户支付中
		 * PAYERROR--支付失败(其他原因，如银行返回失败)
		 */
		private String trade_state;
		private String time_end;//支付完成时间
		
		/**
		 * 从字符串中解析参数
		 * @param data
		 */
		public ORDER_QUERY_Return(String data) {
			try {
				Document doc = DocumentHelper.parseText(data);
				Element root = doc.getRootElement();
				return_code=root.elementText("return_code");
				return_msg=root.elementText("return_msg");
				if("SUCCESS".equals(return_code)) {
					result_code=root.elementText("result_code");
					if("FAIL".equals(result_code)) {
						err_code=root.elementText("err_code");
						err_code_des=root.elementText("err_code_des");
					}else {
						trade_state=root.elementText("trade_state");
						time_end=root.elementText("time_end");
					}
					
				}
				
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public String getReturn_code() {
			return return_code;
		}
		public String getReturn_msg() {
			return return_msg;
		}
		public String getResult_code() {
			return result_code;
		}
		public String getErr_code() {
			return err_code;
		}
		public String getErr_code_des() {
			return err_code_des;
		}
		public String getTrade_state() {
			return trade_state;
		}
		public String getTime_end() {
			return time_end;
		}
		
		












		

	}
	
	//api 参数
	public class SERVER_UNITE_PAY_Param{
		
		private String appid;	 //微信支付分配的公众账号ID（企业号corpid即为此appId）
		
		private String mch_id;   //微信支付分配的商户号
		
		private String nonce_str;//随机字符串，长度要求在32位以内。 例如:5K8264ILTKCH16CQ2502SI8ZNMTM67VS
		
		private String sign;	 //签名
		
		private String body;	 //商品说明 商家名称-销售商品类目
		
		private String out_trade_no; //商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。
	
		private String total_fee;//订单总金额，单位为分
		
		private String spbill_create_ip;//调用微信支付的终端ip
		
		private String notify_url;//异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
		
		private String return_code;//返回值 SUCCESS or FAIL
		private String trade_type;//公众号支付
		
		private String openid;		//客户唯一标识
		
		public SERVER_UNITE_PAY_Param(){
			
			appid=AppUtil.AppID;
			
			mch_id=AppUtil.mch_id;
			
			//生成随机字符串
			Random random=new Random(System.currentTimeMillis());
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<32;i++) {
				int value=random.nextInt(25);
				char ch=(char) ('A'+value);
				sb.append(ch);
			}
			
			nonce_str=sb.toString();
			
			trade_type="JSAPI";
			
			
		}
		

		/**
		 * 商品说明 商家名称-销售商品类目
		 * @param body
		 */
		public void setBody(String body) {
			this.body = body;
		}

		
		public void setOpenid(String openid) {
			this.openid = openid;
		}


		/**
		 * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。
		 * @param out_trade_no
		 */
		public void setOut_trade_no(String out_trade_no) {
			this.out_trade_no = out_trade_no;
		}


		public void setTotal_fee(String total_fee) {
			this.total_fee = total_fee;
		}


		public void setSpbill_create_ip(String spbill_create_ip) {
			this.spbill_create_ip = spbill_create_ip;
		}


		public void setNotify_url(String notify_url) {
			this.notify_url = notify_url;
		}


		public void setReturn_code(String return_code) {
			this.return_code = return_code;
		}
		
		public String getParam(){
			Map<String, String> Params=new TreeMap<>();
			Params.put("appid", appid);
			Params.put("mch_id",mch_id );
			Params.put("nonce_str", nonce_str);
			Params.put("body",body );
			Params.put("out_trade_no", out_trade_no);
			Params.put("total_fee", total_fee);
			Params.put("spbill_create_ip", spbill_create_ip);
			Params.put("notify_url",notify_url );
			Params.put("trade_type", trade_type);
			Params.put("openid", openid);
			
			//迭代map拼接字符串
			Iterator<String> it=Params.keySet().iterator();
			StringBuffer sb=new StringBuffer();
			if(it.hasNext()) {
				String key=it.next();
				sb.append(key+"="+Params.get(key));
			}
			while(it.hasNext()) {
				String key=it.next();
				sb.append("&"+key+"="+Params.get(key));
			}
			//添加key
			sb.append("&key="+AppUtil.mch_key);
			//计算md5
			Md5PasswordEncoder m5=new Md5PasswordEncoder();
			System.out.println("md5 yuan:"+sb);
			String sign=m5.encodePassword(sb.toString(), null);
			this.sign=sign.toUpperCase();
			
			//构造xml
			Document doc=DocumentHelper.createDocument();
			Element root=doc.addElement("xml");
			
			it=Params.keySet().iterator();
			
			while(it.hasNext()) {
				String key=it.next();
				Element e=root.addElement(key);
				e.setText(Params.get(key));
				
			}
			
			//添加签名
			Element element=root.addElement("sign");
			element.setText(this.sign);
			
			StringWriter sw = new StringWriter();
	        OutputFormat format = OutputFormat.createPrettyPrint();
	        format.setEncoding("utf-8");
	        XMLWriter xw=new XMLWriter(sw,format);
	        try {
				xw.write(doc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	        String xml=sw.toString();
			return xml;
		}
		
	}
	//api 返回结果
	public class SERVER_UNITE_PAY_Return{
		
		private String return_code;					//SUCCESS/FAIL此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断

		private String return_msg;					//当return_code为FAIL时返回信息为错误原因 ，例如 签名失败 参数格式校验错误

		private String appid;

		private String mch_id;
		
		private String device_info;					//设备号非必须
		
		private String nonce_str;					//随机字符串
		
		private String sign;
		
		private String result_code;
		
		private String err_code;					//错误代码 非必须
		
		private String err_code_des;				//错误说明 非必须
		
		private String trade_type;
		
		private String prepay_id;
		
		public SERVER_UNITE_PAY_Return(String result) {
			DebugOut.print(result);
			if(result!=null) {
				try {
					Document doc = DocumentHelper.parseText(result);
					Element root=doc.getRootElement();
					return_code=root.element("return_code").getText();
					result_code=root.element("result_code").getText();
					
					if("SUCCESS".equals(return_code)&&"SUCCESS".equals(result_code)) {
						//取出签名及prepay_id 随机字符串
						sign=root.element("sign").getText();
						prepay_id=root.element("prepay_id").getText();
						nonce_str=root.element("nonce_str").getText();
					}
					DebugOut.print(return_code);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
					
		}
	
		public Map<String, Object> getInfo(){
			Map<String, Object> info=null;
			
			if("SUCCESS".equals(return_code)&&"SUCCESS".equals(result_code)) {
				info=new TreeMap<>();
				info.put("sign", sign);
				info.put("prepay_id", prepay_id);
				info.put("nonce_str", nonce_str);
				info.put("appId", AppUtil.AppID);
			}
			
			return info;
		}
	
	}
	
	/**
	 * 异步接收支付结果通知参数
	 * @author jones
	 *
	 */
	public class NotifyPayResult{
		
		
		private String return_code;//返回状态码 SUCCESS/FAIL
		
		private String return_msg;//返回信息
		
		private String result_code;//业务结果 SUCCESS/FAIL
		
		private String err_code;//错误代码
		
		private String err_code_des;//错误信息描述
		
		private String openid;//用户标识
		
		private String is_subscribe;//是否关注公众号 Y/N 非必须
		
		private String trade_type;//交易类型 JSAPI、NATIVE、APP
		
		private String bank_type;//银行类型
		
		private String total_fee;//订单金额 单位分
		
		private String time_end;//支付完成时间 支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
		
		private String out_trade_no;//商户订单号
		
		private String transaction_id; //微信支付订单号
		
		public NotifyPayResult(String param) {
			try {
				Document doc = DocumentHelper.parseText(param);
				Element root=doc.getRootElement();
				return_code=root.elementText("return_code");
				if("SUCCESS".equals(return_code)) {
					openid=root.elementText("openid");
					out_trade_no=root.elementText("out_trade_no");
					
					total_fee=root.elementText("total_fee");
					
					time_end=root.elementText("time_end");
					transaction_id=root.elementText("transaction_id");
				}
				
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public String getReturn_code() {
			return return_code;
		}

		public String getReturn_msg() {
			return return_msg;
		}

		public String getResult_code() {
			return result_code;
		}

		public String getErr_code() {
			return err_code;
		}

		public String getErr_code_des() {
			return err_code_des;
		}

		public String getOpenid() {
			return openid;
		}

		public String getIs_subscribe() {
			return is_subscribe;
		}

		public String getTrade_type() {
			return trade_type;
		}

		public String getBank_type() {
			return bank_type;
		}

		public String getTotal_fee() {
			return total_fee;
		}

		public String getTime_end() {
			return time_end;
		}

		public String getOut_trade_no() {
			return out_trade_no;
		}

		public String getTransaction_id() {
			return transaction_id;
		}
		
		
		
		
	}
	

	
	public SERVER_UNITE_PAY_Return getServerPayReturn() {
		return serverPayReturn;
	}

	public void setServerPayParam(SERVER_UNITE_PAY_Param serverPayParam) {
		this.serverPayParam = serverPayParam;
	}
	
	public String UPay() {
		StringBuffer result=null;
		try {
			URL url=new URL(SERVER_UNITE_PAY);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setConnectTimeout(1000);
			con.setDoOutput(true);
			con.setDoInput(true);
			con.connect();
			OutputStream os=con.getOutputStream();
			
			String data=serverPayParam.getParam();
			os.write(data.getBytes("UTF-8"));
			
			os.flush();
			os.close();
			
			InputStreamReader reader=new InputStreamReader(con.getInputStream(),"UTF-8");
			BufferedReader br=new BufferedReader(reader);
			String line=null;
			result=new StringBuffer();
			while((line=br.readLine())!=null) {
				result.append(line);
			}
			br.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.serverPayReturn = new SERVER_UNITE_PAY_Return(result.toString());
		return result.toString();
	}
	
	/**
	 * 获取支付结果
	 * @return
	 */
	public String getTransacTionResult() {
		try {
			//准备参数
			if(orderQueryParam==null) {
				DebugOut.print("参数错误");
				return "FAILL";
			}
			URL url=new URL(ORDER_QUERY);
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setConnectTimeout(1000);
			con.setDoOutput(true);
			con.setDoInput(true);
			con.connect();
			//传输数据
			OutputStream out =con.getOutputStream();
			out.write(orderQueryParam.getParam().getBytes("utf-8"));
			out.flush();
			out.close();
			
			//取回数据
			InputStreamReader reader=new InputStreamReader(con.getInputStream(),"utf-8");
			
			BufferedReader br=new BufferedReader(reader);
			
			String line=br.readLine();
			StringBuffer data=new StringBuffer();
			while(line!=null) {
				data.append(line);
				line=br.readLine();
			}
			br.close();
			//分析结果
			ORDER_QUERY_Return apiReturn=new ORDER_QUERY_Return(data.toString());
			
			String trade_state=apiReturn.getTrade_state();
			if(trade_state!=null) {
				return trade_state;
			}else {
				DebugOut.print("解析api取回数据出错");
				return "FAILL";
			}
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "";
	}
}
