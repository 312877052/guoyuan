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
	form.submit();
})