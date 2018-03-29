<%@ page import= "java.sql.*"%>
<%@ page import= "javax.sql.*" %>
<%@ page import= "javax.naming.*" %>
<%@ page import= "survey.SurveyDBBean" %>
<% request.setCharacterEncoding ("utf-8"); %>
<jsp:useBean id="surveydata" class="survey.SurveyDataBean" >
	<jsp:setProperty name="surveydata" property="*" />
</jsp:useBean>
<%
SurveyDBBean manager= SurveyDBBean.getInstance();
String code= request.getParameter("code");
String columnname= request.getParameter("column");

int result= manager.addColumn(code, column);

if(result != 0) {
	out.println("<script>");
	out.println("<alert('항목 입력 성공');>");
	out.println("</script>");
}

%>