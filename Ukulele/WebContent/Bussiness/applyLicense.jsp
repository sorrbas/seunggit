<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>

</style>
</head>
<body>

<form action="Bussiness/applyLicenseProc.jsp" method="get">
	<label>이름</label>
	<input type="text" name="name" required="required" id="name">
	<label>전화번호</label>
	<input type="text" name="tel" required="required" id="tel">
	<input type="hidden" name="license_id" value="<%=session.getAttribute("id") %>">
	<input type="hidden" name="license_email" value="<%=session.getAttribute("email") %>">
	<input type="submit" value="신청하기">
	<input type="reset" value="취소">
</form>
</body>
</html>