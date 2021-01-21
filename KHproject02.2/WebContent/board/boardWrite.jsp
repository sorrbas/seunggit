<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
#boardWrite {
	position: absolute;
	top: 300px;
	left: 400px;
}

#complete {
	position: absolute;
	top: 410px; left: 50px;
	width: 70px; height: 60px;
}

.reset {
	position: absolute;
	top: 350px; left: 650px;
	border: 1px solid skyblue;
	border-radius:5px, 5px, 5px, 5px;
	background-color: white;
	color: skyblue;
	padding: 5px;
}

ul {
	list-style-type: none;
}

#boardtitle {
	position: absolute;
	top: 250px;
	left: 430px;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<div id="boardtitle">
		<h2>게시판 글 작성</h2>
	</div>
	<div id="boardWrite">

		<form action="boardRegister.bo" method="get">
			<input type="hidden" name="readCount" value="0">
			<ul>
				<li><label for="제목">제&nbsp&nbsp&nbsp목</label> 
				<input type="text" name="title" autofocus="autofocus" required="required"
					placeholder="제목을 입력하세요." size="30" maxlength="100"><!-- size = 글자갯수 -->
				</li>
				<li><label for="내용">내&nbsp&nbsp&nbsp용</label> 
				<textarea rows="20" cols="80" name="content" placeholder="내용을 입력하세요."></textarea>
				</li>
				<li><label for="작성자">작성자</label> 
				<input type="text" name="author" placeholder="작성자입력">
				</li>
				<li><label for="날짜">날&nbsp&nbsp&nbsp짜</label> 
				<input type="date" name="nal">
				</li>
				<li><input type="image" src="images/check1.png" id="complete">
					<input type="reset" value="취소" class="reset"></li>
				<li><a href="boardList.bo">게시판목록</a>
			</ul>
		</form>
	</div>
</body>
</html>