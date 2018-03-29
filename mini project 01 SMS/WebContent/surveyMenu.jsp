<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>

<%
	Connection conn=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	try {
		Context init=new InitialContext();
		DataSource ds=(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn=ds.getConnection();
		
		pstmt1=conn.prepareStatement("SELECT * FROM SURVEY");
		pstmt2=conn.prepareStatement("SELECT * FROM SURVEY WHERE STATE = 'ONGOING'");
		
		rs1=pstmt1.executeQuery();
		rs2=pstmt2.executeQuery();
	} catch(Exception e) {
		e.printStackTrace();
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>설문지 관리 메뉴</title>
</head>
<body>
<form action="surveyProcess.jsp" method="post">
<h1>설문지 목록</h1>
<%while(rs2.next()) {%>
현재 진행중인 설문지<%=rs2.getString("title") %>
<%} %>
<div>
<!-- 반복시작부분이 중요하다. 설정을 잘 하기 ...코드 눌렀을때 메모까지 뜨게 함-->
<% while(rs1.next()) {%>
<ul>
	<li>설문코드<%=rs1.getString("code") %></li>
	<li>이름<%=rs1.getString("title") %></li>
	<li>상태<%=rs1.getString("state") %></li>
	<li>정보<%=rs1.getString("memo") %></li>
	<li><input type="button" name="deleteSurvey" value="삭제" 
	onclick="location.href='deleteSurvey.jsp?code=<%=rs1.getString("code") %>'"></li>
	<li><input type="button" name="updateSurvey" value="수정" 
	onclick="location.href='updateSurvey.jsp?code=<%=rs1.getString("code") %>'"></li>
	<li><input type="button" name="start" value="개시"></li>


</ul>
<%} %>
</div>

<input type="button" name="newSurvey" value="설문추가" onclick="location.href='insertSurvey.jsp'">&nbsp;
</form>

</body>
</html>