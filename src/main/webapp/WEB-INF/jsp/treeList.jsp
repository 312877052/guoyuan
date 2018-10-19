<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>养苗列表</title>
<script src="${pageContext.request.contextPath }/js/mui.min.js"></script>
<link href="${pageContext.request.contextPath }/css/mui.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/fruitLuck.css" />
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
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
	<!--下拉刷新容器-->
		<div id="pullrefresh" class="mui-content mui-scroll-wrapper">
			<div class="mui-scroll">
				<!--数据列表-->
				<div id="data"></div>
			</div>
		</div>
</body>
<script src="${pageContext.request.contextPath }/js/treelist.js"></script>


</html>