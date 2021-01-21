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
	position : absolute;
	top: 170px; left: 90px;
	width: 60px; height: 50px;
}
ul { list-style-type: none; } 
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<%
		String idSearch = request.getParameter("id");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
		String sql = "select id, pw, addr, tel from memberNJ where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, idSearch);
		ResultSet rs = null;
		String id = null;
		String pw = null;
		String addr = null;
		String tel = null;
		rs = pstmt.executeQuery();
		while(rs.next()){
			id = rs.getString("id");
			pw = rs.getString("pw");
			addr = rs.getString("addr");
			tel = rs.getString("tel");
			out.print("수정하기 전 회원정보입니다.<br>");
			out.print("ID : " + id + "&nbspPW : " + pw + "&nbsp주소 : " + addr + "&nbsp전화번호 : " + tel);
		}
	%>
	<form action="memberUpdate.jsp" method="get">
	<ul>
	<li><label for="아이디">아이디</label>
	<input type="text" name="id" autofocus="autofocus" required="required" placeholder="수정할 ID를 입력해주세요">
	<input type="hidden" name="idSearch" value="<%= idSearch %>">
	</li>
	<li><label for="패스워드">패스워드</label>
	<input type="password" name="pw" placeholder="수정할 패스워드를 입력해주세요">
	</li>
	<li><label for="주소">주소</label>
	<input type="text" name="addr" placeholder="수정할 주소를 입력해주세요">
	</li>
	<li><label for="전화번호">전화번호</label>
	<input type="text" name="tel" placeholder="수정할 전화번호를 입력해주세요">
	</li>
	<li>
	<input type="image" src="../images/update.png" class="kh01">
	</li>
	</ul>
	</form>
</body>
</html>