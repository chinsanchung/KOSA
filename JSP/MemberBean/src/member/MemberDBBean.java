package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDBBean {
	private static MemberDBBean instance= new MemberDBBean();//객체 생성..static이라 객체는 하나
	
	public static MemberDBBean getInstance() { //static으로 정의하면 static 필드만 사용가능(객체를 안만들어도 사용가능)
		return instance;
	}
	
	private MemberDBBean() {
		
	}
	
	private Connection getConnection() throws Exception {
		Context initCtx= new InitialContext();
		Context envCtx= (Context) initCtx.lookup("java:comp/env");
		DataSource ds= (DataSource) envCtx.lookup("jdbc/OracleDB");//연결객체 할당받음
		return ds.getConnection();
	}
	
	public int insertMember(MemberDataBean memberdata) throws Exception {
		Connection conn= null;
		PreparedStatement pstmt= null;
		int result= 0;

		try {
			conn= getConnection();
			
			pstmt= conn.prepareStatement("insert into member values (?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, memberdata.getId());
			pstmt.setString(2, memberdata.getPassword());
			pstmt.setString(3, memberdata.getName());
			pstmt.setInt(4, memberdata.getAge());
			pstmt.setString(5, memberdata.getGender());
			pstmt.setString(6, memberdata.getEmail());
			result= pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("가입오류" + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();}catch (SQLException ex) {}
			if(conn != null) try {conn.close();} catch (SQLException ex) {}
		}
		return result;
	}
	public int userCheck(String id, String password) throws Exception {
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		String dbpasswd= "";
		
		int x= 1;
		
		try {
			conn= getConnection();
			pstmt= conn.prepareStatement("select * from member where id= ?");
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			
			if (rs.next()) {
				dbpasswd= rs.getString("password");
				if(dbpasswd.equals(password))
					x= 1;
				else
					x= 0;	
			} else
				x= -1;  //로그인시 x= 1 인데 실패시 마이너스
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (SQLException ex) {}
			if(pstmt != null) try {pstmt.close();}catch (SQLException ex) {}
			if(conn != null) try {conn.close();} catch (SQLException ex) {}
		}
		
		return x;
	}//usercheck
//DB관리하는 메소드. 멤버리스트를 DB에서 가져온다는 뜻	
	public ArrayList<MemberDataBean> getMemberlist() throws Exception {
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		MemberDataBean memberdata= null;
		//member데이터를 저장하는 배열 
		ArrayList<MemberDataBean> member_list= null;
		
		try {
			conn= getConnection();
			
			pstmt= conn.prepareStatement("select * from member");
			rs= pstmt.executeQuery();
			
			if (rs.next()) {
				member_list= new ArrayList<MemberDataBean>();
				do {
		//밑의 set~으로 databean에다 데이터를 채워넣음	
					memberdata= new MemberDataBean();
					memberdata.setId(rs.getString("id"));
					memberdata.setPassword(rs.getString("password"));
					memberdata.setName(rs.getString("name"));
					memberdata.setAge(rs.getInt("age"));
					memberdata.setGender(rs.getString("gender"));
					memberdata.setEmail(rs.getString("email"));
		//member데이터를 하나하나 모아서 MemberDataBean객체 생성, 그것을 arraylist에 넣음		
					member_list.add(memberdata);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (SQLException ex) {}
			if(pstmt != null) try {pstmt.close();}catch (SQLException ex) {}
			if(conn != null) try {conn.close();} catch (SQLException ex) {}
		}
		return member_list;// arraylist 결과 반환
	}//ArrayList
	
	public MemberDataBean selectMember(String id) throws Exception {
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		MemberDataBean memberdata= null;
		
		try {
			conn= getConnection();
			
			pstmt= conn.prepareStatement("select * from member where id= ?");
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();
			rs.next();
			
			memberdata= new MemberDataBean();
			memberdata.setId(rs.getString("id"));
			memberdata.setPassword(rs.getString("password"));
			memberdata.setName(rs.getString("name"));
			memberdata.setAge(rs.getInt("age"));
			memberdata.setGender(rs.getString("gender"));
			memberdata.setEmail(rs.getString("email"));
		} catch (Exception ex) { 
			ex.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (SQLException ex) {}
			if(pstmt != null) try {pstmt.close();}catch (SQLException ex) {}
			if(conn != null) try {conn.close();} catch (SQLException ex) {}
		}
		return memberdata;
	}//selectMember
	public int deleteMember (String id) throws Exception {
		Connection conn= null;
		PreparedStatement pstmt= null;
		int result= 0;
		
		try {
			conn= getConnection();
			
			pstmt= conn.prepareStatement("delete from member where id= ?");
			pstmt.setString(1, id);
			result= pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();}catch (SQLException ex) {}
			if(conn != null) try {conn.close();} catch (SQLException ex) {}
		}
		return result;
	}//deletemember
}
