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
<h1>교수전체출력</h1>
<table border="1" cellspacing="0" cellpadding="0">
<tr>
<th>번호</th>
<th>나이</th>
<th>이름</th>
<th>과목</th>
</tr>
<tr>
	<%
	String irumSearch = request.getParameter("irum");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb", "underdogb","khacademy1!");
		String sql = "select no,age,irum,subject from professorNJ where irum = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumSearch);
		ResultSet rs = pstmt.executeQuery();
		
		/*Statement stmt = conn.createStatement();
		String sql = "select no,age,irum,subject from professorNJ where irum = '"+irumSearch+"' ";
		ResultSet rs = stmt.executeQuery(sql);*/
		while(rs.next()){
			int no = rs.getInt("no");
			int age = rs.getInt("age");
			String irum = rs.getString("irum");
			String subject = rs.getString("subject");
			out.print("<td>"+no+"</td>"+"<td>"+age+"</td>"+"<td>"+irum+"</td>"+"<td>"+subject+"</td>"+"</tr>");
		}
		pstmt.close();
		conn.close();
	%>
	
	</table>
	<a href="professor.jsp">교수등록</a>
	<a href="../index.jsp">학사관리</a>
</body>
</html>