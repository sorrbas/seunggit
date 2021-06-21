<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>MyTravel</title>
</head>
<body>
<input type="button" value="회원정보조회" class="btn" onclick="location.href='/userInfo.do'">
<input type="button" value="회원정보수정" class="btn" onclick="location.href='/user/userUpdateForm'">
<input type="button" value="회원탈퇴" class="btn" onclick="location.href='/user/userDeleteForm'">
</body>
</html>