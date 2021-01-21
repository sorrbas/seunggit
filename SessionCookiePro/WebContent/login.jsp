<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="myBean" class="kr.or.kh.LoginBean" scope="page"/>
    <jsp:setProperty property="userid" name="myBean"/>
    <jsp:setProperty property="passwd" name="myBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${myBean.userid }
${myBean.passwd }

</body>
</html>