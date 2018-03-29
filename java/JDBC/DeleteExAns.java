package ch20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteExAns {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.3.217:1521:orcl";
		Connection con = null;		
		PreparedStatement pstmt = null;	
		
		String hakbun = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member 테이블에 값 갱신하기");
			System.out.println("삭제할 학번 입력 : ");
			hakbun = in.readLine();
			//학번이 만약 5자리인데 3자리 입력하면 공백 생겨서 그 공백 제거하려고 trim 사용(좌우측 공백 제거)
			//제거 안하면 공백 문자 없는 남은 글자랑만 비교해서, 원래값(공백있음)과 같은 값이라고 인식 못함
			String sql = "Delete From member Where trim(hakbun) = ?";
			System.out.println(sql);
		    
			Class.forName(driver);
		    con = DriverManager.getConnection(url, "scott", "123456");	
		    
		    pstmt = con.prepareStatement(sql);
		    pstmt.setString(1, hakbun.trim());
		    
		    int res = pstmt.executeUpdate();
		    if (res == 1) 
		    	System.out.println("데이터베이스 삭제 성공");
		    else
		    	System.out.println("데이터베이스 삭제 실패");
	}catch (Exception e) {
		System.out.println("데이터베이스 연결 실패 = " + e.getMessage());
	} finally {
		try {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
	}//catch
  }//finally
}//main
}
