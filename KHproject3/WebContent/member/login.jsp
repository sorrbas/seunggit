<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
	String sql = "select id, pw from memberNJ where id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	ResultSet rs = pstmt.executeQuery();
	String iddb = null;
	String pwdb = null;
	while(rs.next()){
		iddb = rs.getString("id");
		pwdb = rs.getString("pw");
	}
		if(!id.equals(iddb)){
			out.print("아이디가 일치하지 않습니다.");
		}
		else if(!pw.equals(pwdb)){
			out.print("패스워드가 일치하지 않습니다.");
		}
		else {
			out.print(id+"님 로그인 되었습니다!");
			session.setAttribute("id", id);
		}
		response.sendRedirect("../index.jsp?page=kh");
%>
</body>
</html>