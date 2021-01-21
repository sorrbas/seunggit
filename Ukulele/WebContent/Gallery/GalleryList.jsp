<%@page import="java.util.Vector"%>
<%@page import="file.FileDAO"%>
<%@page import="file.FileBean"%>
<%@page import="file.Paging"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/main.css?v=2">
<jsp:include page="Header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KHJSP</title>
<style>
#Gallery2 {
	float: left;
	position: relative;
	top: 100px;
	left: 250px;
}

.photo {
	width: 200px;
	height: 200px;
	margin: 10px;
}

.gal {
	display: inline-block;
}

#gal_line {
	display: flex;
}

#preview {
	display: flex;
}
</style>
</head>
<body>
	<%
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		FileDAO dao = new FileDAO();
		Paging paging = new Paging(pageNum);
		paging.setTotalCount(dao.getAllCount());
		Vector<FileBean> list = dao.selectAll(paging.getStartRow(), paging.getEndRow());
	%>
	<div class="row">
		<div class="col-xs-2"></div>
		<div class="col-xs-8 col-md-8">
			<h2 class="text-center">갤러리</h2>
			<p class="text-right">
				<input type="button" value="글쓰기"
					onclick="location.href='index.jsp?page=Gallery/GalleryWrite'"
					class="btn">
			</p>

<div>
			<%
						int j = 0;
						for (int i = 0; i < list.size(); i++) {
							FileBean bean = list.get(i); //벡터에 저장되어 있는 빈클래스를 하나씩 추출
					%>
			<%
				if(j%4==0){
					out.print("<div id='gal_line'>");
				}
			%>
				<table class="gal" border=1>
				<tr>
				<td colspan="3"><a id="preview"
				href="SelectOne?num=<%=bean.getNum()%>"><img
				src="Upload/<%=bean.getFileName() %>" class="photo"></a></td>
				</tr>
				<tr class="cc" style = "text-align: center;">
				<td><%=bean.getNum()%></td>
				<td><%=bean.getSubject()%></td>
				<td><%=bean.getWriter()%></td>
				</tr>
				</table>
			<%
				if(j%4 == 3){
					out.print("</div>");
				}
			j++;
						} 
			
			%>
		
	</div>
	</div>
	</div>
	</div>
	<tr>
		<td colspan="5" class="text-center"><nav style="text-align: center;">
			<ul class="pagination">
				<%
					if (paging.getStartPage() > 10) {
				%>

				<li><a
					href="selectService&&pageNum=<%=paging.getPrev()%>"
					aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				<%
					}
					for (int i = paging.getStartPage(); i <= paging.getEndPage(); i++) {
				%>
				<li
					<%if (i == Integer.parseInt(pageNum))
					out.print("class='active'");%>><a
					href="selectService?pageNum=<%=i%>"><%=i%> <span
						class="sr-only">(current)</span></a></li>
				<%
					}
					if (paging.getEndPage() < paging.getPageCount()) {
				%>
				<li><a href="selectService?pageNum=<%=paging.getNext()%>"
					aria-label="next"><span aria-hidden="true">&raquo;</span></a></li>
				<%
					}
				%>
			</ul>
			<p class="text-left">
			<form action="index.jsp?" method="get">
				<div class="search" style="position: center;">
					<input type="hidden" name="page" value="Gallery/GallerySearchProc">
					<select name="keyword"
						style="vertical-align: text-top; font-size: 12pt; text-align-last: center; width: 50px; height: 30px; background-color: #D4F4FA; color: black; border: 1px solid gray;">
						<option value="subject">제목</option>
						<option value="writer">작성자</option>
						<option value="content">내용</option>
					</select> <input type="text" name="search" autocomplete="off"
						style="vertical-align: sub; border: 1px solid #888ca5; border-width: 1 0 1 0; width: 150px; height: 30px; overflow: visible;">
					<input type="submit" value="검색" name="searchSubject" class="btn1"
						style="vertical-align: text-top; color: white; font-size: 12pt; width: 50px; height: 33px; background-color: #8C8C8C; border-width: 0 0 0 0;">
				</div>
			</form>
			</p>
			</nav></td>
	</tr>
</body>
</html>