<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-image: url("images/backg.png");
	background-repeat: no-repeat;
	background-size: 2000px;
	background-attachment: fixed;
	width: 1500px;
	height: 1000px;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<%
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String author = request.getParameter("author");
		String nal = request.getParameter("nal");
		String readCount = request.getParameter("readCount");
	%>
	제목 :
	<%=title%>
	내용 :
	<%=content%>
	작성자 :
	<%=author%>
	날짜 :
	<%=nal%>
	조회수 :
	<%=readCount%>
	<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
		String sql = "insert into boardNJ(title,content,author,nal,readCount) values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, author);
		pstmt.setString(4, nal);
		pstmt.setString(5, readCount);
		int cnt = pstmt.executeUpdate();
	%><br>
	<%=cnt%>건 게시글이 등록되었습니다.
	<%
		response.sendRedirect("../index.jsp?page=board/boardList");
		pstmt.close();
		conn.close();
	%>
</body>
</html>