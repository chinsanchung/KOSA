<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*" %>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%
	Connection conn= null;
	String sql= "INSERT INTO student (num, name) VALUES(6, 'hong')";	
	try {
		Context init= new InitialContext();
		DataSource ds= (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn= ds.getConnection();
		Statement stmt= conn.createStatement();
		
		int result= stmt.executeUpdate(sql);
		if(result != 0) {
			out.println("<h3>레코드 등록</h3>");
		}
	}catch (Exception e) {
			out.println("<h3>레코드 등록 실패</h3>");
			e.printStackTrace();
		}
%>
