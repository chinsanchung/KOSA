<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*" %>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%
	Connection conn= null;
	String sql= "INSERT INTO student(num, name) values (?, 'hong')";
	
	try {
		Context init= new InitialContext();
		DataSource ds= (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn= ds.getConnection();
		PreparedStatement stmt= conn.prepareStatement(sql);
		
		
		for (int i= 7; i<= 10; i++) {
			stmt.setInt(1, i);
			if (stmt.executeUpdate() != 0) {
				out.println("<h3>" + i + "번 레코드 등록</h3>");
			}
		}		
	} catch(Exception e) {
		out.println("<h3>레코드 등록 실패</h3>");
		e.printStackTrace();
	}
%>
	