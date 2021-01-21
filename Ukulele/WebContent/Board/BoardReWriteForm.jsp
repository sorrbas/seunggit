<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp"/>
</head>
<body>
<%
	//http://localhost:8090/Board/BoardReWriteForm.jsp?num=1&ref=1&ref_step=1&ref_level=1
	//게시글 읽기해서 답변글쓰기를 클릭하면 넘겨주는 데이터를 받아줌
	int num =Integer.parseInt(request.getParameter("num"));
	int ref =Integer.parseInt(request.getParameter("ref"));
 	int re_step =Integer.parseInt(request.getParameter("re_step"));
 	int re_level =Integer.parseInt(request.getParameter("re_level"));
	String id = (String)session.getAttribute("id");
	String pw = (String)session.getAttribute("pw");
	String email = (String)session.getAttribute("email");
%>


<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<h2 class="text-center">답변글 입력하기</h2><p></p>
		<form action="BoardReWrite.bo" method="post">
			<div class="table table-responsive">
					  <table class="table table-striped">
		 	<tr>
		 		<td>작성자</td>
		 		<td><input type="text"  class="form-control" name="writer" value="<%=id%>" readonly="readonly"></td>
		 	</tr>
		 	<tr>
		 		<td>제목</td>
		 		<td><input type="text"  class="form-control" name="subject" value="┗[답변]"></td>
		 	</tr>
		 	<tr>
		 		<td>이메일</td>
		 		<td><input type="email"  class="form-control" name="email" value="<%=email%>" readonly="readonly"></td>
		 	</tr>
		 			 	
		 	<tr>
		 		<td>글내용</td>
		 		<td><textarea rows="10" cols="50" name="content" class="form-control"></textarea></td>
		 	</tr>
		  	<tr>	
		 		<td colspan="2"  class="text-center">
		 		
		 			<input type="hidden" name="num"  value="<%= num %>">
			 		<input type="hidden" name="ref"  value="<%= ref %>">
			 		<input type="hidden" name="re_step"  value="<%= re_step %>">
			 		<input type="hidden" name="re_level"  value="<%= re_level %>">
		 		
		 			<input type="submit" value="답글쓰기완료" class="btn btn-success">
		 			<input type="reset" value="취소" class="btn btn-warning">
		 			<input type="button"  class="btn btn-primary" onclick="location.href='index.jsp?page=Board/BoardList'" value="전체글보기">
		 		</td>
		 	</tr>
		 	
		  </table>
		 	<input type="hidden"  class="form-control" name="password" value="<%=pw%>">
			</div>
		</form>	
	</div>
</div>
</body>
</html>




