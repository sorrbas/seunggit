<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#boardUpdateForm {
	position : absolute;
	top: 300px; left: 590px;
	width: 370px; height: 70px;
	border: 5px solid skyblue;
	border-radius: 20px 20px 20px 20px;
	padding-top : 10px;
}
	
.kh01 {
	position: absolute;
	top: 20px; left: 310px;
	width: 50px; height: 40px;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="boardUpdateForm">
<form action="boardUpdateSearch.bo" method="get">
<ul>
	<li><label for="수정할 제목">수정할 제목</label>
	<input type="text" name="titleUpSearch" autofocus="autofocus" placeholder="수정할 제목을 입력하세요." required="required">
	</li>
	<li><input type="image" src="images/update1.png" class="kh01">
	</li>
</ul>
</form>
</div>
</body>
</html>