<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
ul { list-style-type: none; }
.kh01 {
	position : absolute;
	top: 25px; left: 290px;
	width: 50px; height: 40px;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<form action="passCheckConfirm.jsp" method="get">
<ul>
	<li><label for="아이디">아이디</label>
	<input type="text" name="id" autofocus="autofocus" required="required" placeholder="아이디를 입력해주세요">
	</li>
	<li><input type="image" src="../images/check.png" class="kh01">
</ul>
</form>
</body>
</html>