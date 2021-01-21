<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<%
		String irum = request.getParameter("irum");
		String age = request.getParameter("age");
		String subject = request.getParameter("subject");
		String irumUpdate = request.getParameter("irumUpdate");

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://bbr123.cafe24.com:3306/bbr123", "bbr123",
				"alstjr95!");
		/*Statement stmt = conn.createStatement();*/
		
		String sql = "update professorjw set age=?, irum=?, subject=? where irum=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, age);
		pstmt.setString(2, irum);
		pstmt.setString(3, subject);
		pstmt.setString(4, irumUpdate);
		
		int cnt = pstmt.executeUpdate();
	%>
	<%=cnt%>건 교수가 수정 되었습니다.
	
	<%
		pstmt.close();
		conn.close();
	%>
	<%
		response.sendRedirect("professor_list.jsp");
	%>
</body>
</html>