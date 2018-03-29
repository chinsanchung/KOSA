package com.spring.springboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {
	//JDBC 관련 변수
	private Connection conn= null;
	private PreparedStatement stmt= null;
	private ResultSet rs= null;
	
	//SQL 명령어
	private final String USER_SEARCH= "select * from users where id= ? and password= ?";
	//로그인 인증
	public UserVO login(UserVO userVO) {
		UserVO vo= null;   //아이디, 비번이 안맞으면 null 리턴
		try {
			conn= JDBCUtil.getConnection();
			stmt= conn.prepareStatement(USER_SEARCH);
			stmt.setString(1, userVO.getId());
			stmt.setString(2, userVO.getPassword());
			rs= stmt.executeQuery();
			
			if(rs.next()) {
				vo= new UserVO();  //객체 생성
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(rs, stmt, conn);
		}
		return vo;
	}
}
