<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%@ page import= "member.MemberDBBean" %>
<% request.setCharacterEncoding ("utf-8"); %>
<jsp:useBean id="memberdata" class="member.MemberDataBean" >
	<jsp:setProperty name="memberdata" property="*" />
</jsp:useBean>
<%
	MemberDBBean manager= MemberDBBean.getInstance();
	int result=manager.insertMember(memberdata);
	
	if(result!=0) {
		out.println("<script>");
		out.println("alert('회원가입 성공')");
		out.println("location.href='loginForm.jsp'");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('회원가입 실패')");
		out.println("location.href='joinForm.jsp'");
		out.println("</script>");	
	}
%>

