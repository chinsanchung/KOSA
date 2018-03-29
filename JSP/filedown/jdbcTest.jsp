<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*" %>
<%
	Connection conn= null;
	String driver= "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	
	Boolean connect= false;
	
	try {
		Class.forName(driver);
		conn= DriverManager.getConnection(url, "scott", "123456");
		
		connect= true;
		
		conn.close();
		
	} catch (Exception e) {
		connect= false;
		e.printStackTrace();
	}
%>
<html>
<head>
<title>JDBC</title>
</head>
<body>
<h3>
<%if(connect == true) {%>
연결성공
<%}else {%>
연결실패
<%} %>
</h3>
</body>
</html>