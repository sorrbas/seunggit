<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	margin-left: 300px;
}

a {
	text-decoration: none;
	color: black;
	font-size: 13px;
}

a:hover {
	background-color: white;
}

#studentUpdate {
	width: 500px;
	height: auto;
	border-radius: 20px;
	border: 3px dashed #BF00FF;
	margin: 20px auto;
}

h1 {
	font-size: 25px;
	text-align: center;
}

ul {
	list-style-type: none;
	padding: 20px;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<%
		String irumUpdate = request.getParameter("irum");

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://bbr123.cafe24.com:3306/bbr123", "bbr123",
				"alstjr95!");
		/*Statement stmt = conn.createStatement();*/
		String sql = "select age,irum,hakbun from studentjw where irum=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumUpdate);
		ResultSet rs = pstmt.executeQuery();
		String age = null;
		String irum = null;
		int hakbun = 0;
		while (rs.next()) {
			age = rs.getString("age");
			irum = rs.getString("irum");
			hakbun = rs.getInt("hakbun");
		}
	%>
	<h1>최종 수정하기 전 내용입니다.</h1>
	<div id="studentUpdate">
		<form action="student_update.jsp" method="get">
			<input type="hidden" name="irumUpdate" value="<%=irumUpdate%>">
			<ul>
				<li><label for="나이변경">나이변경</label> <input type="number"
					name="age" value="<%=age%>"></li>
				<li><label for="이름변경">이름변경</label> <input type="text"
					name="irum" value="<%=irum%>"></li>
				<li><label for="학번변경">학번변경</label> <input type="number"
					name="hakbun" value="<%=hakbun%>"></li>
			</ul>
			<input type="image" src="../images/update.png" class="kh01">
		</form>
	</div>
	<%
		pstmt.close();
		rs.close();
		conn.close();
	%>
</body>
</html>