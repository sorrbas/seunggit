<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<%
		ResultSet rs = null;
		String telSearch = request.getParameter("tel");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
		String sql = "select id from memberNJ where tel=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, telSearch);
		rs = pstmt.executeQuery();
		String id = null;
		while (rs.next()) {
			id = rs.getString("id");
		}
	%>
	회원님의 아이디는 <%=id%> 입니다.<br>
	<a href="../index.jsp?page=kh">메인으로</a>
</body>
</html>