<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <jsp:useBean id="managerDAO" class="kr.or.kh.haksa.ManagerDAO" scope="page"/>
  	 <jsp:useBean id="managerDTO" class="kr.or.kh.haksa.ManagerDTO" scope="page"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
	<h1>관리자전체출력</h1>
	<%
   ResultSet rs = managerDAO.managerListSql();
%>
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>번호</th>
        <th>나이</th>
        <th>이름</th>
        <th>부서</th>
    </tr>
    <tr>
    <%
    while(rs.next()) {
      int no = rs.getInt("no");
      managerDTO.setNai(rs.getString("age"));
      managerDTO.setIrum(rs.getString("irum"));
      managerDTO.setPart(rs.getString("part"));
      out.print("<tr>");
      out.print("<td>"+no+"</td>");
      out.print("<td>"+managerDTO.getNai()+"</td>");
      out.print("<td>"+managerDTO.getIrum()+"</td>");
      out.print("<td>"+managerDTO.getPart()+"</td>");
      out.print("</tr>");
   }
     %>
    </tr>
    </table>
    <a href="manager.jsp">관리자등록</a>&nbsp;<a href="manager_searchForm.jsp">관리자검색</a>&nbsp;
    <a href="manager_deleteForm.jsp">관리자삭제</a>&nbsp;<a href="manager_updateForm.jsp">관리자수정</a>
</body>
</html>