<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="utf-8">
  <title>대구가톨릭대학교</title>
  <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <link href="css/top.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-1.10.2.js"></script>
	<script src="js/jquery.innerfade.js"></script>
 </head>
 <body>

  <div id="ALL">
  <h1><img src="images/khkh.jpg" class="khlogo"></h1>
   <!-- <h1>DAEGU CU</h1> -->
    <div id="khmember">
		<a href="index.jsp">홈 |</a> 
		<a href="index.jsp?page=member/memberForm">회원가입 |</a> 
		<% 
			String id = (String)session.getAttribute("id");
			if(id != null){
				out.print("<a href='memberLogout.mb'>로그아웃</a>");
				
		%>
		<div id="logout">
		<%
			
            out.print(id+"님 환영합니다! ");
			out.print("<a href='memberList.mb'> 🔒︎회원목록&nbsp;</a>");
			out.print("<a href='index.jsp?page=member/memberOutForm'>👋회원탈퇴</a>");
        %>
        </div>
        <%
            } else {
               out.print("<a href='index.jsp?page=member/loginForm'>로그인</a>");
            }
        %>
	</div>
   <div class="menu">
    <ul>
     <li><% id = (String)session.getAttribute("id");
     		if(id!=null){
     		out.print("<a href=index.jsp?page=haksainfo>학사소개</a>");
     		} else {
     			out.print("<a href=index.jsp?page=kh onclick=alert('로그인&nbsp먼저&nbsp해주세요')>학사소개</a>");
     		}
     		%></li>
     <li><% if(id!=null){
    	 out.print("<a href=boardList.bo>커뮤니티</a>");
     } else {
    	 out.print("<a href=index.jsp?page=kh onclick=alert('로그인&nbsp먼저&nbsp해주세요')>커뮤니티</a>");
     }
     %></li>
     
     <li><a href="mailForm.jsp">자바메일</a></li>
     <li><a href="zoomkh.jsp">KH-B클래스</a></li>
     <li><a href="thumnail.jsp">포트폴리오</a></li>
     <li><a href="haksainfo.jsp">학사관리</a></li>
    </ul>
   </div>
   <div id="news1">
		<ul id="news">
			<li><a href="#n1">1. 나</a></li>
			<li><a href="#n2">2. 는</a></li>
			<li><a href="#n3">3. 나</a></li>
			<li><a href="#n4">4. 정</a></li>
			<li><a href="#n5">5. 이</a></li>
		</ul>
	</div>
  </div>

  <script src="js/top.js"></script>
     </body>
</html>