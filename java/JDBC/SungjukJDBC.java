package SungjukOracle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SungjukJDBC {

	
	public static void main(String[] args) {
		ArrayList<Sungjuk> list = new ArrayList<Sungjuk>();

		BufferedReader in = null;
		
			try {
			in = new BufferedReader(new InputStreamReader(System.in));
			int menu;
			
			System.out.println("\n*** 메뉴 ***");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 출력");
			System.out.println("3. 성적 조회");
			System.out.println("4. 성적 수정");
			System.out.println("5. 성적 삭제");
			System.out.println("6. 종     료\n");
			
			System.out.print("메뉴 선택(1~6) => ");
			menu = Integer.parseInt(in.readLine());
			
			while (menu == 6) {
				System.out.println("\n프로그램 종료...");
				break;
			}
			
			switch (menu)
			{
				case 1:
					insert_sungjuk(list);
					break;
				case 2:
					select_sungjuk(list);
					break;
				case 3:
					select2_sungjuk(list);
					break;
				case 4:
					update_sungjuk(list);
					break;
				case 5:
					delete_sungjuk(list);
					break;
				default:
					System.out.println("\n메뉴를 다시 선택하세요!!!");
					break;
			}
		} catch(IOException e ) {
			System.out.println("입력 오류 " + e.getMessage());
		}  finally {
			try {
				in.close(); //close하다가도 예외 생길 수 있어서 catch블럭 필요
			} catch(IOException e) {
				System.out.println(e.getMessage());
			}
			}//finally
		}//main
	

	static void insert_sungjuk(ArrayList<Sungjuk> list) {
	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.3.217:1521:orcl";
		Connection con = null;		
		PreparedStatement pstmt = null;	
		String hakbun, irum, grade;
		int kor, eng, math;
		Sungjuk obj = new Sungjuk();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println();
			System.out.println("학번 입력 : ");
			hakbun = in.readLine();
			System.out.println("이름 입력 : ");
			irum = in.readLine();
			System.out.print("국어 입력 => ");
			kor = Integer.parseInt(in.readLine());
			System.out.print("영어 입력 => ");
			eng = Integer.parseInt(in.readLine());
			System.out.print("수학 입력 => ");
			math = Integer.parseInt(in.readLine());

			String sql = "Insert Into sungjuk (hakbun, irum, kor, eng, math) Values (?, ?, ?, ?, ?)";
			System.out.println(sql);
		    Class.forName(driver);
		    con = DriverManager.getConnection(url, "scott", "123456");
		    
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hakbun);
			pstmt.setString(2, irum);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, math);
			int res = pstmt.executeUpdate();
			if (res == 1)
				System.out.println("성적 입력 성공");
			else
				System.out.println("성적 입력 실패");
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
		System.out.println();

		obj.process();
		list.add(obj);
	}
	
	static void select_sungjuk(ArrayList<Sungjuk> list)
	{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.3.217:1521:orcl";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Sungjuk obj = new Sungjuk();
		String sql = "Select * from sungjuk";
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			stmt = con.createStatement();
		//테이블 형식의 ResultSet 반환
			rs = stmt.executeQuery(sql);
		
		System.out.println();
		System.out.println("\n                       *** 성적표 ***");
		System.out.println("============================================================");
		System.out.println("학번    이름     국어    영어    수학    총점    평균    등급");
		System.out.println("============================================================");
		
		while (rs.next()) {
			String hakbun = rs.getString("hakbun");
			String irum = rs.getString("irum");
			int kor = rs.getInt("kor");
			int eng = rs.getInt("eng");
			int math = rs.getInt("math");
			int total = rs.getInt("total");
			String grade = rs.getString("grade");
			obj.output();
			}
			System.out.println();
		//while
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
	
	static void select2_sungjuk(ArrayList<Sungjuk> list)
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
		System.out.print("\n조회할 학번 입력  => ");
		String hakbun = in.readLine();

		for (Sungjuk obj : list)
		{
			if (hakbun.equals(obj.hakbun))
			{
				System.out.println();
				System.out.println("학번    이름     국어    영어    수학    총점    평균    등급");
				System.out.println("============================================================");
				obj.output();
				System.out.println("============================================================");				
				return;
			}
		}
		System.out.println("\n존재하지 않는 학번입니다!!!");
		} catch (IOException e) {
			System.out.println("실패 " + e.getMessage());
		}  finally {
			try {
				in.close(); //close하다가도 예외 생길 수 있어서 catch블럭 필요
			} catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}//finally
	}//insert

	
	static void update_sungjuk(ArrayList<Sungjuk> list) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.3.217:1521:orcl";
		Connection con = null;		
		PreparedStatement pstmt = null;	
	
		String hakbun, irum;
		int kor, eng, math;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("갱신할 학번 입력 : ");
			hakbun = in.readLine();
			System.out.println("새 이름 입력 : ");
			irum = in.readLine();
			System.out.print("새 국어 성적 입력 => ");
			kor = Integer.parseInt(in.readLine());
			System.out.print("새 영어 성적 입력 => ");
			eng = Integer.parseInt(in.readLine());
			System.out.print("새 수학 성적 입력 => ");
			math = Integer.parseInt(in.readLine());

			String sql = "Update sungjuk Set irum = ?, kor = ?, eng = ?, math = ? Where hakbun = ?";
			System.out.println(sql);
		    Class.forName(driver);
		    con = DriverManager.getConnection(url, "scott", "123456");
		    
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, irum);
			pstmt.setInt(2, kor);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, math);
			pstmt.setString(5, hakbun);
			int res = pstmt.executeUpdate();
			if (res == 1)
				System.out.println("데이터베이스 내용 갱신 성공");
			else
				System.out.println("데이터베이스 내용 갱신 성공");
		} catch (Exception e) {
		System.out.println("\n존재하지 않는 학번입니다!!!");
	   } finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
	   }//finally
	}//update
	static void delete_sungjuk(ArrayList<Sungjuk> list) {
		Connection con = null;		
		PreparedStatement pstmt = null;	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.3.217:1521:orcl";
		
		String hakbun = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("sungjuk 테이블에 값 갱신하기");
			System.out.println("삭제할 학번 입력 : ");
			hakbun = in.readLine();
			//학번이 만약 5자리인데 3자리 입력하면 공백 생겨서 그 공백 제거하려고 trim 사용(좌우측 공백 제거)
			//제거 안하면 공백 문자 없는 남은 글자랑만 비교해서, 원래값(공백있음)과 같은 값이라고 인식 못함
			String sql = "Delete From sungjuk Where trim(hakbun) = ?";
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
	}//delete

 }
