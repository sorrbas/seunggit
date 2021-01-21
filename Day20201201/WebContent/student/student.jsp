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
	padding-left: 213px;
}

#studentRegister {
	width: 300px;
	height: auto;
	border-radius: 20px;
	border: 3px dashed #BF00FF;
	margin: 20px auto;
	padding: 20px;
}

h1 {
	width: 300px;
	height: auto;
	text-align: center;
	font-size: 40px;
	color: #BF00FF;
	margin: 0 auto;
}

ul {
	list-style-type: none;
	padding: 0px;
}

a {
	text-decoration: none;
	color: black;
	font-size: 13px;
}

a:hover {
	background-color: white;
}

#link {
	width: 300px;
	height: auto;
	text-align: center;
	margin: 0px auto;
}
</style>

<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
		<h1>고구마 등록</h1>
	<div id="studentRegister">
		<form action="student/studentRegister.jsp" method="get">
			<ul>
				<li><label for="나이">나이</label> <input type="number" name="nai">
				</li>
				<li><label for="이름">이름</label> <input type="text" name="irum"
					size="20"></li>
				<li><label for="학번">학번</label> <input type="text" name="hakbun"
					size="20"></li>
				<li>
					<div id="btn">
						<input type="image" src="../images/submit.png" class="kh01">
					</div>
				</li>
			</ul>
		</form>
	</div>
	<br>
	<div id="link">
	<a href="studentList.jsp">전체고구마출력</a><br>
	<a href="../haksainfo.jsp">학사관리</a><br>
	<a href="../index.jsp">메인화면</a>
	</div>
</body>
</html>