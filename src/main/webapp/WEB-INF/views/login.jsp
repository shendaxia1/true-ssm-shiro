<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<form id="loginform">
用户名：	<input name="username" type="text" >
密码：	<input name="password" type="password" >
	<!-- <input type="submit" value="登陆 " > -->
	<input type="button" value="登陆 ">
	
</form>
<script>
$(function(){ 
	$("input[type='button']").click(function(){
		$.ajax({
		    //几个参数需要注意一下
		        type: "POST",//方法类型
		        dataType: "json",//预期服务器返回的数据类型
		        url: "${pageContext.request.contextPath}/user/login" ,//url
		        data: $('#loginform').serialize(),		        
		        success: function (result) {
		            console.log(result);//打印服务端返回的数据(调试用)
		            if (result.success == true) {
		                alert("SUCCESS");
		            }
		        }
		    });
	});
})
</script>
</body>
</html>