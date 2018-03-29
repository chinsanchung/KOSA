<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("utf-8");
  String pagefile= request.getParameter("page");
  if(pagefile == null) { pagefile= "loginForm";}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Template test</title>
</head>
<body>
	<table width="960" border="1" align="center">
		<tr>
			<td height="43" colspan=3 align=left><jsp:include page="top.jsp" />
			</td>
		</tr>
		<tr>
			<td width="15%" align="right" valign="top"><br> <jsp:include
					page="left.jsp" /></td>
			<td colspan="2" align="center"><jsp:include
					page='<%=pagefile +".jsp"  %>' /></td>
		</tr>
		<tr>
			<td width="100%" height="40" colspan="3"><jsp:include
					page="bottom.jsp" /></td>
		</tr>
	</table>
</body>
</html>
