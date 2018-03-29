package com.spring.springmember;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//스프링이 memberController객체 자동생성..컨트롤러 역할하는 객체. 
@Controller
public class MemberController {
//Autowired는 연결해주는 역할 memberService 이 부분 이름을 막 쓰면 안된다. 
//memberService 자리엔 Impl에서의 @Service("memberService")의 멤버서비스를 써야함
//memberService객체가 20번줄의 memberService에 대입된다(의존성주입) 
	@Autowired
	private MemberService memberService;
//web.xml에서 login.me인 걸 찾아(userCheck) 밑에 표시
	
//스프링에서 생성한 객체가 userCheck () 괄호 안에 대입..입력파라미터로 아이디와 비번 입력한걸 memberVO에 전달
//DispatcherServlet에서 찾고 클래스 타입의 객체 이용해서 userCheck호출
	@RequestMapping("/login.me")
	public String userCheck(MemberVO memberVO, HttpSession session, 
			HttpServletResponse response) throws Exception {
//24줄에서의 memberVO로 MemberServiceImpl에서의 userCheck 실행
		
		int res= memberService.userCheck(memberVO);
		
//한글 안깨지게함
		PrintWriter writer= response.getWriter();
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset='UTF-8'");
	
		if (res == 1) {
			
			session.setAttribute("id", memberVO.getId());
			writer.write("<script>alert('로그인 성공');location.href='./main.me';</script>");
			//return "redirect:/main.me";
		} else {
			writer.write("<script>alert('로그인 실패');location.href='./loginform.me';</script>");
			//return "redirect:/loginform.me";
		}
		return null;
	}
	
	@RequestMapping("/main.me")
	public String mainPage() throws Exception {
		return "main";
	}
	
	@RequestMapping("/loginform.me")
	public String loginForm() throws Exception {
		return "loginForm";
	}
	
	@RequestMapping("/joinform.me")
	public String joinForm() throws Exception {
		return "joinForm";
	}
//회원가입 누른 후 서브정보들을 저장하는 역할..
/* insertMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
 * 	MemberVO memberVO = new MemberVO();
 * 	memberVO.setId(request.getParameter("id")); 로도 실행가능하긴 한데 의존성주입으로 하면 아래 두줄이 필요없음..
 * 객체 자동생성이라 int res= memberService.insertMember(memberVO);를 바로 실행가능
 */
	@RequestMapping("/joinprocess.me")
	public String insertMember(MemberVO memberVO, HttpServletResponse response) throws Exception {
//memberVO에는 파라미터로 전달받은 데이터가 들어있음
		int res= memberService.insertMember(memberVO);
		response.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset='UTF-8'");
//writer객체 생성		
		PrintWriter writer= response.getWriter();
		if (res != 0) {
			writer.write("<script>alert('회원가입 성공');location.href='./loginform.me';</script>");
		} else {
			writer.write("<script>alert('회원가입 실패');location.href='./joinform.me';</script>");
		}
		return null;
	}
//스프링에서 model타입의 객체 생성. getMemberlist호출.	
	@RequestMapping("/memberlist.me")
	public String getMemberlist(Model model) throws Exception {
		ArrayList<MemberVO> member_list= memberService.getMemberlist();
//구한 값을 model객체에 저장 ("~"속성 이름으로 member_list 읽어옴)
		model.addAttribute("member_list", member_list);
		
		return "member_list";
	}
//vo 객체에 전달, model에 저장. 
	@RequestMapping("/memberinfo.me")
	public String selectMember(MemberVO memberVO, Model model) throws Exception {
		MemberVO vo= memberService.selectMember(memberVO);
		model.addAttribute("memberVO", vo);
		
		return "member_info";
	}
//파라미터로 id 전달인데 memberVO에 대입..	
	@RequestMapping("/memberdelete.me")
	public String deleteMember(MemberVO memberVO, Model model) throws Exception {
		memberService.deleteMember(memberVO);
//redirect하면 memberlist.me로 다시 이동		
		return "redirect:/memberlist.me";
	}
}
