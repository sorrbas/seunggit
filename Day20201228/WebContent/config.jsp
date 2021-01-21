<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>config test</title>
</head>
<body>
<h1>config 내장객체를 이용한 초기화 파라미터값 얻기</h1>
<%
String dirPath = config.getInitParameter("dirPath");
String userid = config.getInitParameter("userid");
%>
dirPath 값: <%= dirPath %><br>
userid 값: <%= userid %><br>
</body>
</html>
