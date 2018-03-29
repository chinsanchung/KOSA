<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*" %>
<%
	Connection conn= null;
	PreparedStatement pstmt= null;
	ResultSet rs= null;
	String sql= "INSERT INTO student(num, name) VALUES (11, 'hong')";
	String sql2= "SELECT * FROM student WHERE num= 11";
		
	try {
		Context init= new InitialContext();
		DataSource ds= (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn= ds.getConnection();
		
		conn.setAutoCommit(false);
		
		pstmt= conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		
		pstmt= conn.prepareStatement(sql2);
		rs= pstmt.executeQuery();
		if (!rs.next()) {
			conn.rollback();
			out.println("<h3>데이터 삽입 문제로 롤백</h3>");
		} else {
			conn.commit();
			out.println("<h3>삽입 완료</h3>");
		}
		pstmt.close();
		conn.setAutoCommit(true);
	} catch (Exception e) {
		out.println("<h3>삽입 실패</h3>");
		e.printStackTrace();
	}
%>		