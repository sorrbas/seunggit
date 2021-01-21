<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: #FFA500;
	font-family: "맑은 고딕";
	font-size: 15px;
}

li {
	float: left;
	margin: 20px;
}

a {
	text-decoration: none;
	color: black;
	font-size: 13px;
}

a:hover {
	background-color: white;
}

#wrap {
	width: 600px;
	height: 500px;
}

.member {
	font-size: 40px;
	color: #BF00FF;
	margin: 0 auto;
	text-align: center;
	font-family: "맑은 고딕";
	width: 500px;
	height: auto;
}

.form {
	width: 500px;
	height: auto;
	border-radius: 20px;
	border: 3px dashed #BF00FF;
	margin: 20px auto;
	padding: 30px;
	text-align: center;
}

.form3 label {
	width: 100px;
	height: 20px;
	/*  display: block; */
	float: center;
}

.clear {
	clear: both;
	margin: 5px;
}

table {
	border: 1px solid black;
	border-collapse: collapse;
}

th {
	border: 1px solid black;
	border-collapse: collapse;
	background-color: black;
	color: white;
	width: 300px
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
	<form action="../index.jsp" method="get">
		<h1 class="member">Goguma List</h1>
		<div class="form">
			<table border="1" cellspacing="0" cellpadding="0">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>나이</th>
					<th>학번</th>
				</tr>
				<%
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://bbr123.cafe24.com:3306/bbr123", "bbr123",
							"alstjr95!");
					//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bbr123", "bbr123", "alstjr95!");
					Statement stmt = conn.createStatement();
					String sql = "select * from studentjw";
					ResultSet rs = stmt.executeQuery(sql);

					while (rs.next()) {
						int no = rs.getInt("no");
						String irum = rs.getString("irum");
						String age = rs.getString("age");
						int hakbun = rs.getInt("hakbun");
						out.print("<tr><td>" + no + "</td>" + "<td>" + irum + "</td>" + "<td>" + age + "</td>" + "<td>" + hakbun
								+ "</td></tr>");
					}
					stmt.close();
					conn.close();
				%>

			</table>
		</div>
	</form>
	<br>
	<div id="link">
		<a href="student/student.jsp">학생등록</a><br> <a
			href="../haksainfo.jsp">학사관리</a><br> 
			<a href="../index.jsp">메인화면</a>
	</div>
</body>
</html>