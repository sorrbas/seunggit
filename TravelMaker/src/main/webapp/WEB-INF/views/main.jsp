<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 공통변수 처리 -->
<c:set var="CONTEXT_PATH" value="${pageContext.request.contextPath}"
	scope="application" />
<c:set var="RESOURCES_PATH" value="${CONTEXT_PATH}/resources"
	scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${CONTEXT_PATH}/resources/js/header.js"></script>
<script src="https://kit.fontawesome.com/395fa77f9c.js" crossorigin="anonymous"></script>
<link href="${CONTEXT_PATH}/resources/css/mainContent.css" rel="stylesheet"/>
<link href="${CONTEXT_PATH}/resources/css/total.css" rel="stylesheet"/>
<link href="${CONTEXT_PATH}/resources/css/header.css" rel="stylesheet"/>
<title>Travel Maker</title>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="page_content">
		<tiles:insertAttribute name="content" />
	</div>
	<tiles:insertAttribute name="foot" />
</body>
</html>