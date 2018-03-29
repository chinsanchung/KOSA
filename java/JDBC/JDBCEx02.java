package ch20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx02 {
//sql에서 commit 해야만 결과가 뜬다
	public static void main(String[] args) {
		//연결 객체, 스테이트먼트, 결과 객체
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.3.217:1521:orcl", "scott", "123456");
			//스테이트먼트 객체 할당
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select code, name, price, maker from goodsinfo");
			System.out.println("상품코드 상품명 \t\t가격 제조사");
			System.out.println("------------------------------------");
			//next로 데이터 행에 접근, 반복-> 더 이상 없으면 false로 빠져나옴
			while (rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				System.out.printf("%8s %s \t%12d %s%n", code, name, price, maker);
			}//while
		} 
		//Class.forName관련 예외
		catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없다" + cnfe.getMessage());
		} 
		//밑의 finally쪽 예외인듯
		catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		//마지막으로 닫을 때 예외 생길 수 있기 때문에 try문 사용		
		finally {
			try {
				rs.close();
			} catch (Exception ignored) {
			} 
			try {
				stmt.close();
			} catch (Exception ignored)	{
				
			} try {
				conn.close();
			} catch (Exception ignored) {
				
			}//catch
		}//finally

	}//main

}
