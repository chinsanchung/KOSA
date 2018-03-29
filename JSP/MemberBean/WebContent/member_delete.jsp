<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="javax.sql.*" %>
<%@page import="javax.naming.*" %>
<%@page import="java.util.*" %>
<%@page import="member.MemberDBBean" %>
<%@page import="member.MemberDataBean" %>
<% request.setCharacterEncoding("utf-8"); %>  
<% 
	String id= null;

	if((session.getAttribute("id") == null) || (!((String)session.getAttribute("id")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href= 'loginForm.jsp'");
		out.println("</script>");
	}
	String delete_id= request.getParameter("id");
	
	MemberDBBean manager= MemberDBBean.getInstance();
	int result=manager.deleteMember(delete_id);
	
	if(result!=0) {
		
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