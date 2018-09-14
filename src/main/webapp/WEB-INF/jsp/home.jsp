<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>首页</title>
		<script src="${pageContext.request.contextPath}/js/mui.min.js"></script>
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/banner.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fruitLuck.css" />
		<script type="text/javascript" charset="utf-8">
			mui.init({

			});
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
				<img class="bottomNavIcon" src="${pageContext.request.contextPath}/img/资源 14-100.jpg" />
			</a>
			<a class="mui-tab-item" href="${pageContext.request.contextPath}/common/video.action">
				<img class="bottomNavIcon" src="${pageContext.request.contextPath}/img/资源 10-100.jpg" />
			</a>
			<a class="mui-tab-item" href="${pageContext.request.contextPath}/common/buyList.action">
				<img class="bottomNavIcon " src="${pageContext.request.contextPath}/img/资源 11-100.jpg" />
				<span class="mui-badge mui-badge-success">12</span>
			</a>
			<a class="mui-tab-item" href="${pageContext.request.contextPath}/common/my.action">
				<img class="bottomNavIcon" src="${pageContext.request.contextPath}/img/资源 13-100.jpg" />
			</a>
		</nav>

		<div class="mui-content">
			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-24
    	描述：首页 - 幻灯轮播 - 梁少
    -->
			<div class="mui-slider" style="height: 180px;">
				<div class="mui-slider-group mui-slider-loop">
					<!--支持循环，需要重复图片节点-->
					<div class="mui-slider-item mui-slider-item-duplicate">
						<a href="#"><img src="${pageContext.request.contextPath}/4.jpg" /></a>
					</div>
					<div class="mui-slider-item">
						<a href="#"><img src="${pageContext.request.contextPath}/img/banner-1.png" /></a>
					</div>
					<div class="mui-slider-item">
						<a href="#"><img src="${pageContext.request.contextPath}/img/banner-2.png" /></a>
					</div>
					<div class="mui-slider-item">
						<a href="#"><img src="${pageContext.request.contextPath}/img/banner-3.png" /></a>
					</div>
					<!--支持循环，需要重复图片节点-->
					<!-- <div class="mui-slider-item mui-slider-item-duplicate"><a href="#"><img src="1.jpg" /></a></div>-->
				</div>
			</div>

			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：icon
    -->
			<div>
				<table class="bingoTable">
					<tr>
						<td class="bingo">
							<a id="buyTreeHomeIcon" href="${pageContext.request.contextPath}/common/list.action"><img src="${pageContext.request.contextPath}/img/KeepTree.jpg" class="bingoImg"></a><br>买苗</td>
						<td class="bingo">
							<a id="starHomeIcon" href="${pageContext.request.contextPath}/common/star.action"><img src="${pageContext.request.contextPath}/img/Collection.jpg" class="bingoImg" /></a><br>收藏</td>
						<td class="bingo">
							<a id="buyListHomeIcon" href="${pageContext.request.contextPath}/common/buyList.action"><img src="${pageContext.request.contextPath}/img/Order.jpg" class="bingoImg" /></a><br>订单</td>
					</tr>
					<tr>
						<td class="bingo bingo_td">
							<a id="messageHomeIcon" href="${pageContext.request.contextPath}/common/Message.action"> <img src="${pageContext.request.contextPath}/img/News.jpg" class="bingoImg" /></a><br>消息</td>
						<td class="bingo bingo_td">
							<a id="fruitSuperMarketHomeIcon" href="${pageContext.request.contextPath}/common/fruitSupermarket.action"><img src="${pageContext.request.contextPath}/img/FruitMarket.jpg" class="bingoImg" /></a><br>果市</td>
					</tr>
				</table>
			</div>
		</div>

	</body>
	<script type="text/javascript">
		var gallery = mui('.mui-slider');
		gallery.slider({
			interval: 5000 //自动轮播周期，若为0则不自动播放，默认为0；
		});

		//mui('body').on('click','a',function(){document.location.href=this.href;});
		mui('body').on('tap', 'a', function() {
			document.location.href = this.href;
		});
	</script>

</html>