<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import="member.MemberDataBean" %>
<%@ page import="member.MemberDBBean" %>
<%

if ((session.getAttribute("hakbun") == null) || (!((String) session.getAttribute("hakbun")).equals("admin"))) {
	out.println("<script>");
	out.println("location.href= './template.jsp?page=loginForm'");//admin이 아니라서 다시 로그인폼으로 돌아감
	out.println("</script>");
}
	

MemberDBBean manager= MemberDBBean.getInstance();
ArrayList<MemberDataBean> memberList= manager.getMemberlist();

%>
<center>
<% if (memberList==null) {%>
출력할 데이터 없다
<%} else {%>
<table border=1 width=300>
	<tr align=center><td colspan=2>회원 목록</td></tr>
<%
for (int i=0; i<memberList.size(); i++) {
	MemberDataBean memberBean=memberList.get(i);
%>
	<tr align=center>
	<td>
	<a href="./template.jsp?page=member_info&hakbun=<%=memberBean.getHakbun() %>">
	<%=memberBean.getHakbun() %></a>
	</td>
	<td><a href="./template.jsp?page=member_delete&hakbun=<%=memberBean.getHakbun() %>">삭제</a>
	<a href="./template.jsp?page=member_updateForm&hakbun=<%=memberBean.getHakbun() %>">수정</a>
	</td>
	</tr>
<%
	}
}
%>
</table>
</center>