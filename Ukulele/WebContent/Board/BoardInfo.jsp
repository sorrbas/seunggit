<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp"/>
<style>
.btn {
     color: #fff;
     background-color: #007bff;
     border-color: #007bff;
}

.btn:hover {
     color: #fff;
     border-color: #0062cc;
}
</style>
</head>
<body>
<%
	int num =Integer.parseInt(request.getParameter("num").trim());//공백제거후 정수형으로 바뀜
	//데이터 베이스 접근
	BoardDAO bdao =new BoardDAO();
	//boardbean 타입으로 하나의 게시를 리턴
	BoardBean bean =bdao.getOneBoard(num);
	
%>

<div class="row">
	<div class="col-xs-2 col-md-2"></div>
	<div class="col-xs-8 col-md-8">
	<h2 class="text-center">게시글 보기</h2><p>&nbsp;</p>
	<div class="table table-responsive">
		<table class="table">
		<tr>
			<th class="success">글번호</th>
			<td><%= bean.getNum() %></td>
			<th class="success">조회수</th>
			<td><%= bean.getReadcount() %></td>
		</tr>
		  
		
		<tr>
			<th class="success">작성자</th>
			<td><%= bean.getWriter() %></td>
			<th class="success">작성일</th>
			<td><%= bean.getReg_date() %></td>
		</tr>
		
		<tr>
			<th class="success">이메일</th>
			<td colspan="3"><%= bean.getEmail() %></td>
		</tr>
		
		<tr>
			<th class="success">제목</th>
			<td colspan="3"><%= bean.getSubject() %></td>
		</tr>
		<%
 		if(bean.getFileBoardname() != null){
 			%>
		<tr>
			<th class="success">첨부파일</th>
			<td colspan="3"><a href="Board/fileDownload.jsp?fileBoardname=<%=bean.getFileBoardname()%>&fileBoardid=<%=bean.getFileBoardid()%>"><%= bean.getFileBoardname() %></a></td>
		</tr>
 		<% } %>
		<tr>
			<th class="success">글 내용</th>
			<td colspan="3"><%= bean.getContent() %></td>
		</tr>
		
		<tr>
			<td colspan="4" class="text-center">
			  <input type="button" class="btn btn-success"  value="답글 쓰기" 
onclick="location.href='index.jsp?page=Board/BoardReWriteForm&&num=<%=bean.getNum()%>&ref=<%=bean.getRef() %>&re_step=<%= bean.getRe_step() %>&re_level=<%=bean.getRe_level() %>'" >

			<input type="button" class="btn btn-info" value="수정하기" onclick="location.href='index.jsp?page=Board/BoardUpdateForm&num=<%= bean.getNum()%>&fileSysname=<%= bean.getFileBoardid()%>&filename=<%= bean.getFileBoardname()%>'">	  
			<input type="button" class="btn btn-danger" value="삭제하기" onclick="location.href='index.jsp?page=Board/BoardDeleteForm&num=<%= bean.getNum()%>&fileBoardid=<%= bean.getFileBoardid()%>'">
			<input type="button" class="btn" value="목록보기" onclick="location.href='index.jsp?page=Board/BoardList'">
			</td>
		</tr>
	
			
		
		</table>
	</div>
	
	</div>
</div>
</body>
</html>