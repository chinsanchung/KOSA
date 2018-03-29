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
	private static MemberDBBean instance = new MemberDBBean(); // 객체 생성. singleton - 모든 사용자가 동일한 객체 사용

	public static MemberDBBean getInstance() {
		return instance;
	}

	private MemberDBBean() {
	}

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/OracleDB");
		return ds.getConnection();
	}

	public int insertMember(MemberDataBean memberdata) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into member values(?,?,?,?,?,?)");
			pstmt.setString(1, memberdata.getHakbun());
			pstmt.setString(2, memberdata.getPassword());
			pstmt.setString(3, memberdata.getIrum());
			pstmt.setInt(4, memberdata.getAge());
			pstmt.setString(5, memberdata.getGender());
			pstmt.setString(6, memberdata.getEmail());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("가입오류" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return result;
	}

	// 아이디, 비밀번호 체크
	public String userCheck(String hakbun, String password) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		String irum = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from member where hakbun = ?");
			pstmt.setString(1, hakbun);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpasswd = rs.getString("password");
				if (dbpasswd.equals(password)) {
					irum = rs.getString("irum");
				}
			}
		} catch (Exception e) {
			System.out.println("login오류");
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return irum;
	}

	public ArrayList<MemberDataBean> getMemberlist() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDataBean memberdata = null;
		ArrayList<MemberDataBean> member_list = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from member");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member_list = new ArrayList<MemberDataBean>();
				do {
					memberdata = new MemberDataBean();
					memberdata.setHakbun(rs.getString("hakbun"));
					memberdata.setPassword(rs.getString("password"));
					memberdata.setIrum(rs.getString("irum"));
					memberdata.setAge(rs.getInt("age"));
					memberdata.setGender(rs.getString("gender"));
					memberdata.setEmail(rs.getString("email"));
					member_list.add(memberdata);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return member_list;
	}

	public MemberDataBean selectMember(String hakbun) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDataBean memberdata = null;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from member where hakbun = ?");
			pstmt.setString(1, hakbun);
			rs = pstmt.executeQuery();
			rs.next();

			memberdata = new MemberDataBean();
			memberdata.setHakbun(rs.getString("hakbun"));
			memberdata.setPassword(rs.getString("password"));
			memberdata.setIrum(rs.getString("irum"));
			memberdata.setAge(rs.getInt("age"));
			memberdata.setGender(rs.getString("gender"));
			memberdata.setEmail(rs.getString("email"));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return memberdata;
	}

	public int deleteMember(String hakbun) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("delete from member where hakbun = ?");
			pstmt.setString(1, hakbun);
			result = pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}

		return result;
	}

	public int updateMember(MemberDataBean memberBean) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(
					"update s_member set pw = ?, irum = ?, " + "age = ?, gender = ?, email = ? where hakbun = ?");
			pstmt.setString(1, memberBean.getPassword());
			pstmt.setString(2, memberBean.getIrum());
			pstmt.setInt(3, memberBean.getAge());
			pstmt.setString(4, memberBean.getGender());
			pstmt.setString(5, memberBean.getEmail());
			pstmt.setString(6, memberBean.getHakbun());

			res = pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		return res;
	}
}