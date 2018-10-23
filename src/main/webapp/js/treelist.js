/**
 * 
 */
mui.init({
				pullRefresh: {
					container: '#pullrefresh',
					down: {
						callback: function(){mui('#pullrefresh').pullRefresh().endPulldownToRefresh();}
					},
					up: {
						contentrefresh: '正在加载...',
						callback: pullupRefresh
					}
				}
			});
		

var count = 0;
/**
 * 上拉加载具体业务实现 
 * 
 */
var currentPage=0;
var pageSige=5;
var nomoreData = false;
function pullupRefresh() {
	
	count++;
	currentPage++;
	var result = $('#data');
	var host = location.hostname;
	// ajax取数据

	mui.ajax("/guoyuan/commondity/list.action",
					{
						data : {
							'pageNum' : currentPage,
							'pageSize' : pageSige
						},
						dataType : 'json',
						success : function(data) {
							// 构造数据视图
							if (data.length == 0) {
								nomoreData = true;
							}
							for (var i = 0; i < data.length; i++) {
								var item = $('<div class="mui-row treeListDiv"></div>');
								item.attr('id', data[i].commodityId);
								
								item.on('tap',function() {
											var commodityId = $(this).attr("id");
											var url = 'http://'
													+ location.hostname
													+ ':'
													+ location.port
													+ "/guoyuan/commondity/showCommodity.action?commodityId="
													+ commodityId;
											console.log(url);
											window.open(url, '_self');
										});
								var imgDiv = $('<div class="mui-col-sm-5 mui-col-xs-5"></div>');
								var img = $('<img class="treeListImg" />');
								img.attr('src', data[i].commodityMainPho);
								imgDiv.append(img);
								item.append(imgDiv);
								var tableDiv = $('<div class="mui-col-sm-7 mui-col-xs-7"></div>');
								var table = $('<table></table>');
								var tr1 = $('<tr><td><p><b>'
										+ data[i].commodityName
										+ '</b></p></td></tr>');
								var td = $('<td><p>￥<b>'
										+ data[i].commodityPrice
										+ '</b>/株</p></td>');
								tr1.append(td);
								var tr2 = $('<tr><td colspan="2"><p>生长周期：'
										+ data[i].commodityTerm
										+ '个月</p></td></tr>');
								var tr3 = $('<tr><td colspan="2"><p>预估产量：'
										+ data[i].commodityProduct
										+ 'kg</p></td></tr>');
								table.append(tr1);
								table.append(tr2);
								table.append(tr3);
								tableDiv.append(table);
								item.append(tableDiv);
								result.append(item);
							}
						},
						error : function(data) {
							mui.toast('请求数据出错')
						}
					});
	mui('#pullrefresh').pullRefresh().endPullupToRefresh(nomoreData);
}

if (mui.os.plus) {
	mui.plusReady(function() {
		setTimeout(function() {
			mui('#pullrefresh').pullRefresh().pullupLoading();
		}, 1000);

	});
} else {
	mui.ready(function() {
		mui('#pullrefresh').pullRefresh().pullupLoading();
	});
}


