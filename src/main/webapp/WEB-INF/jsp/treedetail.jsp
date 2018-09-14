<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>订单信息</title>
		<script src="${pageContext.request.contextPath }/js/mui.min.js"></script>
		<link href="${pageContext.request.contextPath }/css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/fruitLuck.css" />
	</head>

	<body>
		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-24
    	描述：订单信息 - abu
    -->

		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：果苗信息 title
    -->
		<div class="mui-col-xs-12 treeListTitle">
			<header class="mui-bar mui-bar-nav mui-bar-transparent">
				<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
				<h1 class="mui-title">果苗详情</h1>
			</header>
		</div>
		
		<div class="mui-content">
			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-24
    	描述：果苗图片 - 幻灯轮播 - 梁少
    -->
			<div id="buyMesFruitImg" class="mui-slider">
				<div class="mui-slider-group mui-slider-loop">
					<!--支持循环，需要重复图片节点-->
					<div class="mui-slider-item mui-slider-item-duplicate">
						<a href="#"><img src="/pic/${commodityDetail.commodityMainPho }" /></a>
					</div>
					<div class="mui-slider-item">
						<a href="#"><img src="/pic/${commodityDetail.commoditySubPho1 }" /></a>
					</div>
					<div class="mui-slider-item">
						<a href="#"><img src="/pic/${commodityDetail.commoditySubPho2 }" /></a>
					</div>
					<div class="mui-slider-item">
						<a href="#"><img src="/pic/${commodityDetail.commoditySubPho3 }" /></a>
					</div>
					<!--支持循环，需要重复图片节点-->
					<!-- <div class="mui-slider-item mui-slider-item-duplicate"><a href="#"><img src="1.jpg" /></a></div>-->
				</div>
			</div>

			<div>
				<table id="buyMesTable">
					<tr>
						<td>
							<p><b>${commodityDetail.commodityName }</b></p>
						</td>
						<td></td>
						<td>
							<p><b>￥${commodityDetail.commodityPrice }</b>/株</p>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<p>共计 ${commodityDetail.commodityNum } 株 已售 1400 株</p>
						</td>
					</tr>
					<tr>
						<td>
							<img class="buyMesIcon" src="img/资源 2-100.jpg" />
							<img class="buyMesIcon" src="img/资源 1-100.jpg" />
						</td>
						<td></td>
						<td>
							<input id="buyMesNumber" type="text" value="1" />
							<a href="ensureBuyMessage.html"><button id="buy">购买</button></a>
						</td>
					</tr>
				</table>
			</div>

			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：详情和工厂
   -->
			<hr />
			<div class="mui-row ">
				<table id="buyMesFruitTableLeft" class="mui-col-sm-12 mui-col-xs-12">
					<tr>
						<td>
							<p>产品名称</p>
						</td>
						<td class="MesTableRight">
							<p>果缘苹果</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>领养方式</p>
						</td>
						<td class="MesTableRight">
							<p>株</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>生长周期</p>
						</td>
						<td class="MesTableRight">
							<p>${commodityDetail.commodityTerm }个月</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>价格</p>
						</td>
						<td class="MesTableRight">
							<p>￥${commodityDetail.commodityPrice }/株</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>树苗培育基地</p>
						</td>
						<td class="MesTableRight">
							<a href="factory.html">
								<p>广西桂林百香果工厂</p>
							</a>
						</td>
					</tr>
				</table>
			</div>

			<hr />
			<div id="buyMesEnsure">
				<p><b>认购须知</b></p>
				<p>(1)确认开发商是否是有合法手续的房地产公司；
					<br />(2)签订认购书；
					<br /> (3)签订合同；
					<br /> (4)办理预售登记及转让；
					<br /> (5)办理入住；
					<br /> (6)产权过户、领取产权证。
			</div>
		</div>

	</body>
	<script type="text/javascript" charset="utf-8">
		mui('body').on('tap', 'a', function() {
			document.location.href = this.href;
		});
	</script>

	<!--描述：轮播图-->
	<script type="text/javascript">
		var gallery = mui('.mui-slider');
		gallery.slider({
			interval: 3000 //自动轮播周期，若为0则不自动播放，默认为0；
		});
	</script>

</html>