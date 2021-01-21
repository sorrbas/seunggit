<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <jsp:useBean id="professorDAO" class="kr.or.kh.haksa.ProfessorDAO" scope="page"/>
   <jsp:useBean id="professorDTO" class="kr.or.kh.haksa.ProfessorDTO" scope="page"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
   <h1>교수전체출력</h1>
<%
   ResultSet rs = professorDAO.professorListSql();
%>
<table border="1" cellspacing="0" cellpadding="0">
    <tr>
        <th>번호</th>
        <th>나이</th>
        <th>이름</th>
        <th>과목</th>
    </tr>
    <tr>
    <%
    while(rs.next()) {
      int no = rs.getInt("no");
      professorDTO.setNai(rs.getString("age"));
      professorDTO.setIrum(rs.getString("irum"));
      professorDTO.setSubject(rs.getString("subject"));
      out.print("<tr>");
      out.print("<td>"+no+"</td>");
      out.print("<td>"+professorDTO.getNai()+"</td>");
      out.print("<td>"+professorDTO.getIrum()+"</td>");
      out.print("<td>"+professorDTO.getSubject()+"</td>");
      out.print("</tr>");
   }
     %>
    </tr>
    </table>
    <a href="professor.jsp">교수등록</a>&nbsp;<a href="professor_searchForm.jsp">교수검색</a>&nbsp;
    <a href="professor_deleteForm.jsp">교수삭제</a>&nbsp;<a href="professor_updateForm.jsp">교수수정</a>
</body>
</html>