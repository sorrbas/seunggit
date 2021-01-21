<%@page import="kr.or.kh.board.BoardDTO"%>
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
.kh01 {
   width: 100px;
   height: 50px;
}

ul {
   list-style-type: none;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
     
    
  
   <div id="boardUpdate">
   <%
   
    BoardDTO boardDTO = (BoardDTO)request.getAttribute("boardDTO");
    out.print("변경하기 전 내용입니다.<br>");
    out.print("번호="+boardDTO.getNo()+"제목="+boardDTO.getTitle()+"내용="+boardDTO.getContent()+"작성자="+boardDTO.getAuthor()+"날짜="+boardDTO.getNal()+"조회수="+boardDTO.getReadCount()+"<br>");
   
   %>
      <form action="boardUpdateFinal.bo" method="get">

         <ul>

            <li><label for="번호">번호</label> <input type="number" name="no"
               readonly="readonly" value="<%=boardDTO.getNo()%>"> <input type="hidden"
               name="no" value="<%=boardDTO.getNo()%>"></li>

            <li><label for="제목">제목</label> <input type="text" name="title"
               autofocus="autofocus" required="required"
               placeholder="변경할 제목을 입력해주세요."> <input type="hidden"
               name="titleSearch" value="<%=boardDTO.getTitle()%>"></li>

            <li><label for="내용">내용</label> <textarea rows="20" cols="80"
                  name="content" placeholder="변경할 내용을 입력해주세요."></textarea></li>

            <li><label for="작성자">작성자</label> <input type="text"
               name="author" placeholder="변경할 작성자를 입력해주세요."></li>

            <li><label for="날짜">날짜</label> <input type="date" name="nal"></li>

            <li><label for="조회수">조회수</label> <input type="text"
               name="readcount" placeholder="변경할 조회수를 입력해주세요."></li>

            <li><input type="image" src="images/update1.png"
               class="kh01"> <input type="reset" value="지우기"></li>
         </ul>

      </form>
   </div>
</body>
</html>