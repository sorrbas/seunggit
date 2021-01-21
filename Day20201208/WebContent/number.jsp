<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>khjsp</title>
</head>
<body>
<form action="numberprocess.jsp" method="get">
<fieldset>
   <legend>숫자테스트</legend>
   <ul>
    <li><label for="넘버테스트">넘버테스트</label>
    <input type="number" name="num" max="100" min="1" step="2">
    </li>
    <li><input type="submit" value="전송"></li>
    
    
   
   </ul>

</fieldset>


</form>

</body>
</html>