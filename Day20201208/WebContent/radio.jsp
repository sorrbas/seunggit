<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="radioprocess.jsp" method="get">
<filedset>
      <legend>성별선택</legend>
      <ul>
      <li><label for="남자">남자</label>
          <input type="radio" name="gender" value="남자">
          </li>
          <li><label for="여자">여자</label>
          <input type="radio" name="gender" value="여자">
          </li> 
       <li><input type="submit" value="누르세요">
       </li>      
      </ul>

</form>
</body>
</html>