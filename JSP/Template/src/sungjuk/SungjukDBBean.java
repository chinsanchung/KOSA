package sungjuk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SungjukDBBean {
	private static SungjukDBBean instance= new SungjukDBBean();//객체 생성..static이라 객체는 하나
	
	public static SungjukDBBean getInstance() { //static으로 정의하면 static 필드만 사용가능(객체를 안만들어도 사용가능)
		return instance;
	}
	
	private SungjukDBBean() {
		
	}
	
	private Connection getConnection() throws Exception {
		Context initCtx= new InitialContext();
		Context envCtx= (Context) initCtx.lookup("java:comp/env");
		DataSource ds= (DataSource) envCtx.lookup("jdbc/OracleDB");//연결객체 할당받음
		return ds.getConnection();
	}
	
	public int memberCheck(SungjukDataBean sungjukBean) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int res=0;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select count(*) from member where hakbun=? and irum=?");
			pstmt.setString(1, sungjukBean.getHakbun());
			pstmt.setString(2, sungjukBean.getIrum());
			rs=pstmt.executeQuery();
			rs.next();
			res=rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();}catch (SQLException ex) {}
			if(conn != null) try {conn.close();} catch (SQLException ex) {}			
		}
		return res;
		
	}
	
	public int insertSungjuk(SungjukDataBean sungjukBean) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int res=0;
		
		try {
			conn=getConnection();
			
			pstmt= conn.prepareStatement("insert into sungjuk values (?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, sungjukBean.getHakbun());
			pstmt.setString(2, sungjukBean.getIrum());
			pstmt.setInt(3, sungjukBean.getKor());
			pstmt.setInt(4, sungjukBean.getEng());
			pstmt.setInt(5, sungjukBean.getMath());
			pstmt.setInt(6, sungjukBean.getTot());
			pstmt.setDouble(7, sungjukBean.getAvg());
			pstmt.setString(8, sungjukBean.getGrade());
			res= pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
			if(conn != null) try {conn.close();} catch (SQLException ex) {}
		}
		return res;
	}
	
	public ArrayList<SungjukDataBean> getSungjukList() throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<SungjukDataBean> sungjukList=null;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select * from sungjuk order by hakbun");
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				sungjukList= new ArrayList<SungjukDataBean>();
				do {
		//밑의 set~으로 databean에다 데이터를 채워넣음	
					SungjukDataBean sungjukBean= new SungjukDataBean();
					sungjukBean.setHakbun(rs.getString("hakbun"));
					sungjukBean.setIrum(rs.getString("irum"));
					sungjukBean.setKor(rs.getInt("kor"));
					sungjukBean.setEng(rs.getInt("eng"));
					sungjukBean.setMath(rs.getInt("math"));
					sungjukBean.setTot(rs.getInt("tot"));
					sungjukBean.setAvg(rs.getInt("avg"));
					sungjukBean.setGrade(rs.getString("grade"));
		//member데이터를 하나하나 모아서 MemberDataBean객체 생성, 그것을 arraylist에 넣음		
					sungjukList.add(sungjukBean);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch (SQLException ex) {}
			if(pstmt != null) try {pstmt.close();}catch (SQLException ex) {}
			if(conn != null) try {conn.close();} catch (SQLException ex) {}
		}
		return sungjukList;// arraylist 결과 반환
	}//ArrayList
	
	public SungjukDataBean getSungjuk(String hakbun) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SungjukDataBean sungjukBean=null;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select * from sungjuk where hakbun=?");
			pstmt.setString(1, hakbun);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				sungjukBean= new SungjukDataBean();
				sungjukBean.setHakbun(rs.getString("hakbun"));
				sungjukBean.setIrum(rs.getString("irum"));
				sungjukBean.setKor(rs.getInt("kor"));
				sungjukBean.setEng(rs.getInt("eng"));
				sungjukBean.setMath(rs.getInt("math"));
				sungjukBean.setTot(rs.getInt("tot"));
				sungjukBean.setAvg(rs.getInt("avg"));
				sungjukBean.setGrade(rs.getString("grade"));
			} 
			}catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if(rs != null) try {rs.close();} catch (SQLException ex) {}
				if(pstmt != null) try {pstmt.close();}catch (SQLException ex) {}
				if(conn != null) try {conn.close();} catch (SQLException ex) {}
			}
			return sungjukBean;
		}
	
	public int updateSungjuk(SungjukDataBean sungjukBean) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int res=0;
		String sql= "update sungjuk set kor=?, eng=?, math=?, tot=?, avg=?, grade=? "
				+ "where hakbun=? and irum=?";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sungjukBean.getKor());
			pstmt.setInt(2, sungjukBean.getEng());
			pstmt.setInt(3, sungjukBean.getMath());
			pstmt.setInt(4, sungjukBean.getTot());
			pstmt.setDouble(5, sungjukBean.getAvg());
			pstmt.setString(6, sungjukBean.getGrade());
			pstmt.setString(7, sungjukBean.getHakbun());
			pstmt.setString(8, sungjukBean.getIrum());
			
			res= pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();}catch (SQLException ex) {}
			if(conn != null) try {conn.close();} catch (SQLException ex) {}
		}
		return res;
	}
	
	public int deleteSungjuk(String hakbun) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int res=0;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("delete from sungjuk where hakbun = ?");
			pstmt.setString(1, hakbun);
			res=pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();}catch (SQLException ex) {}
			if(conn != null) try {conn.close();} catch (SQLException ex) {}
		}
		return res;
	}
}