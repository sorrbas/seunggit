<%@page import="board.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="board.BoardBean"%>
<%@ page import="java.util.Vector"%>
<%@ page import="board.BoardDAO"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp" />
<style>
.btn {
	background-color: gray;
	color: white;
}
a {
text-decoration: none;
}
</style>

</head>
<body>
	<%
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		BoardDAO bdao = new BoardDAO();

		Paging paging = new Paging(pageNum);

		paging.setTotalCount(bdao.getAllCount());

		Vector<BoardBean> vec = bdao.getAllBoard(paging.getStartRow(), paging.getEndRow());
	%>

	<div class="row">
		<div class="col-xs-2"></div>
		<div class="col-xs-8 col-md-8">
			<h2 class="text-center">자유게시판</h2>
			<p class="text-right">
				<input type="button" value="글쓰기"
					onclick="location.href='index.jsp?page=Board/BoardWrite'"
					class="btn">
			</p>

			<div class="table-responsive">
				<table class="table  table-striped">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>

					<%
						for (int i = 0; i < vec.size(); i++) {
							BoardBean bean = vec.get(i); //벡터에 저장되어 있는 빈클래스를 하나씩 추출
					%>
					<tr>
						<td><%=paging.getNumber() - i%></td>
						<td><a href="index.jsp?page=Board/BoardInfo&&num=<%=bean.getNum()%>">
								<%
									if (bean.getRe_step() > 1) {
											for (int j = 0; j < (bean.getRe_step() * 5); j++) {
								%> &nbsp; <%
 												}
 										}%> <%=bean.getSubject()%></a></td>
						<td><%=bean.getWriter()%></td>
						<td><%=bean.getReg_date()%></td>
						<td><%=bean.getReadcount()%></td>
					</tr>
					<%
						}
					%>
					<tr>
						<td colspan="5" class="text-center">
							<nav>
								<ul class="pagination">
									<%
										if (paging.getStartPage() > 10) {
									%>
									<li><a
										href="index.jsp?page=Board/BoardList.jsp&&pageNum=<%=paging.getPrev()%>"
										aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
									<%
										}
										for (int i = paging.getStartPage(); i <= paging.getEndPage(); i++) {
									%>
									<li
										<%if (i == Integer.parseInt(pageNum))
											out.print("class='active'");%>><a href="index.jsp?page=Board/BoardList&&pageNum=<%=i%>"><%=i%>
											<span class="sr-only">(current)</span></a></li>
										<%}
										if (paging.getEndPage() < paging.getPageCount()) {
										%>
									<li><a href="index.jsp?page=Board/BoardList&&pageNum=<%=paging.getNext()%>"
										aria-label="next"><span aria-hidden="true">&raquo;</span></a></li>
									<%}	%>
								</ul>
								<p class="text-left">
								<form action="index.jsp?" method="get">
								<div class="search" style="position: center;">
								<input type="hidden" name="page" value="Board/BoardSearchProc">
									<select name="keyword" style="vertical-align: text-top; font-size: 12pt; text-align-last: center; width: 70px; height: 30px; background-color: #D4F4FA; color: black; border: 1px solid gray;">
										<option value="subject">제목</option>
										<option value="writer">작성자</option>
										<option value="content">내용</option>
									</select> 
									<input type="text" name="search" autocomplete="off" style="vertical-align: sub; border: 1px solid #888ca5; border-width: 1 0 1 0; width: 150px; height: 30px; overflow: visible;">
									<input type="submit" value="검색" name="searchSubject" class="btn1"
										style="vertical-align: text-top; color: white; font-size: 12pt; width: 50px; height: 33px; background-color: #8C8C8C; border-width: 0 0 0 0;">
								</div>
								</form>
								</p>
							</nav>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
