<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="myBean" class="kr.or.kh.LoginBean"/>
    <jsp:setProperty property="*" name="myBean"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session test</title>
</head>
<body>
<h1>EL 실습</h1>

사용자 아이디: ${myBean.userid}<br>  <!--  <퍼센트= userid %>와 같은뜻임 -->
사용자 비밀번호: ${myBean.passwd}<br>
 
 <!-- 스프링에선 보통 위와같은 경우로 많이들 쓴다고 한다... 대신 JAR파일을 넣어주어야함 -->

</body>
</html>
