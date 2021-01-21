<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getParameterNames 실습</title>
</head>
<body>
<h1>getParameterNames 실습</h1>
<form action="Member" method="post">
<fieldset>
	<legend>회원관리폼</legend>
	<ul>
		<li>
			<label for="username">이름</label>
			<input type="text" name="username">
		</li>
		<li>
			<label for="address">주소</label>
			<input type="text" name="address">
		</li>
		<li>
			<label for="userid">아이디</label>
			<input type="text" name="userid">
		</li>
		<li>
			<label for="passwd">비밀번호</label>
			<input type="text" name="passwd">
		</li>
		<li>
			<label for="email">이메일</label>
			<input type="text" name="email">
		</li>
		<li>
			<input type="submit" value="전송">
		</li>
	</ul>
</fieldset>
</form>
</body>
</html>
