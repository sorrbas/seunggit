<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type = "text/css">

table{
border: 1px solid lightgray;
border-collapse : collapse; 
width: 400px;
}
th{ 
border:1px solid lightgray;
background-color: lightgreen; color:white;
}

</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<h1>관리자전체출력</h1>
	<table border="1" cellspacing="0" cellpadding="0">
<tr>
<th>번호</th>
<th>나이</th>
<th>이름</th>
<th>부서</th>
</tr>
<tr>

	<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb", "underdogb","khacademy1!");
		String sql = "select no,age,irum,part from managerNJ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		/*Statement stmt = conn.createStatement();
		String sql = "select no,age,irum,part from managerNJ";
		ResultSet rs = stmt.executeQuery(sql);*/
		while(rs.next()){
			int no = rs.getInt("no");
			int age = rs.getInt("age");
			String irum = rs.getString("irum");
			String part = rs.getString("part");
			out.print("<td>"+no+"</td>"+"<td>"+age+"</td>"+"<td>"+irum+"</td>"+"<td>"+part+"</td>"+"</tr>");
		}
		pstmt.close();
		conn.close();
	%>
	
	</table>
	<a href="manager.jsp">관리자등록</a>
	<a href="../index.jsp">학사관리</a>
</body>
</html>