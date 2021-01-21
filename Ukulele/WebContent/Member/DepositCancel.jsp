<%@page import="license.LicenseDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%
	int apply_no = Integer.parseInt(request.getParameter("apply_no"));
	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
	LicenseDAO ldao = new LicenseDAO();
	ldao.depositCancel(apply_no);
%>
<script type="text/javascript">
location.href='../index.jsp?page=Member/MasterPageIndex&subpage=licenseManage&&pageNum=<%=pageNum%>'
</script>

