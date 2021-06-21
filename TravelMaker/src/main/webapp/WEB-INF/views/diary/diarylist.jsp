<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="CONTEXT_PATH" value="${pageContext.request.contextPath}"
	scope="application" />
<c:set var="RESOURCES_PATH" value="${CONTEXT_PATH}/resources"
	scope="application" />
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://kit.fontawesome.com/395fa77f9c.js" crossorigin="anonymous"></script>
<link href="${CONTEXT_PATH}/resources/css/total.css" rel="stylesheet"/>
<link href="${CONTEXT_PATH}/resources/css/headerStatic.css" rel="stylesheet"/>
<link href="${CONTEXT_PATH}/resources/css/journal/journalNav.css" rel="stylesheet"/>

<style type="text/css">
#blank{
	height: 100px;
}
#diaryContentContainer{
	float: left;
    width: 70%;
    height: 100%;
}
</style>
</head>
<body>
	<div id="blank"></div>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="nav" />
	<tiles:insertAttribute name="content" />
</body>
</html>