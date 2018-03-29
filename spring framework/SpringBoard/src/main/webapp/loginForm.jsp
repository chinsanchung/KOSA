<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<div align=center>
		<h3>Login하세요</h3>
		<hr>
<!-- 컨트롤러가 두 개 있는데 둘 다 찾는다. 이건 유저컨트롤러에 있음 -->
		<form action="user.do?method=login" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" /></td>
				</tr>		
				<tr>
					<td align="center" colspan="2"><input type="submit" value="로그인" /></td>
				</tr>
			</table>
		</form>
		<hr>
	</div>
</body>
</html>