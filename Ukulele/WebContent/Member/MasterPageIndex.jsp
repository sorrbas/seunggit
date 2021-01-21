<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String pagefile = request.getParameter("subpage");
      if(pagefile == null){
    	  pagefile = "licenseManage";
      }
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>관리자페이지</title>
<style type="text/css">
	
	#master_contant #left{
		width: 300px;
		text-align: center;
    	margin-top: 50px;
	}
</style>
</head>
<body>
<div id="master_contant">

<div id="center">
	<jsp:include page='<%=pagefile+".jsp" %>'/>
</div>
</div>
</body>
</html>