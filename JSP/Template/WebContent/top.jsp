<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
if(session.getAttribute("hakbun") == null) {
%>
&nbsp;
<a href="./template.jsp?page=loginForm">Login</a> |
<a href="./template.jsp?page=joinForm">Join</a>
<%} else {%>
%nbsp;<b><%=session.getAttribute("irum") %></b> |
<a href="./template.jsp?page=logout">Logout</a>
<% if (((String)session.getAttribute("hakbun")).equals("admin")) {%>
	| <a href="./template.jsp?page=member_list">회원관리</a>
<%
	}
}
%>