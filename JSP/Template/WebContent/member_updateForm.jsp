<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%@ page import= "member.MemberDBBean" %>
<%@ page import= "member.MemberDataBean" %>
<% request.setCharacterEncoding ("utf-8"); %>
<%

	if ((session.getAttribute("hakbun") == null) || (!((String) session.getAttribute("hakbun")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href= './template.jsp?page=loginForm'");//admin이 아니라서 다시 로그인폼으로 돌아감
		out.println("</script>");
	}
	String hakbun=request.getParameter("hakbun");
	
	MemberDBBean manager= MemberDBBean.getInstance();
	MemberDataBean memberBean= manager.selectMember(hakbun);
	
	if (memberBean==null) {
		out.println("<script>");
		out.println("location.href= './template.jsp?page=member_list'");
		out.println("</script>");
	} else {
%>
	<form name="member_updateform"
	action="./template.jsp?page=member_updateProcess&hakbun=<%=memberBean.getHakbun() %>" method="post">
	<table border=1>
	<tr>
		<td colspan="2" align=center>
			<b><font size=5>회원수정페이지</font></b>
		</td>
	<tr><td>HAKBUN: </td><td><%=memberBean.getHakbun() %></td></tr>
	<tr><td>PASSWORD: </td><td><input type="password" name= "password" value="<%=memberBean.getPassword() %>"></td></tr>
	<tr><td>IRUM: </td><td><input type="text" name="irum" value="<%=memberBean.getIrum() %>"></td></tr>
	<tr><td>AGE: </td><td><input type="text" name="age" maxlength=2 size=5
	value="<%=memberBean.getAge() %>"></td></tr>
	<tr><td>GENDER: </td><td>

<%	if (memberBean.getGender().equals("m")) { %>
		<input type="radio" name="gender" value="남" checked>남자
		<input type="radio" name="gender" value="여">여자
	<%} else { %>
		<input type="radio" name="gender" value="남" >남자
		<input type="radio" name="gender" value="여" checked>여자
	<%} %>
		</td>
	</tr>	
	<tr><td>EMAIL: </td><td><input type="text" name="email" size=30
	value="<%=memberBean.getEmail() %>"></td></tr>
	<tr><td colspan="2" align=center>
	<a href="javascript:member_updateform.submit()">회원정보수정</a>
	<a href="javascript:member_updateform.reset()">다시작성</a></td></tr>
	</table>
	</form>
<%} %>
	