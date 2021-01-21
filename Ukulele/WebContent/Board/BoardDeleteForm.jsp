<%@page import="board.BoardDAO"%>
<%@page import="board.BoardBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp"/>
</head>
<body>
<%
	BoardDAO bdao=new BoardDAO();
	int num =Integer.parseInt(request.getParameter("num"));
	//하나의 게시글을 리턴
	BoardBean bean=bdao.getOneUpdateBoard(num);
	String id = (String)session.getAttribute("id");
	String fileBoardid = request.getParameter("fileBoardid");
	
%>
<div class="row">
 <div class="col-xs-2 col-md-2"></div>
 	<div class="col-xs-8 col-md-8">
 		<h2 class="text-center">글 삭제하기</h2><p>&nbsp;</p>
 		<form action="BoardDelete.bo" method="post">
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
	 			  	 <input type="hidden"  value="<%= num %>"  name="num" >
	 			  	 <input type="hidden"  value="<%= id %>"  name="id" >
	 			  	 <input type="hidden"  value="<%= fileBoardid %>" name="fileBoardid">
	 			  	 <input type="hidden" value="<%=bean.getRef() %>" name = "ref">
	 			  	 <input type="hidden" value="<%=bean.getRe_step() %>" name="re_step">
	 			  	 <input type="submit" value="글삭제" class="btn btn-danger">&nbsp;&nbsp;
	 			  	 <input type="button" class="btn btn-primary" onclick="location.href='index.jsp?page=Board/BoardList'" value="목록보기">
	 			  </td>
	 			</tr>
	 			
	 		 </table>
	 	   </div>
 		</form>
	 </div>
</div>
</body>
</html>






