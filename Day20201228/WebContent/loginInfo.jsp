<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session 실습</title>
</head>
<body>
<h1>로그인 정보 보기 </h1>
<%
String id = (String) session.getAttribute("userid");

if(id==null){
response.sendRedirect("loginForm.jsp");
}else{
String pw = (String) session.getAttribute("passwd");

out.print("사용자 아이디값:"+id+"<br>");
out.print("사용자 비밀번호값:"+pw+"<br>");

out.print("<a href='logout.jsp'>로그아웃</a>");
}
%>
</body>
</html>

