package ch20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertEx02 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.3.217:1521:orcl";
		Connection con = null;		
		PreparedStatement pstmt = null;
	//?는 파라미터의 대응값(직접 입력한거)을 아직 몰라서 ?임
		String sql = "Insert Into member (hakbun, name, addr, phone) Values (?, ?, ?, ?)";
		String hakbun, name, addr, phone;
		

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블에 값 추가하기");
			System.out.println("학번 입력 :");
			hakbun = in.readLine();
			System.out.println("이름 입력 :");
			name = in.readLine();
			System.out.println("주소 입력 :");
			addr = in.readLine();
			System.out.println("전화번호 입력 :");
			phone = in.readLine();
			
			System.out.println(sql);
		    Class.forName(driver);
		    con = DriverManager.getConnection(url, "scott", "123456");
	//?에 들어갈 값을 설정해주기...1234는 ?위치		    
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hakbun);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.setString(4, phone);
	//끝나고 나서 업데이트한 개수 나오게함
			int res = pstmt.executeUpdate();
			if (res == 1)
				System.out.println();
			else
				System.out.println();
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
