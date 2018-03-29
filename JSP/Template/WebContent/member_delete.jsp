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

	if((session.getAttribute("hakbun") == null) || (!((String)session.getAttribute("hakbun")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href= './template.jsp?page=loginForm'");
		out.println("</script>");
	}
	String hakbun= request.getParameter("hakbun");
	
	MemberDBBean manager= MemberDBBean.getInstance();
	int result=manager.deleteMember(hakbun);
	
	if(result!=0) {
		out.println("<script>");
		out.println("location.href= './template.jsp?page=member_list'");
		out.println("</script>");
	} else {
		
	}
%>
