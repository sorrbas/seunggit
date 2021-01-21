<%@page import="notice.NoticeBean"%>
<%@page import="notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp"/>
</head>
<body>
<%
	int num =Integer.parseInt(request.getParameter("num").trim());//공백제거후 정수형으로 바뀜
	//데이터 베이스 접근
	NoticeDAO bdao =new NoticeDAO();
	NoticeBean bean =bdao.getOneNotice(num);
	
%>
 <%
   String id = (String)session.getAttribute("id"); 
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
 		if(bean.getFilename() != null){
 			%>
		<tr>
			<th class="success">첨부파일</th>
			<td colspan="3"><a href="notice/fileDownload.jsp?filename=<%=bean.getFilename()%>&fileSysname=<%=bean.getFileSysname()%>"><%= bean.getFilename() %></a></td>
		</tr>
 		<% } %>
		<tr>
			<th class="success">글 내용</th>
			<td colspan="3"><%= bean.getContent() %></td>
		</tr>
		<tr>
			<td colspan="4" class="text-center">
<%
	if(session.getAttribute("id").equals("1111")){
%>
	<input type="button" class="btn btn-warning" value="수정하기" 
	onclick="location.href='index.jsp?page=notice/NoticeUpdateForm&num=<%= bean.getNum()%>&fileSysname=<%= bean.getFileSysname()%>&filename=<%= bean.getFilename()%>'">		  
	<input type="button" class="btn btn-danger" value="삭제하기" 
	onclick="location.href='index.jsp?page=notice/NoticeDeleteForm&num=<%= bean.getNum()%>&fileSysname=<%= bean.getFileSysname()%>'">
<% } %>
	<input type="button" class="btn btn-primary" value="목록보기" 
	onclick="location.href='index.jsp?page=notice/NoticeList'">
			</td>
		</tr>
	</table>
	</div>
	</div>
</div>
</body>
</html>