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
#memberUpdateForm {
	position : absolute;
	top: 320px; left: 430px;
	width: 350px; height: 70px;
	border: 5px solid skyblue;
	border-radius: 20px 20px 20px 20px;
	padding-top : 10px;
}

.kh01 {
	position: absolute;
	top: 20px; left: 270px;
	width: 50px; height: 40px;
}
ul { list-style-type: none; }

</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id = "boardtitle">
<h2>회원아이디수정</h2>
</div>
<div id ="memberUpdateForm">
<form action="member/memberUpdateConfirm.jsp" method="get">
<ul>
	<li><label for="아이디">아이디</label>
	<input type="text" name="id" autofocus="autofocus" required="required" placeholder="수정할 ID를 입력해주세요">
	</li>
	<li><input type="image" src="images/update.png" class="kh01">
	</li>
	
</ul>
</form>

</div>
</body>
</html>