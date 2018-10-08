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
    	时间：2018-08-24
    	描述：我的果园列表 - abu
   -->
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
			<a class="mui-tab-item" href="buyList.html">
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
    	时间：2018-08-26
    	描述：我的树苗列表
 -->
			<div id="myTreeListTitle" class="mui-row">
				<div class="mui-col-sm-3 mui-col-xs-3">
					<p>距下一阶段</p>
				</div>
				<div class="mui-col-sm-3 mui-col-xs-3">
					<p>状态</p>
				</div>
				<div class="mui-col-sm-3 mui-col-xs-3">
					<p>品种</p>
				</div>
				<div class="mui-col-sm-3 mui-col-xs-3">
					<p>数量</p>
				</div>
			</div>

			<a href="${pageContext.request.contextPath}/common/fruitState.action">
				<div id="100" class="mui-row myTreeList">
					<div class="mui-col-sm-3 mui-col-xs-3">
						<p>20d</p>
					</div>
					<div class="mui-col-sm-3 mui-col-xs-3">
						<p>幼苗期</p>
					</div>
					<div class="mui-col-sm-3 mui-col-xs-3">
						<p>芒果一期F区</p>
					</div>
					<div class="mui-col-sm-3 mui-col-xs-3">
						<p>2株</p>
					</div>
				</div>
			</a>

			<a href="fruitState.html">
				<div id="101" class="mui-row myTreeList">
					<div class="mui-col-sm-3 mui-col-xs-3">
						<p>30d</p>
					</div>
					<div class="mui-col-sm-3 mui-col-xs-3">
						<p>成长期</p>
					</div>
					<div class="mui-col-sm-3 mui-col-xs-3">
						<p>芒果三期A区</p>
					</div>
					<div class="mui-col-sm-3 mui-col-xs-3">
						<p>10株</p>
					</div>
				</div>
			</a>

			<a href="logistics.html">
				<div id="102" class="mui-row myTreeList">
					<div class="mui-col-sm-3 mui-col-xs-3">
						<p>邮寄中</p>
					</div>
					<div class="mui-col-sm-3 mui-col-xs-3">
						<p>40kg + 10kg</p>
					</div>
					<div class="mui-col-sm-3 mui-col-xs-3">
						<p>芒果三期A区</p>
					</div>
					<div class="mui-col-sm-3 mui-col-xs-3">
						<p>10株</p>
					</div>
				</div>
			</a>
		</div>

	</body>
	<script>
		mui('body').on('tap', 'a', function() {
			document.location.href = this.href;
		});
	</script>
</html>