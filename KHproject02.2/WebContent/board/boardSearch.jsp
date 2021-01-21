<%@page import="kr.or.kh.board.BoardDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardSearch" class="kr.or.kh.board.BoardDAO" scope="page"/> <!--class는 객체를 생성해준다는 의미  -->
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

#boardSearch{
 position: absolute;
   top:300px;left:400px;
   width:1100px;
}




</style>
<meta charset="UTF-8">
<title>KHJSP</title>

</head>
<body>
<%

BoardDTO boardDTO = (BoardDTO)request.getAttribute("boardDTO");
boardSearch.boardReadCount(boardDTO);
%>
<div id="boardSearch">
<table border ="1" cellspacing="0" cellpadding="0">

<tr>
   <th>번호</th>
   <th>제목</th>
   <th>내용</th>
   <th>작성자</th>
   <th>날짜</th>
   <th>조회수</th>
   <th>&nbsp;</th>
   </tr>
   <tr>
     <td><%=boardDTO.getNo() %></td>
     <td><%=boardDTO.getTitle() %></td>
     <td><%=boardDTO.getContent() %></td>
     <td><%=boardDTO.getAuthor() %></td>
     <td><%=boardDTO.getNal() %></td>
     <td><%=boardDTO.getReadCount() %></td>
</table>
<a href="boardList.bo">게시판목록</a>
</div>
</body>
</html>