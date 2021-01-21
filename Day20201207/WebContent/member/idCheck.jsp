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
<form action="idCheckConfirm.jsp" method="get">
<ul>
	<li><label for="전화번호">전화번호</label>
		<input type="text" name="tel" required="required" autofocus="autofocus" placeholder="전화번호를 입력하세요">	
	</li>
	<li><input type="image" src="../images/check.png" class="kh01">
	</li>
</ul>
</form>
</body>
</html>