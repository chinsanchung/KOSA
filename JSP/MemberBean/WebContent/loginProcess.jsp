<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%@ page import= "member.MemberDBBean" %>
<%
	String id=request.getParameter("id");
	String password=request.getParameter("password");
	
	MemberDBBean manager= MemberDBBean.getInstance();
	int check= manager.userCheck(id, password);
	
	if (check==1) {
		session.setAttribute("id", id);
		
		out.println("<script>");
		out.println("location.href='main.jsp'");
		out.println("</script>");
	} else if (check==0) {
		out.println("<script>");
		out.println("alert('패스워드 다시 입력해')");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('아이디와 패스워드를 다시 입력해라')");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	}
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>