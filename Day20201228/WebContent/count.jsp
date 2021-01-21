<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방문자수 카운트</title>
</head>
<body>
<h1>방문자수 설정하기 화면</h1>
<%! int count; %>
<%
count++;

application.setAttribute("countValue", count);
%>

현재방문자수:<%= count %>
</body>
</html>
