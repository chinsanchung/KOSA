<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String irum=null;

if (session.getAttribute("hakbun") == null) {
	out.println("<script>");
	out.println("location.href='./template.jsp?page=loginForm'");
	out.println("</script>");
} else {
	irum=(String)session.getAttribute("irum");
	%>

<h3><%=irum %>으로 로그인함
</h3>
<%}
%>