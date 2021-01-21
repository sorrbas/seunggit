<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-color: #FFA500;
}

.kh01 {
	width: 60px;
	height: 10;
	margin-left: 213px;
}

#professorSearch {
	font-size: 17px;
	border: 3px dashed #BF00FF;
	border-radius: 20px;
	width: 300px;
	height: auto;
	margin: 20px auto;
	padding: 20px;
	text-align: center;
}


h1 {
	font-size: 40px;
	color: #BF00FF;
	margin: 0 auto;
	text-align: center;
	font-family: "맑은 고딕";
	width: 400px;
	height: auto;
}

ul {
	list-style-type: none;
	padding: 0px;
}

</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="studentSearch">
		<h1>Search Manager</h1>
		<form action="manager_search.jsp" method="get">
			<ul>
				<li><label for="찾을이름">찾을이름</label> <input type="text"
					name="irum"></li>
			</ul>
			<div id="btn">
				<input type="image" src="../images/search.png" class="kh01">
			</div>
		</form>
	</div>
</body>
</html>