/**
 * 
 */
var form =$("#buyform")


$("#buy").on('tap',function(){
	var buyNum=$("#buyMesNumber").val();
	if(tree.commodityStatus!=1){alert('商品已下架');return;}
	else if(buyNum>tree.commodityCurrNum){
		alert('库存不足');return;
	}
	//ajax提交表单
	$.ajax("/guoyuan/order/ensureOrderDirect.action",{
		method:'POST',
		data:form.serialize(),
		dataType:"json",
		success:function(data){ 
			alert("null")
		},
		error:function(data){
			var iframe=$('<iframe id="if_content" name="if_content" width="100%" onload="this.height=if_content.document.body.scrollHeight" frameborder="0" ></iframe>');
			iframe[0].srcdoc=data.responseText;
			$("body").html($(iframe));
		}
	})
})