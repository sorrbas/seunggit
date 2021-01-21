<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jstl core 라이브러리 실습</h1>
<%

  int[] num={1,2,3,4,5,6,7,8,9,10};
   request.setAttribute("myarray", num);
  
%>
<c:forEach var="n" items="${myarray}">
<c:out value ="${n}"/>
</c:forEach>
<br>
<c:forEach var ="n" items="${myarray }" begin="0" end="6">
<c:out value ="${n }"/>
</c:forEach>


<h1>JSTL core 라이브러리 실습2</h1>

<% 

ArrayList<String> list = new ArrayList<String>();
list.add("홍길동");
list.add("이순신");
list.add("유관순");
request.setAttribute("name", list);

%>

<c:forEach var="n" items="${name }">
<!-- items은 객체를 가져온다는 의미로 사용  -->
<c:out value="${n }"></c:out>
</c:forEach>

<h1>JSTL core 라이브러리 실습3</h1>

<%

String str="A,B,C,D";
request.setAttribute("data", str);

%>

<c:forTokens var="n" items="${data }" delims=",">
<c:out value="${n }"/><br>
</c:forTokens>


</body>
</html>