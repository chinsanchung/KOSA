<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="color.jsp"%>   
<%
	int num= Integer.parseInt(request.getParameter("num"));
	String pageNum= request.getParameter("pageNum");
%>
<html>
<head>
<title> 게시판 </title>
<script language="JavaScript">
<!--
	function deleteSave() {
		if(document.delForm.passwd.value == '') {
			alert("비밀번호를 입력해라");
			document.delForm.passwd.focus();
			return false;
		}
	}
-->
</script>
</head>
<body bgcolor="<%=bodyback_c%>">
	<center>
		<b> 글 삭제 </b> <br>
		<form method="post" name="delForm" action="deletePro.jsp?pageNum=<%=pageNum%>"
			onsubmit="return deleteSurvey()">
		<table border="1" align="center" cellspacing="0" cellpadding="0" width="360">
			<tr height="30">
				<td align="center" bgcolor="<%=value_c%>"><b> 비밀번호 입력해야</b></td>
			</tr>
			<tr height="30">
				<td align="center">
				비밀번호 :
				<input type="password" name="passwd" size="8" maxlength="12">
				<input type="hidden" name="num" value="<%=num%>">
				</td>
			</tr>
			<tr height="30">
				<td align="center" bgcolor="<%=value_c%>">
					<input type="submit" value="글삭제">
					<input type="button" value="글목록"
					onlclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
		</table>
	</center>
</body>
</html>