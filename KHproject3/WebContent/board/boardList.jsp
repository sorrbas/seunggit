<%@page import="kr.or.kh.board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
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
	top: 300px; left: 590px;
	width: 340px; height: 80px;
	border: 5px solid skyblue;
	border-radius: 20px 20px 20px 20px;
	padding-top: 10px;
	
}

.kh01 {
	position : absolute;
	top: 20px; left: 260px;
	width: 60px; height: 40px;
}

#underTitle {
	position: absolute;
	top: 55px; left: 50px;
	
}
ul {
	list-style-type: none;
}

#boardResult {
	position: absolute;
	top: 450px;
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
}

.List {
	background-color: white;
	text-align: center;
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
			
			ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>)request.getAttribute("boardList");
			for(int i=0; i<boardList.size();i++){
			   BoardDTO boardDTO = boardList.get(i);	
			
			
			%>
		
		<tr>
		
		
		<td><%= boardDTO.getNo() %></td>
		<td><%= boardDTO.getTitle()%></td>
		<td><%= boardDTO.getContent()%> </td>
		<td><%= boardDTO.getAuthor()%></td>
		<td><%= boardDTO.getNal()%>
		<td><%= boardDTO.getReadCount()%></td>
		<td><a href ="boardDelete.bo?no=<%=boardDTO.getNo()%>">삭제</a></td>
		<!-- 주소를 가져오고 서블릿 내에서 삭제를 해주어야함 -->
		
		</tr>
		<%}%>		
		</table>
		<a href="index.jsp?page=board/boardSearchForm">검색</a>&nbsp;&nbsp;
		<a href="index.jsp?page=board/boardUpdateForm">수정</a>&nbsp;&nbsp;
		<a href="index.jsp?page=board/boardWrite" class="write">글쓰기</a>
		
		<!--<a href="index.jsp?page=boardWrite"><input type="image" src="images/register.jpg" class="register"></a>-->
	</div>
</body>
</html>