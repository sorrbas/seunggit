<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
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
		String irum = request.getParameter("irum");
		String age = request.getParameter("age");
		String part = request.getParameter("part");
		String irumUpdate = request.getParameter("irumUpdate");

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://bbr123.cafe24.com:3306/bbr123", "bbr123",
				"alstjr95!");
		/*Statement stmt = conn.createStatement();*/
		String sql = "update managerjw set age=?, irum=?, part=? where irum=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, age);
		pstmt.setString(2, irum);
		pstmt.setString(3, part);
		pstmt.setString(4, irumUpdate);
		int cnt = pstmt.executeUpdate();
	%>
	<%=cnt%>건 매니저가 수정 되었습니다.

	<%
		pstmt.close();
		conn.close();
	%>
	<%
		response.sendRedirect("manager_list.jsp");
	%>
</body>
</html>