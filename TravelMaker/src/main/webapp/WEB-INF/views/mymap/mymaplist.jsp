<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<div><c:out value="${title}"/></div>
	<c:forEach var="diary" items="${mydiaryList}">
		<div><c:out value="${diary.title}"/></div>
		<div><c:out value="${diary.writer}"/></div>
		<div><c:out value="${diary.regdate}"/></div>
	</c:forEach>
</body>
</html>