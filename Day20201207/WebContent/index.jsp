<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String pagefile = request.getParameter("page");
	if (pagefile == null) {
		pagefile = "kh";
	}
%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#top {
	position: absolute;
	top: 0px;
	left: 400px;
	/*border : 1px solid red;*/
}

#bottom {
	position: absolute;
	top: 800px;
	left: 400px;
	border: 0px solid skyblue;
	background-color: pink;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<div id="top">
		<jsp:include page="top.jsp" /> <!-- jsp:include는 불러온다고 생각하면 된다. -->
	</div>
	<div id="left">
		<jsp:include page="left.jsp" />
	</div>
	<div id="center">
		<jsp:include page='<%=pagefile + ".jsp"%>' />
	</div>
	<div id="bottom">
		<jsp:include page="bottom.jsp" />
	</div>
</body>
</html>