<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>我的果园列表</title>
		<script src="${pageContext.request.contextPath}/js/mui.min.js"></script>
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fruitLuck.css" />
		<script type="text/javascript" charset="utf-8">
			mui.init();
		</script>
	</head>

	<body>
		<!--
        	作者：abusuper@outlook.com
        	时间：2018-09-02
        	描述：底部选项卡
        -->
		<nav class="mui-bar mui-bar-tab">
			<a id="defaultTab" class="mui-tab-item mui-active" href="${pageContext.request.contextPath}/common/home.action">
				<img id="homeIcon" class="bottomNavIcon" src="${pageContext.request.contextPath}/img/资源 14-100.jpg" />
			</a>
			<a class="mui-tab-item" href="${pageContext.request.contextPath}/common/video.action">
				<img id="videoIcon" class="bottomNavIcon" src="${pageContext.request.contextPath}/img/资源 10-100.jpg" />
			</a>
			<a class="mui-tab-item" href="${pageContext.request.contextPath}/user/buyList.action">
				<img id="buyIcon" class="bottomNavIcon " src="${pageContext.request.contextPath}/img/资源 11-100.jpg" />
				<span class="mui-badge mui-badge-success">12</span>
			</a>
			<a class="mui-tab-item" href="${pageContext.request.contextPath}/common/my.action">
				<img id="myIcon" class="bottomNavIcon" src="${pageContext.request.contextPath}/img/资源 13-100.jpg" />
			</a>
		</nav>

		<div class="mui-content">
			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-24
    	描述：我的果园列表 - abu
    -->
			<div id="headDiv">
				<p id="userName">DEMO</p>
				<p id="userSign">植物可以净化心灵</p>
				<a href="${pageContext.request.contextPath}/common/pearsonalInfo.action"><img class="head" src="${pageContext.request.contextPath}/img/阿布.jpg" /></a>
			</div>

			<table class="myNavIconFirst">
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/user/star.action"><img class="myIcon" src="${pageContext.request.contextPath}/img/资源 1-100.jpg" /><br /></a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/user/buyCar.action"><img class="myIcon" src="${pageContext.request.contextPath}/img/资源 2-100.jpg" /><br /></a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/user/money.action"><img class="myIcon" src="${pageContext.request.contextPath}/img/资源 5-100.jpg" /><br /></a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/user/address.action"><img class="myIcon" src="${pageContext.request.contextPath}/img/资源 4-100.jpg" /><br /></a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/user/Setting.action"><img class="myIcon" src="${pageContext.request.contextPath}/img/资源 3-100.jpg" /><br /></a>
					</td>
				</tr>
			</table>
		</div>

	</body>
	<script>
		mui('body').on('tap', 'a', function() {
			document.location.href = this.href;
		});
	</script>

</html>