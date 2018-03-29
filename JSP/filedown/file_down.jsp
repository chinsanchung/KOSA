<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.io.File" %>
<%@ page import= "java.io.*" %>
<%@ page import= "com.oreilly.servlet.ServletUtils " %>

<%
	request.setCharacterEncoding("utf-8");
	String fileName= request.getParameter("file_name");
	
	String savePath= "upload";
	ServletContext context= getServletContext();
	String sDownloadPath= context.getRealPath(savePath);
	
	String sFilePath= sDownloadPath + "\\" + fileName;
	//String savePath= "C:\\upload";
	//String sFilePath= savePate + "\\" + fileName";
	
	byte b[]= new byte[4096];
	File oFile= new File(sFilePath);
//입력 객체 하나 생성
	FileInputStream in= new FileInputStream(sFilePath);
			
	String sMimeType= getServletContext().getMimeType(sFilePath);
	System.out.println("sMimeType>>>" + sMimeType);
//octet-stream은 8비트로 된 일련의 데이터로 지정되지 않은 파일 형식	
	if(sMimeType== null)
		sMimeType= "application/octet-stream";
	
	response.setContentType(sMimeType);
//한글 업로드(한글 파일명이 깨지는 것 방지)	
	String sEncoding= new String(fileName.getBytes("utf-8"), "8859_1");
	response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
//서버에 발생하는 예외문제 해결: response.getOutputStream();으로 객체 생성
	out.clear(); //이것 없으면 에러발생..JSP에서 servlet으로 변환시 내부적으로 out객체 생성됨.
	out= pageContext.pushBody();
	
	ServletOutputStream out2= response.getOutputStream();
	int numRead;
//바이트 배열b의 0번에서 numRead번까지 브라우저로 출력	..-1이 될때까지 읽겠다
	while((numRead= in.read(b, 0, b.length)) != -1) {
		out2.write(b, 0, numRead);
	}
	out2.flush(); //불필요한 내용 간추림
	out2.close();
	in.close();
%>