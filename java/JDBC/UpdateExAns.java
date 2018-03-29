package ch20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateExAns {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.3.217:1521:orcl";
		Connection con = null;		
		PreparedStatement pstmt = null;	
		
		String hakbun, addr, phone;
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블에 값 갱신하기");
			System.out.println("갱신할 학번 입력 : ");
			hakbun = in.readLine();
			System.out.println("새 주소 입력 : ");
			addr = in.readLine();
			System.out.println("새 전화번호 입력 : ");
			phone = in.readLine();
			//출력때 나오는 불필요한 공백 제거 Where trim(hakbun) = ?...오라클에서 쓰는 trim
			String sql = "Update member Set addr = ?, phone = ? Where hakbun = ?";
			System.out.println(sql);
		    Class.forName(driver);
		    con = DriverManager.getConnection(url, "scott", "123456");
		    
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setString(2, phone);
			pstmt.setString(3, hakbun);
			int res = pstmt.executeUpdate();
			if (res == 1)
				System.out.println("데이터베이스 내용 갱신 성공");
			else
				System.out.println("데이터베이스 내용 갱신 성공");
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패 = " + e.getMessage());
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}//catch
		}//finally
	}//main

}