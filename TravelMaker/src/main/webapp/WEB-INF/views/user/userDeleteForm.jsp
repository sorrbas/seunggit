<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
// String id = (String) session.getAttribute("id");
// if(id == null) {
// 	response.sendRedirect("/");
// }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<legend>회원탈퇴</legend>
	<form action="/delete.do" method="post">
	<!-- input타입중 hidden은 화면에 있는 해당 input태그를 숨겨서 정보 전달   -->
		아이디 : <input type="text" name="id" value = "${vo.id }"readonly><br>
		비밀번호 : <input type="password" name="password"><br>
		이 름<input type = "text" name = "name" value = "${vo.name }" readonly><br>
		<input type="submit" class="btn" value="탈퇴하기">
		<input type="button" class="btn" value="뒤로가기" onclick="location.href='/member/main'">
	</form>
	<div>
	<c:if test="${msg == false }">
	비밀번호가 틀렸습니다.
	</c:if>
	</div>
</fieldset>
</body>
</html>