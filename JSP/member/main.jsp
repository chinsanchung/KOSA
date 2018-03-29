<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	String id= null;

	if (session.getAttribute("id") != null) {
		id= (String)session.getAttribute("id");
	} else {
		out.println("<script>");
		out.println("location.href= 'loginForm.jsp'");
		out.println("</script>");
	}
%>
<html>
<head>
<title>Member Management System Main Page</title>
</head>
<body>
<h3><%=id %> login complete</h3>
<% if(id.equals("admin")) {%>
<a href= "member_list.jsp">Manager mode connect(View member list)</a>
<%} %>
</body>
</html>