package com.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberMapper {
	ArrayList<MemberVO> getMembers();
	//ArrayList<Member> getMembers(String t);
	MemberVO getMember(String id);
	void insertMember(MemberVO member);
	void insertMember2(HashMap<String, String> map);
	void updateMember(MemberVO member);
	void deleteMember(String id);
	int getCount();
}
