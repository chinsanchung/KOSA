package com.spring.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService") //반드시 이 이름을 써야 의존성주입가능
public class UserServiceImpl implements UserService{
	@Autowired(required= false)  //@Autowired는 필드, 생성자, 메소드에 사용가능..
	private UserDAO userDAO= null;  //new UserDAO()객체가 자동으로 생성되어 대입된다
	//파라미터는 userVO
	public UserVO login(UserVO userVO) throws Exception {
		try {
			UserVO vo= userDAO.login(userVO);
			return vo;
		} catch (Exception e) {
			throw new Exception(userVO.getId() + "인 회원의 로그인 실패" , e);
		}
	}
}
