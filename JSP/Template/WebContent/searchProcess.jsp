<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%@ page import= "sungjuk.SungjukDBBean" %>
<%@ page import= "sungjuk.SungjukDataBean" %>

<%
request.setCharacterEncoding("utf-8");
if (session.getAttribute("hakbun") == null || 
	(!((String)session.getAttribute("hakbun")).equals("admin"))) {
	out.println("<script>");
	out.println("history.back();");
	out.println("</script>");
} else {

	String hakbun= (String)request.getParameter("hakbun");
	SungjukDBBean manager= SungjukDBBean.getInstance();
	SungjukDataBean sungjukBean=manager.getSungjuk(hakbun);
	
	
	if (sungjukBean == null) {
		out.println("<script>");
		out.println("alert('성적 다시 입력')");
		out.println("history.back();");
		out.println("</script>");
	} else {%>
	<table border="0" align="center">
	<tr>
		<td>HAKBUN </td>
		<td><%=sungjukBean.getHakbun() %></td>
	</tr>
	<tr>
		<td>IRUM </td>
		<td><%=sungjukBean.getIrum() %></td>
	</tr>
	<tr>
		<td>KOR </td>
		<td><%=sungjukBean.getKor() %></td>
	</tr>
	<tr>
		<td>ENG </td>
		<td><%=sungjukBean.getEng() %></td>
	</tr>
	<tr>
		<td>MATH </td>
		<td><%=sungjukBean.getMath() %></td>
	</tr>	
	<tr>
		<td>TOTAL </td>
		<td><%=sungjukBean.getTot() %></td>
	</tr>
	<tr>
		<td>AVG </td>
		<td><%=sungjukBean.getAvg() %></td>
	</tr>
	<tr>
		<td>GRADE </td>
		<td><%=sungjukBean.getGrade() %></td>
	</tr>
<%
sungjukBean.process();
} %>	
</table>
<%} %>