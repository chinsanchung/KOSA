<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.spring.springboard.BoardDAO"%>
<%@ page import="com.spring.springboard.BoardVO"%>
<%
	String userRole= (String)session.getAttribute("userRole");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>
</head>
<body>
<center>
<h3>글 상세</h3>
<hr>
<table border='1' cellpadding='0' cellspacing='0'>
	<tr>
		<td>제목</td>
		<td>${boardVO.getTitle()}</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${boardVO.getWriter()}</td>
	</tr>
	<tr>
		<td>내용</td>
		<!-- disabled는 content창이 비활성화되어서 출력(읽기)만 가능하게 만든다 -->
		<td><textarea name='content' cols='40' rows='10'disabled='disabled'>${boardVO.getContent()}</textarea>
		</td>
	</tr>
	<tr>
		<td>등록일</td>
		<td>${boardVO.getRegdate()}</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${boardVO.getCnt()}</td>
	</tr>
	<tr>
		<td colspan='2' align='center'>
			<a href='./board.do?method=addBoardForm'>글 등록</a>&nbsp;&nbsp;&nbsp;
			<a href='./board.do?method=updateBoardForm&seq=${boardVO.getSeq()}'>글 수정</a>&nbsp;&nbsp;&nbsp;
<%			
			if(userRole.equals("Admin")) {
%>
				<a href='./board.do?method=deleteBoard&seq=${boardVO.getSeq()}'>글 삭제</a>&nbsp;&nbsp;&nbsp;
<%
			}
%>		
			<a href='./board.do?method=getBoardlist'>글 목록</a>
		</td>
	</tr>
</table>
</center>
</body>
</html>