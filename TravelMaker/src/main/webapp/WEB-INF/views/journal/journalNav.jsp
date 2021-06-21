<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <div id="journalNavContainer">
    <div id="navTitle">My Trip</div>
    	<ul>
    		<li><a href="${pageContext.request.contextPath}/journal/list?id=${id}">- 내 여행일지</a></li>
    		<li><a href="${pageContext.request.contextPath}/my/map?author=${id}">- 내 여행지도</a></li>
    		<li><a href="/MyTravel.do">- 회원정보</a></li>
    	</ul>
    </div>