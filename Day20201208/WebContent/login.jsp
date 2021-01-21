<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="loginprocess.jsp" method="get">
<fieldset>
<ul>
  <li><label for="아이디">아이디</label>
      <input type="text" name="id" autofocus="autofocus" required="required" placeholder="아이디입력해주세요">
  </li>
   <li><label for="패스워드">패스워드</label>
        <input type="password" name="pw" placeholder="패스워드를 입력해주세요">
        </li>
        <li><input type="submit" value="전송"></li>

</ul>
</fieldset>
</form>
</body>
</html>