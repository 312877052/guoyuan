/**
 * @author jones
 */
/**
 * 获取短信验证码
 * @param btn
 * @returns
 */
function getCheckCode(btn){
	var tel=document.getElementById("tel").value;
	if(tel==null||tel.trim()==""){
		mui.toast("手机号不能为空")
		return false;
	}
	if(tel.length<11){
		mui.toast("手机号长度错误")
		return false;
	}
	mui.ajax("/guoyuan/user/smsCode.action",{
		data:{
			'tel':tel,
			'regist':'true'
		},
		success:function(data){
			if(data.indexOf("1001")!=-1){
				mui.toast('该手机号已注册')
			}else if(data.indexOf("false")!=-1){
				mui.toast('短信发送失败')
			}
			
		},
		error:function(data){
			mui.toast('短信发送失败')
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
 * 注册功能提交表单是触发效果
 * @param form
 * @returns
 */
function regist(form){
	//校验数据
	var tel=document.getElementById("tel").value;
	if(tel==null||tel.trim()==""){
		mui.toast("手机号不能为空")
		return false;
	}
	if(tel.length<11){
		mui.toast("手机号长度错误")
		return false;
	}
	var pwd=document.getElementById("pwd").value;
	if(pwd.length<6){
		mui.toast("密码长度至少6个字符")
	}
	
	var smsCode=document.getElementById("smsCode").value;
	if(smsCode==null||smsCode.trim()==""){
		mui.toast("请输入验证码!")
		return false;
	}
	
	//校验验证码
	var result=false;
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
			if(data.indexOf("1001")!=-1){
				mui.toast('该手机号已注册')
				return false;
			}
			},
			error:function(data){
				result=false;
				mui.toast('验证码错误')
			}
		});
	//通过ajax注册
	if(result){
		mui.ajax("/guoyuan/user/regist.action",{
			data:{
				'pwd':pwd
			},
			async: false,
			success:function(data){
				if(data.indexOf("true")!=-1){
					mui.alert("恭喜您注册成功","注册成功",function(){
						//重定向
						 mui.openWindow({
							 url:'/guoyuan/common/home.action',
							 id:'home.jsp'
							 });
					})
				}
				},
				error:function(data){
					
				}
		
		})
	}
	return  false;
}
