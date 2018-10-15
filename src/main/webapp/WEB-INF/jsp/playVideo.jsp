<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>果缘</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/css/video-js.css" rel="stylesheet" />
		<script src="${pageContext.request.contextPath}/js/mui.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/video.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js"></script>
	    <script>
			videojs.options.flash.swf = "${pageContext.request.contextPath}/js/video-js.swf";
 		</script>
	</head>
<body>
<div>
   <video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="640" height="480" data-setup="{}">    
    <source src="${video.vUrl }" type="rtmp/flv"/>     
  </video>   
</div>	
</body>
<script>
     $(window).resize(function(e) {
         var window_h = $(window).height();
         var window_w = $(window).width();
         $(".video-js").height( window_h );
         $(".video-js").width( window_w );
     }).resize();

     setTimeout(function(){
         $('.vjs-big-play-button').css('display', 'none');
         $('.vjs-big-play-button').click();
     },100);
 </script>
</html>