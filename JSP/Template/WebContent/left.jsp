<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<center>
<% if (session.getAttribute("hakbun")==null) {%>
	로그인하세요
<%} else if (!session.getAttribute("hakbun").equals("admin")) {%>
<a href="./template.jsp?page=search_sungjuk">성적조회</a><br><br><br><br><br><br><br><br>
<%} else { %>
<a href="./template.jsp?page=input_sungjuk">성적입력</a><br><br>
<a href="./template.jsp?page=output_sungjuk">성적출력</a><br><br>
<a href="./template.jsp?page=search_sungjuk">성적조회</a><br><br>
<a href="./template.jsp?page=update_sungjuk">성적수정</a><br><br>
<a href="./template.jsp?page=delete_sungjuk">성적삭제</a><br><br>

<%} %>
</center>
<br /><br /><br /><br /><br /><br />