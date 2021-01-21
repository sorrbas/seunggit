<%@page import="java.sql.PreparedStatement"%>
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
		<%
			String irum = request.getParameter("irum");
			String age = request.getParameter("age");
			String hakbun = request.getParameter("hakbun");
			String irumUpdate = request.getParameter("irumUpdate");

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://bbr123.cafe24.com:3306/bbr123", "bbr123",
					"alstjr95!");
			String sql = "update studentjw set age=?, irum=?, hakbun=? where irum=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			/*Statement stmt = conn.createStatement();*/
			pstmt.setString(1, age);
			pstmt.setString(2, irum);
			pstmt.setString(3, hakbun);
			pstmt.setString(4, irumUpdate);
			
			int cnt = pstmt.executeUpdate();
		%>
		<%=cnt%>건 학생이 수정 되었습니다.

		<%
			pstmt.close();
			conn.close();
		%>
<%
		response.sendRedirect("studentList.jsp");
	%>

</body>
</html>