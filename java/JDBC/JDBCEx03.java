package ch20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCEx03 {
	
	public static void main(String[] args) {
		//연결 객체, Statement, ResultSet 객체
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BufferedReader in = null;
		
		try {
		//버퍼드리더 객체 in 만듬
			in = new BufferedReader(new InputStreamReader(System.in));
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.3.217:1521:orcl", "scott", "123456");
		//스테이트먼트 객체 할당
			stmt = conn.createStatement();
			
			System.out.println("조회할 상품코드 입력 => ");
			String code = in.readLine();
			rs = stmt.executeQuery("select code, name, price, maker " +
			"from goodsinfo where code = '" + code + "'");			
			System.out.println("상품코드 상품명 \t\t가격 제조사");
			System.out.println("------------------------------------");
		//next로 데이터 행에 접근, 반복-> 더 이상 없으면 false로 빠져나옴
			while (rs.next()) {
				code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				System.out.printf("%8s %s \t%12d %s%n", code, name, price, maker);
			}//while		 
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없다" + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		//30줄의 code = in.readLine(); 오류 없애기 위한 예외 e
		  catch (Exception e) { 
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
