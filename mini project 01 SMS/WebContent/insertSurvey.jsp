<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="insertSurvey" action="insertSurveyProcess.jsp" method="post" >
<div>
<ul>
	<li>설문코드: <input type="text" name="code" /></li>
	<li>제목 : <input type="text" name="title" /></li>
	<li>메모 : <input type="text" name="memo" /></li>
	
	<li><input type="button" name="add" value="추가" onclick="location.href='javascript:insertSurvey.submit()'"></li>
	<li><input type="button" name="reset" value="취소" onclick="location.href='surveyMenu.jsp'"></li>
</ul>
</div>
</form>
</body>
</html>