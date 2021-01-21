<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:useBean id="boardSearch" class="kr.or.kh.board.BoardDAO" scope="page"/> <!--class는 객체를 생성해준다는 의미  -->
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
body {
	background-image: url("images/backg.png");
}

#boardTitle {
	position: absolute;
	top: 300px; left: 590px;
	width: 340px; height: 80px;
	border: 5px solid skyblue;
	border-radius: 20px 20px 20px 20px;
	padding-top: 10px;
	
}

.kh01 {
	position : absolute;
	top: 20px; left: 260px;
	width: 60px; height: 40px;
}

#underTitle {
	position: absolute;
	top: 55px; left: 50px;
	
}
ul {
	list-style-type: none;
}

#boardResult {
	position: absolute;
	top: 450px;
	left: 420px;
	width: 800px;
}

table {
	border: 0px solid lightgray;
	border-collapse: collapse;
	width: 700px;
}

th {
	border: 1px solid lightgray;
	background-color: lightblue;
	color: white;
}

.List {
	background-color: white;
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<div id="boardTitle">
		<form action="boardSearch.bo" method="get">
			<ul>
				<li><input type="hidden" name="readCount"
					value="0"></li>
				<li><label for="제목">제목</label> 
					<input type="text" name="titleSearch" autofocus="autofocus" required="required" placeholder="제목입력">
				</li>
				<li><input type="image" src="images/pencil.png" class="kh01"></li>
			</ul>
		</form>
		
		<div id="underTitle">
		<a href="boardList.bo">게시판목록&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="index.jsp?page=board/boardWrite">게시판글쓰기</a>
		<!--  보드DAO로 넘어감 -->
		</div>
	</div>
	

</body>
</html>