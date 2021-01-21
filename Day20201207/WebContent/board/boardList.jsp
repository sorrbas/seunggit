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
	width: 800px;
}

table {
	border: 0px solid lightgray;
	border-collapse: collapse;
	width: 700px;
}

th {
	border: 1px solid lightgray;
	background-color: lightblue;
	color: white;
	border-bottom : 2px solid #0067A3;
}

.List {
	background-color: white;
	text-align: center;
}

.write {
	position: absolute;
	left: 100px;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<div id="boardList">
		<table border="1" cellspacing="0" cellpadding="0" class="List">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
				<th>&nbsp;</th>
			</tr>
			<%
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
				String sql = "select no,title,content,author,nal,readCount from boardNJ";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				int no = 0;
				String title = null;
				String content = null;
				String author = null;
				String nal = null;
				int readCount = 0;
				while (rs.next()) {
					no = rs.getInt("no");
					title = rs.getString("title");
					content = rs.getString("content");
					author = rs.getString("author");
					nal = rs.getString("nal");
					readCount = rs.getInt("readCount");
					out.print("<tr><td>" + no + "</td><td>" + title + "</td><td>" + content + "</td><td>" + author
							+ "</td><td>" + nal + "</td><td>" + readCount + "</td><td><a href=board/boardDelete.jsp?no="+no+">삭제</a></td></tr>");
				}
			%>
			
		</table>
		<a href="index.jsp?page=boardSearchForm">검색</a>&nbsp;&nbsp;
		<a href="index.jsp?page=boardUpdateForm">수정</a>&nbsp;&nbsp;
		<a href="index.jsp?page=board/boardWrite" class="write">글쓰기</a>
		
		<!--<a href="index.jsp?page=boardWrite"><input type="image" src="images/register.jpg" class="register"></a>-->
	</div>
</body>
</html>