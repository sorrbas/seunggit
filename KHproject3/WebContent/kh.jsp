<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
   	background-image: url("images/backg.png");
   	background-repeat: no-repeat;
   	background-size: 2000px;
	background-attachment: fixed;
	width: 1500px; height: 1000px;
	}
#mainpage {
		position : absolute;
		top: 300px; left: 500px;
}
.khb {
	width:400px; height: 300px;
	}
</style>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.innerfade.js"></script>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<div id="mainpage">
		<ul id="portfolio">
			<li><a href="index.jsp?page=haksainfo"> <img src="images/snoopy3.gif" title="학사소개" class="khb"/>
			</a></li>
			<li><a href="index.jsp?page=boardWrite"> <img src="images/winter.png" title="커뮤니티" class="khb"/>
			</a></li>
			<li><a href="#"> <img src="images/chrisnoopy.gif" title="모집과정" class="khb"/>
			</a></li>
			<li><a href="#"> <img src="images/snoopy1.png" title="포트폴리오" class="khb"/>
			</a></li>
			<li><a href="#"> <img src="images/dancesnoopy.gif" title="학사관리" class="khb"/>
			</a></li>
		</ul>
	</div>
	<script>
	$('#portfolio').innerfade({
				speed: 'slow',
				timeout: 4000,
				type: 'sequence',
				containerheight: '220px'
			});
	</script>
</body>
</html>