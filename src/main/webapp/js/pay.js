/**
 * 
 */


function pay(){
	var order = {};
	order.totalFee = $("#totalFee").text();
	order.preferFee = $("#preferFee").text();
	order.postFee = $("#postFee").text();
	order.payment = $("#totalFee").text();
	//payment_type
	order.paymentType=1;// 在线
	order.payState = 0;
	order.receiverName = $("#per").text();
	order.receiverMobile = $("#phone").text();
	order.receiverAddress = $("#ad").text();
	order.receiverAddress=order.receiverAddress.replace(/\n|\r|\t/g,"");
	
	//订单项
	var item = new Array();
	var length=$("#nodes").children().length;
	for(var i=0;i<length;i++){
		//得到一个商品节点
		var node=$("#nodes").children().eq(i);
		//遍历子节点添加进list
		var leng=node.children().length;
		
		var orderItem={}
		
		orderItem.commodityId=node.children().eq(0).attr("alt");
		
		orderItem.buyNum=node.children().eq(3).find("span").html();
		console.log(orderItem.commodityId)
		item.push(orderItem)
	}
	
	//ajax 传值
	mui.ajax("commitOrder.action", {
		data : {"order":new String(JSON.stringify(order)),"list":JSON.stringify(item)},
		dataType : 'json',
		success : function(data) {
			console.log(data)
			console.log("订单提交成功")
			order=data.order;
			if (typeof WeixinJSBridge == "undefined"){
				   if( document.addEventListener ){
				       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
				   }else if (document.attachEvent){
				       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
				       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
				   }
				}else{
				   onBridgeReady(data);
				}
			
		},
		error : function(data) {
			console.log("订单提交失败")
		},
		type : 'post',
	
		async : false,
		cache : false
	});
}



function onBridgeReady(data){
	//计算签名
	var timeStamp=Math.round(new Date() / 1000);
	
	var s="appId="+data.appId+"&nonceStr="+data.nonce_str+"&package="+"prepay_id="+data.prepay_id+"&signType=MD5"+"&timeStamp="+timeStamp;
	s=s+"&key="+data.key;
	var sign= hex_md5(s);
	sign=sign.toUpperCase();
	WeixinJSBridge.invoke(
	      'getBrandWCPayRequest', {
	         "appId":data.appId,     //公众号名称，由商户传入     
	         "timeStamp":timeStamp,         //时间戳，自1970年以来的秒数     
	         "nonceStr":data.nonce_str, //随机串     
	         "package":"prepay_id="+data.prepay_id,     
	         "signType":"MD5",         //微信签名方式：     
	         "paySign":sign //微信签名 
	      },
	      function(res){
	    	  if(res.err_msg=='get_brand_wcpay_request:cancel'){
	    		  var url="http://hy.aliquan.top/guoyuan/order/cancelTheOrder.action?orderId="+data.order.orderId+"&page=true";
	    		  window.location.href=url;
	    	  }
	      if(res.err_msg == "get_brand_wcpay_request:ok" ){
	      // 使用以上方式判断前端返回,微信团队郑重提示：
	            //res.err_msg将在用户支付成功后返回ok，但并不保证它绝对可靠。paySuccess
	    	 //ajax请求支付结果
	    	  $.ajax("http://hy.aliquan.top/guoyuan/order/payState.action",{
	    		  data:{'orderId':data.order.orderId},
	    		  type:"POST",
	    		  success:function(data){ 
	    			  if(data=='SUCCESS'){
	    				  location.href="http://hy.aliquan.top/guoyuan/common/paySuccess.action";
	    			  }
	    			  else{
	    				  alert("支付失败");
	    			  }
	    		  },
	    		  error:function(data){
	    			  alert("error"+data.status)
	    		  }
	    		  
	    	  })
	    	  
	      } 
	   }); 
	}
	


















