<%@page import="board.BoardBean"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp"/>
</head>
<body>
<%
	//해당 게시글번호를 통하여 게시글을 수정
	int num =Integer.parseInt(request.getParameter("num").trim());
	//하나의 게시글의 대한 정보를 리턴
	BoardDAO bdao =new BoardDAO();
	BoardBean bean =bdao.getOneUpdateBoard(num);
	String id = (String)session.getAttribute("id");
	String fileSysname = request.getParameter("fileSysname");
	String filename = request.getParameter("filename");
%>

<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<h2 class="text-center">게시글 수정</h2><p>&nbsp;</p>
		<form action="Board/fileUpdateUpload.jsp" method="post" enctype="multipart/form-data">
			<div class="table table-responsive">
					  <table class="table table-striped">
		 	<tr>
		 		<td class="danger">작성자</td>
		 		<td><%= bean.getWriter() %></td>
		 		<td class="danger">작성일</td>
		 		<td><%= bean.getReg_date() %></td>
		 	</tr>
		 	<tr>
		 		<td class="danger">제목</td>
		 		<td colspan="3"><input type="text"  class="form-control" name="subject" value="<%= bean.getSubject() %>"></td>
		 	</tr>
		 	
		 	<tr>
		 		<td class="danger">패스워드</td>
		 		<td colspan="3"><input type="password"  class="form-control" name="password"></td>
		 	</tr>
		 	<%
		 		if(filename.equals(null)){
		 	%>
		 	<tr>
		 		<td class="danger">첨부파일</td>
		 		<td>
		 		<input type="file" name="filename"  id="fileSelect">
		 		</td>
		 	</tr>
		 	<%
		 		} else {
		 	%>
			 <tr>
			 	<td class="danger">첨부파일</td>
			 	<td>
			 	<a href="#" id="hidename"><%= filename %></a>
			 	<a href="#" id="hideX" onclick="namehide()">&nbsp;&nbsp;x</a>
			 	<input type="hidden" name="fileOrgname" value="<%= filename %>">
			 	<input type="hidden" name="fileOrgsysname" value="<%= fileSysname %>">
			 	<input type="file" name="filename" id="fileSelect" style="float: left; display: none;" value="<%= bean.getSubject()%>">
			 	</td>
			 </tr>
		 	<% } %>
		 	<tr>
		 		<td class="danger">글내용</td>
		 		<td colspan="3"><textarea  name="content" class="form-control"><%= bean.getContent() %></textarea></td>
		 	</tr>
	
		  	<tr>	
		 		<td colspan="4"  class="text-center">
		 			<input type="hidden" name="num" value="<%= bean.getNum() %>">
		 			<input type="hidden" value="<%= fileSysname %>" name="fileSysname">
		 			<input type="hidden" name="id"  value="<%=id %>">
		 			<input type="submit" value="글수정" class="btn btn-warning">
		 			<input type="button"  class="btn btn-primary" onclick="location.href='index.jsp?page=Board/BoardList'" value="전체글보기">
		 		</td>
		 	</tr>
		  </table>
			</div>
		</form>	
	</div>
</div>
<script>
CKEDITOR.replace('content', {
		
	width:'100%',
	height:'350'
		
});

function namehide(){
	hidename.style.display = "none";
	hideX.style.display = "none";
	fileSelect.style.display = "";
}
</script>
</body>
</html>