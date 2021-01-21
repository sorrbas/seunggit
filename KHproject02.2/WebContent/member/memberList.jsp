<%@page import="kr.or.kh.member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
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

#boardList {
	position: absolute;
	top: 300px;
	left: 420px;
	width: 1000px;
}

.List {
	border: 0px solid lightgray;
	border-collapse: collapse;
	width: 700px;
	background-color: white;
	text-align: center;
}

th {
	border: 1px solid lightgray;
	background-color: pink;
	color: white;
	border-bottom : 2px solid #c00;
}


</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="boardList">
		<table border="1" cellspacing="0" cellpadding="0" class="List">
			<tr>
				<th>ID</th>
				<th>PW</th>
				<th>주소</th>
				<th>전화번호</th>
			</tr>
							<%

  ArrayList<MemberDTO> memberList = (ArrayList<MemberDTO>)request.getAttribute("memberList");
  for(int i=0; i<memberList.size();i++) {
	  MemberDTO memberDTO =memberList.get(i);
%>
			<tr>
			<td><%= memberDTO.getId() %></td>
			<td><%= memberDTO.getPw() %></td>
			<td><%= memberDTO.getAddr() %></td>
			<td><%= memberDTO.getTel() %>
		
			
			</tr>
			<%} %>

	</table>
	<a href = "index.jsp?page=member/memberUpdateForm">멤버수정</a>
	</div>
</body>
</html>