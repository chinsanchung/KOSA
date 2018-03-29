package ch20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteEx {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.3.217:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		BufferedReader in = null;
		
		String hakbun = null;	

		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블에 값 갱신하기");
			System.out.println("삭제할 학번 입력 : ");
			hakbun = in.readLine();
		//"MBC" + 3 = MBC3이 뜨는 것과 같은 원리
			String sql = "Delete From member Where hakbun = '" + hakbun + "'";

			System.out.println(sql);			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);
			//학번의 값은 하나밖에 없기에 res에 하나만 저장되어 1이 됨 없는 학번 입력시 res는 0이라 갱신실패
			if (res == 1)
				System.out.println("데이터베이스 내용 갱신 성공");
			else
				System.out.println("데이터베이스 내용 갱신 실패");			
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패" + e.getMessage());
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}//catch
		}//finally
	}//main
}