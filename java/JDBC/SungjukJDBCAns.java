package SungjukOracle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SungjukJDBCAns {

	public static void main(String[] args) {
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		
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
			
			
			switch (menu)
			{
				case 1:
					input_sungjuk();
					break;
				case 2:
					output_sungjuk();
					break;
				case 3:
					search_sungjuk();
					break;
				case 4:
					update_sungjuk();
					break;
				case 5:
					delete_sungjuk();
					break;
				case 6:
					System.out.println("\n프로그램 종료");
					break;
				default:
					System.out.println("\n메뉴를 다시 선택하세요!!!");
					break;
			}//switch
			if (menu == 6) {
				break;
				}//if
			}//while
		} catch (IOException e) {
			System.out.println("입력 오류 : " + e.getMessage());
		} finally {
			try {
				in.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			}//catch
		}//finally
	}//main	
	//input에서 활용할것임..호출시 연결 객체 할당받은 후 con 반환(return con)
	static Connection getconnectDB() {
		Connection con = null;
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@192.168.3.217:1521:orcl";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
		} catch(Exception e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace( );
		}
		return con;
	}//getconnectDB()
	
	static void input_sungjuk() {

		Sungjuk obj = new Sungjuk();

		System.out.println();
		obj.input();
		obj.process();

		Connection con = getconnectDB();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO SUNGJUK (hakbun, irum, kor, eng, math, total, avg, grade) VALUES (?,?,?,?,?,?,?,?)";
		// String sql = "insert into sungjuk(hakbun, irum, kor, eng, math, tot, avg,
		// grade)" + " values (?,?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.hakbun);
			pstmt.setString(2, obj.irum);
			pstmt.setInt(3, obj.kor);
			pstmt.setInt(4, obj.eng);
			pstmt.setInt(5, obj.math);
			pstmt.setInt(6, obj.total);
			pstmt.setDouble(7, obj.avg);
			pstmt.setString(8, obj.grade);

			int res = pstmt.executeUpdate();
			if (res == 1)
				System.out.println("\n 성적 입력 성공!");

		} catch (Exception e) {
			System.out.println("데이터베이스 연결 실패! = " + e.getMessage());

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}//finally
	}//input
	
	static void output_sungjuk() {
		Connection con = null;
	//하나는 개수 찾기 하나는 일반 출력	
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
	//성적 테이블 데이터 갯수 찾기..없으면 0
		String sql1 = "select count(*) from sungjuk";
		String sql2 = "select * from sungjuk order by hakbun";
		
		try {
			Sungjuk obj = new Sungjuk();
			con = getconnectDB();
			
			pstmt1 = con.prepareStatement(sql1);
			rs1 = pstmt1.executeQuery();
			rs1.next();
		//필드의 위치로 해당 데이터 읽어서 값이 0(추가데이터 없음)이면 출력안함
			if (rs1.getInt(1) == 0) {
				System.out.println("\n출력할 데이터가 없다\n");
			} else {
				pstmt2 = con.prepareStatement(sql2);
				rs2 = pstmt2.executeQuery();
				
				System.out.println();
				System.out.println("\n                       *** 성적표 ***");
				System.out.println("============================================================");
				System.out.println("학번    이름     국어    영어    수학    총점    평균    등급");
				System.out.println("============================================================");
		//printf로 해도 상관은 없음		
				while(rs2.next()) {
					obj.hakbun = rs2.getString("hakbun");
					obj.irum = rs2.getString("irum");
					obj.kor = rs2.getInt("kor");
					obj.eng = rs2.getInt("eng");
					obj.math = rs2.getInt("math");
					obj.total = rs2.getInt("total");
					obj.avg = rs2.getInt("avg");
					obj.grade = rs2.getString("grade");
					obj.output();
					}//while
				System.out.println("============================================================");
				}//else
		} catch (Exception e) {
			System.out.println("성적 출력 실패 = " + e.getMessage());
		} finally {
			try {
				if(rs1 != null) rs1.close();
				if(rs2 != null) rs2.close();
				if(pstmt1 != null) pstmt1.close();
				if(pstmt2 != null) pstmt2.close();
				if(con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage( ));
			} 
		}//finally
	}//output
	
	static void search_sungjuk() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sungjuk where hakbun = ?";
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("\n조회할 학번 입력 => ");
			String hakbun = in.readLine();
			
			con = getconnectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hakbun);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println();
				System.out.println("학번 : " + rs.getString("hakbun"));
				System.out.println("이름 : " + rs.getString("irum"));
				System.out.println("국어 : " + rs.getInt("kor"));
				System.out.println("영어 : " + rs.getInt("eng"));
				System.out.println("수학 : " + rs.getInt("math"));
				System.out.println("총점 : " + rs.getInt("total"));
				System.out.println("평균 : " + rs.getDouble("avg"));
				System.out.println("등급 : " + rs.getString("grade"));
			} else {
				System.out.printf("\n%s는 존재하지 않는 학번\n", hakbun);
			}
		} catch (Exception e) {
			System.out.println("성적 조회 실패 = " + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}//finally		
	}//search
	
	static void update_sungjuk() {
		
		Sungjuk obj = new Sungjuk();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update sungjuk set kor = ?, eng = ?, math = ?, total = ?,"
				+ " avg = ?, grade = ? where hakbun = ?";
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("\n수정할 학번 입력 => ");
			obj.hakbun = in.readLine();
			System.out.println("국어 입력 => ");
			obj.kor = Integer.parseInt(in.readLine());
			System.out.println("영어 입력 => ");
			obj.eng = Integer.parseInt(in.readLine());
			System.out.println("수학 입력 => ");
			obj.math = Integer.parseInt(in.readLine());
			
			obj.process();
			
			con = getconnectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, obj.kor);
			pstmt.setInt(2, obj.eng);
			pstmt.setInt(3, obj.math);
			pstmt.setInt(4, obj.total);
			pstmt.setDouble(5, obj.avg);
			pstmt.setString(6, obj.grade);
			pstmt.setString(7, obj.hakbun);
			int res = pstmt.executeUpdate();
			if (res == 1)
				System.out.println("\n" + obj.hakbun + " 학번 수정 완료");
			else
				System.out.printf("\n%s는 존재하지 않는 학번\n", obj.hakbun);
		} catch(Exception e) {
			System.out.println("성적 수정 실패 = " + e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}//finally
	}//update
	
	static void delete_sungjuk() {
			
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete from sungjuk where hakbun = ?";
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("\n삭제할 학번 입력 => ");
			String hakbun = in.readLine();
			
			con = getconnectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hakbun);
			int res = pstmt.executeUpdate();
			if (res == 1)
				System.out.println("\n" + hakbun + " 학번 삭제 완료");
			else
				System.out.printf("\n%s는 존재하지 않는 학번\n", hakbun);
		} catch (Exception e) {
			System.out.println("성적 삭제 실패 = " + e.getMessage());			
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage( ));
			}
		}//finally
	}//delete
}
