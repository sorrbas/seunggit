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
	request.setCharacterEncoding("utf-8");
	String titleSearch = request.getParameter("title");
%>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
	String sql = "select no,title,content,author,nal,readCount from boardNJ where title=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, titleSearch);
	ResultSet rs = pstmt.executeQuery();
	int no = 0;
	String title = null;
	String content = null;
	String author = null;
	String nal = null;
	int readCount = 0;
	while(rs.next()){
		no = rs.getInt("no");
		title = rs.getString("title");
		content = rs.getString("content");
		author = rs.getString("author");
		nal = rs.getString("nal");
		readCount = rs.getInt("readCount");
	}
	readCount++;
	sql = "update boardNJ set readCount=? where title=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, readCount);
	pstmt.setString(2, titleSearch);
	int cnt = pstmt.executeUpdate();
%>
<jsp:forward page='<%= request.getParameter("boardTest") %>'>
<jsp:param value="<%= no %>" name="no"/>
<jsp:param value="<%= title %>" name="title"/>
<jsp:param value="<%= content %>" name="content"/>
<jsp:param value="<%= author %>" name="author"/>
<jsp:param value="<%= nal %>" name="nal"/>
<jsp:param value="<%= readCount %>" name="readCount"/>
</jsp:forward>
</body>
</html>