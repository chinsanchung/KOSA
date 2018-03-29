package SangpumOracle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SangpumJDBC {

	public static void main(String[] args) {
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		
			int menu;
			
			System.out.println("\n*** 메뉴 ***");
			System.out.println("1. 상품 입력");
			System.out.println("2. 상품 출력");
			System.out.println("3. 상품 조회");
			System.out.println("4. 상품 수정");
			System.out.println("5. 상품 삭제");
			System.out.println("6. 종     료\n");
			
			System.out.print("메뉴 선택(1~6) => ");
			menu = Integer.parseInt(in.readLine());
					
			switch (menu)
			{
				case 1:
					input_sangpum();
					break;
				case 2:
					output_sangpum();
					break;
				case 3:
					search_sangpum();
					break;
				case 4:
					update_sangpum();
					break;
				case 5:
					delete_sangpum();
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

	static void input_sangpum() {
		Sangpum obj = new Sangpum();
		
		System.out.println();
		
		if (obj.input()) {
			return;
		}
		
		obj.process();
		
		Connection con = getconnectDB();
		PreparedStatement pstmt = null;
		String sql = "insert into sangpum values (?, ?, ?, ?, ?)";
		
		try {		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.code);
			pstmt.setString(2, obj.irum);
			pstmt.setInt(3, obj.su);
			pstmt.setInt(4, obj.dan);
			pstmt.setInt(5, obj.price);
			
			int res = pstmt.executeUpdate();
			if (res == 1)
				System.out.println("\n 상품 입력 성공");

		} catch (Exception e) {
			System.out.println("상품 연결 실패 = " + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}//finally
	}//input
	
	static void output_sangpum() {
		Connection con = null;
		
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
	//상품 테이블 데이터 있는지 찾기..없으면 0
		String sql1 = "select count(*) from sangpum";
		String sql2 = "select * from sangpum order by code";
		
		try {
			Sangpum obj = new Sangpum();
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
				System.out.println("            *** 판매 현황 ***");
				System.out.println("===================================");
				System.out.println("상품코드    상품명     수량    단가      금액");
				System.out.println("===================================");
				while(rs2.next()) {
					obj.code = rs2.getString("code"); // = rs2.getString(1)
					obj.irum = rs2.getString("irum");
					obj.su = rs2.getInt("su");  // = rs2.getInt(3)
					obj.dan = rs2.getInt("dan");
					obj.price = rs2.getInt("price");
					
					obj.output();
					}//while
				System.out.println("===================================");
			}//else
		} catch (Exception e) {
			System.out.println("상품출력 실패 = " + e.getMessage());
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
	static void search_sangpum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sangpum where code = ?";
		BufferedReader in = null;
		
		try {
			Sangpum obj = new Sangpum();
			in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\n조회할 상품코드 입력 => ");
			String code = in.readLine();
			
			con = getconnectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("\n상품코드   상품명     수량           단가           금액");
				System.out.println("==============================================");
				
				obj.code = rs.getString("code");
				obj.irum = rs.getString("irum");
				obj.su = rs.getInt("su");
				obj.dan = rs.getInt("dan");
				obj.price = rs.getInt("price");
				obj.output();
				
				System.out.println("==============================================");
			} else {
				System.out.printf("\n%s는 존재하지 않는 상품", code);
			}
		} catch (Exception e) {
			System.out.println("search_sangpum : 입력 오류");
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}//finally
	}//search
	
	static void update_sangpum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update sangpum set su = ?, dan = ?, price = ? where code = ?";
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			Sangpum obj = new Sangpum();
			
			System.out.println("\n수정할 상품코드 입력 => ");
			obj.code = in.readLine();
			System.out.println("수량 입력 => ");
			obj.su = Integer.parseInt(in.readLine());
			System.out.println("단가 입력 => ");
			obj.dan = Integer.parseInt(in.readLine());
			
			obj.process();
			
			con = getconnectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, obj.su);
			pstmt.setInt(2, obj.dan);
			pstmt.setInt(3, obj.price);
			pstmt.setString(4, obj.code);
			int res = pstmt.executeUpdate();
			if (res == 1)
				System.out.println("\n상품코드" + obj.code + " 상품 수정 완료");
			else
				System.out.printf("\n%s는 존재하지 않는 상품\n", obj.code);
		} catch (Exception e) {
			System.out.println("update_sangpum : 입력 오류");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}//finally
	}//update
	
	static void delete_sangpum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete from sangpum where code = ?";
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\n수정할 상품코드 입력 => ");
			String code = in.readLine();
			
			con = getconnectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			int res = pstmt.executeUpdate();
			if (res == 1)
				System.out.println("\n상품코드" + code + " 상품 수정 완료");
			else
				System.out.printf("\n%s는 존재하지 않는 상품\n", code);
		} catch (Exception e) {
			System.out.println("delete_sangpum : 입력 오류");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}//finally
	}//delete
}
