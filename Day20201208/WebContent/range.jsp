<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>khjsp</title>
</head>
<body>
<form action="rangeprocess.jsp" method="get">
<fieldset>
<legend>막대테스트</legend>
<ul>
<li><label for="막대기">막대기</label>
    <input type="range" name="range" max="50" min="1" stpe="1">
    </li>
    <li><input type="submit" value="전송"> </li>

</ul>

</fieldset>


</form>

</body>
</html>