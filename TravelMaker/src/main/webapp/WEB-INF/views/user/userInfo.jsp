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
		<td>���̵�</td>
		<td>${vo.id }</td>
	</tr>
	<tr>
		<td>��й�ȣ</td>
		<td>${vo.password }</td>
	</tr>
	<tr>
		<td>�̸�</td>
		<td>${vo.name }</td>
	</tr>
	<tr>
		<td>�̸���</td>
		<td>${vo.email }</td>
	</tr>
<input type="button" value="��������" class="main-btn" onclick="location.href='/main'">
</table>
</body>
</html>