<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>exception test</title>
</head>
<body>
<h1>서버공사중입니다.</h1>
<%
out.print("발생된 예외는:"+exception.getMessage());
%>
</body>
</html>
