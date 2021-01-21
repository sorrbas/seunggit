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
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
		String sql = "select id, pw, addr, tel from memberNJ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = null;
		String id = null;
		String pw = null;
		String addr = null;
		String tel = null;
		rs = pstmt.executeQuery();
		while(rs.next()) {
			id = rs.getString("id");
			pw = rs.getString("pw");
			addr = rs.getString("addr");
			tel = rs.getString("tel");
			out.print("<tr><td>" + id + "</td><td>" + pw + "</td><td>" + addr + "</td><td>" + tel + "</td></tr>");
		}
	%>
	</table>
	<a href = "index.jsp?page=member/memberUpdateForm">멤버수정</a>
	</div>
</body>
</html>