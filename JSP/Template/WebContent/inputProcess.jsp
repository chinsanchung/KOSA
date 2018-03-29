<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%@ page import= "sungjuk.SungjukDBBean" %>
<%@ page import= "sungjuk.SungjukDataBean" %>

<%

if (session.getAttribute("hakbun") == null || 
	(!session.getAttribute("hakbun").equals("admin"))) {
	out.println("<script>");
	out.println("history.back();");
	out.println("</script>");
} else { %>
<jsp:useBean id="sungjukBean" class="sungjuk.SungjukDataBean" scope="page">
<jsp:setProperty name="sungjukBean" property="*" />
</jsp:useBean>
<% 
	SungjukDBBean manager = SungjukDBBean.getInstance();
	sungjukBean.process();
	int res= manager.memberCheck(sungjukBean);
	
	if (res == 0) {
		out.println("<script>");
		out.println("alert('성적 입력 실패')");
		out.println("history.back();");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('성적 입력 성공')");
		out.println("location.href='./template.jsp?page=output_sungjuk'");
		out.println("</script>");
	}
}
%>
