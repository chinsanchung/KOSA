package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx01 {

	public static void main(String[] args) {
		Connection conn = null;
		try { 
		 //1. 데이터베이스 로드
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		 //2. 연결 객체 conn 생성
		  conn = DriverManager.getConnection(
				  //자신의 ip로 할것
				  "jdbc:oracle:thin:@192.168.3.217:1521:orcl", "scott", "123456");
		  System.out.println("데이터베이스에 접속");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없다" + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
		//3. 반드시 닫기
				conn.close();			
		} catch (Exception ignored) {
		   }
		}//finally

	}//main

}
