<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.kh01{
	width: 50px; height: 40px;
	}
	
ul{ list-style-type: none ;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<h1>관리자등록</h1>
	<div id="managerRegister">
	<form action="../managerRegister.do" method="get">
	<ul>
		<li><label for="나이">나이</label>
		    <input type="number" name="nai">
		</li>
		<li><label for="이름">이름</label>
			<input type="text" name="irum" size="20">
		</li>
		<li><label for="부서">부서</label>
		    <input type="text" name="part" size="20">
		</li>
		<li>
		<input type="image"src="../images/registerr.png" class="kh01">
		</li>
	</ul>
	</form>
	</div>
	<a href="managerList.jsp">관리자전체출력</a>
	<a href="../index.jsp">학사관리</a>
</body>
</html>