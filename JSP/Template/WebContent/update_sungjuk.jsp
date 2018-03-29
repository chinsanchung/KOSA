<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%
request.setCharacterEncoding("utf-8");
if (session.getAttribute("hakbun") == null || 
	(!((String)session.getAttribute("hakbun")).equals("admin"))) {
	out.println("<script>");
	out.println("history.back();");
	out.println("</script>");
} %>
<script>
function input_check() {
	if(document.updateform1.hakbun.value=="") {
		alert("수정할 학번 입력해라");
		document.updateform1.hakbun.focus();
		return false;
	}
	document.updateform1.submit();
}	
</script>
<form name="updateform1" action="./template.jsp?page=updateForm" method="post">
<table border="0" align="center">
	<tr><td>HAKBUN </td>
	<td><input type="text" name="hakbun" size="7" /></td>
	<td><a href="javascript:input_check()" >검색</a></td>
	</tr>
</table>
</form>