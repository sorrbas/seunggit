<%@page import="kr.or.kh.member.MemberDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.kh01 {
	position: absolute;
	top: 170px;
	left: 90px;
	width: 60px;
	height: 50px;
}

ul {
	list-style-type: none;
}


</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	
	<div id="memberUpdateConfirm">
		<%
		MemberDTO memberDTO = (MemberDTO) request.getAttribute("memberDTO");
	    out.print("변경하기 전 내용입니다.");
	    out.print("아이디 : "+memberDTO.getId()+"패스워드 : "+memberDTO.getPw()+"주소 :"+memberDTO.getAddr()+"전화번호 : "+memberDTO.getTel()+"<br>");
	%>
	
	<form action="memberUpdateFinal.mb" method="get">
		<ul>
			<li>
			<label for="아이디">아이디</label> <input type="text" name="id"
				autofocus="autofocus" required="required"
				placeholder="수정할 ID를 입력해주세요"> <input type="hidden"
				name="idSearch" value="<%=memberDTO.getId()%>">
				<!--   -->
				</li>
			<li>
			<label for="패스워드">패스워드</label> <input type="password"
				name="pw" placeholder="수정할 패스워드를 입력해주세요">
				</li>
			<li>
			<label for="주소">주소</label> <input type="text" name="addr"
				placeholder="수정할 주소를 입력해주세요">
				</li>
			<li>
			<label for="전화번호">전화번호</label> <input type="text" name="tel"
				placeholder="수정할 전화번호를 입력해주세요">
				</li>
			<li>
			<input type="image" src="images/update1.png" class="kh01">
			</li>
		</ul>
	</form>
	</div>
</body>
</html>