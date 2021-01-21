<%@page import="java.util.ArrayList"%>
<%@page import="file.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="file.FileBean"%>
<%-- <%@ page import="java.util.Vector"%> --%>
<%@ page import="file.FileDAO"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp" />
<jsp:useBean id="filebean" class="file.FileBean">
 <jsp:setProperty name="filebean" property="*" />
</jsp:useBean>
<style>
.btn {
	background-color: gray;
	color: white;
}

a {
text-decoration: none;
}
#Gallery2 {
	float: left;
	position: relative;
	top: 100px;
	left: 250px;
}

.photo {
	width: 200px;
	height: 200px;
	border: 1px solid pink;
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
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String pageNum = request.getParameter("pageNum");
		
		if (pageNum == null || pageNum == "0") {
			pageNum = "1";
		}
		
		int pageList = 16;
		
		String keyword = request.getParameter("keyword");
		if(keyword.equals("제목")){
			keyword="subject";
		}
		else if(keyword.equals("작성자")){
			keyword="writer";
		}
		else if(keyword.equals("내용")){
			keyword="content";
		}
		
		String searchSubject = request.getParameter("search");
		int pageNum1 = Integer.parseInt(pageNum);
		
		FileDAO bdao = new FileDAO();
		
		Paging paging = new Paging(pageNum);

		paging.setTotalCount(bdao.getCount(searchSubject,keyword));

		ArrayList<FileBean> vec = bdao.searchGallery(pageNum1, pageList, searchSubject, keyword);
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
			if(vec.size()>0){
						int k = 0;
						for (int i = 0; i < vec.size(); i++) {
							FileBean bean = vec.get(i); //벡터에 저장되어 있는 빈클래스를 하나씩 추출
					%>
			<%
				if(k%4==0){
					out.print("<div id='gal_line'>");
				}
			%>
				<table class="gal" border=1>
				<tr>
				<td colspan="4"><a id="preview"
				href="SelectOne?num=<%=bean.getNum()%>"><img
				src="Upload/<%=bean.getFileName() %>" class="photo"></a></td>
				</tr>
				<tr class="lll">
				<td><%=paging.getNumber() - i%></td>
				<td><a href="SelectOne?num=<%=bean.getNum()%>">
				<%=bean.getSubject() %></a></td>
				<td><%=bean.getNum()%></td>
				<td><%=bean.getWriter()%></td>
				</tr>
				</table>
			<%
				if(k%4 == 3){
					out.print("</div>");
				}
			k++;
						}		 
			
			%>
		
	</div>
	
					<%
						
						}else{
							out.println("<tr><td colspan='6'>게시글이 없습니다.</td></tr>");
						}
							
					%>
					<tr>
						<td colspan="5" class="text-center">
							<nav style="text-align:center;">
								<ul class="pagination">
									<%
										if (paging.getStartPage() > 10) {
									%>
									<li><a
										href="index.jsp?page=Gallery/GallerySearchProc&keyword=<%=keyword%>&search=<%=searchSubject %>&pageNum=<%=paging.getPrev()%>"
										aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
									<%
										}
										for (int i = paging.getStartPage(); i <= paging.getEndPage(); i++) {
									%>
									<li
										<%if (i == Integer.parseInt(pageNum))
											out.print("class='active'");%>><a href="index.jsp?page=Gallery/GallerySearchProc&keyword=<%=keyword%>&search=<%=searchSubject %>&pageNum=<%=i%>"><%=i%>
											<span class="sr-only">(current)</span></a></li>
										<%}
										if (paging.getEndPage() < paging.getPageCount()) {
										%>
									<li><a href="index.jsp?page=Gallery/GallerySearchProc&keyword=<%=keyword%>&search=<%=searchSubject %>&pageNum=<%=paging.getNext()%>"
										aria-label="next"><span aria-hidden="true">&raquo;</span></a></li>
									<%}	%>
								</ul>
								<p class="text-left">
								<input type="button" value="목록" name="list" class="btn1" onclick="location.href='selectService'"
										style="vertical-align: text-top; color: white; font-size: 12pt; width: 50px; height: 33px; background-color: #8C8C8C; border-width: 0 0 0 0;">
								</p>
							</nav>
						</td>
					</tr>
				
			
		</div>
	</div>
</body>
</html>
