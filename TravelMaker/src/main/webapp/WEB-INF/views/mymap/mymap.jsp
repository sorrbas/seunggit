<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="CONTEXT_PATH" value="${pageContext.request.contextPath}"
	scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 여행 지도</title>
<style type="text/css">
html, body{
	height:100%;
}
body{
	margin: 0px;
}
#journalContentContainer{
	height: 100%;
}

#myJournalList{
	height: 100%;
	display: flex;
	padding-top: 60px;
}
#diaryList{
	height: 100%;
	width: 0%;
	overflow-y:scroll;
}
#diaryList::-webkit-scrollbar {
    display: none;
}
#journalContent {
    height: 25%;
    padding: 30px;
    display: flex;
    background-color: #258FFF;
    color: white;
    width: 100%;
    position: relative;
}
#gotoMyJournalList{
	position: absolute;
    right: 40px;
}
#journalTitle{
	font-size: 40px;
    font-weight: bold;
    width: 100%;
    height: 100%;
    padding-top: 10%;
}
#journalDate{
	display: flex;
    width: 60%;
    top: 30px;
    height: 100%;
    padding-top: 16%;
}
#diaryContent{
	height: 75%;
    position: relative;
}
.diary {
    height: 33%;
    border-bottom: 1px solid lightblue;
    display: inline-block;
    width: 100%;
    position: relative;
}
.diaryTitle {
    margin-left: 40%;
    padding-top: 20px;
    padding-left: 20px;
    font-size: 40px;
}
.diaryDate {
    margin-left: 40%;
    padding-left: 20px;
    padding-right: 20px;
    text-align: right;
}
.diaryImgs {
    height: 100%;
    background-position: center;
    background-size: cover;
    position: absolute;
    width: 40%;
    top: 0px;
}
.diaryLink{
	position: absolute;
    bottom: 40px;
    right: 20px;
    text-decoration: none;
    color: black;
    font-size: 20px;
}
#map, #diaryList{
	-webkit-transition: width 0.5s, -webkit-transform 0.5s;
    transition: width 0.5s, transform 0.5s;
}

</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="${CONTEXT_PATH}/resources/css/headerStatic.css" rel="stylesheet"/>
<link href="${CONTEXT_PATH}/resources/css/total.css" rel="stylesheet"/>
<script src="https://kit.fontawesome.com/395fa77f9c.js" crossorigin="anonymous"></script>

