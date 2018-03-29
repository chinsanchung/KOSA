<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%@ page import= "survey.SurveyDBBean" %>
<%@ page import= "survey.SurveyDataBean" %>
<% request.setCharacterEncoding ("utf-8"); %>
<% 
String info_code=request.getParameter("code");

SurveyDBBean manager= SurveyDBBean.getInstance(); 
ResultSet rs= manager.getResultSet(info_code);
ResultSetMetaData rsMdata= manager.getTableMdata(info_code);
%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form name="deleteSurvey" action="deleteColumnProcess.jsp" method="post">
<input type="hidden" name="code" value="<%=info_code%>">
<div>
<ul>
	<%
	for (int i = 1; i <= rsMdata.getColumnCount(); i++) {
	%>
	<li><%=rsMdata.getColumnName(i)%>
		<%if(i >= 3) {%>
			<input type="checkbox" name="col" value="<%=rsMdata.getColumnName(i)%>"></li>
	<%}
	}	%>
</ul>

</div>
</form>
<input type="button" name="add" value="항목추가" onclick="location.href='addColumn.jsp?code=<%=info_code%>''">
<input type="button" name="delete" value="삭제" onclick="location.href='javascript:deleteSurvey.submit()'">
</body>
</html>