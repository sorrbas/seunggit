<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

  String gender = request.getParameter("gender");
 
  
%>
선택한 성별은 : <%= gender %>


</body>
</html>