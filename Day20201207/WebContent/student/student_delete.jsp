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
	<h1>학생삭제</h1>
	<%
		String irum = request.getParameter("irum");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb", "underdogb", "khacademy1!");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb", "underdogb","khacademy1!");
		String sql = "delete from studentNJ where irum=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irum);
		int cnt = pstmt.executeUpdate();
		
		/*Statement stmt = conn.createStatement();*/
		/*String sql = "delete from studentNJ where irum='" + irum + "'";*/
		/*int cnt = stmt.executeUpdate(sql);*/
	%>
	<%=cnt%>건 학생이 삭제되었습니다.
	<%
		pstmt.close();
		conn.close();
	%>
	<% response.sendRedirect("studentList.jsp"); %>
</body>
</html>