<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%
	String id= request.getParameter("id");
	String pass= request.getParameter("pass");
	
	Connection conn= null;
	PreparedStatement pstmt= null;
	ResultSet rs= null;
	
	try {
		Context init= new InitialContext();
		DataSource ds= (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn= ds.getConnection();
		
		pstmt= conn.prepareStatement("SELECT * FROM member WHERE id= ?");
		pstmt.setString(1, id);
		rs= pstmt.executeQuery();
		
		if(rs.next()) {
		//입력한 password와 DB에 있는 password 비교
			if(pass.equals(rs.getString("password"))) {
				session.setAttribute("id", id);
				
				out.println("<script>");
				out.println("location.href='main.jsp'");
				out.println("</script>");
			}
		}
		
		out.println("<script>");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	} catch (Exception e) {
		e.printStackTrace();
	}
%>