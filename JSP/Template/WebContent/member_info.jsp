<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="member.MemberDBBean"%>
<%@ page import="member.MemberDataBean"%>

<%
	if ((session.getAttribute("hakbun") == null)
			|| (!((String) session.getAttribute("hakbun")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href= './template.jsp?page=loginForm'");//admin이 아니라서 다시 로그인폼으로 돌아감
		out.println("</script>");
	}
	String hakbun = request.getParameter("hakbun");

	MemberDBBean manager = MemberDBBean.getInstance();
	MemberDataBean memberBean = manager.selectMember(hakbun);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manger mode(View Member List)</title>
</head>
<body>
	<center>
		<table border=1 width=300>
			<tr align=center>
				<td>HAKBUN :</td>
				<td><%=memberBean.getHakbun()%></td>
			</tr>
			<tr align=center>
				<td>PASSWORD :</td>
				<td><%=memberBean.getPassword()%></td>
			</tr>
			<tr align=center>
				<td>IRUM :</td>
				<td><%=memberBean.getIrum()%></td>
			</tr>
			<tr align=center>
				<td>AGE :</td>
				<td><%=memberBean.getAge()%></td>
			</tr>
			<tr align=center>
				<td>GENDER :</td>
				<td><%=memberBean.getGender()%></td>
			</tr>
			<tr align=center>
				<td>EMAIL :</td>
				<td><%=memberBean.getEmail()%></td>
			</tr>
			<tr align=center>
				<td colspan=2><a href="./template.jsp?page=member_list">BACK
						TO THE LIST</a></td>
			</tr>
		</table>
	</center>
</body>
</html>