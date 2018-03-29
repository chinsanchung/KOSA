<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
	function check_input() {
		var str, i, ch;
		//id check
		if (document.loginform.hakbun.value == "") {
			alert("아이디 입력해라");
			document.loginform.hakbun.focus();
			return;
		} else {
			str = document.loginform.hakbun.value;

			for (i = 0; i < str.length; i++) {
				ch = str.substring(i, i + 1);
				if (!((ch >= "0" && ch <= "9") || (ch >= "a" && ch <= "z") || (ch >= "A" && ch <= "Z"))) {
					alert("특수문자 포함, 다시 입력해라");
					document.loginform.password.focus();
					return;
				}
			}
		}//id check

		//password check
		if (document.loginform.password.value == "") {
			alert("패스워드 입력해라");
			document.loginform.password.focus();
			return;
		} else {
			str = document.loginform.password.value;

			for (i = 0; i < str.length; i++) {
				ch = str.substring(i, i + 1);
				if (!((ch >= "0" && ch <= "9") || (ch >= "a" && ch <= "z") || (ch >= "A" && ch <= "Z"))) {
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
<title>JOIN PAGE</title>
</head>
<body>
	<form name="joinform" action="./template.jsp?page=joinProcess"
		method="post">
		<center>
			<table border=1>
				<tr>
					<td colspan="2" align=center><b><font size=5>JOIN
								PAGE</font></b></td>
				</tr>
				<tr>
					<td>HAKBUN :</td>
					<td><input type="text" name="hakbun" /></td>
				</tr>
				<tr>
					<td>PASSWORD :</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>IRUM :</td>
					<td><input type="text" name="irum" /></td>
				</tr>
				<tr>
					<td>AGE :</td>
					<td><input type="text" name="age" maxlength=2 size=5 /></td>
				</tr>
				<tr>
					<td>GENDER :</td>
					<td><input type="radio" name="gender" value="m" checked />male
						<input type="radio" name="gender" value="f" checked />female</td>
				</tr>
				<tr>
					<td>EMAIL :</td>
					<td><input type="text" name="email" size=30 /></td>
				</tr>
				<tr>
					<td colspan="2" align=center><a
						href="javascript:joinform.submit()">JOIN</a> <a
						href="javascript:joinform.reset()">RESET</a></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>