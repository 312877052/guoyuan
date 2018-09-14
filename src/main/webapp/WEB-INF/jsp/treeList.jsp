<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>养苗列表</title>
		<script src="${pageContext.request.contextPath }/js/mui.min.js"></script>
		<link href="${pageContext.request.contextPath }/css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/fruitLuck.css" />
		<script type="text/javascript" charset="utf-8">
			mui.init();
		</script>
	</head>

	<body>
		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-24
    	描述：养苗列表 - abu
    -->
		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：买苗 title
    -->
		<header class="mui-bar mui-bar-nav mui-bar-transparent">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">买苗</h1>
		</header>

		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：树苗批次
   -->
		<div class="mui-content">
			<c:forEach items="${commodtiypageInfo.list}" var="commodity">
			<a href="${pageContext.request.contextPath }/common/showCommodity.action?commodityId=${commodity.commodityId}">
				<div id="1" class="mui-row treeListDiv">
					<div class="mui-col-sm-5 mui-col-xs-5">
						<img class="treeListImg" src="/pic/${commodity.commodityMainPho }" />
					</div>
					<div class="mui-col-sm-7 mui-col-xs-7">
						<table>
							<tr>
								<td>
									<p><b>${commodity.commodityName }</b></p>
								</td>
								<td>
									<p><b>￥${commodity.commodityPrice }</b>/株</p>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<p>生长周期：${commodity.commodityTerm }个月</p>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<p>预估产量：${commodity.commodityProduct }kg</p>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</a>
			</c:forEach>
		</div>
	</body>

</html>