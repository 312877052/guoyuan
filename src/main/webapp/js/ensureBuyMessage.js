/**
 * 
 */
var model;
var commodityModel;
function delay(){
	
}
var data={
		"isDefaultAddress": '',
		"receiverAddress": "",
		"receiverAddressId": 0,
		"receiverCity": "",
		"receiverDistrict": "",
		"receiverMobile": "",
		"receiverName": "",
		"receiverPostalcode": "",
		"receiverState": ""
	}
function init(){
	if(pageData.defaultAddr!=undefined&&pageData.defaultAddr!='' ){
		model=addr(pageData.defaultAddr);
		$("#ensureMesAddressDiv").append(model);
	}else{
		var receiveAddr =$('<table id="ensureMesAddress"><tr><td><p></p></td></tr></table>');
		//
		var p=receiveAddr.find('p');
		//收件人
		p.append("添加收货地址:")
		$("#ensureMesAddressDiv").append(receiveAddr);
		noAddr=true;
		
	}
}

init();
/**
 * data 收货地址数据对象
 * @returns
 */
function addr(data){
	var receiveAddr =$('<table id="ensureMesAddress"><tr><td><p></p></td></tr></table>');
	//
	var p=receiveAddr.find('p');
	//收件人
	p.append("收件人:")
	var person=$('<b id="per"></b>');
	person.html(data.receiverName);
	p.append(person);
	var tel=$('<td><p><b id="phone"></b></p></td>');
	tel.find("#phone").html(data.receiverMobile);
	receiveAddr.find('tr').append(tel);
	var tr=$('<tr><td colspan="2"></td></tr>');
	var p1=$('<p>收货地址:</p>');
	var p2=$('<p id="ad">');
	p2.append(data.receiverCity+data.receiverAddress);
	tr.children().append(p1)
	tr.children().append(p2);
	receiveAddr.children().append(tr);
	return receiveAddr;
	
}


function getModel(){
	
	
	
	

}


//打开添加收货地址窗口openWindow
function AddAddress(){
	
	var myWindow=window.open("/guoyuan/common/addAddressforbuy.action","addAddr.jsp");
	myWindow.focus()
	myWindow.onbeforeunload=function(){
		var temp;
		//ajax 获取默认收货地址
		mui.ajax("/guoyuan/user/getDefaultAddress.action",{
			dataType:'json',
			success:function(data){
				temp=data;
			},
			error:function(){
				mui.toast("获取收货地址失败");
			},
			complete:function(){
				model=addr(temp);
				$("#ensureMesAddressDiv").html(model);
				flag = true;//下次重新加载地址数据
			}
			,
			timeout:550
		});
		
	}
	
	
	
}



$(function() {
	if (flag) {
		//取出收货地址数据
		var res = getAddress();
		//弹出层
		var popAddress;
		var deviceHeight = document.body.offsetHeight;

		var popAddressCss = "'height:" + deviceHeight / 2
				+ "px;background-color: white;'";
		popAddress = $("<div id='popAddress' class='box mui-popover mui-popover-action mui-popover-bottom' style="+popAddressCss+"></div>")
		var divtitle = $('<div style="text-align: center;background-color: #007AFF;">收货地址</div>');
		popAddress.append(divtitle)
		//ul
		var ul = $('<ul class="mui-table-view mui-table-view-radio"></ul>');
		//循环li
		for (var i = 0; i < res.length; i++) {
			var html = res[i].receiverState + res[i].receiverCity
					+ res[i].receiverDistrict + res[i].receiverAddress;
			html = '<a class="mui-navigate-right">' + html + '</a>'
			if (i == 0) {
				var li = $('<li class="mui-table-view-cell mui-selected" style="text-align: left;color: black;"></li>');
				li.html(html);

			} else {
				var li = $('<li class="mui-table-view-cell" style="text-align: left;color: black;"></li>');
				li.html(html);
			}
			li.val(i);
			ul.append(li);
			
		}
		//添加收货地址
		var li=$('<li class="mui-table-view-cell" style="text-align: left;color: black;"></li>');
		li.html("添加收货地址");
		li.on('tap',function(){
			AddAddress();
		});
		
		ul.append(li);
		popAddress.append(ul)
		$("body").append(popAddress)
		document.querySelector('.mui-table-view.mui-table-view-radio')
				.addEventListener('selected', function(e) {
					var value = e.detail.el.value;
					$("#per").html(res[value].receiverName);
					$("#phone").html(res[value].receiverMobile);
					$("#ad").html($($(e.detail.el).html()).html());
					mui('#popAddress').popover('toggle');
				});
		flag = false;
	} else {

	}
});

$("#ensureMesAddressDiv").on("tap",function(){
	if (flag) {
		mui('#popAddress').popover('hide');//取消弹出层
		$("body").find("#popAddress").remove();
		
		//取出收货地址数据
		var res = getAddress();
		//弹出层
		var popAddress;
		var deviceHeight = document.body.offsetHeight;

		var popAddressCss = "'height:" + deviceHeight / 2
				+ "px;background-color: white;'";
		popAddress = $("<div id='popAddress' class='box mui-popover mui-popover-action mui-popover-bottom' style="+popAddressCss+"></div>")
		var divtitle = $('<div style="text-align: center;background-color: #007AFF;">收货地址</div>');
		popAddress.append(divtitle)
		//ul
		var ul = $('<ul class="mui-table-view mui-table-view-radio"></ul>');
		//循环li
		for (var i = 0; i < res.length; i++) {
			var html = res[i].receiverState + res[i].receiverCity
					+ res[i].receiverDistrict + res[i].receiverAddress;
			html = '<a class="mui-navigate-right">' + html + '</a>'
			if (i == 0) {
				var li = $('<li class="mui-table-view-cell mui-selected" style="text-align: left;color: black;"></li>');
				li.html(html);

			} else {
				var li = $('<li class="mui-table-view-cell" style="text-align: left;color: black;"></li>');
				li.html(html);
			}
			li.val(i);
			ul.append(li);
			
		}
		//添加收货地址
		var li=$('<li class="mui-table-view-cell" style="text-align: left;color: black;"></li>');
		li.html("添加收货地址");
		li.on('tap',function(){
			AddAddress();
		});
		
		ul.append(li);
		popAddress.append(ul)
		
		$("body").append(popAddress)
		document.querySelector('.mui-table-view.mui-table-view-radio')
				.addEventListener('selected', function(e) {
					var value = e.detail.el.value;
					$("#per").html(res[value].receiverName);
					$("#phone").html(res[value].receiverMobile);
					$("#ad").html($($(e.detail.el).html()).html());
					mui('#popAddress').popover('toggle');
				});
		setTimeout("display()",50);
		flag = false;
	} else {

	}
})


function display(){
	mui('#popAddress').popover('toggle');//显示弹出层
}


function commodityNode(pageData){
	var div=$('<div id="ensureMesTreeDiv" class="mui-row treeListDiv">');
	
	var money=$('<div class="mui-col-sm-4 mui-col-xs-4">');
	money.append($('<p>').html('￥'+pageData.CommodityInfo.commodityPrice));
	var name=$('<div class="mui-col-sm-4 mui-col-xs-4">');
	name.append($('<p>').html(pageData.CommodityInfo.commodityName));
	var number=$('<div class="mui-col-sm-4 mui-col-xs-4"><p><span id="buyNum"></span></p></div>');
	number.find('span').html(pageData.buyInfo[0].buyNumber);
	number.find('p').append("株");
	div.append(money).append(name).append(number);
	$('#nodes').append(div);
}


commodityNode(pageData);




