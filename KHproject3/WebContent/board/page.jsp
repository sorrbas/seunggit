<%@page import="kr.or.kh.board.PageTo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>khjsp</title>
</head>
<body>

	<%
	    PageTo to = (PageTo)request.getAttribute("page");
		int cursorPage = to.getCursorPage();
		int perPage = to.getPerPage(); 
		int totalCount = to.getTotalCount();
		int totalPage = totalCount / perPage;   //보여줘야 할 페이지의 갯수
		if (totalCount % perPage != 0)
			totalPage++;
		for (int i = 1; i <= totalPage; i++) {
			if (cursorPage == i) {
				out.print("<font size=10 color='red'>" + i + "</font>");

			} else {
				out.print("<a href='boardList.bo?cursorPage=" + i + "'>" + i + "</a>&nbsp;");
			}
		}
	%>

</body>
</html>