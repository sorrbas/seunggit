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
		String id = (String)session.getAttribute("id");
		String pw = request.getParameter("pw");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
		String sql = "delete from memberNJ where id=? and pw=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		int cnt = pstmt.executeUpdate();
	%>
	<%= cnt %>건이 삭제 되었습니다.
	<% 
	if(cnt == 1) {
	%>
	<script type="text/javascript">
		alert("탈퇴되었습니다");
		location.href="../index.jsp"
	</script>
	<%
		session.invalidate();
	}
	else %> 
		<script type="text/javascript">
		alert("비밀번호가 틀렸습니다.");
		location.href="../index.jsp?page=member/memberOutForm"
		
		</script>
	
</body>
</html>