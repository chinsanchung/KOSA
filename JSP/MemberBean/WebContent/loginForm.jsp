<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
function check_input() {
	var str, i, ch;
	//id check
	if (document.loginform.id.value=="") {
		alert("아이디 입력해라");
		document.loginform.id.focus();
		return;
	} else {
		str= document.loginform.id.value;
		
		for (i=0; i<str.length; i++) {
			ch= str.substring(i, i+1);
			if(!((ch >= "0" && ch <= "9") || (ch >= "a" && ch <= "z") || (ch >= "A" && ch <= "Z"))) {
				alert("특수문자 포함, 다시 입력해라");
				document.loginform.password.focus();
				return;
			}
		}
	}//id check

	//password check
	if (document.loginform.password.value== "") {
		alert("패스워드 입력해라");
		document.loginform.password.focus();
		return;
	} else {
		str= document.loginform.password.value;
		
		for (i=0; i<str.length; i++) {
			ch= str.substring(i, i+1);
			if(!((ch >= "0" && ch <= "9") || (ch >= "a" && ch<= "z") || (ch >= "A" && ch <= "Z"))) {
				alert("특수문자 포함, 다시 입력해라");
				document.loginform.password.focus();
				return;
			}
		}
	}//password check
//return true;
	
	loginform.submit();
}
</script>
<title>로그인 페이지</title>
</head>
<body>
<form name="loginform" action="loginProcess.jsp" method="post">
<center>
<table border=1>
	<tr>
		<td colspan="2" align=center>
			<b><font size=5>로그인페이지</font></b>
		</td>
	</tr>
	<tr>
		<td>ID: </td><td><input type="text" name="id" /></td></tr>
	<tr>
		<td>Password: </td><td><input type="password" name="password" /></td></tr>
	<tr>
		<td colspan="2" align=center>
			<a href="javascript:check_input()">login</a>&nbsp;&nbsp;
			<a href="joinForm.jsp">회원가입</a>
		</td>
	</tr>
</table>
</center>
</form>
</body>
</html>