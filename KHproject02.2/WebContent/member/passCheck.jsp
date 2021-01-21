<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
ul { list-style-type: none; }
.kh01 {
	position : absolute;
	top: 10px; left: 290px;
	width: 50px; height: 40px;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<form action="../passCheckconfirm.mb" method="get">
<ul>
	<li><label for="아이디찾기">아이디찾기</label>
	<input type="text" name="id" autofocus="autofocus" required="required" placeholder="아이디를 입력해주세요">
	</li>
	<li><input type="image" src="../images/search.png" class="kh01">
</ul>
</form>
</body>
</html>