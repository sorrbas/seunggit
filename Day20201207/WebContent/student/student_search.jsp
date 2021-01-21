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
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<h1>학생검색</h1>
	번호 나이 이름 학번
	<br>
	<%
		String irumSearch = request.getParameter("irum");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb", "underdogb","khacademy1!");
		String sql = "select no,age,irum,hakbun from studentNJ where irum =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumSearch);
		ResultSet rs = pstmt.executeQuery();

		/*Statement stmt = conn.createStatement();*/
		/*String sql = "select no,age,irum,hakbun from studentNJ where irum ='"+irumSearch+"'";*/
		/*ResultSet rs = stmt.executeQuery(sql);*/
		
		while (rs.next()) {
			int no = rs.getInt("no");
			int age = rs.getInt("age");
			String irum = rs.getString("irum");
			String hakbun = rs.getString("hakbun");
			out.print(no + "&nbsp;&nbsp;&nbsp" + age + "&nbsp;&nbsp;&nbsp" + irum + "&nbsp;&nbsp;&nbsp" + hakbun+ "<br>");
		}
	%>
	<a href="studentList.jsp">학생전체출력</a>
	<a href="../index.jsp">학사관리</a>
	<%
		pstmt.close();
		conn.close();
	%>
</body>
</html>