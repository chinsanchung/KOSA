<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="member.MemberDBBean"%>
<%@ page import="member.MemberDataBean"%>

<%
	String hakbun=request.getParameter("hakbun");
	String password=request.getParameter("password");
	
	MemberDBBean manager= MemberDBBean.getInstance();
	String irum = manager.userCheck(hakbun, password);
	
	if (irum != null) {
	//이름 존재시 학번이름 둘 다 저장
		session.setAttribute("hakbun", hakbun);
		session.setAttribute("irum", irum);
		
		out.println("<script>");
		out.println("location.href='./template.jsp?page=main'");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("location.href='./template.jsp?page=loginForm'");
		out.println("</script>");
	}
%>