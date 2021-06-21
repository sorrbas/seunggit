<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.net.*"%>
<% int journal_no = Integer.parseInt(request.getParameter("journal_no")); %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/summernote/summernote-lite.js"></script>
<script src="${pageContext.request.contextPath}/resources/summernote/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/summernote/summernote-lite.css">
<!-- <link rel="stylesheet" href="/resources/css/bootstrap1.min.css"> -->

<style>
@font-face {
 font-family: 'NanumBarunGothic';
 font-style: normal;
 font-weight: 400;
 src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot');
 src: url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.eot?#iefix') format('embedded-opentype'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.woff') format('woff'), url('//cdn.jsdelivr.net/font-nanumlight/1.0/NanumBarunGothicWeb.ttf') format('truetype');
}
.big{
	width: 70%;
	margin-top: 100px;
	margin-left: 200px;
}

h1{
	font-family: 'NanumBarunGothic';
	font-size: 35px;
}

.write {
   position: relative;
   width: 100%;
   margin-left: 15%;
}
label{
   font-family: 'NanumBarunGothic';
   font-size: 17px;
    width: 10%; /*50px*/
    float: left;
}

#box {
   font-family: 'NanumBarunGothic';
    position: relative;
    width: 80%; /*950*/
    border: 0px;
    border-bottom: 2px solid rgb(198, 198, 199);
    margin-bottom: 10px;
    padding: 5px;
}

#regdate {
   width: 220px;
   position: relative;
   border: 0px;
   border-bottom: 2px solid rgb(198, 198, 199);
   margin-bottom: 5px;
   padding: 3px;
}

.map_wrap {
    width:100%; height:350px;
    margin-top: 30px;
    margin-bottom: 30px;
}

#map {
   position:relative;
   width:90%; 
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

#Btn {
	position: relative;
    float: left;
}
#btnsave {
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

#rewrite {
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

.ck{
	position:relative;
	width: 90%;
	height: 500px;
	top: 150px;
}

</style>
</head>
<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=ebaa88a9f875faa0b1038d0b6682dfde&libraries=services"></script>
<body>
<div class="big">
   <h1>여행일기 작성</h1>
   <div class="write">
      <form role="form" id="form" action="${pageContext.request.contextPath}/diary/write" method="post">
         <input type="hidden" name="journal_no" value="<%=journal_no%>">
         <div>
            <label>제목</label>
            <input name="title" id="box" required="required">
         </div>
         <div>
            <label>아이디</label>
            <input name="writer" id="box" required="required">
         </div>
         <div>
            <label>날짜</label>
            <input type="date" id="regdate" name="regdate">
            <input type="hidden" id="smap" name="marker">
         </div>
         <div class="map_wrap">
              <div id="map"></div>
        </div>
         <div class="ck">
           <textarea id="summernote" name="diary"></textarea>
         </div>
         <div id="Btn">
            <button id="btnsave">작성</button>
            <button type="reset" id="rewrite">다시쓰기</button>
         </div>
      </form>
      <div id="menu_wrap" class="bg_white">
        <div class="option">
            <div>
                <form onsubmit="searchPlaces(); return false;">
                    키워드 : <input type="text" value="" id="keyword" size="10"> 
                    <button type="submit">검색</button> 
                </form>
            </div>
        </div>
      </div>
       <button id="resetMarker">마커초기화</button>
   </div>
</div>
   <script>
   var sendsmap = '{"markers":[';
   
   $(document).ready(function() {
         //여기 아래 부분
         $('#summernote').summernote({
               width: 1000,
               height: 500,
               top: 150,// 에디터 높이
               minHeight: null, // 최소 높이
               maxHeight: null, // 최대 높이
               focus: true, // 에디터 로딩후 포커스를 맞출지 여부
               lang: "ko-KR",   // 한글 설정
               callbacks : { 
                      onImageUpload : function(files, editor, welEditable) { // 파일 업로드(다중업로드를 위해 반복문 사용)
                    for (var i = files.length - 1; i >= 0; i--) {
                    uploadFile(files[i], this);
                           }
                        }
                     }
         });
         $('#summernote').summernote(setting);     
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
    
   $(document).on('click', '#btnsave', function(e) {
      sendsmap=sendsmap.substr(0, sendsmap.length -1);
      sendsmap+="]}";
      $("#smap").val(sendsmap);
      
      $("#form").submit();
   });
// 장소 검색 객체를 생성합니다
   var ps = new kakao.maps.services.Places();  
//   searchPlaces();

// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {

    var keyword = document.getElementById('keyword').value;

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('키워드를 입력해주세요!');
        return false;
    }

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB); 
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
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
   
   var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
   mapOption = { 
       center: new kakao.maps.LatLng(37.533934, 126.901143), // 지도의 중심좌표
       level: 3 // 지도의 확대 레벨
   };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
var smap = document.getElementById('smap'); // id값이 일치하는 태그를 읽어들임


//지도를 클릭했을때 클릭한 위치에 마커를 추가하도록 지도에 클릭이벤트를 등록합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
   // 클릭한 위치에 마커를 표시합니다 
   addMarker(mouseEvent.latLng);
   savemarkers(mouseEvent.latLng);
});
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

var reset = document.getElementById('resetMarker'); 
resetMarker.onclick = function() {
   sendsmap = '{"markers":[';
   setMarkers(null);

}
   

   </script>
</body>
</html>