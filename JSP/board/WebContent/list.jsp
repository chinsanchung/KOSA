<%@page import="javafx.scene.layout.Border"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDBBean"%>
<%@ page import="board.BoardDataBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="color.jsp" %>

<%
	int pageSize= 10;  //한페이지 안에 들어갈 글의 개수
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-mm-d HH:mm");
	
	String pageNum = request.getParameter("pageNum");  
	
	if(pageNum == null)   //페이지에 아무 글도 없으면 기본값 1로 지정
		pageNum= "1";
		
	int currentPage=Integer.parseInt(pageNum);  //currentPage에 pagenum을 정수로 변환한것 저장
	int startRow=(currentPage - 1) * pageSize + 1;  //실제 테이블에 존재하는 글 추출(1p는 1~10, 2p는 11~20)
	int endRow= startRow + pageSize - 1;
	int count=0;  //테이블에 존재하는 총 글의 개수
	int number=0; // 출력시 일련번호
	
	List<BoardDataBean> articleList= null;  //리스트객체 만들기
	BoardDBBean dbPro = BoardDBBean.getInstance(); 
	count= dbPro.getArticleCount();  //실제 테이블 내에 존재하는 총 글의 개수가 count에 저장됨
	
	//맨 마지막 페이지의 마지막글을 삭제해서 마지막 페이지가 없어졌을 때 필요. 글 21개인데 1개 없애서 20이 되면 3페이지가 없어진다 
	if (count < startRow) {
		currentPage= currentPage - 1;
		startRow= (currentPage - 1) * pageSize + 1;
		endRow= startRow + pageSize - 1;
	}
	if (count > 0)
	//articleList에 추출한 페이지목록이 들어있다
		articleList= dbPro.getArticles(startRow, endRow); //board테이블에 가서 화면에 출력할 데이터만 불러옴
//count가 총 글의 수	
	number= count - (currentPage - 1) * pageSize;
%>

<html>
<head>
<title>게시판</title>
</head>
<body bgcolor="<%=bodyback_c %>">
	<center>
		<b>글목록</b>
		<table width="600">
			<tr>
				<td align="right" bgcolor="<%=value_c %>">
				<a href="writeForm.jsp"> 글쓰기 </a>
				</td>
			</tr>		
		</table>
<%	//카운트가 0=글이 없을 때
	if (count == 0) {%>	
		<table width="600" border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">게시판에 저장한 글이 없다</td>
			</tr>
		</table>	
<%} else {%>	
		<table border="1" width="600" cellpadding="0" cellspacing="0" align="center">
			<tr height="30" bgcolor="<%=value_c %>">
				<td align="center" width="50"> 번 호 </td>
				<td align="center" width="250"> 제 목 </td>
				<td align="center" width="100"> 작성자 </td>
				<td align="center" width="150"> 작성일 </td>
				<td align="center" width="50"> 조 회 </td>
			</tr>
<%
			for(int i=0; i<articleList.size(); i++) {
				BoardDataBean article= (BoardDataBean)articleList.get(i);
%>
				<tr height="30">
					<td align="center" width="50"> <%=number%> </td>
					<td width="250">
<%	//
					if (article.getRe_level() > 0) {
						for(int level=0; level <article.getRe_level(); level++) { %>							
						
						&nbsp;
						
<%						} %>
						<img src="image/re.gif">
<%					} else //else면 원글이란 뜻..그럼 공백처리 
							{ %>

						&nbsp;
						
<%					} %>
<!-- num을 클릭하면 글 상세가 보임, 밑의 number로 글 제목 추출 -->
					<a href="content.jsp?num=<%=article.getNum() %>&pageNum=<%=currentPage %>	
					&number=<%=number %>"><%=article.getSubject() %></a>
<%	
					if(article.getReadcount() >= 20) { %>
						<img src="image/hot.gif" border="0" height="16">
<%					} %>
					</td>
					<td align="center" width="100">
						<a href="mailto:<%=article.getEmail() %>"><%=article.getWriter() %></a>
					</td>
					
					<td align="center" width="150">
						<%=sdf.format(article.getReg_date()) %>
					</td>
					
					<td align="center" width="50"> <%=article.getReadcount() %> </td>
				</tr>
<%
				number--;
			}
%>

		</table>
		<br>
<%}
	//count >0으로 글이 존재한다면 
	if(count > 0) {
		int pageCount=((count-1) / pageSize) + 1;  //1~10까지는 1페이지라는 가정
		int startPage= 1;   //
		int i;
	//현재 페이지가 10의배수가 아니라면 1페이지(3도 1페이지, 5도 1페이지)(10개마다 다른 페이지)	
		if(currentPage%10 != 0)
			startPage=(int)(currentPage/10)*10+1;
		else
			startPage=currentPage - 9;
		int pageBlock=10;	//한 페이지는 10개
	//startpage가 10보다 크다면 pageblock을 10 적은걸로 표시해줌[이전]	
		if (startPage > 10) { %>
			<a href="list.jsp?pageNum=<%=startPage - 10 %>">[이전]</a>
<%		}
	//i<=pageCount를 준 이유..만약 10개를 다 못채웠을때 i<=pageCount이 없으면 나머지 글들이 밑에 나옴?	
		for (i=startPage; (i<=startPage+9) && (i<=pageCount); i++) { %>
			<a href="list.jsp?pageNum=<%=i %>">[<%=i %>]</a>
<%		}
	//10개 다 채우고 나면 새로운 pageBlock을 만든다 (11~20)
		if (i < pageCount) { %>
			<a href="list.jsp?pageNum=<%=startPage + 10 %>">[다음]</a>
<%		}
	} %>
	</center>
</body>
</html>