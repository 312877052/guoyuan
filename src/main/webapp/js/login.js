/**
 * @author 于金彪
 */
var m=1;
/**
 * 判断登录方式
 * @param vm
 * @returns
 */
	function setM(vm){
		m=vm;
	}
	
	/**
	 * 发送验证码
	 * @param btn
	 * @returns
	 */
	function getCheckCode(btn){
		var tel;
		if(m==1){
			tel=document.getElementById("tel1").value;
		}else{
			tel=document.getElementById("tel2").value;
		}
		if(tel==null||tel.trim()==''){
			mui.toast('请输入手机号');
			return false;
		}
		
		mui.ajax("/guoyuan/user/smsCode.action",{
			data:{
				'tel':tel
			},
			success:function(data){
				if(data.indexOf("1002")!=-1){
					mui.toast('该手机号未注册')
				}else if(data.indexOf("false")!=-1){
					mui.toast('短信发送失败')
				}
				
			},
			error:function(data){
				
			}
		});
		
		btn.classList.add("mui-disabled");
		btn.disabled=true;
		timer()
		return false;
	}
	var t=60
	/**
	 * 60s禁用btn
	 * @returns
	 */
	function timer(){
		t=t-1
		if(t==0){
			document.getElementById("sendCode").innerHTML="重新发送";
			t=60
			document.getElementById("sendCode").classList.remove("mui-disabled")
			document.getElementById("sendCode").disabled=false;
			return;
		}
		
		document.getElementById("sendCode").innerHTML=t;
		setTimeout("timer()",1000)
		
		
	}
	
	/**
	 * 登录
	 * @param btn
	 * @returns
	 */
	function login(btn){
		var result=false;
		var tel=document.getElementById("tel1").value;
		if(tel==null||tel.trim()==''){
			mui.toast("手机号不能为空")
			return false;
		}
		var smsCode=
		document.getElementById("smsCode").value;
		if(smsCode==null||smsCode.trim()==''){
			mui.toast("验证码不能为空");
			return false;
		}
		
			mui.ajax("/guoyuan/user/checkSMSCode.action",{
				data:{
					'smsCode':smsCode
				},
				async: false,
				success:function(data){
					if(data.indexOf("true")!=-1){
						result= true;
					}else{
						result=false;
						mui.toast('验证码错误')
					}
				},
				error:function(data){
					result=false;
					mui.toast('验证码错误')
				}
			});
			
		
		if(result){
			return true;
		}
	}
	/**
	 * 
	 * @returns
	 */
	function check(){
		var tel=document.getElementById("tel2").value;
		var pwd=document.getElementById("pwd").value;
		if(tel==null||tel.trim()=="") {
			mui.toast("手机号不能为空")
			return false;
		} 
		if(pwd==null||pwd.trim()==""){
			mui.toast("密码不能为空")
			return false;
		}
		
		mui.ajax("/guoyuan/user/login.action",{
			data:{
				"tel":tel,
				"pwd":pwd
			},
			dataType:'json',
			async: false,
			success:function(data){
				if(data.return_code=='SUCCESS'){
					mui.toast("登录成功")
					
						mui.openWindow({
							 url:data.data.url,
							 data,
							 id:'my.jsp'
							 });
					
					
				}else{
					mui.toast("用户名或密码错误")
					return false;
				}
			}
			
			
		})
		return false;
	}
	/**
	 * 
	 * @returns
	 */
	function loginByPwd(){
		
	}