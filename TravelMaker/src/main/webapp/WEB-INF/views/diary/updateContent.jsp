<%@page import="com.traveler.web.diary.mapper.DiaryMapper"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.net.*"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/summernote/summernote-lite.js"></script>
<script src="${pageContext.request.contextPath}/resources/summernote/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/summernote/summernote-lite.css">

<style>
@font-face {
 font-family: 'NanumBarunGothic';
 font-style: normal;
 font-weight: 400;
 src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot');
 src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot?#iefix') format('embedded-opentype'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.woff') format('woff'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.ttf') format('truetype');
}

.diaryUpdateContainer {
	width: 70%;
	margin-top: 100px;
	margin-left: 200px;
}

h1 {
	font-family: 'NanumBarunGothic';
	font-size: 35px;
}

.updateDiary {
	position: relative;
	width: 100%;
	margin-left: 15%;
}

label{
	font-family: 'NanumBarunGothic';
	font-size: 17px;
	width: 10%;
	float: left;
}

#box {
    font-family: 'NanumBarunGothic';
    position: relative;
    width: 80%;
    border: 0px;
    border-bottom: 2px solid rgb(198, 198, 199);
    margin-bottom: 10px;
    padding: 5px;
    text-size: 17px;
}

.map_wrap {
	width:100%; height:350px;
	margin-top: 30px;
	margin-bottom: 30px;
}

#map {
	position:relative;
	width: 90%; 
	height:500px; 
	overflow:hidden;
}

#menu_wrap {
   position:absolute;
   top:135px; left:0; bottom:0;
   width:230px;
   height:37px;
   margin:10px 0 30px 5px;
   padding:5px;
   overflow-y:auto;
   background:rgba(255, 255, 255, 0.7);
   z-index: 1;
   font-size:12px;
   border-radius: 10px;
}

.bg_white {
	background:#fff;
}

#menu_wrap hr {
	display: block; 
	height: 1px;
	border: 0; 
	border-top: 2px solid #5F5F5F;
	margin:3px 0;
}

#menu_wrap .option{
	text-align: center;
}

#menu_wrap .option p {
	margin:10px 0;
}  

#menu_wrap .option button {
	margin-left:5px;
}

#resetMarker {
	font-family: 'NanumBarunGothic';
	position: absolute;
	top: 185px;
	left: 5px;
	width: 80px;
	height: 25px;
	background-color: rgb(68, 96, 223);
	border: 0px;
	padding: 3px;
	border-radius: 7px;
	color: white;
	letter-spacing: 1px;
	z-index: 1;
}

.ck{
	position:relative;
	width: 90%;
	height: 500px;
	top: 150px;
}

#Btn {
	position: relative;
    float: left;
}

#upBtn {
    border: 2px solid rgb(198, 198, 199);
    background-color: white;
    border-radius: 5px;
    padding: 7px;
    margin-bottom: 10px;
    margin-top: 220px;
    font-family: 'NanumBarunGothic';
    font-size: 15px;
    font-weight: bold;
    letter-spacing: 1px;
}

#goList {
    border: 2px solid rgb(198, 198, 199);
    background-color: white;
    border-radius: 5px;
    padding: 7px;
    margin-bottom: 10px;
    margin-top: 20px;
    font-family: 'NanumBarunGothic';
    font-size: 15px;
    font-weight: bold;
    letter-spacing: 1px;
}

#goList a {
	text-decoration: none;
	color: black;
	}
</style>
</head>
<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=ebaa88a9f875faa0b1038d0b6682dfde&libraries=services"></script>
<body>
<div class="diaryUpdateContainer">
	<h1>다이어리 수정하기</h1>
		<div class="updateDiary">
			<form role="form" id="form" action="${pageContext.request.contextPath}/diary/update" method="post">
			<input type="hidden" name="journal_no" value="${diary.journal_no}">
			<div>
				<label>번호</label>
		    	<input name="diary_no" id="box" readonly="readonly" value='<c:out value="${diary.diary_no}"/>'>
			</div>
			<div>
				<label>제목</label>
				<input name="title" id="box" value='<c:out value="${diary.title}"/>'>
			</div>
			<div>
				<label>아이디</label>
				<input name="writer" id="box" readonly="readonly" value='<c:out value="${diary.writer}"/>'>
			</div>
			<div class="map_wrap">
		    	<div id="map"></div>
		    </div>
	    	<input type="hidden" id="marker" value='<c:out value="${diary.marker}"/>'>
			<div class="ck">
				<textarea id="summernote" name="diary"><c:out value="${diary.diary}"/></textarea>
			</div>
			<input type="hidden" id="smap" name="marker">
			<div id="Btn">
				<button id="upBtn">수정하기</button>
				<button id="goList"><a href='/diary/diarylist?journal_no=${diary.journal_no}'>목록으로</a></button>
			</div>
			</form>
			<div id="menu_wrap" class="bg_white">
			       <div class="option">
			           <div>
			               <form onsubmit="searchPlaces(); return false;">
			            키워드 : <input type="text" id="keyword" size="10"> 
			            <button type="submit">검색</button> 
			        </form>
			    </div>
			</div>
      	</div>
      	<button id="resetMarker">마커초기화</button>
		</div>
