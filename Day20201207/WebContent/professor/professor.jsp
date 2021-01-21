<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.kh01{
	width: 100px; height: 80px;
	}
	/*
	#professorRegister{
	}border
	border-radius : 20px
	width
	} */
ul{list-style-type: none;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<h1>교수등록</h1>
	<div id="professorRegister">
	<form action="professorRegister.jsp" method="get">
	<ul>
		<li><label for="나이">나이</label>
		    <input type="number" name="nai">
		</li>
		<li><label for="이름">이름</label>
			<input type="text" name="irum" size="20">
		</li>
		<li><label for="과목">과목</label>
		    <input type="text" name="subject" size="20">
		</li>
		<li>
		<input type="image"src="../images/submitt.jpg" class="kh01">
		<!-- <input type="button" value="등록"> -->
		</li>
	</ul>
	</form>
	</div>
	<a href="professorList.jsp">교수전체출력</a>
	<a href="../index.jsp">학사관리</a>
</body>
</html>