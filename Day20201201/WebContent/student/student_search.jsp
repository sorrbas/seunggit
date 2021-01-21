<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
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

#box {
	font-size: 17px;
	border: 3px dashed #BF00FF;
	border-radius: 20px;
	width: 300px;
	height: auto;
	margin: 20px auto;
	padding: 20px;
	text-align: center;
}

h1 {
	font-size: 40px;
	color: #BF00FF;
	margin: 0 auto;
	text-align: center;
	font-family: "맑은 고딕";
	width: 400px;
	height: auto;
}

a {
	text-decoration: none;
	color: black;
	font-size: 13px;
}

a:hover {
	background-color: white;
}

#link {
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
	<h1>Search Goguma</h1>
	<div id="box">
		<%
			String irumSearch = request.getParameter("irum");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://bbr123.cafe24.com:3306/bbr123", "bbr123",
					"alstjr95!");
			/*Statement stmt = conn.createStatement();*/
			String sql = "select no,age,irum,hakbun from studentjw where irum=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, irumSearch);
			ResultSet rs = pstmt.executeQuery();
			int no = 0;
			String age = null;
			String irum = null;
			int hakbun = 0;
			while (rs.next()) {
				no = rs.getInt("no");
				age = rs.getString("age");
				irum = rs.getString("irum");
				hakbun = rs.getInt("hakbun");
			}
		%>
		<%=no%>&nbsp;&nbsp;&nbsp;<%=age%>&nbsp;&nbsp;&nbsp;<%=irum%>&nbsp;&nbsp;&nbsp;<%=hakbun%><br>
		<%
			pstmt.close();
			rs.close();
			conn.close();
		%>

	</div>
	<div id="link">
		<a href="studentList.jsp">학생전체출력</a><br> <a
			href="../haksainfo.jsp">학사관리</a><br> <a href="../index.jsp">메인화면</a>
	</div>
</body>
</html>