package com.spring.springmember;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//"memberService"라는 문자열에 해당하는 객체를 만들어준다..만약 괄호 안이 없다면 이름이 memberServiceImpl인 객체가 만들어짐
@Service("memberService")
public class MemberServiceImpl implements MemberService {
//@Autowired는 기본값이 true. 해당 클래스로 객체 생성이 실패하면 memberDAO가 null..오류 생성해 그걸 막기 위해 required= false
//의존성주입(Dependency Injection)스프링에서 만들어서 대입..
	@Autowired(required= false) 
	private MemberDAO memberDAO= null;
//호출할 때 직접 파라미터 받아서 처리	
	@Override
	public int insertMember(MemberVO memberVO) throws Exception {
		try {
			int res= memberDAO.insertMember(memberVO);
			return res;
		} catch (Exception e) {
			throw new Exception("회원 확인 실패", e);
		}
	}

	@Override
	public int userCheck(MemberVO memberVO) throws Exception {
		try {
		//MemberDAO의 userCheck사용
			int res= memberDAO.userCheck(memberVO);
			return res;
		} catch (Exception e) {
			throw new Exception("회원 확인 실패", e);
		}
	}
	
	@Override
	public ArrayList<MemberVO> getMemberlist() throws Exception {
		try {
			ArrayList<MemberVO> member_list= new ArrayList<MemberVO>();
			member_list= memberDAO.getMemberlist();
			return member_list;
		} catch (Exception e) {
			throw new Exception("회원 리스트 검색 실패", e);
		}
	}
	
	@Override
	public MemberVO selectMember(MemberVO memberVO) throws Exception {
		try {
			MemberVO vo= memberDAO.selectMember(memberVO);
			return vo;
		} catch (Exception e) {
			throw new Exception("회원 검색 실패", e);
		}
	}
	
	@Override
	public int deleteMember(MemberVO memberVO) throws Exception {
		try {
			int res= memberDAO.deleteMember(memberVO);
			return res;
		} catch (Exception e) {
			throw new Exception("회원 삭제 실패", e);
		}
	}
}