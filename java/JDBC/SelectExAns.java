package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExAns {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.3.217:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
				String sql = "Select * from member";
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			stmt = con.createStatement();
		
			rs = stmt.executeQuery(sql);
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
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}//finally

	}//main

}
