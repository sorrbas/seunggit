<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name;
if(session.getAttribute("name")!=null){
name=(String) session.getAttribute("name");
}else{
name="세션값없음";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session Test</title>
</head>
<body>
<h2>세션 테스트</h2>
<input type="button" onclick="location.href='sessionSeT.jsp'" value="세션값 저장">
<input type="button" onclick="location.href='sessionDel.jsp'" value="세션값 삭제">
<input type="button" onclick="location.href='sessionInvalidate.jsp'" value="세션초기화">
<h3><%= name %></h3>
</body>
</html>
