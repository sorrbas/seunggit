<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.kh01{
	width: 100px; height: 80px;
	
	}
/*.image{
position : absolute;
border 3px solid red;
top:200px; left: 70px;
 }*/
ul{list-style-type: none;}

</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<h1>학생등록</h1>
	<div id="studentRegister">
	<form action="studentRegister.jsp" method="get">
	<ul>
		<li><label for="나이">나이</label>
		    <input type="number" name="nai">
		</li>
		<li><label for="이름">이름</label>
			<input type="text" name="irum" size="20">
		</li>
		<li><label for="학번">학번</label>
		    <input type="text" name="hakbun" placeholder="숫자로만 적어주세요" size="20">
		</li>
		<li>
		<!--<div class="image"> -->
		<input type="image"src="../images/submitt.jpg" class="kh01">
		<!-- <input type="button" value="등록"> -->
		</li>
	</ul>
	</form>
	</div>
	<a href="studentList.jsp">학생전체출력</a>
	<a href="../index.jsp">학사관리</a>
</body>
</html>