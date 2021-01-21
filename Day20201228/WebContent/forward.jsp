<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>current.jsp에서forward된 화면</h1>
<%
String data = request.getParameter("data");
String nickName = request.getParameter("nickName");
%>
포워드 되었으며 넘어온 파라미터값은<%= nickName %>입니다.<br>
직접 입력시킨 파라미터값은<%= data %>입니다.

</body>
</html>