<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*" %>
<%@ page import= "java.io.*" %>
<%
	Connection conn= null;
	PreparedStatement pstmt= null;
	ResultSet rs= null;
	StringBuffer sb= null;
	
	String driver= "oracle.jdbc.driver.OracleDriver";
	String url= "jdbc:oracle:thin:@localhost:1521:ORCL";
	
	String sql= "INSERT INTO clobtable (num, content) VALUES (1, empty_clob())";
	String sql2= "SELECT content FROM clobtable WHERE num= 1 FOR UPDATE";
	
	try {
		Class.forName(driver);
		conn= DriverManager.getConnection(url, "scott", "123456");
		
		conn.setAutoCommit(false);
		
		sb= new StringBuffer();
		for (int i= 0; i <=10000; i++) {
		sb.append("hong");
		}
		
		pstmt= conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		
		pstmt= conn.prepareStatement(sql2);
		rs= pstmt.executeQuery();
		if(rs.next()) {
//content란 곳에 bufferedwriter로 입력해서 저장
			oracle.sql.CLOB clob= (oracle.sql.CLOB)(rs).getClob("content");
			BufferedWriter bw= new BufferedWriter(clob.getCharacterOutputStream());
			bw.write(sb.toString());
			bw.close();
		}
		pstmt.close();
		
		conn.commit();
		conn.setAutoCommit(true);
		out.println("데이터 저장");
		
		rs.close();
		pstmt.close();
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
%>