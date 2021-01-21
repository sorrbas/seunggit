<%@page import="board.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="license.LicenseBean"%>
<%@ page import="java.util.Vector"%>
<%@ page import="license.LicenseDAO"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../Board/Header.jsp" />
<style>
.btn {
	background-color: gray;
	color: white;
}
.depositCheck{
	display: inline-block;
	width: 100%;
}
.depositCheck form{
	display: inline-block;
}
</style>

</head>
<body>
	<%
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		LicenseDAO ldao = new LicenseDAO();

		Paging paging = new Paging(pageNum);

		paging.setTotalCount(ldao.getAllCount());

		Vector<LicenseBean> vec = ldao.getAllApply(paging.getStartRow(), paging.getEndRow());
	%>

	<div class="row">
		<div class="col-xs-2"></div>
		<div class="col-xs-8 col-md-8">
			<h2 class="text-center">자격증 신청 관리</h2>

			<div class="table-responsive">
				<table class="table table-striped">
					<tr>

						<th>신청번호</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>ID</th>
						<th>email</th>
						<th>주소</th>
						<th>생년월일</th>
						<th>신청등급</th>
						<th>신청일자</th>
						<th>입금 체크</th>
					</tr>

					<%
						for (int i = 0; i < vec.size(); i++) {
							LicenseBean bean = vec.get(i); //벡터에 저장되어 있는 빈클래스를 하나씩 추출
					%>
					<tr>

						<td><%=bean.getApply_no()%></td>
						<td><%=bean.getName()%></td>
						<td><%=bean.getTel()%></td>
						<td><%=bean.getLicense_id()%></td>
						<td><%=bean.getLicense_email()%></td>
						<td><%=bean.getAddr()%></td>
						<td><%=bean.getBirth()%></td>
						<td><%=bean.getGrade()%></td>
						<td><%=bean.getDate()%></td>
						<%
							if (bean.getTrackingProgress() == 1) {
						%>
						<td class="depositCheck">
						<form action="Member/Deposit.jsp" method="get">
							<input type="hidden" value="<%=bean.getApply_no()%>" name="apply_no">
							<input type="hidden" value="<%=pageNum%>" name="pageNum">
							<input type="submit" value="입금확인">
						</form>
						</td>
						<%
							} else if (bean.getTrackingProgress() == 2) {
						%>
						<td class="depositCheck">
						입금완료
						<form action="Member/DepositCancel.jsp" method="get">
							<input type="hidden" value="<%=bean.getApply_no()%>" name="apply_no">
							<input type="hidden" value="<%=pageNum%>" name="pageNum">
							<input type="submit" value="취소">
						</form>
						</td>
						<%
							}
						%>
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
										href="index.jsp?page=Member/MasterPageIndex&subpage=licenseManage&&pageNum=<%=paging.getPrev()%>"
										aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
									<%
										}
										for (int i = paging.getStartPage(); i <= paging.getEndPage(); i++) {
									%>
									<li
										<%if (i == Integer.parseInt(pageNum))
					out.print("class='active'");%>><a
										href="index.jsp?page=Member/MasterPageIndex&subpage=licenseManage&&pageNum=<%=i%>"><%=i%>
											<span class="sr-only">(current)</span></a></li>
									<%
										}
										if (paging.getEndPage() < paging.getPageCount()) {
									%>
									<li><a
										href="index.jsp?page=Member/MasterPageIndex&subpage=licenseManage&&pageNum=<%=paging.getNext()%>"
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
