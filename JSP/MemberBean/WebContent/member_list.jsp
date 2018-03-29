<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*" %>
<%@page import="javax.sql.*" %>
<%@page import="javax.naming.*" %>
<%@page import="java.util.*" %>
<%@page import="member.MemberDBBean" %>
<%@page import="member.MemberDataBean" %>

<%

String id = null ;
ArrayList<MemberDataBean> member_list = null ;

if(( session.getAttribute( "id" ) == null ) || 
		!( ( (String)session.getAttribute( "id" ) ).equals( "admin" ) ) )	{
	out.println( "<script>" ) ;
	out.println( "alert( '관리자 페이지' ) ; " ) ;
	out.println( "location.href='loginForm.jsp' " ) ;
	out.println( "</script>" ) ;
}

MemberDBBean manager= MemberDBBean.getInstance();
member_list= (ArrayList<MemberDataBean>) manager.getMemberlist();


%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리 시스템 관리자모드(회원 목록 보기)</title>
</head>
<body>
<center>
<table border=1 width=300>
	<tr align=center>
		<td colspan="2">회원 목록</td>
	</tr>
	<%
	for( int i = 0 ; i < member_list.size() ; i++ ){
		MemberDataBean memberdata = (MemberDataBean) member_list.get( i ) ;
		
		%>
		<tr align=center>
		<td>
			<a href="member_info.jsp?id=<%=memberdata.getId()%>">
				<%=memberdata.getId()%>
			</a>
		</td>
		<td>
			<a href="member_delete.jsp?id=<%=memberdata.getId()%>">삭제</a>
		</td>
		</tr>
		
		<%
	}
	%>

</table>
</center>
</body>
</html>