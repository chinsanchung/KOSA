package com.spring.springmember;

import org.springframework.stereotype.Component;

//@Component 쓰면 스프링 프레임워크가 해당 클래스의 객체 자동 생성(첫글자가 소문자)..VO는 DataBean과 같은 방식으로 사용
//객체 : memberVO
@Component
public class MemberVO {
	String id;
	String password;
	String name;
	int age;
	String gender;
	String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
