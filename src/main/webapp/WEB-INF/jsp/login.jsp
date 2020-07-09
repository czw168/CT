<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UBoT</title>
<style type="text/css">
body{
	font-family:Arial; 
	background-color:#D5E1F9;
}

div{
    height: 400px;
    position:absolute;
    left:0;
    top: 0;
    bottom: 0;
    right: 0;
    margin: auto;
}
</style>
<script type="text/javascript" src="statics/js/jquery-1.6.4.js"></script>
</head>
<body onkeydown="keyLogin();">
<h2>Carrier Tape System</h2><hr/>
<div style="font-size: 18px">
	<form id="loginForm" method="post" onsubmit="return false;">
		<table  align="center" >
			<!-- <tr colspan="2">
				<td><h3>欢迎登录</h3></td>
			</tr> -->
			<tr>
				<td>User Name</td>
				<td><input type="text" name="name" id="name"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="password"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" id="loginSubmit" value="Login" style="font-size: 16px"/></td>
			</tr>
		</table>
	</form>
</div>

<script type="text/javascript">
	
	window.onload=function(){
		if(window !=top){    
		 	top.location.href = location.href;  
		} 
		document.getElementById('name').focus();
	}
	
	function keyLogin(){
		 if (event.keyCode==13)  //回车键的键值为13
		 $("#loginSubmit").click(); //调用登录按钮的登录事件
	}
	
	var LOGIN = {
			checkInput:function() {
				if ($("#name").val() == "") {
					alert("username cannot be empty");
					$("#name").focus();
					return false;
				}
				if ($("#password").val() == "") {
					alert("password cannot be empty");
					$("#password").focus();
					return false;
				}
				return true;
			},
			doLogin:function() {
				// $("#loginForm").serialize()：将表单序列化为key-value形式
				$.post("${pageContext.request.contextPath}/login", $("#loginForm").serialize(),function(result){
					console.log(result);
					if (result.status == 200) {
						location.href = "${pageContext.request.contextPath}/index";
					} else {
						alert("message：" + result.msg);
						$("#name").select();
					}
				});
			},
			login:function() {
				if (this.checkInput()) {
					this.doLogin();
				}
			}
		
	};
	$(function(){
		$("#loginSubmit").click(function(){
			LOGIN.login();
		});
	});
</script>
</body>
</html>