<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<style>
#deletetitle{
	margin-left: 390px;
	margin-top: 25px;
}
#deletetable{
margin-left: 300px;
margin-top: 60px;
}
#bbb{
margin-left: 200px;
margin-top: 10px;
}
table {
	width: 360px;
	height: 250px;
	border-right: none;
	border-left: none;
	border-top: none;
	border-bottom: none;
	
}

th {
	background-color: #B2CCFF;
	color: #050099;
	border-radius: 10px 10px 10px 10px;
	border-color: #4641D9;
 text-shadow: -1px 0 #F2F1F6, 0 1px #F2F1F6, 1px 0 #F2F1F6, 0 -1px #F2F1F6;
 -moz-text-shadow: -1px 0 #F2F1F6, 0 1px #F2F1F6, 1px 0 #F2F1F6, 0 -1px #F2F1F6;
 -webkit-text-shadow: -1px 0 #F2F1F6, 0 1px #F2F1F6, 1px 0 #F2F1F6, 0 -1px #F2F1F6;
}
td {
	width: 230px;
	text-align: center;
	border-color: #4641D9;
	border-radius: 10px 10px 10px 10px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="journalContentContainer">
<div id = "deletetitle">
<h1>회원 탈퇴</h1>
</div>
	<form action="/delete.do" method="post" name = "deletefrm">
	<div id = "deletetable">
	<table border = "1">
	<tr>
	<th>아이디</th>
	<td><input type="text" name="id" value = "${VO.id }"readonly style="background-color:transparent; border:0 solid black;text-align:center;"></td>
	</tr>
	<tr>
	<th>비밀번호</th>
	<td><input type="password" name="password" placeholder = "비밀번호를 입력해주세요" style ="background-color:transparent; border:0 solid black;text-align:center;"></td>
	</tr>
	<tr>
	<th>이름</th>
	<td><input type = "text" name = "name" value = "${VO.name }" readonly style="background-color:transparent; border:0 solid black;text-align:center;"></td>
	</tr>
	<tr>
	<th>이메일</th>
	<td><input type = "text" name = "email" value = "${VO.email }" readonly style="background-color:transparent; border:0 solid black;text-align:center;"></td>
	</tr>
	</table>
	<div id = "bbb">
	<input type="submit" id = "delete_btn" value="탈퇴하기" style="width: 70px; height: 30px; color: #5D5D5D; font-size: 15px;
		background-color: #B2CCFF; border:0; border-radius: 10px 10px 10px 10px;">
	<input type="button" value="뒤로가기" onclick="location.href='/main'" style="width: 70px; height: 30px; color: #5D5D5D; font-size: 15px;
		background-color: #B2CCFF; border:0; border-radius: 10px 10px 10px 10px;">
	</div>
	</div>
	</form>
	<div>
	<c:if test="${msg == false }">
	<p style = "margin-left: 480px; color : red;" >
	비밀번호가 틀렸습니다.
	</p>
	</c:if>
	</div>
	</div>
	<script>
	$('#delete_btn').click(function(){
		if(confirm("정말 삭제하시겠습니까?") == true) {
			document.deletefrm.submit();
		} else {
			return false;
		}
	});
	</script>
	</body>
</html>