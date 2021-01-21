<%@page import="notice.NoticeBean"%>
<%@page import="notice.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp"/>
</head>
<body>
<%
	NoticeDAO ndao = new NoticeDAO();
	int num = Integer.parseInt(request.getParameter("num"));
	//하나의 게시글을 리턴
	NoticeBean bean = ndao.getOneUpdateNotice(num);
	String fileSysname = request.getParameter("fileSysname");
%>
<div class="row">
 <div class="col-xs-2 col-md-2"></div>
 	<div class="col-xs-8 col-md-8">
 		<h2 class="text-center">글 삭제하기</h2><p>&nbsp;</p>
 		<form action="NoticeDelete.no" method="post">
 		  <div class="table table-responsive">
	 		<table class="table">
	 			<tr>
	 				<td class="danger">작성자</td>
	 				<td><%= bean.getWriter() %></td>
	 				<td class="danger">작성일</td>
	 				<td><%= bean.getReg_date() %></td>
	 			</tr>
	 			<tr>
	 			  <td class="danger">제목</td>
	 			  <td colspan="3"><%= bean.getSubject() %></td>
	 			</tr>
	 			
	 			<tr>
	 			 <td class="danger">패스워드</td>
	 			 <td><input type="password" name="password"  class="form-control"></td>
	 			</tr>
	 			
	 			<tr>
	 			  <td colspan="4" class="text-center">
	 			  	 <input type="hidden" value="<%= num %>" name="num" >
	 			  	 <input type="hidden" value="<%= fileSysname %>" name="fileSysname">  
	 			  	 <input type="submit" value="글삭제" class="btn btn-danger">&nbsp;&nbsp;
	 			  	 <input type="button" class="btn btn-primary" onclick="location.href='index.jsp?page=notice/NoticeList'" value="목록보기">
	 			  </td>
	 			</tr>
	 			
	 		 </table>
	 	   </div>
 		</form>
	 </div>
</div>
</body>
</html>






