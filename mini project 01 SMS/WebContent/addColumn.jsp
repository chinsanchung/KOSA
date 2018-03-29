<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String code=request.getParameter("code");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="addColumn" action="addColumnProcess.jsp" method="post">
<input type="hidden" name= "add" value="<%=code%>">
<ul>
<li>추가할 항목<input type="text" name="column"></li>
</ul>
<input type="button" name="add" value="추가" onclick="location.href='javascript:addColumn.submit()'">
<input type="button" name="re" value="취소" onclick="location.href='surveyMenu.jsp'">
</form>
</body>
</html>