<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session Login</title>
</head>
<body>
<form action="sessionLogin2.jsp" method="post">
<table border="0" width="400" height="100">
<tr bgcolor="yellow">
<td align="right"><font size="2">아이디:</font></td>
<td><input type="text" name="id" size="10"></td>
</tr>
<tr bgcolor="yellow">
<td align="right"><font size="2">비밀번호:</font></td>
<td><input type="password" name="pass" size="12"></td>
</tr>
<tr bgcolor="yellow">
<td colspan="2" align="center">
<input type="submit" value="로그인">
<input type="reset" value="다시작성">
</td>
</tr>
</table>
</form>
</body>
</html>
