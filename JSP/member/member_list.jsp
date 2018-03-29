<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%
	String id= null;
	
	if((session.getAttribute("id") == null) || 
			(!((String)session.getAttribute("id")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href= 'loginForm.jsp'");
		out.println("</script>");
	}
	
	Connection conn= null;
	PreparedStatement pstmt= null;
	ResultSet rs= null;
	try {
		Context init= new InitialContext();
		DataSource ds= (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn= ds.getConnection();
		
		pstmt= conn.prepareStatement("SELECT * FROM member");
		rs= pstmt.executeQuery();
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Manger mode(View Member List)</title>
</head>
<body>
<center>
<table border= 1 width= 300>
	<tr align= center><td colspan= 2>Member List</td></tr>
	<%while(rs.next()) { %>
	<tr align= center>
		<td>
		<a href= "member_info.jsp?id=<%=rs.getString("id") %>">
			<%=rs.getString("id") %>
		</a></td>
		<td><a href= "member_delete.jsp?id=<%=rs.getString("id") %>">DELETE</a></td>
	</tr>
	<%} %>
</table>
</center>
</body>
</html>
		