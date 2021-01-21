<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#boardtitle {
	position: absolute;
	top: 250px;
	left: 430px;
}
#loginForm {
	position : absolute;
	top: 300px; left: 560px;
	width: 430px; height: 100px;
	border: 5px solid skyblue;
	border-radius: 20px 20px 20px 20px;
	padding-top: 10px;
}
ul { list-style-type: none; }
.kh01 {
	position : absolute;
	top: 25px; left: 290px;
	width: 50px; height: 40px;
}
.kh02 {
	position : absolute;
	top: 25px; left: 360px;
	width: 50px; height: 40px;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="boardtitle">
<h2>Sign In</h2>
</div>
<div id="loginForm">
<form action="member/login.jsp" method="get">
<ul>
	<li><label for="아이디">아이디&nbsp;&nbsp;&nbsp;</label>
	<input type="text" name="id" size ="20" maxlength ="14" autofocus="autofocus" required="required" placeholder="ID를 입력해주세요">
	</li>
	<li><label for="패스워드">패스워드</label>
	<input type="text" name="pw" size="20" maxlength = "16" placeholder="패스워드를 입력해주세요">
	</li>
	<li><input type="image" src="images/check1.png" class="kh01">
	</li>
	<li><input type="image" src="images/registerr.png" class="kh02">
		<a href="index.jsp?page=member/memberForm"><img src="images/registerr.png" class="kh02"></a>
		<a href="member/idCheck.jsp">아이디찾기</a>&nbsp;&nbsp;&nbsp;
		<a href="member/passCheck.jsp">패스워드찾기</a>
	</li>
</ul>

</form>
</div>
</body>
</html>