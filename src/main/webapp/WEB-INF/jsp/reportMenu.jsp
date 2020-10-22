<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report Menu</title>
<style type="text/css">
body{
	font-family:Arial; 
	background-color:#D5E1F9;
	font-size: 20px;
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

a{
	text-decoration : none
}
</style>
</head>
<body>
	<div style="margin: 20px 20px">
		<table>
			<tr>
				<td><a href="${pageContext.request.contextPath}/report/reportIndex">1.Yield Summary by Lot</a><br><br></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/report/reportIndex2">2.Lot Dimension</a><br><br></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/report/reportIndex3">3.XXXXX</a><br><br></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/report/reportIndex4">4.Lot Image Inspection Report</a><br><br></td>
			</tr>
			<tr>
				<!-- <td><a href="javascript:(0)" onclick="javascript:history.back(-1)">返回</a><br><br></td> -->
				<td><a href="javascript:;" onclick="javascript:location.href='${pageContext.request.contextPath}/index'">return</a><br><br></td>
			</tr>
		</table>
	</div>
</body>
</html>