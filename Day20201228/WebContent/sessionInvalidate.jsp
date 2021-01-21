<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% session.invalidate();%> <!-- 값을 초기화한다는 의미 -->
<script>
location.href="sessionTest.jsp";
</script>

</body>
</html>