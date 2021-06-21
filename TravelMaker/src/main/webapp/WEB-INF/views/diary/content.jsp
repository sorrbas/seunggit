 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% int journal_no = Integer.parseInt(request.getParameter("journal_no")); %>
<!DOCTYPE html>
<html>
<head>
<style>
@font-face {
    font-family: 'Chosunilbo_myungjo';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/Chosunilbo_myungjo.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@font-face {
    font-family: 'KOTRA_BOLD-Bold';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-10-21@1.1/KOTRA_BOLD-Bold.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {
    font-family: 'KCC-eunyoung';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/KCC-eunyoung-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

#diaryContentContainer{
	float: left;
    width: 70%;
    height: 100%;
    position: relative;
}

h2 {
	font-size: 35px;
}

#myDiaryList {
	float: left;
    width: 70%;
    height: 100%;
}

#createDiaryBox {
	font-family: 'NanumBarunGothic';
	letter-spacing: 2px;
	float: left;
    width: 30%;
    background-color: #258FFF;
    color: white;
    font-size: 50px;
    font-weight: bold;
    text-align: center;
    padding: 30px 15px;
    border-radius: 20px;
    position: absolute;
    right: 5%;
}

.section {
     position: relative;
     width: 600px; height: 300px;
}
.section1 {
    width:56%;
    margin: 2%;
    height: 92%;
    float: left;
}
.section2 {
    width: 38%;
    margin-right: 2%;
    margin-top: 2%;
    height: 92%;
    float: left;
    overflow: hidden;
}

#image {
    position: relative;
    width: 100%;
    height: 100%;
    border-radius: 5px;
}
.section2 ul {
    margin: 0;
    padding: 0;
    margin-top: 25px;
}

.section2 ul li {
    width: 100%;
    list-style-type: none;
}
#title{
    font-family: 'KOTRA_BOLD-Bold';
    height: 30px;
    text-align: center;
    margin-top: 4%;
    font-size: 24px;
    font-weight: bold;
}
#title a{ 
	color: black;
	text-decoration: none;
}

#writer{
    font-family: 'KCC-eunyoung';
    text-align: center;
    color: rgb(8, 57, 218)
}
#regdate{
    text-align: right;
    margin-top: 6%;
    font-size: 12px;
    color: rgb(167, 165, 165);
}
#diary{
    font-family: 'Chosunilbo_myungjo';
    line-height: 20px;
    font-weight: bold;
    width: 96%;
    margin: 3%;
    font-size: 14px;
}
p{
	margin: 0px;
}
img{
	display: none;
}
#Btn{
float: right;
}
.thumbnail{
	width: 200px;
	height: 200px;
	background-position: center;
    background-size: cover;
    background-repeat: no-repeat;
}
</style>
<meta charset="UTF-8">
<title>diary</title>
<!--jquery와 4버전부터 지원되는 popper.js를 사용하려면 추가-->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
</script>
<!-- <link rel="stylesheet" href="/resources/css/bootstrap1.min.css"> -->

</head>
<body>
	<div id="diaryContentContainer">
	<h2>내 여행일기</h2>
	<div id="myDiaryList">
    <c:forEach items="${diarylist}" var="diary" varStatus="status">
	<div class="section">
		<div class="section1">
            <div class="thumbnail" id="image"></div>
		</div>
		<div class="section2">
	        <ul>
	            <li id="title">
	            	<a class='move' href='<c:out value="${diary.diary_no}"/>'>
	            	<c:out value="${diary.title}"/></a>
	            </li>
	            <li id="writer">by ${diary.writer}</li>
	            <li id="regdate">${diary.regdate}</li>
	            <li id="diary">${diary.diary}</li>
	        </ul>
        </div>
    </div>
    </c:forEach>
	
	<form id="actionForm" action="/diary/diarylist" method='get'>
	<input type="hidden" name="journal_no" value="<%=journal_no%>">
	</form>
	</div>
	<div id="createDiaryBox">+일기작성</div>
	</div>
<script>
 	$(document).ready(function() {
 		
	$(document).on('click', '#createDiaryBox', function(e){
	    e.preventDefault();   
	    location.href = "write?journal_no="+<%=journal_no%>;
	 });
	
	 var actionForm = $("#actionForm");
	 $(".move").on("click", function(e){
	    	e.preventDefault();
	    	
	    	var targetdiary_no = $(this).attr("href");
	    	console.log(targetdiary_no);
	    	
	    	actionForm.append("<input type='hidden' name='diary_no' value='"+targetdiary_no+"'>'");
	    	actionForm.attr("action", "/diary/info").submit();
	    	
	    });
	 
	 	var arr = new Array(); //imglocs전체 배열 
	 	var imglist = new Array(); //첫번째 사진의 경로를 담은 배열
	    <c:forEach items="${diarylist}" var="diary"> //db를 가져왔어
	  	if('${diary.imglocs}'!='{"imglocs"}]}'){ //사진이 있는경우
	  		arr.push('${diary.imglocs}'); //사진의 경로를 arr에 넣어준다 아직 형태는 json string
	  	}else{ //없는경우
	  		arr.push('{"imglocs":[{"imgloc":"${CONTEXT_PATH}/resources/img/noImage.gif"}]}'); //noimage가 뜬다
	  	}
	  </c:forEach>
	  
	  for(var i=0; i<arr.length; i++){   
		  var jsonimg = JSON.parse(arr[i]); //json string을 json객체로 변환을 하고
		  imglist.push(jsonimg.imglocs[0].imgloc); //변환한 경로들 중 첫번째 경로의 첫번째 사진을 imglist에 넣어준다.
//		  console.log(jsonimg.imglocs[0].imgloc);
	  } // 현재 imglist에는 각 게시글의 첫번째 사진의 경로가 순서대로 저장되어있다.
	  console.log(imglist);
	  for(var i=0; i<imglist.length; i++){
	  	$('.thumbnail').eq(i).css('background-image','url('+imglist[i]+')'); //thumbnail i번째 요소의 src 속성을 첫번째 사진의 경로로 바꿔준다.
	  }
	});
</script>
</body>
</html>