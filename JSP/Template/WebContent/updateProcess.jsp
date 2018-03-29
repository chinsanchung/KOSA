<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%@ page import= "sungjuk.SungjukDBBean" %>
<%@ page import= "sungjuk.SungjukDataBean" %>

<%
request.setCharacterEncoding("utf-8");
if (session.getAttribute("hakbun") == null || 
	(!((String)session.getAttribute("hakbun")).equals("admin"))) {
	out.println("<script>");
	out.println("history.back();");
	out.println("</script>");
} else { %>
<jsp:useBean id="sungjukBean" class="sungjuk.SungjukDataBean" scope="page">
	<jsp:setProperty name="sungjukBean" property="*" />
</jsp:useBean>
<%
	sungjukBean.process();
	SungjukDBBean manager=SungjukDBBean.getInstance();
	int res= manager.updateSungjuk(sungjukBean);
	
	if (res == 0) {
		out.println("<script>");
		out.println("alert('성적 수정 실패')");
		out.println("history.back();");
		out.println("</script>");
	} else {
			out.println("<script>");
		out.println("alert('성적 수정 성공')");
		out.println("location.href='./template.jsp?page=output_sungjuk'");
		out.println("</script>");
	}
}
%>