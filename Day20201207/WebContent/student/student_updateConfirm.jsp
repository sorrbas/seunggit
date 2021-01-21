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
<style>
.kh01 {
	width: 100px;
	height: 80px;
}

ul {
	list-style-type: none;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<%
	String irumUpdate = request.getParameter("irum");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb", "khacademy1!");
		//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/underdogb", "underdogb","khacademy1!");
		String sql = "select no,age,irum,hakbun from studentNJ where irum =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumUpdate);
		ResultSet rs = pstmt.executeQuery();
		
		/*Statement stmt = conn.createStatement();*/
		/*String sql = "select no,age,irum,hakbun from studentNJ where irum ='" + irumUpdate + "'";*/
		/*ResultSet rs = stmt.executeQuery(sql);*/
		
		
		int no = 0;
		int age = 0;
		String irum = null;
		String hakbun = null;
		
		while(rs.next()){
	         no = rs.getInt("no");
	         age = rs.getInt("age");
	         irum = rs.getString("irum");
	         hakbun = rs.getString("hakbun");
	         }
	%>
	<h1>최종수정하기 전 내용입니다.</h1>
	<form action="student_update.jsp" method="get">
	<input type="hidden" name="irumUpdate" value="<%=irumUpdate %>">
		<ul>
			<li><label for="나이변경">나이변경</label> 
			<input type="number" name="age" value="<%=age %>"></li>
			<li><label for="이름변경">이름변경</label> 
			<input type="text" name="irum" value="<%=irum %>"></li>
			<li><label for="학번변경">학번변경</label> 
			<input type="text" name="hakbun" value="<%=hakbun %>"></li>
			<li><input type="image" src="../images/update.jpg" class="kh01">
		</ul>
	</form>
</body>
</html>