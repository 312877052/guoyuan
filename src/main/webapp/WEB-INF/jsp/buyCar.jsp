<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>购物车</title>
		<script src="${pageContext.request.contextPath }/js/mui.min.js"></script>
		<link href="${pageContext.request.contextPath }/css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/banner.css" />
		<script type="text/javascript" charset="utf-8">
			mui.init();
		</script>
		<style type="text/css">

		</style>
	</head>

	<body>
		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-24
    	描述：购物车 - 制作人.
    -->
		<div class="mui-content">
			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：收藏 title
    -->
			<!--<div class="mui-col-xs-12 treeListTitle">-->
			<header class="mui-bar mui-bar-nav mui-bar-transparent">
				<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
				<h1 class="mui-title">购物车</h1>
			</header>

			<div class="mui-content">
				<table style="width:100%;">
					<tr>
						<td class="CheckboxBtn"><input type="checkbox" name="item1" value="Item1" class="buycarChb" /></td>
						<td>
							<div class="buycarInfo">
								￥ 400.0 苹果一期F区 2株
							</div>
						</td>
					</tr>

					<tr>
						<td class="CheckboxBtn"><input type="checkbox" name="item2" value="Item2" class="buycarChb" /></td>
						<td>
							<div class="buycarInfo">
								￥ 400.0 苹果一期F区 2株
							</div>
						</td>
					</tr>
				</table>
			</div>

			<table class="sum" border="1">
				<tr>
					<td>
						<div class="mui-input-row mui-checkbox mui-left">
							<label>全选</label>
							<input name="checkbox1" value="Item3" type="checkbox">
						</div>
					</td>
					<td>
						<font size="5">总计：600.00</font>
					</td>
					<td>
						<a href="${pageContext.request.contextPath }/common/ensureBuyMessage.action"><input id="sum" type="button" name="count" value="结算" /></a>
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