</div>
<script>
$(document).ready(function() {
    //여기 아래 부분
    $('#summernote').summernote({
		    	width: 1000,
		        height: 500,
				minHeight: null, // 최소 높이
				maxHeight: null, // 최대 높이
				focus: true, // 에디터 로딩후 포커스를 맞출지 여부
				lang: "ko-KR",	// 한글 설정
				placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
				callbacks : { 
                    onImageUpload : function(files, editor, welEditable) { // 파일 업로드(다중업로드를 위해 반복문 사용)
                 	for (var i = files.length - 1; i >= 0; i--) {
                  	uploadFile(files[i], this);
                         }
                   	}
                }
    	});
    //$('#summernote').summernote(setting);
});

	function uploadFile(file, el) {
	    data = new FormData();
	    data.append("file", file);
	    $.ajax({
	       data : data,
	       type : "POST",
	       url : "uploadFile",
	       contentType : false,
	       enctype : 'multipart/form-data',
	       processData : false,
	       success : function(data) {
	          $(el).summernote('editor.insertImage', data.url);
	       }
	    });
	 }
	 
	$(document).on('click', '#upBtn', function(e) {
	    sendsmap=sendsmap.substr(0, sendsmap.length -1);
	    sendsmap+="]}";
	    $("#smap").val(sendsmap);
	    
	    $("#form").submit();
	 });
	

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
	    center: new kakao.maps.LatLng(37.533934, 126.901143), // 지도의 중심좌표
	    level: 3 // 지도의 확대 레벨
	};  

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	var marker1 = $("#marker").val();
	var jsonmarker = JSON.parse(marker1); //json string을 json객체로 변환
	//console.log(marker);
	
	var markerSave = [];
	
	for(var num=0; num<jsonmarker.markers.length; num++){
	var coords = new kakao.maps.LatLng(jsonmarker.markers[num].Ma, jsonmarker.markers[num].La);
	
	 // 결과값으로 받은 위치를 마커로 표시합니다
	 var marker = new kakao.maps.Marker({
	     map: map,
	     position: coords
	 });
	 map.setCenter(coords);
	 
	 markerSave[num] = marker;
	}
	
	var reset = document.getElementById('resetMarker'); 
	reset.onclick = function() { 
		for(var num=0; num<jsonmarker.markers.length; num++){ //좌표의 갯수만큼 돌린다
			 markerSave[num].setMap(null);
			}
		}
	
	//장소 검색 객체를 생성합니다
	var ps = new kakao.maps.services.Places(); 
	
	//키워드 검색을 요청하는 함수입니다
	function searchPlaces() {
	
	    var keyword = document.getElementById('keyword').value;
	
	    if (!keyword.replace(/^\s+|\s+$/g, '')) {
	        alert('키워드를 입력해주세요!');
	        return false;
	    }
	    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
	    ps.keywordSearch( keyword, placesSearchCB); 
	}

	//장소검색이 완료됐을 때 호출되는 콜백함수 입니다
	function placesSearchCB(data, status, pagination) {
	    if (status === kakao.maps.services.Status.OK) {
	
	        // 정상적으로 검색이 완료됐으면 검색 목록과 마커를 표출합니다
	        displayPlaces(data);
	
	    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
	
	        alert('검색 결과가 존재하지 않습니다.');
	        return;
	
	    } else if (status === kakao.maps.services.Status.ERROR) {
	
	        alert('검색 결과 중 오류가 발생했습니다.');
	        return;
	
	    }
	}

	//검색 결과 목록과 마커를 표출하는 함수입니다
	function displayPlaces(places) {
	    fragment = document.createDocumentFragment(), 
	    bounds = new kakao.maps.LatLngBounds(), 
	    listStr = '';
	    
	    
	    for ( var i=0; i<places.length; i++ ) {
	
	        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x);
	
	        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해 LatLngBounds 객체에 좌표를 추가합니다
	        bounds.extend(placePosition);
	    }
	    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
	    map.setBounds(bounds);
	}

	//지도를 클릭했을때 클릭한 위치에 마커를 추가하도록 지도에 클릭이벤트를 등록합니다
	kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
	   // 클릭한 위치에 마커를 표시합니다 
	   
	   addMarker(mouseEvent.latLng);
	   savemarkers(mouseEvent.latLng);
	});
	var sendsmap = '{"markers":[';
	
	function savemarkers(position){
	    sendsmap+='{"Ma":"';
	    sendsmap+=position.Ma;
	    sendsmap+='","La":"';
	    sendsmap+=position.La;
	    sendsmap+='"},';
	}
	//지도에 표시된 마커 객체를 가지고 있을 배열입니다
	var markers = [];
	
	//마커를 생성하고 지도위에 표시하는 함수입니다
	function addMarker(position) {
	   
	   // 마커를 생성합니다
	   var marker = new kakao.maps.Marker({
	       position: position
	   });
	
	   // 마커가 지도 위에 표시되도록 설정합니다
	   marker.setMap(map);
	   // 생성된 마커를 배열에 추가합니다
	   markers.push(marker);
	}
	
	//배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
	function setMarkers(map) {
	   for (var i = 0; i < markers.length; i++) {
	       markers[i].setMap(map);
	   }            
	}
	
	$("#reset").on('click', function() {
		setMarkers(null);
	});
</script>
</body>
</html>