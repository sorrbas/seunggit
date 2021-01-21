<%@page import="java.sql.PreparedStatement"%>
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
	background-color: #ffd0d1;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<h1>학생등록 처리</h1>

	<%
		String nai = request.getParameter("nai");
		String irum = request.getParameter("irum");
		String hakbun = request.getParameter("hakbun");
	%>
	나이 : <%=nai%> 이름 : <%=irum%>  학번 : <%=hakbun%><br>
	<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://bbr123.cafe24.com:3306/bbr123", "bbr123",
				"alstjr95!");
		String sql = "insert into studentjw(age,irum,hakbun) values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nai);
		pstmt.setString(2, irum);
		pstmt.setString(3, hakbun);
		/*Statement stmt = conn.createStatement();*/
		int cnt = pstmt.executeUpdate();/*파라미터로 쿼리 빼주기*/
	%>
	<%=cnt%>건 학생이 등록되었습니다.
	<% 
	 pstmt.close();
	 conn.close();
	 %>
	  <% response.sendRedirect("student_register_confirm.jsp"); %>
</body>
</html>