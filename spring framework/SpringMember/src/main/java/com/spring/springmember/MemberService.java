package com.spring.springmember;

import java.util.ArrayList;

public interface MemberService {
	public int insertMember(MemberVO memberVO) throws Exception;
	public int userCheck(MemberVO memberVO) throws Exception;
	public ArrayList<MemberVO> getMemberlist() throws Exception;
	public MemberVO selectMember(MemberVO memberVO) throws Exception;
	public int deleteMember(MemberVO memberVO) throws Exception;
}

//역할: 파라미터는 MemberVO(통일성 주기 위해서)..이걸 구현한 것이 MemberServiceImpl.java