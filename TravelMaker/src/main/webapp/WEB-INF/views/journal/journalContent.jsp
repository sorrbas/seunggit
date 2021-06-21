<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%String id = (String)session.getAttribute("id"); %>
<c:set var="CONTEXT_PATH" value="${pageContext.request.contextPath}"
	scope="application" />
<div id="journalContentContainer">
	<h1>내 여행일지</h1>
	<div id="myJournalList">
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
								<img src="${pageContext.request.contextPath}/resources/img/plus.png" class="plusBtn" onclick="openMenu(${status.index})">
								<div class="btn">
									<button type="button" value="${list.journal_no}" class="btnUpdate">수정</button>
									<button type="button" value="${list.journal_no}" class="btnDelete">삭제</button>
								</div>
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
	<div id="createJournalBox">+일지생성</div>
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

   $(document).on('click', '#createJournalBox', function(e){
      e.preventDefault();   
      location.href = "${pageContext.request.contextPath}/journal/create";
   });
   
   function openMenu(i){
       $('.btn:eq('+i+')').show();
       $('.plusBtn:eq('+i+')').hide();
   }
   function setImg(diarylist){
	   console.log(diarylist);
// 	   if(imglocs!='{"imglocs"}]}'){
//    		var jsonImg = JSON.parse(imglocs);
//    		$('.diaryImgs:eq('+i+')').css('background-image','url('+jsonImg.imglocs[0].imgloc+')');
//    	}else{
//    		$('.diaryImgs:eq('+i+')').css('background-image','url(${CONTEXT_PATH}/resources/img/noImage.gif)');
//    	}
   }
 //수정 버튼 클릭 이벤트
	$(document).on('click', '.btnUpdate', function(){
		var url = "${pageContext.request.contextPath}/journal/update";
		url = url + "?journal_no="+event.target.value;
		url = url + "&mode=edit";
		location.href = url;
	});
 
	//삭제 버튼 클릭 이벤트
	$(document).on('click', '.btnDelete', function(){
    var url = "${pageContext.request.contextPath}/journal/delete";
    url = url + "?journal_no="+event.target.value;
		location.href = url;
	});

	$(document).on('click', '.journal_title', function(){
	    var url = "${pageContext.request.contextPath}/diary/diarylist";
	    url = url + "?journal_no="+event.target.children[0].value;
			location.href = url;
	});
</script>