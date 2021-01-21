<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="css/wayToCome.css">
<meta charset="UTF-8">
<title>Document</title>

</head>

<body>
	<div id="wayToCome">
		<div id="waytocome_top">
			<h1>오시는 길</h1>
			<p>교육센터로 오시는 길입니다.</p>
		</div>
		<ul>
			<li><a href="#" onclick="center1()">오즈에듀 평생교육원</a></li>
<!-- 			<li><a href="#" onclick="center2()">센터2</a></li> -->
<!-- 			<li><a href="#" onclick="center3()">센터3</a></li> -->
		</ul>
		<div>
			<table id="centerinfo">
				<tr>
					<td><label for="address">주소</label></td>
					<td id="address">경기 성남시 분당구 판교동 618-3</td>
				</tr>
								<tr>
									<td><label for="bus">버스</label></td>
									<td id="bus">103/220/330/340/341/350/누리3/1303/4000/9003/9004/9007</td>
								</tr>
								<tr>
									<td><label for="subway">지하철</label></td>
									<td id="subway">판교역 4번 출구에서 버스로 20분</td>
								</tr>
			</table>
		</div>
		<div id="map"></div>
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d625053b0732bfe46e3b6a75cb7c220a&libraries=services"></script>
		<script>
			var address = document.getElementById('address');
			var bus = document.getElementById('bus');
			var subway = document.getElementById('subway');
			var container = document.getElementById('map');
			var options = {
				center : new kakao.maps.LatLng(37.3906970406967,127.089101943711),
				level : 3
			};

			var map = new kakao.maps.Map(container, options);

			// 마커가 표시될 위치입니다 
			var markerPosition = new kakao.maps.LatLng(37.3906970406967,127.089101943711);

			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
				position : markerPosition
			});

			// 마커가 지도 위에 표시되도록 설정합니다
			marker.setMap(map);
			var infowindow = new kakao.maps.InfoWindow(
					{
						content : '<div class = "infowindow" style="width:150px;text-align:center;padding:6px 0;">오즈에듀평생교육원<br><a href="https://map.kakao.com/link/map/center1,37.3906970406967,127.089101943711" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/오즈에듀 평생교육원,37.3906970406967,127.089101943711" style="color:blue" target="_blank" display="flex">길찾기</a></div>'
					});
			infowindow.open(map, marker);
			var geocoder = new kakao.maps.services.Geocoder();

			function center1() {
				address.textContent = '경기 성남시 분당구 판교동 618-3';
				bus.textContent = '103/220/330/340/341/350/누리3/1303/4000/9003/9004/9007';
				subway.textContent = '판교역 4번 출구에서 버스로 20분';
				geocoder
						.addressSearch(
								'경기 성남시 분당구 판교동 618-3',
								function(result, status) {
									// 정상적으로 검색이 완료됐으면 
									if (status === kakao.maps.services.Status.OK) {

										var coords = new kakao.maps.LatLng(
												result[0].y, result[0].x);

										// 결과값으로 받은 위치를 마커로 표시합니다
										var marker = new kakao.maps.Marker({
											map : map,
											position : coords
										});
										// 인포윈도우로 장소에 대한 설명을 표시합니다
										var infowindow = new kakao.maps.InfoWindow(
												{
// 													content : '<div class = "infowindow" style="width:150px;text-align:center;padding:6px 0;">' + result[0].y + ',' + result[0].x + '</div>'
													content : '<div class = "infowindow" style="width:150px;text-align:center;padding:6px 0;">오즈에듀평생교육원<br><a href="https://map.kakao.com/link/map/center1,' + result[0].y + ',' + result[0].x + '" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/오즈에듀평생교육원,' + result[0].y + ',' + result[0].x + '" style="color:blue" target="_blank" display="flex">길찾기</a></div>'
												});
										infowindow.open(map, marker);

										// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
										map.setCenter(coords);
									}
								});
			}

			function center2() {
				address.textContent = '서울특별시 강남구 테헤란로 14길 6';
				bus.textContent = '111/222/333/444';
				subway.textContent = '지하철 2호선 역삼역 3번출구 100m';
				geocoder
						.addressSearch(
								'서울특별시 강남구 테헤란로 14길 6',
								function(result, status) {

									// 정상적으로 검색이 완료됐으면 
									if (status === kakao.maps.services.Status.OK) {

										var coords = new kakao.maps.LatLng(
												result[0].y, result[0].x);

										// 결과값으로 받은 위치를 마커로 표시합니다
										var marker = new kakao.maps.Marker({
											map : map,
											position : coords
										});
										// 인포윈도우로 장소에 대한 설명을 표시합니다
										var infowindow = new kakao.maps.InfoWindow(
												{
													content : '<div class = "infowindow" style="width:150px;text-align:center;padding:6px 0;">센터2<br><a href="https://map.kakao.com/link/map/Hello World!,'
															+ result[0].y
															+ ','
															+ result[0].x
															+ '" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/센터2,' + result[0].y + ',' + result[0].x + '" style="color:blue" target="_blank" display="flex">길찾기</a></div>'
												});
										infowindow.open(map, marker);

										// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
										map.setCenter(coords);
									}
								});
			}

			function center3() {
				address.textContent = '서울특별시 영등포구 선유동2로 57';
				bus.textContent = '555/666/777/888';
				subway.textContent = '지하철 2, 9호선 당산역 12번 출구 400m';
				geocoder
						.addressSearch(
								'서울특별시 영등포구 선유동2로 57',
								function(result, status) {

									// 정상적으로 검색이 완료됐으면 
									if (status === kakao.maps.services.Status.OK) {

										var coords = new kakao.maps.LatLng(
												result[0].y, result[0].x);

										// 결과값으로 받은 위치를 마커로 표시합니다
										var marker = new kakao.maps.Marker({
											map : map,
											position : coords
										});
										// 인포윈도우로 장소에 대한 설명을 표시합니다
										var infowindow = new kakao.maps.InfoWindow(
												{
													content : '<div class = "infowindow" style="width:150px;text-align:center;padding:6px 0;">센터3<br><a href="https://map.kakao.com/link/map/Hello World!,'
															+ result[0].y
															+ ','
															+ result[0].x
															+ '" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/센터3,' + result[0].y + ',' + result[0].x + '" style="color:blue" target="_blank" display="flex">길찾기</a></div>'
												});
										infowindow.open(map, marker);

										// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
										map.setCenter(coords);
									}
								});
			}
		</script>
	</div>
</body>
</html>