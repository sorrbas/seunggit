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
}

#professortDelete {
	border: 3px dashed #BF00FF;
	border-radius: 20px;
	width: 300px;
	padding: 30px;
}

#btn {
	padding-left: 190px;
}

h1 {
	font-size: 30px;
	text-align: center;
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
<div id="professortDelete">
		<h1>교수 삭제</h1>
		<form action="professor_delete.jsp" method="get">
			<ul>
				<li><label for="삭제이름">삭제이름</label> <input type="text"
					name="irum"></li>
			</ul>
			<div id="btn">
				<input type="image" src="../images/delete.png" class="kh01">
			</div>

		</form>
	</div>
</body>
</html>