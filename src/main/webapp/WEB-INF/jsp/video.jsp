<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>视频页面</title>
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
			<a id="defaultTab" class="mui-tab-item mui-active" href="home.html">
				<img id="homeIcon" class="bottomNavIcon" src="${pageContext.request.contextPath }/img/资源 14-100.jpg" />
			</a>
			<a class="mui-tab-item" href="video.html">
				<img id="videoIcon" class="bottomNavIcon" src="${pageContext.request.contextPath }/img/资源 10-100.jpg" />
			</a>
			<a class="mui-tab-item" href="buyList.html">
				<img id="buyIcon" class="bottomNavIcon " src="${pageContext.request.contextPath }/img/资源 11-100.jpg" />
				<span class="mui-badge mui-badge-success">12</span>
			</a>
			<a class="mui-tab-item" href="my.html">
				<img id="myIcon" class="bottomNavIcon" src="${pageContext.request.contextPath }/img/资源 13-100.jpg" />
			</a>
		</nav>

		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-24
    	描述：视频页面 - abu
    -->

		<div class="mui-content">
			<a href="${pageContext.request.contextPath }/video/showvideos.action?vcategoryId=5"><img id="videoImg" src="${pageContext.request.contextPath }/img/video.png" /></a>
			<table id="videoTable">
				<tr>
					<td>
						<img class="videoIcon" src="${pageContext.request.contextPath }/img/天气.png" />
					</td>
					<td>
						<span>晴</span>
					</td>
					<td>
						<img class="videoIcon" src="${pageContext.request.contextPath }/img/温度.png" />
					</td>
					<td>
						<span>24℃</span>
					</td>
					<td>
						<img class="videoIcon" src="${pageContext.request.contextPath }/img/风级.png" />
					</td>
					<td>
						<span>2-4级</span>
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