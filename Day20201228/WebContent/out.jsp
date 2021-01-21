<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>out test</title>
</head>
<body>
<%
String name="이승기";
out.print("이것은 out내장 객체로 출력:"+name+"<br>");
%>
이것은 expression tag로 출력:<%= name %>
</body>
</html>
