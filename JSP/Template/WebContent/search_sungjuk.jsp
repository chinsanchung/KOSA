<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%@ page import= "sungjuk.SungjukDBBean" %>
<%@ page import= "sungjuk.SungjukDataBean" %>
<jsp:useBean id="sungjukBean" class="sungjuk.SungjukDataBean" scope="page">
	<jsp:setProperty name="sungjukBean" property="*" />
</jsp:useBean>
<% 
request.setCharacterEncoding("utf-8");
if (session.getAttribute("hakbun") == null) {
	out.println("<script>");
	out.println("history.back();");
	out.println("</script>");
} else if (session.getAttribute("hakbun").equals("admin")) {
%>

<script>
	function input_check() {
		if(document.searchform.hakbun.value=="") {
			alert("조회할 학번 입력해라");
			document.searchform.hakbun.focus();
			return false;
		}
		document.searchform.submit();
	}
</script>
<form name="searchform" action="./template.jsp?page=searchProcess" method="post">
<table border="0" align="center" >
	<tr><td>HAKBUN </td>
	<td><input type="text" name="hakbun" size="7" /></td>
	<td><a href="javascript:input_check()">조회</a></td>
	</tr>
</table>
</form>

<!-- 일반계정 로그인 -->
<% } else { %>
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
</table>
<% } %>