<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>

<html>
<head>
<title>首页</title>
</head>
<script type="text/javascript">
function is_weixn(){
    var ua = navigator.userAgent.toLowerCase();
    if(ua.match(/MicroMessenger/i)=="micromessenger") {
    	window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1073827a341fc612&redirect_uri=http://hy.aliquan.top/guoyuan/user/home.action&response_type=code&scope=snsapi_base&state=ok#wechat_redirec"; 
        
    } else {
    	window.location.href="/guoyuan/common/home.action";
       
    }
}
is_weixn();
</script>
</html>
