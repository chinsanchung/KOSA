package com.spring.mybatis;

import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MybastisController {
	@Autowired
	//의존성주입
	private MemberDAOService memberDAOService;
	
	private static final Logger logger= LoggerFactory.getLogger(MybastisController.class);
	
	//시작 메인화면
	@RequestMapping("/list.do")
	public ModelAndView main(Locale locale, Model model) {
		logger.info("Welcome list", locale);

		//view 화면인 main.jsp에서 DB로부터 읽어온 데이터를 보여줌
		ModelAndView result= new ModelAndView();
		//addObject view에 넘어가는 데이터...메소드 호출->
		List<MemberVO> memberList= memberDAOService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		return result;
	}
	//insert버튼 클릭시 값을 가져와서 list.jsp로 화면전환함..여기 member에 4개 값 저장돼있다
	@RequestMapping("/insert.do")
	public ModelAndView insert(MemberVO member) {
		memberDAOService.insertMember(member);
		
/*		HashMap(String, String> map= new HashMap<String, String>();  //hashmap
 * 		map.put("id", member.getId());  //hashmap
 * 		map.put("name", member.getName());
 * 		map.put("email", member.getEmail());
 * 		map.put("phone", member.getPhone());
 * 		memberDAOService.insertMember2(map);
 */
//result는 list로 이동한다		
		ModelAndView result= new ModelAndView();
		List<MemberVO> memberList= memberDAOService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		return result;
	}
	
	@RequestMapping("/updateForm.do")
	public ModelAndView updateForm(MemberVO member) {
		String id= member.getId();
		member= memberDAOService.getMember(id);
		System.out.println("update complete");
		
		ModelAndView result= new ModelAndView();
		result.addObject("member", member);
		result.setViewName("updateForm");
		return result;
	}
	
	@RequestMapping("/update.do")
	public ModelAndView update(MemberVO member) {
		memberDAOService.updateMember(member);
		System.out.println("update complete");
		
		ModelAndView result= new ModelAndView();
		List<MemberVO> memberList= memberDAOService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		return result;
	}
	
	@RequestMapping("/delete.do")
	public ModelAndView delete(MemberVO member) {
		String id= member.getId();
		memberDAOService.deleteMember(id);
		System.out.println("delete complete");
		
		ModelAndView result= new ModelAndView();
		List<MemberVO> memberList= memberDAOService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		return result;
	}
}
