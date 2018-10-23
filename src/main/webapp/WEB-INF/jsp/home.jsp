<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>首页</title>
		<script src="../js/mui.min.js"></script>
		<link href="../css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="../css/fruitLuck.css" />
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
			<a id="defaultTab" class="mui-tab-item mui-active" href="../common/home.action">
				<img class="bottomNavIcon" src="../img/navBottom/首页.png" />
			</a>
			<a class="mui-tab-item" href="../common/video.action">
				<img class="bottomNavIcon" src="../img/navBottom/视频2.png" />
			</a>
			<a class="mui-tab-item" href="../common/buyList.action">
				<img class="bottomNavIcon " src="../img/navBottom/列表2.png" />
				
			</a>
			<a class="mui-tab-item" href="../common/my.action">
				<img class="bottomNavIcon" src="../img/navBottom/我的2.png" />
			</a>
		</nav>

		<div class="mui-content">
			<!--
            	作者：abusuper@outlook.com
            	时间：2018-09-14
            	描述：顶部信息栏
            -->
            
			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-24
    	描述：首页 - 幻灯轮播 - 梁少
    -->
			<div class="mui-slider" style="height: 180px;">
				<div class="mui-slider-group mui-slider-loop">
					<!--支持循环，需要重复图片节点-->
					<div class="mui-slider-item mui-slider-item-duplicate">
						<a href="#"><img src="../img/banner/banner-菠萝.png" /></a>
					</div>
					<div class="mui-slider-item">
						<a href="#"><img src="../img/banner/banner-菠萝.png" /></a>
					</div>
					<div class="mui-slider-item">
						<a href="#"><img src="../img/banner/banner-菠萝.png" /></a>
					</div>
					<div class="mui-slider-item">
						<a href="#"><img src="../img/banner/banner-菠萝.png" /></a>
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
				<table>
					<tr>
						<td colspan="2">
							<a id="buyTreeHomeIcon" href="../common/treeList.action"><img src="../img/home/养苗Icon.png" style="width: 100%;" ></a></td>
						<td>
							<a id="fruitSuperMarketHomeIcon" href="../common/fruitSupermarket.action"><img src="../img/home/果市Icon.png" style="width: 100%;" /></a></td>
						</tr>
						<tr>
						<td>
							<a id="starHomeIcon" href="../common/star.action"><img src="../img/home/收藏Icon.png" style="width: 100%;" /></a></td>
						<td>
							<a id="messageHomeIcon" href="../common/Message.action"> <img src="../img/home/消息Icon.png" style="width: 100%;" /></a></td>
						<td>
							<a id="" href="#"><img src="../img/home/涨知识Icon.png" style="width: 100%;" /></a></td>
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