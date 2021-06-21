<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="Header">
	<div id="logo">Travel Maker</div>
	<!-- 로그인한 상태 -->
	<c:if test="${id != null }">
		<div id="header_right">
			<a href="${pageContext.request.contextPath}/journal/list?id=${id}" id = "logout">My Travel</a>
			<a href="/logout.do" id = "logout">로그아웃</a>
			<a href="${pageContext.request.contextPath}/journal/create?id=${id}" id = "logout">일지생성</a>
		</div>
	</c:if>
	<form id="searchForm" action="${pageContext.request.contextPath}/journal/journalSearch" method="post">
	<div id="main_search">
		<div id="main_searchbar">
			<input type="text" id="search_title" name="search_title" placeholder="제목"> 
			<input type="date" id="search_date" name="search_date"> 
			<input type="text" id="search_author" name="search_author" placeholder="작성자">
			<div id="search_btn">
				<i class="fas fa-search"></i>
			</div>
		</div>
	</div>
	</form>
</div>

<script>

$(document).ready(function() {
	    $("#search_btn").on("click", function(e) {
	    e.preventDefault();

	    $('#searchForm').submit();

	    });
	    $('#logo').on("click", function(){
	    	location.href="${pageContext.request.contextPath}/main";
	    });
	});

</script>