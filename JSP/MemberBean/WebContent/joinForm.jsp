<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JOIN PAGE</title>
</head>
<body>
<form name="joinform" action="joinProcess.jsp" method="post" >
<center>
<table border=1>
	<tr>
		<td colspan="2" align=center>
			<b><font size= 5>JOIN PAGE</font></b>
		</td>
	</tr>
	<tr><td>ID : </td>
	<td><input type= "text" name= "id" /></td>
	</tr>
	<tr><td>PASSWORD : </td>
	<td><input type= "password" name= "password" /></td>
	</tr>
	<tr><td>NAME : </td>
	<td><input type= "text" name= "name" /></td>
	</tr>
	<tr><td>AGE : </td>
	<td><input type= "text" name= "age" maxlength= 2 size= 5 /></td>
	</tr>
	<tr><td>GENDER : </td>
	<td>
		<input type= "radio" name= "gender" value= "m" checked />male
		<input type= "radio" name= "gender" value= "f" checked />female
			</td>
	</tr>	
	<tr><td>EMAIL : </td>
	<td><input type= "text" name= "email" size= 30 /></td>
	</tr>
	<tr>
	<td colspan= "2" align= center>
		<a href="javascript:joinform.submit()">JOIN</a>
		<a href="javascript:joinform.reset()">RESET</a>
	</td>
	</tr>
</table>
</center>
</form>
</body>
</html>