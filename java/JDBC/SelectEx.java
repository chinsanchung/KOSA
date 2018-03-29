package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectEx {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		//JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
		//데이터베이스 연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.3.217:1521:orcl", "scott", "123456");
		//스테이트먼트 객체 stmt 할당
			stmt = conn.createStatement();
		//executeQuery 메소드 호출
			rs = stmt.executeQuery("select hakbun, name, addr, phone from member");
			System.out.println("hakbun   name   addr     phone");
			System.out.println("------------------------------------");
		//next메소드 호출..더이상 부를게 없을때까지 + get~~으로 특정 컬럼 값 가져옴
			while (rs.next()) {
				String code = rs.getString("hakbun");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String phone = rs.getString("phone");
				System.out.printf("%8s %3s %5s     %9s", code, name, addr, phone);
				System.out.println();
			}//while
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없다" + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		//마지막으로 닫을 때 예외 생길 수 있기 때문에 try문 사용
		} finally {
			try {
				rs.close();
			} catch (Exception ignored) {

			} try {
				stmt.close();
			} catch (Exception ignored)	{
				
			} try {
				conn.close();
			} catch (Exception ignored) {
				
			}//catch
		}//finally
	}//main

}
