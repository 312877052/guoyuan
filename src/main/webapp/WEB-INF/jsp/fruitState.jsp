<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>果苗状态</title>
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
    	描述：水果状态 - 制作人
    -->

		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：我的树苗列表
 -->
		<div class="mui-content">
			<div id="myTreeListTitle" class="mui-row">
				<div class="mui-col-sm-1 mui-col-xs-1">
					<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
				</div>
				<div class="mui-col-sm-2 mui-col-xs-2">
					<p>20d</p>
				</div>
				<div class="mui-col-sm-3 mui-col-xs-3">
					<p>幼苗期</p>
				</div>
				<div class="mui-col-sm-3 mui-col-xs-3">
					<p>苹果</p>
				</div>
				<div class="mui-col-sm-3 mui-col-xs-3">
					<p>2株</p>
				</div>
			</div>
			<img id="fruitStsteImg" src="${pageContext.request.contextPath}/img/幼苗期.png" />

			<div id="fruitStsteDiv" class="mui-row">
				<div class="mui-col-sm-12 mui-col-xs-12">
					<p id="fruitStsteTitle">发芽期</p>
				</div>
				<div class="mui-col-sm-8 mui-col-xs-8">
					<p>距下一阶段还有 20 天</p>
				</div>
				<div class="mui-col-sm-4 mui-col-xs-4">
					<p>幼苗期</p>
				</div>
			</div>

			<div id="fruitStsteEnvariment" class="mui-row">
				<div class="mui-col-sm-4 mui-col-xs-4">
					<img class="fruitStsteEnvarimentIcon" src="${pageContext.request.contextPath}/img/雨水.png" />
					<br />
					<p>充足</p>
				</div>
				<div class="mui-col-sm-4 mui-col-xs-4">
					<img class="fruitStsteEnvarimentIcon" src="${pageContext.request.contextPath}/img/阳光.png" />
					<br />
					<p>充足</p>
				</div>
				<div class="mui-col-sm-4 mui-col-xs-4">
					<img class="fruitStsteEnvarimentIcon" src="${pageContext.request.contextPath}/img/肥料.png" />
					<br />
					<p>充足</p>
				</div>
				<div id="fruitStsteEnvarimentArea" class="mui-col-sm-12 mui-col-xs-12">
					<span>果区</span>
					<a href="fruitGarden.html"><img class="fruitStsteEnvarimentIcon" src="${pageContext.request.contextPath}/img/果区.png" /></a>
				</div>
			</div>
		</div>
	</body>

</html>