<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="member.MemberDataBean"%>
<%@ page import="member.MemberDBBean"%>


<%
	if ((session.getAttribute("hakbun") == null)
			|| (!((String) session.getAttribute("hakbun")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href= './template.jsp?page=loginForm'");//admin이 아니라서 다시 로그인폼으로 돌아감
		out.println("</script>");
	}
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="memberBean" class="member.MemberDataBean" scope="page">
	<jsp:setProperty name="memberBean" property="*" />
</jsp:useBean>
<%
	MemberDBBean manager = MemberDBBean.getInstance();
	int res = manager.updateMember(memberBean);

	if (res == 0) {
		out.println("<script>");
		out.println("alert('수정 실패')");
		out.println("location.href= './template.jsp?page=member_list'");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('수정 완료')");
		out.println("location.href= './template.jsp?page=member_list'");
		out.println("</script>");
	}
%>