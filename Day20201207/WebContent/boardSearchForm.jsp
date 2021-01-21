<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form action="boardSearch.jsp" method="get">
			<ul>
				<li><input type="hidden" name="boardTest"
					value="index.jsp?page=boardSearchForm"></li>
				<li><label for="제목">제목</label> 
					<input type="text" name="title" autofocus="autofocus" required="required" placeholder="제목입력">
				</li>
				<li><input type="image" src="images/pencil.png" class="kh01"></li>
			</ul>
		</form>

		<%
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String no = request.getParameter("no");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String author = request.getParameter("author");
			String nal = request.getParameter("nal");
			String readCount = request.getParameter("readCount");
			if (no == null || no.equals("0")) {
				out.print("");
			} else {
		%>
		<div id="underTitle">
		<a href="index.jsp?page=board/boardList">게시판목록&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="index.jsp?page=board/boardWrite">게시판글쓰기</a>
		</div>
	</div>
	<div id="boardResult">
		<table border="1" cellspacing="0" cellpadding="0" class="List">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
			<tr>
				<%
					out.print("<td>" + no + "&nbsp</td><td>" + title + "&nbsp</td><td>" + content + "&nbsp</td><td>"
								+ author + "&nbsp</td><td>" + nal + "&nbsp</td><td>" + readCount + "</td>");
				%>
			</tr>
			<%
				}
			%>
		</table>
	</div>

</body>
</html>