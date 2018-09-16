<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>订单确认</title>
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
    	描述：订单确认信息 - 制作人
    -->

		<div class="mui-content">
			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：title
    -->
			<div class="mui-col-xs-12 treeListTitle">
				<header class="mui-bar mui-bar-nav mui-bar-transparent">
					<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
					<h1 class="mui-title">提交订单</h1>
				</header>
			</div>

			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：收获地址
    -->
    
			<div id="ensureMesAddressDiv">
			<c:if test="${ensureOrderVo!=null}">
				<table id="ensureMesAddress">
					<tr>
						<td>
							<p>收件人：<b>${ensureOrderVo.receiverAddress.receiverName }</b></p>
						</td>
						<td>
							<p><b>${ensureOrderVo.receiverAddress.receiverMobile }</b></p>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<p>收货地址：${ensureOrderVo.receiverAddress.receiverState }
				           ${ensureOrderVo.receiverAddress.receiverCity }
				           ${ensureOrderVo.receiverAddress.receiverDistrict }
				           ${ensureOrderVo.receiverAddress.receiverAddress }</p>
						</td>
					</tr>
				</table>
				</c:if>
			</div>
			
			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：果苗信息
    -->		
			<div id="ensureMesTreeDiv" class="mui-row treeListDiv">
				<img alt="商品图片" src="/pic/${ensureOrderVo.commodityOrderVo.commodityMainPho }"/>
				<div class="mui-col-sm-4 mui-col-xs-4">
					<p>￥${ensureOrderVo.commodityOrderVo.commodityPrice }</p>
				</div>
				<div class="mui-col-sm-4 mui-col-xs-4">
					<p>${ensureOrderVo.commodityOrderVo.commodityName }</p>
				</div>
				<div class="mui-col-sm-4 mui-col-xs-4">
					<p>${ensureOrderVo.commodityOrderVo.buyNumber }株</p>
				</div>
			</div>
			<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：详情和工厂
   		-->
			<div class="mui-row ensureMesBuy">
				<table class="mui-col-sm-12 mui-col-xs-12">
					<tr>
						<td>
							<p>运费</p>
						</td>
						<td class="MesTableRight">
							<p>￥15.00</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>运费险</p>
						</td>
						<td class="MesTableRight">
							<p>卖家免费赠送</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>果币</p>
						</td>
						<td class="MesTableRight">
							<p> - ￥20.00</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>商品总价</p>
						</td>
						<td class="MesTableRight">
							<c:if test="${ensureOrderVo!=null}">
								<p>￥${ensureOrderVo.commodityOrderVo.buyNumber * ensureOrderVo.commodityOrderVo.commodityPrice}</p>
							</c:if>
						</td>
					</tr>
				</table>
			</div>
			<hr />
			<c:if test="${ensureOrderVo!=null}">
				<form id="orderForm" action="" method="post">
					<input type="hidden" name="commodityId" value="${ensureOrderVo.commodityOrderVo.commodityId}"/>
					<input type="hidden" name="buyNumber" value="${ensureOrderVo.commodityOrderVo.buyNumber}"/>
					<input type="hidden" name="receiverAddressId" value="${ensureOrderVo.receiverAddress.receiverAddressId}"/>
				</form>
			</c:if>
			<div id="ensureMesBtn">
				<a href="buyMessage.html"><button>取消订单</button></a>
				<a href="paySuccess.html"><button>提交订单</button></a>
			</div>
		</div>

	</body>

</html>