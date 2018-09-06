<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>我的果园列表</title>
		<script src="js/mui.min.js"></script>
		<link href="css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="css/fruitLuck.css" />
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
				<img id="homeIcon" class="bottomNavIcon" src="img/资源 14-100.jpg" />
			</a>
			<a class="mui-tab-item" href="video.html">
				<img id="videoIcon" class="bottomNavIcon" src="img/资源 10-100.jpg" />
			</a>
			<a class="mui-tab-item" href="buyList.html">
				<img id="buyIcon" class="bottomNavIcon " src="img/资源 11-100.jpg" />
				<span class="mui-badge mui-badge-success">12</span>
			</a>
			<a class="mui-tab-item" href="my.html">
				<img id="myIcon" class="bottomNavIcon" src="img/资源 13-100.jpg" />
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
				<a href="PersonalInfo.html"><img class="head" src="img/阿布.jpg" /></a>
			</div>

			<table class="myNavIconFirst">
				<tr>
					<td>
						<a href="star.html"><img class="myIcon" src="img/资源 1-100.jpg" /><br /></a>
					</td>
					<td>
						<a href="buyCar.html"><img class="myIcon" src="img/资源 2-100.jpg" /><br /></a>
					</td>
					<td>
						<a href="money.html"><img class="myIcon" src="img/资源 5-100.jpg" /><br /></a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="address.html"><img class="myIcon" src="img/资源 4-100.jpg" /><br /></a>
					</td>
					<td>
						<a href="Setting.html"><img class="myIcon" src="img/资源 3-100.jpg" /><br /></a>
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