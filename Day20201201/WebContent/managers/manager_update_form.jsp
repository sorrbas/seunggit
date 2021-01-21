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

#managerUpdate {
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
#link{
width: 300px;
height: auto;
text-align: center;
margin: 20px auto;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>

<h1>매니저 수정</h1>
<div id="managerUpdate">
<form action="manager_update_confirm.jsp" method="get">
			<ul>
				<li><label for="수정할 매니저 이름">수정 할 이름</label> <input type="text"
					name="irum"></li>
			</ul>
			
				<input type="image" src="../images/update.png" class="kh01">
		
		</form>
</div>
<div id="link">
<a href="manager_list.jsp">매니저전체출력</a>
	<br>
	<a href="../haksainfo.jsp">학사관리</a>
	<br>
	<a href="../index.jsp">메인화면</a>
</div>

</body>
</html>