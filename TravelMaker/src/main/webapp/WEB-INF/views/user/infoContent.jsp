<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<style>
#usertitle{
	margin-left: 330px;
	margin-top: 25px;
}
#usertable{
margin-left: 300px;
margin-top: 60px;
}
#bbb{
margin-left: 130px;
margin-top: 10px;
}
.btn{background-color: #f8585b;
border:none;
color:#fffff;
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
</head>
<body>
	<div id="journalContentContainer">
	<div id = "usertitle">
		<h1>회원관리 페이지</h1>
		</div>
		<div id = "usertable">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td>${VO.id }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${VO.name }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${VO.email }</td>
			</tr>
		</table>
		<div id = "bbb">
		<input type="button" value="메인으로" onclick="location.href='/main'" style="width: 70px; height: 30px; color: #5D5D5D; font-size: 15px;
		background-color: #B2CCFF; border:0; border-radius: 10px 10px 10px 10px;"> 
		<input type="button" value="회원수정" onclick="location.href='/user/update'"style="width: 70px; height: 30px; color: #5D5D5D; font-size: 15px;
		background-color: #B2CCFF; border:0; border-radius: 10px 10px 10px 10px;">
		<input type="button" value="회원탈퇴" onclick="location.href='/user/delete'"style="width: 70px; height: 30px; color: #5D5D5D; font-size: 15px;
		background-color: #B2CCFF; border:0; border-radius: 10px 10px 10px 10px;">
	</div>
	</div>
	</div>
</body>
</html>