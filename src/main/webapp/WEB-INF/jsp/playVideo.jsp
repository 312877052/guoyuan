<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>果缘</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <meta name="apple-mobile-web-app-capable" content="yes">
	    <meta name="apple-mobile-web-app-status-bar-style" content="black">
	    <meta name="format-detection" content="telephone=no">
	    <meta name="wap-font-scale" content="no">
		<link href="${pageContext.request.contextPath}/css/mui.min.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/css/video-js.css" rel="stylesheet" />
		<script src="${pageContext.request.contextPath}/js/mui.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/video.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery-1.10.1.js"></script>
		<script src="${pageContext.request.contextPath}/js/videojs-contrib-hls.js"></script>
	</head>
<body>
<div>    
    <video id="roomVideo" class="video-js vjs-default-skin">
	    <source src="${video.vUrl }"  type="application/x-mpegURL">
	</video>
</div>	
</body>
	<script type="text/javascript">
		var window_h = $(window).height();
		var window_w = $(window).width();
	    var myPlayer = videojs('roomVideo',{
	    	ontrols:true,
			autoplay:true,
			height:window_h,
			width:window_w,
	        bigPlayButton : false,
	        textTrackDisplay : false,
	        posterImage: true,
	        errorDisplay : false,
	        controlBar : false
	    },function(){
	    	this.play();
	        //startVideo();
	    });
	    var isVideoBreak;
	    function startVideo() {
	        myPlayer.play();
	        //微信内全屏支持
	        document.getElementById('roomVideo').style.width = window.screen.width + "px";
	        document.getElementById('roomVideo').style.height = window.screen.height + "px";
	        //判断开始播放视频，移除高斯模糊等待层
	        var isVideoPlaying = setInterval(function(){
	            var currentTime = myPlayer.currentTime();
	            if(currentTime > 0){
	                $('.vjs-poster').remove();
	                clearInterval(isVideoPlaying);
	            }
	        },200)

	        //判断视频是否卡住，卡主3s重新load视频
	        var lastTime = -1,
	            tryTimes = 0;
	        
	        clearInterval(isVideoBreak);
	        isVideoBreak = setInterval(function(){
	            var currentTime = myPlayer.currentTime();
	            console.log('currentTime'+currentTime+'lastTime'+lastTime);

	            if(currentTime == lastTime){
	            	//此时视频已卡主3s
	            	//设置当前播放时间为超时时间，此时videojs会在play()后把currentTime设置为0
	                myPlayer.currentTime(currentTime+10000);
	                myPlayer.play();

	                //尝试5次播放后，如仍未播放成功提示刷新
	                if(++tryTimes > 5){
	                    alert('您的网速有点慢，刷新下试试');
	                    tryTimes = 0;
	                }
	            }else{
	                lastTime = currentTime;
	                tryTimes = 0;
	            }
	        },3000)

	    }
	</script>
</html>