</head>
<body>
	<div id="journalContentContainer">
		<tiles:insertAttribute name="header" />
		<div id="myJournalList">
			<div id="diaryList">
			<div id="journalContent">
				<div id="journalTitle" onclick="setMyMarkers()"></div>
				<div id="journalDate">
					<div id="startDate"></div>
					<div id="endDate"></div>
				</div>
				
			</div>
			<div id="diaryContent">
			
			</div>
			</div>
			<div id="map" style="width: 100%; height: 100%;"></div>
		</div>
	</div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d625053b0732bfe46e3b6a75cb7c220a&libraries=services"></script>
	<script>
		var checkOnce = 0;
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 12
		// 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		var arr = new Array();
		var ajaxData = new Array();
		var journalMarkers = [];
		var diaryMarkers= [];
		// 주소로 좌표를 검색합니다

		<c:forEach var="my" items="${myjournalList}">
		geocoder.addressSearch('${my.marker}', function(result, status) {
			// 정상적으로 검색이 완료됐으면 
			if (status === kakao.maps.services.Status.OK) {
				var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

				var marker = new kakao.maps.Marker({
					map : map, // 마커를 표시할 지도
					position : coords
				// 마커의 위치
				});
				journalMarkers.push(marker);
				map.setCenter(coords);
				// 마커에 표시할 인포윈도우를 생성합니다 
				var infowindow = new kakao.maps.InfoWindow({
					content : '${my.marker}'
				// 인포윈도우에 표시할 내용
				});
				
				// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
				// 이벤트 리스너로는 클로저를 만들어 등록합니다 
				kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map,
						marker, infowindow));
				kakao.maps.event.addListener(marker, 'mouseout',
						makeOutListener(infowindow));
				kakao.maps.event.addListener(marker,'click',function(){
					var params={
							journal_no : '${my.journal_no}'
					}
					 $.ajax({
			                type : "POST",            // HTTP method type(GET, POST) 형식이다.
			                url : "/my/list",      // 컨트롤러에서 대기중인 URL 주소이다.
			                data : params,            // Json 형식의 데이터이다.
			                success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
			                    if(checkOnce==0){			                    	
				                	$('#map').css('width','70%');
				                	$('#diaryList').css('width','30%');
				                	checkOnce = 1;
			                    }
			                	ajaxData = res;
			                	$('#diaryContent').text('');
		                    	$('#journalTitle').text(res.title.title);
		                    	$('#startDate').text(res.title.start_dt+'~');
		                    	$('#endDate').text(res.title.end_dt);
		                    	$('#journalContent').append('<div id="gotoMyJournalList" onclick="gotoMyJournal('+res.title.journal_no+')">내 여행일지</div>');
			                    for(var i = 0; i<res.mydiaryList.length; i++){
			                    	$('#diaryContent').append('<div class="diary"></div>');
			                    	$('.diary:eq('+i+')').append('<div class="diaryTitle" onclick="setDiaryMarker('+i+')">'+res.mydiaryList[i].title+'</div>');
			                    	$('.diary:eq('+i+')').append('<div class="diaryDate">'+res.mydiaryList[i].regdate+'</div>');
			                    	$('.diary:eq('+i+')').append('<div class="diaryImgs"></div>');
			                    	$('.diary:eq('+i+')').append('<a class="diaryLink" href="/diary/info?journal_no=${my.journal_no}&diary_no='+res.mydiaryList[i].diary_no+'">보러가기</a>');
			                    	var imglocs = res.mydiaryList[i].imglocs;
			                    	if(imglocs!='{"imglocs"}]}'){
			                    		var jsonImg = JSON.parse(imglocs);
			                    		$('.diaryImgs:eq('+i+')').css('background-image','url('+jsonImg.imglocs[0].imgloc+')');
			                    	}else{
			                    		$('.diaryImgs:eq('+i+')').css('background-image','url(${CONTEXT_PATH}/resources/img/noImage.gif)');
			                    	}
			                    }
//			                    $('#journaltitle').text(res.mydiaryList[0].title);
			                    console.log(res);
			                },
			                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
			                    alert("통신 실패.")
			                }
			            });
// 					var url = "${pageContext.request.contextPath}/my/list";
// 				    url = url + "?journal_no="+'${my.journal_no}';
// 					location.href = url;
				});
			}
		});
		</c:forEach>
		
		// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
		function makeOverListener(map, marker, infowindow) {
			return function() {
				infowindow.open(map, marker);
			};
		}

		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
			return function() {
				infowindow.close();
			};
		}
		function setDiaryMarker(i){
			var diaryMarker = ajaxData.mydiaryList[i].marker;
			var jsonmarker = JSON.parse(diaryMarker);
			setJournalMarkers(null);
			setDiaryMarkers(null);
			map.setLevel(4);
			for(var num=0; num<jsonmarker.markers.length; num++) {
			   var coords = new kakao.maps.LatLng(jsonmarker.markers[num].Ma, jsonmarker.markers[num].La);
			   // 결과값으로 받은 위치를 마커로 표시합니다
			   var marker = new kakao.maps.Marker({ map: map, position: coords });
			   map.setCenter(coords);
			   diaryMarkers.push(marker);
			}
		}
		function setMyMarkers(){
			map.setLevel(12);
			setDiaryMarkers(null);
			setJournalMarkers(map);
		}
		function setJournalMarkers(map) {
			   for (var i = 0; i < journalMarkers.length; i++) {
			       journalMarkers[i].setMap(map);
			   }            
		}
		function setDiaryMarkers(map) {
			   for (var i = 0; i < diaryMarkers.length; i++) {
			       diaryMarkers[i].setMap(map);
			   }
			   diaryMarkers=[];
		}
		function gotoMyJournal(journal_no){
			location.href='/journal/list?id=${id}';
		}
	</script>
</body>
</html>