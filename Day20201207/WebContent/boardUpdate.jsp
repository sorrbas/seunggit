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
      String titleSearch = request.getParameter("titleSearch");
      String no = request.getParameter("no");
      String title = request.getParameter("title");
      String content = request.getParameter("content");
      String author = request.getParameter("author");
      String nal = request.getParameter("nal");
      String readCount = request.getParameter("readCount");
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
      String sql = "update boardNJ set title=?, content=?, author=?,nal=?,readCount=? where title = ?";
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, title);
      pstmt.setString(2, content);
      pstmt.setString(3, author);
      pstmt.setString(4, nal);
      pstmt.setString(5, readCount);
      pstmt.setString(6, titleSearch);
      int cnt = pstmt.executeUpdate();
   %>
<%= cnt %>건 게시글이 수정되었습니다.
<%response.sendRedirect("index.jsp?page=board/boardList"); %>
</body>
</html>