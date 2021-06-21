<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>uesrInfo</title>
</head>
<body>
<table border="1">
	<tr>
		<td>아이디</td>
		<td>${vo.id }</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>${vo.password }</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>${vo.name }</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${vo.email }</td>
	</tr>
<input type="button" value="메인으로" class="main-btn" onclick="location.href='/main'">
</table>
</body>
</html>