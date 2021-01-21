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
#memberDelete {
	position : absolute;
	top: 320px; left: 430px;
	width: 350px; height: 70px;
	border: 5px solid skyblue;
	border-radius: 20px 20px 20px 20px;
	padding-top : 10px;
}

.kh01 {
	position: absolute;
	top: 20px; left: 280px;
	width: 50px; height: 40px;
}
ul { list-style-type: none; }
</style>

<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="boardtitle">
		<h2>회원탈퇴</h2>
	</div>
<div id = "memberDelete">
<form action="memberDelete.mb" method="get">
<ul>
	<li><label for="비밀번호">비밀번호</label>
	<input type="password" name="pw" autofocus="autofocus" required="required" placeholder="비밀번호를 입력해주세요">
	</li>
	<li><a onclick="alert('정말 탈퇴하시겠습니까?')"><input type="image" src="images/delete.png" class="kh01" ></a>
	</li>
</ul>
</form>
</div>

</body>
</html>