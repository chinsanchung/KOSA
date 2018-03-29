package com.spring.springboard;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //controller의 그룹핑 객체 생성
@RequestMapping("/user.do")  //파라미터로 지정함
public class UserController {
	
	@Autowired
	private UserService userService= null;  //이름은 Service("userService")에서 사용한 이름으로만 가능
	
	@RequestMapping(params="method=login")// 파라미터 확인. 
	//userVo에는 로그인에 사용한 id, password가 저장
	public String login(UserVO userVO, HttpSession session) throws Exception {
		UserVO vo = userService.login(userVO);
		if (vo != null) {
			session.setAttribute("loginID", vo.getId());
			session.setAttribute("userName", vo.getName());
			session.setAttribute("userRole", vo.getRole());
			return "redirect:/board.do?method=getBoardList";
		} else {
			return "loginForm";
		}
	}
	
	@RequestMapping(params="method=logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();  //세션 객체 지움
		return "loginForm";
	}

}
