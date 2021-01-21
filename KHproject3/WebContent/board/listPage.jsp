<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">

#boardlist{
  position: absolute;
  top:300px;left:400px;
}
</style>



<title>khjsp</title>
</head>
<body>
	<div id="boardlist">

		<h1>커뮤니티목록</h1>
		<table border="1" cellspacing="0" cellpadding="0">
			<tr>

				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
				<th>&nbsp;</th>

			</tr>
			<c:forEach items="${list}" var="board">
				<tr>
					<td><a href="editForm.bo?no=${board.no }">${board.no }</a></td>

					<td>${board.title }</td>
					<td>${board.content }</td>
					<td>${board.author }</td>
					<td>${board.nal }</td>
					<td>${board.readCount }</td>
					<td><a href="boardDelete.bo?no=${board.no }">삭제</a></td>


				</tr>
			</c:forEach>
			<tr>

				<td colspan="7"><jsp:include page="page.jsp" flush="true" /></td>


			</tr>

		</table>


		<a href="index.jsp?page=board/boardWrite">글쓰기</a>&nbsp; <a
			href="index.jsp?page=board/boardSearchForm">검색</a>&nbsp; <a
			href="index.jsp?page=board/boardUpdateForm">수정</a>&nbsp;

	</div>

</body>
</html>