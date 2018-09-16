<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!doctype html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/banner.css" />
		<script src="${pageContext.request.contextPath}/js/mui.min.js"></script>
		<script type="text/javascript">
			mui.init()
		</script>

	</head>
	<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：收货地址 - 梁世仟
   -->

	<body>
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title"><strong>个人资料</strong></h1>
		</header>

		<div class="mui-content" style="height:100%;">
			<div class="shadow"></div>
			<div class="portrait">
				<img src="${pageContext.request.contextPath}/img/headPortrait.png" class="img_portrait" />
			</div>
			<h3 class="vip"><strong>VIP4</strong></h3>
			<hr class="hr1" />
			<div class="info">
				<table>
					<tr>
						<td>昵称:</td>
						<td>
							<input type="text" value="Domo" />
						</td>
					</tr>
					<tr>
						<td>个签:</td>
						<td>
							<input type="text" value="植物能净化心灵" />
						</td>
					</tr>
				</table>
				<a href="${pageContext.request.contextPath}/common/my.action"><button type="button">修改</button></a>
			</div>
			<hr class="hr2" />
		</div>
	</body>

</html>