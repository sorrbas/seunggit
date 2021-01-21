<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="myBean" class="kr.or.kh.LoginBean"/>  
    <jsp:setProperty property="userid" name="myBean" value="안녕하세요"/>    
     <!--  jsp파일에서 set함수를 호출하는 기능 -->
      <!--  property는 변수명 / name = myBean / value = 값을 넣으면 된다. -->
      <jsp:setProperty property="passwd" name="myBean" value="1111"/>
      <jsp:getProperty property="userid" name="myBean"/>
      <!--  결국  출력을하기위해 -->
      <jsp:getProperty property="passwd" name="myBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <!-- 
  <%

myBean.setUserid("아이디셋팅란");
myBean.setPasswd("1111");

%>

<%=myBean.getUserid() %>
<%=myBean.getPasswd() %>

-->
</body>
</html>