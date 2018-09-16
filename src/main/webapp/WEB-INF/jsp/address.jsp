<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>收货地址</title>
		<script src="${pageContext.request.contextPath}/js/mui.min.js"></script>
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/banner.css" />
		<script type="text/javascript" charset="utf-8">
			mui.init();
		</script>

	</head>

	<body>
		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-27
    	描述：收货地址 - 梁世仟
   -->
		<div class="mui-content">
			<header class="mui-bar mui-bar-nav">
				<a href="${pageContext.request.contextPath}/common/my.action" class="mui-icon mui-icon-left-nav mui-pull-left"></a>
				<h1 class="mui-title">收货地址</h1>
			</header>

			<div class="mui-content" style="height: 100%;">
				<div class="consigneeAddress">
					<a href="${pageContext.request.contextPath}/common/addAddress.action">

						<div class="receivingAddress1">
							<span>Demo</span>
						</div>

						<div class="receivingAddress2">
							<span>新疆维吾尔自治区自治区直辖县级行政区划阿拉尔市阿拉尔星旗舰店</span>
						</div>

					</a>

				</div>

				<div class="consigneeAddress">
					<a href="${pageContext.request.contextPath}/common/addAddress.action">

						<div class="receivingAddress1">
							<span>+</span>
						</div>

						<div class="receivingAddress2">
							<span>新增地址</span>
						</div>
					</a>
				</div>
			</div>
		</div>

	</body>
	<script>
		mui('body').on('tap', 'a', function() {
			document.location.href = this.href;
		});
	</script>

</html>