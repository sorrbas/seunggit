<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pagefile = request.getParameter("subpage");
      if(pagefile == null){
    	  pagefile = "licenseGuidance";
      }
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
<style type="text/css">
	#bussiness_contant{
		display: flex;
	}
	#bussiness_contant #center{
		padding-left: 10%;
		width: 100%;
	}
	
	#bussiness_contant #left{
		width: 300px;
		text-align: center;
    	margin-top: 50px;
	}
</style>
</head>

<body>
<div id="bussiness_contant">
<div id="left">
	<jsp:include page="licenseLeft.jsp"/>
</div>

<div id="center">
	<jsp:include page='<%=pagefile+".jsp" %>'/>
</div>
</div>
</body>
</html>