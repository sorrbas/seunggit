<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  foreach문을 쓰려면 이 URL이 무조건 들어가야한다. -->



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL Core 라이브러리 실습</title>
</head>
<body>
	<h1>JSTL Core 라이브러리 실습</h1>
	<%
    int [] num = { 1 ,2 , 3 ,4, 5 , 6 , 7, 8, 9, 10 };
    request.setAttribute("myArray", num);
%>
	<c:forEach var="n" items="${myArray}">
		<c:out value="${n}" />
	</c:forEach>
	<br>
	<c:forEach var="n" items="${myArray}" begin="0" end="6">
		<c:out value="${n}" />
	</c:forEach>

	<h1>JSTL Core 라이브러리 실습2</h1>
	<%
   
    ArrayList<String> list = new ArrayList<String>();
    list.add("홍길동");
    list.add("이순신");
    list.add("유관순");
    request.setAttribute("name", list);
%>
	<c:forEach var="n" items="${name}">
		<c:out value="${n}" />
	</c:forEach>
	<h1>JSTL Core 라이브러리 실습3</h1>

	<%
    String str = "A,B,C,D";
    request.setAttribute("data", str);
%>
	<c:forTokens var="n" items="${data}" delims=",">
		<c:out value="${n}" />
		<br>
	</c:forTokens>
</body>
</html>