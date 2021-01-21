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
<h1>매니저등록 처리</h1>

	<%
		String nai = request.getParameter("nai");
		String irum = request.getParameter("irum");
		String part = request.getParameter("part");
	%>
	나이 : <%=nai%><br> 이름 : <%=irum%><br>  과목 : <%=part%><br>
	<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://bbr123.cafe24.com:3306/bbr123", "bbr123",
				"alstjr95!");
		/*Statement stmt = conn.createStatement();*/
		String sql = "insert into managerjw(age,irum,part) values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nai);
		pstmt.setString(2, irum);
		pstmt.setString(3, part);

		int cnt = pstmt.executeUpdate();
	%>
	<%=cnt%>건 매니저가 등록되었습니다.
	<% 
	 pstmt.close();
	 conn.close();
	 %>
	  <% response.sendRedirect("manager_register_confirm.jsp"); %>
</body>
</html>