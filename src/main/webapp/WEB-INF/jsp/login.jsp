<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>登录</title>
		<script src="${pageContext.request.contextPath}/js/mui.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/login.js"></script>
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fruitLuck.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
		<script type="text/javascript" charset="utf-8">
			mui.init();
		</script>
	</head>

	<body>
		<section class="mui-content">
			<div style="padding: 10px 10px;">
				<div id="segmentedControl" class="mui-segmented-control">
					<a class="mui-control-item mui-active" href="#item1" onclick="setM(1)">
						短信登录
					</a>
					<a class="mui-control-item" href="#item2"  onclick="setM(2)">
						密码登录
					</a>
				</div>
			</div>

			<div id="item1" class="mui-control-content mui-active">
				<form id="sms" action="${pageContext.request.contextPath}/user/loginBySMS.action" method="post" class="mui-input-group mui-table-view" >
							<div class="mui-input-row">
								<label for="tel1">手机号</label>
								<input id="tel1" name="tel" type="tel" class="mui-input-clear" />
							</div>
							<div class="mui-input-row">
								<label for="">验证码</label>
								<input id="smsCode" name="SMSCode" type="text" class="mui-input" />
								<button id="sendCode" class="mui-btn mui-btn-primary" style="float:right;width:30%;" onClick="return getCheckCode(this)">发送验证码</button>
							</div>
							<button id="btn-login" type="submit" onclick="return login(this)" class="mui-btn mui-btn-primary mui-btn-block"  >登录</button>
						</form>
			</div>

			<div id="item2" class="mui-control-content " >
				<form  class="mui-input-group" method="post">
							<div class="mui-input-row">
								<label for="tel2">手机号</label>
								<input id="tel2" name="tel" type="tel" class="mui-input-clear" />
							</div>
							<div class="mui-input-row">
								<label for="">密码</label>
								<input id="pwd" name="pwd" type="text" class="mui-input-clear" />
							</div>
							<button   onclick="return check()" class="mui-btn mui-btn-primary mui-btn-block" > 登录</button>
						</form>
			</div>
		</section>
		<a href="/guoyuan/common/register.action" id="gotoregist">快速注册</a>
	</body>

</html>