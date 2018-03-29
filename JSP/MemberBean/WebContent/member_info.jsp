<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%@ page import= "member.MemberDBBean" %>
<%@ page import= "member.MemberDataBean" %>
<%
	String id=null;
	if ((session.getAttribute("id") == null) || (!((String) session.getAttribute("id")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href= './template.jsp?page=loginForm'");//admin이 아니라서 다시 로그인폼으로 돌아감
		out.println("</script>");
	}
	String info_id=request.getParameter("id");
	
	MemberDBBean manager= MemberDBBean.getInstance();
	MemberDataBean memberdata= manager.selectMember(info_id);
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
	<tr align= center><td>ID : </td><td><%=memberdata.getId() %></td></tr>
	<tr align= center><td>PASSWORD : </td><td><%=memberdata.getPassword() %></td></tr>
	<tr align= center><td>NAME : </td><td><%=memberdata.getName() %></td></tr>
	<tr align= center><td>AGE : </td><td><%=memberdata.getAge() %></td></tr>
	<tr align= center><td>GENDER : </td><td><%=memberdata.getGender() %></td></tr>
	<tr align= center><td>EMAIL : </td><td><%=memberdata.getEmail() %></td></tr>
	<tr align= center>
		<td colspan= 2><a href= "./template.jsp?page=member_list">BACK TO THE LIST</a></td>
	</tr>
</table>
</center>
</body>
</html>