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
	<label>�̸�</label>
	<input type="text" name="name" required="required" id="name">
	<label>��ȭ��ȣ</label>
	<input type="text" name="tel" required="required" id="tel">
	<input type="hidden" name="license_id" value="<%=session.getAttribute("id") %>">
	<input type="hidden" name="license_email" value="<%=session.getAttribute("email") %>">
	<input type="submit" value="��û�ϱ�">
	<input type="reset" value="���">
</form>
</body>
</html>