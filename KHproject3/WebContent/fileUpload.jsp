<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String name="";
    String subject = "";
    String filename1 ="";
    String filename2="";
    String origfilename1="";
    String origfilename2="";
    try{
    String uploadPath=request.getRealPath("/upload");
    int size = 10*1024*1024;
    MultipartRequest multi = new MultipartRequest(request,uploadPath,size,"UTF-8",new DefaultFileRenamePolicy());
    name = multi.getParameter("name");
    subject = multi.getParameter("subject");
    Enumeration files = multi.getFileNames();
    String file1 = (String) files.nextElement();
    filename1 = multi.getFilesystemName(file1);
    origfilename1 = multi.getOriginalFileName(file1);
    String file2 = (String) files.nextElement();
    filename2 = multi.getFilesystemName(file2);
    origfilename2 = multi.getOriginalFileName(file2);
    } catch(Exception e) {
    	e.printStackTrace();
    }
    
    //Enumeration 벡터 배열방식으로 접근할떄 사용 접근속도가 빠름
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>khjsp</title>
</head>
<body>
<form name="filecheck" action="filecheck.jsp" method="post">

<input type="hidden" name="name" value="<%=name %>">
<input type="hidden" name="subject" value="<%=subject %>">
<input type="hidden" name="filename1" value="<%=filename1 %>">
<input type="hidden" name="filename2" value="<%=filename2 %>">
<input type="hidden" name="origfilename1" value="<%=origfilename1 %>"> 
<input type="hidden" name="origfilename2" value="<%=origfilename2 %>">
</form>
<a href="#" onclick="javascript:filecheck.submit()">업로드 확인 및 다운로드 페이지 이동</a>
</body>
</html>