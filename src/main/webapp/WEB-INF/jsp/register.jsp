<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>注册</title>
<script src="${pageContext.request.contextPath}/js/mui.min.js"></script>
<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet">
<script type="text/javascript" charset="utf-8">
	mui.init();
</script>
<script src="${pageContext.request.contextPath}/js/register.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}css/fruitLuck.css" />

</head>

<body>
	<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-24
    	描述：注册页面
    -->
	<form id="sms"  method="post"
		class="mui-input-group mui-table-view" >
		<div class="mui-input-row">
			<label for="tel">手机号</label>
			<input id="tel" name="tel" type="tel" class="mui-input-clear" />
		</div>
		<div class="mui-input-row">
			<label for="pwd">密码</label>
			<input type="password" class="mui-input" name="pwd"id="pwd" />
		</div>
		<div class="mui-input-row">
			<label for="">验证码</label>
			 <input id="smsCode" name="SMSCode" type="text" class="mui-input" />
			<button id="sendCode" class="mui-btn mui-btn-primary" style="float: right; width: 30%;" onClick="return getCheckCode(this)">发送验证码</button>
		</div>
		<button id="btn-regist"  class="mui-btn mui-btn-primary mui-btn-block" onclick="return regist(this)">注册</button>
	</form>
</body>

</html>