<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% session.setAttribute("id", request.getParameter("id")); %>
      <!-- 입력한 아이디의 값을 세션에다가 저장을 하고 데이터베이스에 id의 값을 요청한다 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session Login</title>
</head>
<body>
<center>
<h3>로그인 되었습니다.</h3>
<h3>로그인 아이디:<%=(String)session.getAttribute("id") %></h3>
<a href="sessionLogout.jsp">로그아웃</a>
</center>
</body>
</html>
