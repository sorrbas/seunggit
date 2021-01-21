<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.kh01 {
	width: 100px;
	height: 80px;
}
ul { list-style-type: none; }
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<%
	String titleSearch = request.getParameter("titleSearch");
	int no = 0;
	String title = null;
	String content = null;
	String author = null;
	String nal = null;
	String readCount = null;
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
	String sql = "select no, title, content,author, nal, readCount from boardNJ where title=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, titleSearch);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){
		no = rs.getInt("no");
		title = rs.getString("title");
		content = rs.getString("content");
		author = rs.getString("author");
		nal = rs.getString("nal");
		readCount = rs.getString("readCount");
	}
	out.print("변경하기 전 내용입니다.");
	out.print("번호 : "+no+"&nbsp제목 : "+title+"&nbsp내용 : "+content+"&nbsp작성자 : "+author+"&nbsp날짜 : "+nal+"&nbsp조회수 : "+readCount);
%>
<div id="boardUpdate">
<form action="boardUpdate.jsp" method="get">
<ul>
	<li><label for="번호">번호</label>
		<input type="number" readonly="readonly" value="<%= no %>">
		<input type="hidden" name="no" value="<%= no %>">
	</li>
	<li><label for="제목">제목</label>
		<input type="text" name="title" autofocus="autofocus" required="required" placeholder="수정할 제목을 입력해주세요.">
		<input type="hidden" name="titleSearch" value="<%= titleSearch %>">
	</li>
	<li><label for="내용">내용</label>
		<textarea rows="20" cols="80" name="content" placeholder="수정할 내용을 입력해주세요."></textarea>
	</li>
	<li><label for="작성자">작성자</label>
		<input type=text" name="author" placeholder="수정할 작성자를 입력해주세요.">
	</li>
	<li><label for="날짜">날짜</label>
		<input type="date" name="nal">
	</li>
	<li><label for="조회수">조회수</label>
		<input type="text" name="readCount" placeholder="수정할 조회수를 입력해주세요.">
	</li>
	<li><input type="image" src="images/update.jpg" class="kh01">
	<input type="reset" value="되돌리기"></li>
</ul>

</form>

</div>
</body>
</html>