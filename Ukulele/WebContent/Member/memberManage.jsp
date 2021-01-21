<%@page import="board.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="member.MemberBean"%>
<%@ page import="java.util.Vector"%>
<%@ page import="member.MemberDAO"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../Board/Header.jsp" />
<style>
.btn {
	background-color: gray;
	color: white;
}

</style>

</head>
<body>
	<%
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		MemberDAO mdao = new MemberDAO();

		Paging paging = new Paging(pageNum);

		paging.setTotalCount(mdao.getAllCount());

		Vector<MemberBean> vec = mdao.getAllMember(paging.getStartRow(), paging.getEndRow());
	%>

	<div class="row">
		<div class="col-xs-2"></div>
		<div class="col-xs-8 col-md-8">
			<h2 class="text-center">회원 관리</h2>

			<div class="table-responsive">
				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>email</th>
						<th>비밀번호</th>
						<th>자격증 신청 여부</th>
					</tr>

					<%
						for (int i = 0; i < vec.size(); i++) {
							MemberBean bean = vec.get(i); //벡터에 저장되어 있는 빈클래스를 하나씩 추출
					%>
					<tr>

						<td><%=bean.getId()%></td>
						<td><%=bean.getEmail()%></td>
						<td><%=bean.getPw() %></td>
						<td><%
							if(bean.getTrackingProgress()==0){
								out.print("미신청");
							}else if(bean.getTrackingProgress()==1){
								if(bean.getLicenseGrade()==1){
									out.print("1급 신청 : ");
								}else if(bean.getLicenseGrade()==2){
									out.print("2급신청 : ");
								}
								out.print("입금확인중");
							}else{
								if(bean.getLicenseGrade()==1){
									out.print("1급 신청 : ");
								}else if(bean.getLicenseGrade()==2){
									out.print("2급신청 : ");
								}
								out.print("입금완료");
							}
						%></td>
					</tr>
					<%
						}
					%>
					<tr>
						<td colspan="10" class="text-center">
							<nav>
								<ul class="pagination">
									<%
										if (paging.getStartPage() > 10) {
									%>
									<li><a
										href="index.jsp?page=Member/MasterPageIndex&subpage=memberManage&&pageNum=<%=paging.getPrev()%>"
										aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
									<%
										}
										for (int i = paging.getStartPage(); i <= paging.getEndPage(); i++) {
									%>
									<li
										<%if (i == Integer.parseInt(pageNum))
					out.print("class='active'");%>><a
										href="index.jsp?page=Member/MasterPageIndex&subpage=memberManage&&pageNum=<%=i%>"><%=i%>
											<span class="sr-only">(current)</span></a></li>
									<%
										}
										if (paging.getEndPage() < paging.getPageCount()) {
									%>
									<li><a
										href="index.jsp?page=Member/MasterPageIndex&subpage=memberManage&&pageNum=<%=paging.getNext()%>"
										aria-label="next"><span aria-hidden="true">&raquo;</span></a></li>
									<%
										}
									%>
								</ul>
							</nav>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
