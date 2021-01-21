<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>

<%

String col = request.getParameter("col");


%>

<%=col %>
h1{
    color: col;

}
</style>
<meta charset="UTF-8">
<title>khjsp</title>
</head>
<body bgcolor="<%=col%>">




<h1>안녕하세요</h1>
</body>
</html>