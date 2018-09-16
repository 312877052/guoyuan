<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>收藏</title>
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
    	描述：收藏 - abu
    -->
		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：收藏 title
    -->
		<header class="mui-bar mui-bar-nav mui-bar-transparent">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">收藏</h1>
		</header>

		<div class="mui-content">

			<a href="${pageContext.request.contextPath}/common/buyMessage.action">
				<div id="2" class="mui-row treeListDiv">
					<div class="mui-col-sm-5 mui-col-xs-5">
						<img class="treeListImg" src="${pageContext.request.contextPath}/img/Order.jpg" />
					</div>
					<div class="mui-col-sm-7 mui-col-xs-7">
						<table>
							<tr>
								<td>
									<p><b>青柠二期</b></p>
								</td>
								<td>
									<p><b>￥400.0</b>/株</p>
									<!--</td>-->
							</tr>
							<tr>
								<td colspan="2">
									<p>生长周期：4个月</p>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<p>预估产量：20kg + 40kg = 60kg</p>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</a>

			<a href="${pageContext.request.contextPath}/common/buyMessage.action">
				<div id="3" class="mui-row treeListDiv">
					<div class="mui-col-sm-5 mui-col-xs-5">
						<img class="treeListImg" src="${pageContext.request.contextPath}/img/资源 14-100.jpg" />
					</div>
					<div class="mui-col-sm-7 mui-col-xs-7">
						<table>
							<tr>
								<td>
									<p><b>青柠二期</b></p>
								</td>
								<td>
									<p><b>￥400.0</b>/株</p>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<p>生长周期：4个月</p>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<p>预估产量：20kg + 40kg = 60kg</p>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</a>
		</div>
	</body>

</html>