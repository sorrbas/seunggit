<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% session.setAttribute("name","KH TEST"); %>
<script>
location.href="sessionTest.jsp";   //sessionTest로 다시 간다.
</script>

</body>
</html>