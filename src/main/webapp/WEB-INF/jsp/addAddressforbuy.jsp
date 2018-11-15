<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!doctype html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="css/banner.css" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ydui.css?rev=@@hash">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/demo.css">
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/ydui.flexible.js"></script>
		<script src="${pageContext.request.contextPath}/js/mui.min.js"></script>
		<script type="text/javascript">
			mui.init()
		</script>
	</head>

	<body>
		<!--
    	作者：abusuper@outlook.com
    	时间：2018-08-26
    	描述：收货地址 - 梁世仟 
   -->
		<div class="mui-content">
			<!--导航栏-->
			<header class="mui-bar mui-bar-nav">
				<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
				<h1 class="mui-title">新增收货地址</h1>
			</header>

			<!--收货地址信息-->
			<div class="mui-content">
				<form class="mui-input-group" action="/guoyuan/user/addShippingAddr.action">

					<div class="mui-input-row">
						<input type="text" name="receiverName" placeholder="收货人姓名" class="mui-input-clear" />
					</div>

					<div class="mui-input-row">
						<input type="number" name="receiverMobile" placeholder="手机号码" class="mui-input-clear" />
					</div>

					<div class="mui-input-row">
						<input type="text" name="receiverCity" class="cell-input" readonly id="J_Address" placeholder="请选择收货地址">
					</div>

					<div class="mui-input-row"  style="height: 80px;">
						<textarea name="receiverAddress" placeholder="详细地址:如道路、门牌号、小区、楼栋号、单元室等" class="mui-input-clear"></textarea>
					</div>

					<div class="mui-input-row">
						<input type="number" name="receiverPostalcode" placeholder="邮政编码" class="mui-input-clear" />

					</div>
				</form>
				<input type="button" id="addAddressSave" value="保存" />
			</div>
		</div>

	</body>
	<!--可优化的地方：
	1：详细地址要限定字数
	2：底部未完成
	3：详细地址再输入的时候应该放大。像淘宝。
-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ydui.citys.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ydui.js"></script>
<script type="text/javascript">
$("#addAddressSave").on("tap",function(){
	mui.ajax("/guoyuan/user/addShippingAddr.action",{
		data:$("form").serialize(),
		success:function(){
			close();
		},
		error:function(){
			mui.toast('添加失败');
		}
	})
	
})
!function () {
	var $target = $('#J_Address');

	$target.citySelect();

	$target.on('click', function (event) {
		event.stopPropagation();
		$target.citySelect('open');
	});

	$target.on('done.ydui.cityselect', function (ret) {
		$(this).val(ret.provance + ' ' + ret.city + ' ' + ret.area);
	});
}();
</script>
	<script>
		mui('body').on('tap', 'a', function() {
			document.location.href = this.href;
		});
	</script>

</html>