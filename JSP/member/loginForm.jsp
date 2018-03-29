<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LOGIN</title>
</head>
<body>
<form name= "loginform" action= "loginProcess.jsp" method="post">
<center>
<table border=1>
	<tr>
		<td colspan= "2" align= center>
			<b><font size= 5>LOGIN PAGE</font></b>
		</td>
	</tr>
	<tr><td>ID : </td>
	<td><input type= "text" name= "id" /></td>
	</tr>
	<tr><td>PASSWORD : </td>
	<td><input type= "password" name= "pass" /></td>
	</tr>
	<tr>
		<td colspan= "2" align= center>
		<a href="javascript:loginform.submit()">LOGIN</a>
		<a href="joinForm.jsp">JOIN</a>
		</td>
	</tr>
</table>
</center>
</form>
</body>
</html>