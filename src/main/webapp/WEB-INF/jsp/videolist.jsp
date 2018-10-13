<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>果缘</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/css/videoshow.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/css/iconfont.css" rel="stylesheet" />
		<script src="${pageContext.request.contextPath}/js/mui.min.js"></script>
	</head>
	<body>
		<div class="mui-content">
		    <div class="video-div">
		    <c:if test="${videoVo.size<=5}">
		    	<div class="video-div-nav">
		    		<c:forEach items="${videoVo.vids}" var="vid">		    	
		    			<a class="w20">${vid.catName}</a>
	    			</c:forEach>
	    		</div>
	    	</c:if>	 
	    	<c:if test="${videoVo.size>5}">
	    		<div class="video-div-nav">	
	    			<c:forEach items="${videoVo.vids}" begin="0" end="3"  var="vid">	    	
	    				<a class="w20">${vid.catName}</a>
	    			</c:forEach>    			
	    			<button class="mui-btn-link vidmore">更多<span class="mui-icon iconfont icon-sanjiaoxing_o"></span></button>	    			   			
	    		</div>
		    	<div class="other-nav-list">
		    		<c:forEach items="${videoVo.vids}" begin="4" var="vid">	    	
	    				<a class="w20">${vid.catName}</a>
	    			</c:forEach> 
		    	</div>
	    	</c:if>
		    </div>
		    <c:forEach items="${videoVo.videolist}" var="videoInfo">
			    <div class="video-list" style="display:none;">
			    	 <c:forEach items="${videoInfo.videos}" var="video">
				    	<div class="video-item">
					    	<a href="${video.id }">
					    		<img src="/pic/${video.vImg }"/>
					    		<p>${video.vName }</p>
					    	</a>	    		
				    	</div>
			    	</c:forEach>
			    </div>
		    </c:forEach>
		</div>
		<script type="text/javascript">
			mui.init();
			var vNav = document.getElementsByClassName('video-div')[0];
			var navItem = vNav.getElementsByTagName('a');
			var vList = document.getElementsByClassName('video-list');
			navItem[0].className='w20 active-a';
			vList[0].style.display="block";
			for(var i=0;i<navItem.length;i++){
				navItem[i].index=i;
				navItem[i].onclick=function(){
					for(var j=0;j<vList.length;j++){
						navItem[j].className='w20';
						vList[j].style.display='none';
					}
					this.className='w20 active-a';
					vList[this.index].style.display="block";
				}
			}
			var morebtn = document.getElementsByClassName('vidmore')[0];
			if(morebtn!=null){				
				var moreicon = morebtn.getElementsByTagName('span')[0];
				var morelist = document.getElementsByClassName('other-nav-list')[0];
				morebtn.onclick = function(){
					var currName = moreicon.className;
					if(currName == 'mui-icon iconfont icon-sanjiaoxing_o'){
						moreicon.className = 'mui-icon iconfont icon-sanjiaoxing_shang_o';
						morelist.style.display = 'block';
					}else{
						moreicon.className = 'mui-icon iconfont icon-sanjiaoxing_o';
						morelist.style.display = 'none';
					}
				}
			}
		</script>
	</body>

</html>