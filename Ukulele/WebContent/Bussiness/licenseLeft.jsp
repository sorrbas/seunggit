<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	#bussiness_menu{
		
	}
	#liner{
		border: 3px gray solid;
    	border-radius: 3px;
    	margin: 15px 0px;
	}
	#left_cover{
	margin: 20px 50px;
	}
</style>
</head>
<body>
<div id="left_cover">
<h1>자격증</h1>
<div id="liner"></div>
<ul id="bussiness_menu">
<li><a href="index.jsp?page=Bussiness/licenseIndex&subpage=licenseGuidance" id="guidance">자격증 정보</a></li>
<li><a href="index.jsp?page=Bussiness/licenseIndex&subpage=applyLicenseGuidance" id="apply" onclick="sessioncheck()">자격증 신청</a></li>
</ul>
</div>
<script type="text/javascript">
function sessioncheck() {
	if(<%=session.getAttribute("id")%>==null){
		alert("먼저 로그인 해주세요.");
		event.preventDefault();
	}
}
</script>
	
</body>
</html>