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
<h1>교수등록처리</h1>
	<%
		String nai = request.getParameter("nai");
		String irum = request.getParameter("irum");
		String subject = request.getParameter("subject");
	%>
	<%=nai%>:<%=irum%>:<%=subject%>
	<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb", "underdogb","khacademy1!");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb", "underdogb","khacademy1!");
		String sql = "insert into professorNJ(age, irum, subject) values(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nai);
		pstmt.setString(2, irum);
		pstmt.setString(3, subject);
		int cnt = pstmt.executeUpdate();
		
		/*Statement stmt = conn.createStatement();
		String sql = "insert into professorNJ(age, irum, subject) values(" + nai + ",'" + irum + "','" + subject + "')";
		int cnt = stmt.executeUpdate(sql);*/
	%>
	<%=cnt%>건 교수님이 등록되었습니다.

	<%
		pstmt.close();
		conn.close();
		response.sendRedirect("professorList.jsp");
	%>
</body>
</html>