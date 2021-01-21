<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<%
	session.invalidate(); //session에 들어가있는값을 지운다.
	response.sendRedirect("../index.jsp");
%>
</body>
</html>