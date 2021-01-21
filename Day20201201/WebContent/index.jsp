<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
background-color:#FFA500;
}
ul {
	list-style-type: none;
}
img {
	width: 300px;
	height: 300px;
}


.khlogo{width: 90px; height: 80px; padding-left: 30px;}

.khmain{width: 800px; height:500px;}

a {text-decoration: none;}

a:hover {text-decoration: underline;color:black;}

a{text-decoration: none; color:black;}

hr{border:1px solid black;}

ul{
list-style-type: none;
}

li{
float:left;
margin:20px;
}

#kh01 {
	position: absolute;
	top: 110px;
	left: 100px;
	width: 1500px;
	height: 500px;
	/*border: 1px solid hotpink;*/
}

#khmaintitle{
position: absolute;
top:40px; left:200px;
width:1000px; height:100px;
font-size:23px;
;
font-weight: bold;
/*border: 1px solid pink;*/
}
#news1{
position:absolute;
top:50px;left:1200px;
width:300px; height:80px;

/*border: 1px solid pink;*/
}
#khmember{
position: absolute;
top:0%; right:1%;
width:200px; height:30px;
/*border: 1px solid pink;*/
}

</style>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.innerfade.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="css/khstyle.css"> -->

<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<div id="kh02">
		<h1>
			<a href="index.jsp"><img src="images/khh.png" class="khlogo"></a></h1>
	</div>
	<div id="khmember">
			<a href="haksainfo.jsp">홈</a>|
			<a href="#">회원가입</a>|
			<a href="#">로그인</a>
	</div>
	<div id="khmaintitle" class="khmaintitle">
			<ul>
			<li><a href="haksainfo.jsp">호구마 소개</a></li>
			<li><a href="#">커뮤니티</a></li>
			<li><a href="#">채집과정</a></li>
			<li><a href="#">KH호구마클래스</a></li>
			</ul>
	</div>
	<hr>
	<div id="kh01">
		<ul id="portfolio">
			<li>
				<a href="#"> <img src="images/111.jpg" title="산지직송" class="khmain" />
				</a>
			</li>
			<li>
				<a href="#"> <img src="images/666.jpg" title="호박고구마" class="khmain"/>
				</a>
			</li>
			<li>
				<a href="#"> <img src="images/777.jpg" title="10kg" class="khmain"/>
				</a>
			</li>
			<li>
				<a href="#"> <img src="images/444.gif" title="가락시장" class="khmain"/>
				</a>
			</li>
			<li>
				<a href="#"> <img src="images/555.gif" title="직접캐낸" class="khmain"/>
				</a>
			</li>
		</ul>
	</div>
	<div id="news1">
	<ul id="news">
		<li><a href="#n1">1 오늘의 고구마</a></li>
		<li><a href="#n2">2 호박고구마</a></li>
		<li><a href="#n3">3 당진 호구마 </a></li>
		<li><a href="#n4">4 하이킥 고구마</a></li>
		<li><a href="#n5">5 분노의 호박고구마</a></li>
		<li><a href="#n6">6 나문희</a></li>
		<li><a href="#n7">7 호구마대학</a></li>
	</ul>
    </div>
	<script>
		$('#portfolio').innerfade({
			speed : 'slow',
			timeout : 1600,
			type : 'sequence',
			containerheight : '220px'
		});
		$('#news').innerfade({
			animationtype : 'slide',
			speed : 750,
			timeout : 2000,
			type : 'sequence',
			containerheight : '1em'
		});
	</script>
</body>
</html>