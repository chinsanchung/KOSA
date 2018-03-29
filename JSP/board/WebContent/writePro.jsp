<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDBBean"%>
<%@ page import="java.sql.Timestamp" %>

<% request.setCharacterEncoding("utf-8"); 
//처음 설계때 파라미터랑 class안의 boardDataBean과 같아야함..그래야 *사용가능?
%>

<jsp:useBean id="article" scope="page" class="board.BoardDataBean">
	<jsp:setProperty name="article" property="*" />
</jsp:useBean>

<%
	article.setReg_date(new Timestamp(System.currentTimeMillis()));
	
	BoardDBBean dbPro= BoardDBBean.getInstance();
	
	dbPro.insertArticle(article);
	
	response.sendRedirect("list.jsp");
%>