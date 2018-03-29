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
(!session.getAttribute("hakbun").equals("admin"))) {
out.println("<script>");
out.println("history.back();");
out.println("</script>");
} else {
	SungjukDBBean manager = SungjukDBBean.getInstance();
	ArrayList<SungjukDataBean> sungjukList = manager.getSungjukList();
	
	if (sungjukList == null) { %>
	출력할 성적 데이터 없음
<%} else {%>
<table border="1" align="center">
<tr align="center">
	<td>학번</td>
	<td>이름</td>
	<td>국어</td>
	<td>영어</td>
	<td>수학</td>
	<td>총점</td>
	<td>평균</td>
	<td>등급</td>
</tr>
<%
	for (int i=0; i<sungjukList.size(); i++) {
		SungjukDataBean sungjukBean = sungjukList.get(i);
	
%>
	<tr align="center">
		<td><%=sungjukBean.getHakbun() %></td>
		<td><%=sungjukBean.getIrum() %></td>
		<td><%=sungjukBean.getKor() %></td>
		<td><%=sungjukBean.getEng() %></td>
		<td><%=sungjukBean.getMath() %></td>
		<td><%=sungjukBean.getTot() %></td>
		<td><%=sungjukBean.getAvg() %></td>
		<td><%=sungjukBean.getGrade() %></td>
	</tr>
<%	} %>
</table>
<%}
}	
%>