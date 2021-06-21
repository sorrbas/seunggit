<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div id="searchContentContainer">
	<h1>여행일지 검색</h1>
	<div id="searchJournalList">
		<table>
			<tbody>
				<c:choose>
					<c:when test="${empty journalList }">
						<tr>
							<td colspan="4" align="center">데이터가 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${!empty journalList}">
						<c:forEach var="list" items="${journalList}" varStatus="status">
						<div class="plus">
						<div class="section1">
							<div class="bigTitle">
								<div id="title" class="journal_title"><c:out value="${list.title}" /><input type="hidden" value="${list.journal_no}"></div>
								<div id="author"><c:out value="${list.author}"/></div>
							</div>
							<div class="bigReply">
								<div id="regdate"><c:out value="${list.start_dt}" /> ~ <c:out value="${list.end_dt}" /></div>								
								<img src="${pageContext.request.contextPath}/resources/img/view.png" id="viewImg">
								<div id="view"><c:out value="${list.view_cnt}" /></div>
							</div>
						</div>
						<c:forEach var="i" begin="0" end="2">
							<input type='hidden' class='imglocs' value='${diarylist[status.index][i].imglocs}'>
						</c:forEach>
						<div class="section2">
							<div class="img"></div>
							<div class="img"></div>
							<div class="img"></div>
						</div>
						</div>
						</c:forEach>
					</c:when>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>

<script>
$(document).ready(function() {
	for(var i=0; i<$('.imglocs').length; i++){
		var imgloc=$('.imglocs:eq('+i+')').val();
		if(imgloc!='{"imglocs"}]}'&&imgloc!=''){
			console.log(imgloc);
			var jsonImg = JSON.parse(imgloc);
			$('.img:eq('+i+')').css('background-image','url('+jsonImg.imglocs[0].imgloc+')');
		}else{
			$('.img:eq('+i+')').css('background-image','url(${CONTEXT_PATH}/resources/img/noImage.gif)');
		}
	}
});
	$(document).on('click', '.journal_title', function(){
	    var url = "${pageContext.request.contextPath}/diary/diarylist";
	    url = url + "?journal_no="+event.target.children[0].value;
			location.href = url;
	});
</script>