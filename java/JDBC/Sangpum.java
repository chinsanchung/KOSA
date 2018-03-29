package SangpumOracle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sangpum {
	String code, irum;
	int su, dan, price;

	
	boolean input() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		try {

			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@192.168.3.217:1521:orcl";
			String sql = "select count(*) from sangpum where code = ?";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
		
			System.out.println("상품코드 입력 => ");
			code = in.readLine();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			rs.next();
			//중복 찾기			
			if(rs.getInt(1) != 0) {
				System.out.println("\n상품코드 중복오류\n");
				return true;
			}
			
			System.out.println("상품명 입력 => ");
			irum = in.readLine();
			System.out.println("수량 입력 => ");
			su = Integer.parseInt(in.readLine());
			System.out.println("단가 입력 => ");
			dan = Integer.parseInt(in.readLine());
		} catch (IOException e) {
			System.out.println("input : 입력 오류 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패: " + e.getMessage());			
		}
//컨트로 쉬프트 o키로 import시킴		
		return false;
	}
	void process() {
		price = su * dan;
	}
	
	void output() {	
		System.out.printf("%4s   %3s   %4d    %4d     %5d \n",
			code, irum, su, dan, price);
	}

}
