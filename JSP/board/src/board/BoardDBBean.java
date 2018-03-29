package board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDBBean {
	private static BoardDBBean instance= new BoardDBBean();
	
	public static BoardDBBean getInstance() {
		return instance;
	}
	
	private BoardDBBean() {
		
	}
	
	private Connection getConnection() throws Exception {
		Context initCtx= new InitialContext();
		Context envCtx= (Context) initCtx.lookup("java:comp/env");
		DataSource ds= (DataSource) envCtx.lookup("jdbc/OracleDB");//연결객체 할당받음
		return ds.getConnection();
	}
	
	private void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(rs != null) try {rs.close();} catch (SQLException ex) {}
		if(pstmt != null) try {pstmt.close();} catch (SQLException ex) {}
		if(conn != null) try {conn.close();} catch (SQLException ex) {}	
	}
	
	public void insertArticle(BoardDataBean article) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		int num=article.getNum();
		int ref=article.getRef();
		int re_step=article.getRe_step();
		int re_level=article.getRe_level();
		int number=0;
		String sql="";
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select max(num) from board");
			rs=pstmt.executeQuery();
			
			if(rs.next())
				number=rs.getInt(1) + 1;
			else
				number=1;
	//num이 0이면 원글 , 1이면 답글..else면 원글일시 ref=num, ~~이러케
			if (num != 0) {
				sql="update board set re_step = re_step + 1 where " + 
						"ref = ? and re_step > ? ";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();
				re_step= re_step + 1;
				re_level= re_level + 1;
			} else {
				ref=number;
				re_step=0;
				re_level = 0;
			}
			sql= "insert into board(num, writer, passwd, subject, " +
					"email, content, reg_date, readcount, ";
		//시퀸스만든걸 대입
			sql += "ref, re_step, re_level) values" +
					"(board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getPasswd());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getEmail());
			pstmt.setString(5, article.getContent());
			pstmt.setTimestamp(6, article.getReg_date());
			pstmt.setInt(7, article.getReadcount());
			pstmt.setInt(8, ref);
			pstmt.setInt(9, re_step);
			pstmt.setInt(10, re_level);
			
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("글쓰기 오류 : " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
	}
//테이블 안에 존재하는 글의 개수 구함	
	public int getArticleCount() throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select count(*) from board");
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return count;
	}
	//최대 10개까지 저장. start와 end로 받음
	public List<BoardDataBean> getArticles(int start, int end) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BoardDataBean> articleList=null;
		String sql=null;
		
		try { 
			conn=getConnection();
	//서브쿼리 사용. 결과는 테이블로 나옴(가장 안쪽부터 수행됨)
	//글 그룹표시하는 ref, 글번호 num..asc로 오름차순 정리..
	//위의 select rownum~이 두번째 서브쿼리. 로우넘은 새로운 테이블 만들어질 때마다 바뀐다. 
	//마지막의 where rnum~~실행.
			sql="select * from " + 
					"(select rownum rnum, num, writer, passwd, " +
					"subject, email, content, reg_date, " +
					"readcount, ref, re_step, re_level from " +
					"(select * from board order by ref desc, re_step asc))" +
					"where rnum >= ? and rnum <= ?" ;
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery();
	//데이타 저장하는 객체 만들어 저장 후 arraylist에 추가		
			if (rs.next()) {
				articleList=new ArrayList<BoardDataBean>();
				do {
					BoardDataBean article = new BoardDataBean();
					article.setNum(rs.getInt("num"));
					article.setWriter(rs.getString("writer"));
					article.setPasswd(rs.getString("passwd"));
					article.setSubject(rs.getString("subject"));
					article.setEmail(rs.getString("email"));
					article.setContent(rs.getString("content"));
					article.setReg_date(rs.getTimestamp("reg_date"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setRe_step(rs.getInt("re_step"));
					article.setRe_level(rs.getInt("re_level"));
					
					articleList.add(article);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return articleList;
	}
	
	public BoardDataBean getArticle(int num) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardDataBean article=null;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select * from board where num = ?");
			pstmt.setInt(1, num);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				article=new BoardDataBean();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setPasswd(rs.getString("passwd"));
				article.setSubject(rs.getString("subject"));
				article.setEmail(rs.getString("email"));
				article.setContent(rs.getString("content"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				
				pstmt=conn.prepareStatement("update board set readcount=? where num=?");
				pstmt.setInt(1, rs.getInt("readcount") + 1);
				pstmt.setInt(2, num);
				
				pstmt.executeUpdate();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return article;
	}
	
	public BoardDataBean updateGetArticle(int num) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardDataBean article=null;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select * from board where num = ?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				article=new BoardDataBean();
				article.setNum(num);
				article.setWriter(rs.getString("writer"));
				article.setSubject(rs.getString("subject"));
				article.setEmail(rs.getString("email"));
				article.setContent(rs.getString("content"));
				article.setPasswd(rs.getString("passwd"));			
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return article;
	}
	
	public int updateArticle(BoardDataBean article) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String dbpasswd= "";
		String sql= "";
		int x= -1;
		
		try {
			conn= getConnection();
		//글쓰기때 입력한 비밀번호와 일치하는지 알기 위해 비밀번호 조회	
			pstmt=conn.prepareStatement("select passwd from board where num = ?");
			pstmt.setInt(1, article.getNum());
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				dbpasswd= rs.getString("passwd");
				if(dbpasswd.equals(article.getPasswd())) {
					sql="update board set writer = ?, passwd = ?, subject = ?, " +
							"email = ?, content = ? where num = ?";
					
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getPasswd());
					pstmt.setString(3, article.getSubject());
					pstmt.setString(4, article.getEmail());
					pstmt.setString(5, article.getContent());
					pstmt.setInt(6, article.getNum());
					pstmt.executeUpdate();
					x= 1;
				} else {
					x= 0;
				}
			} 
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return x;
	}
	
	public int deleteArticle(int num, String passwd) throws Exception {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String dbpasswd= "";
		int x= -1;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement("select passwd from board where num=?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dbpasswd=rs.getString("passwd");
				if(dbpasswd.equals(passwd)) {
					pstmt=conn.prepareStatement("delete from board where num=?");
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					
					x=1;
				} else
					x=0;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		return x;
	}
}