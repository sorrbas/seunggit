<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Style -->
<link rel="stylesheet" href="css/main.css?v=2">
<link rel="stylesheet" href="css/login_.css">

<!-- Scripts -->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.dropotron.min.js"></script>
<script src="js/jquery.scrolly.min.js"></script>
<script src="js/browser.min.js"></script>
<script src="js/breakpoints.min.js"></script>
<script src="js/util.js"></script>
<script src="js/main.js"></script>
<script src="js/login_.js"></script>
<script type="text/javascript" charset="utf-8"></script>
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
   rel="stylesheet">
<script src="js/login_check.js"></script>

<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>

   <!-- Header -->
   <header id="header"> </header>

   <!-- Nav -->
   <nav id="nav">
      <a href="index.jsp" id="centerlogo"><img src="images/logo.png"></a>
       <ul>
         <li><a href="">협회소개</a>
            <ul>
               <li><a href="index.jsp?page=Greetings/hi2">인사말</a></li>

               <li><a href="index.jsp?page=Association/information">연혁</a></li>
            </ul></li>
         <li><a href="">주요사업</a>
            <ul>
               <li><a href="index.jsp?page=Bussiness/licenseIndex">자격증</a></li>
               <li><a href="index.jsp?page=Bussiness/wayToCome">교육센터 위치</a></li>
            </ul></li>
         <li><a href="#">커뮤니티</a>
            <ul>
               <li>
                  <%
                     String id = (String) session.getAttribute("id");
                     id = (String) session.getAttribute("id");
                     if (id != null) {
                        out.print("<a href=index.jsp?page=notice/NoticeList>공지사항</a>");
                     } else {
                        out.print("<a href=index.jsp?page=center onclick=alert('로그인&nbsp먼저&nbsp해주세요')>공지사항</a>");
                     }
                  %>
               </li>
               <!-- <a href="index.jsp?page=notice/NoticeList">공지사항</a></li> -->
               <li>
                  <%
                     id = (String) session.getAttribute("id");
                     if (id != null) {
                        out.print("<a href=index.jsp?page=Board/BoardList>자유게시판</a>");
                     } else {
                        out.print("<a href=index.jsp?page=center onclick=alert('로그인&nbsp먼저&nbsp해주세요')>자유게시판</a>");
                     }
                  %>
               </li>
               <!-- <a href="index.jsp?page=Board/BoardList">자유게시판</a></li> -->
               <li>
                  <%
                  
                     id = (String) session.getAttribute("id");
                     if (id != null) {
                    	 out.print("<a href=selectService>갤러리(연주회 영상/악보공유)</a>");
                     } else {
                        out.print("<a href=index.jsp?page=center onclick=alert('로그인&nbsp먼저&nbsp해주세요')>갤러리(연주회 영상/악보공유)</a>");
                     }
                  %> <!--                     <a href="#">갤러리(연주회 영상/악보공유)</a></li> -->
            </ul></li>
         <li class="current"><a href="index.jsp">쇼핑몰바로가기</a></li>
           

<li id="dltmdrl">
<%


    if(id == null) {
    
          out.print("<a href='#new-box' class='login-window' id='login_position'>회원가입</a>");
              
    }else if((session.getAttribute("id")).equals("1111")){
         
         out.print("<a href='index.jsp?page=Member/MasterPageIndex' id='login_position'>관리자</a>");
         out.print("<ul>");
         out.print("<li>");
         out.print("<a href='index.jsp?page=Member/MasterPageIndex&subpage=licenseManage'>자격증신청현황</a>");
         out.print("</li>");
         out.print("<li>");
         out.print("<a href='index.jsp?page=Member/MasterPageIndex&subpage=memberManage'>회원목록</a>");
         out.print("</li>");
         out.print("</ul>");
         
    
    }else {
          out.print("<div class='exchange'><a href='index.jsp?page=Member/Mypage' id='login_position'>마이페이지</a>");
        
    
    }

%>
</li>
<li id="dltmdrl2">
<%

    if( id == null) {
    	 out.print("<a href='#login-box' class='login-window' id='login_position'>로그인</a></div>");
    }else {
    	out.print("<a href='memberLogout.mb' id='login_position'>로그아웃</a></div>");
    }


    

%>
</li>
      </ul>
      

      <!-- 로그인 팝업 -->
      <div id="login-box" class="login-popup">
         <a href="#" class="close"><img src="images/close.png" class="btn_close" title="Close Window" alt="Close" /></a>
         <div class="login_main">
            <p class="login_sign" align="center">
               <img src="images/logo.png">
            </p>
            <form class="login_form2" action="memberLogin.mb" method="get">
               <input class="login_username" type="text" align="center"
                  placeholder="아이디" name="id" id="login_id" required="required"> <input
                  class="login_password" type="password" align="center"
                  placeholder="비밀번호" name="pw" id="login_pw" required="required">

               <p class="login_mid" align="center" id="search_id">
                  <div id="idpwsc">
                  <a href="#idsearch-box" class="login-window">아이디 찾기&nbsp;</a>
                   <a href="#pwsearch-box" class="login-window">비밀번호 찾기</a>
                   </div>
               </p>

               <input type="submit" class="login_submit" align="center"
                  value="로그인" id="btn1">

               <div class="loginEnd">
                  <div class="loginLine">
                     회원이 아니신가요? <a href="#new-box" class="login-window">회원가입</a>
                  </div>
               </div>
               <!--    <a class="login-window login_submit" align="center" href="#new-box">회원가입</a> -->

            </form>
         </div>

      </div>

      <div id="new-box" class="login-popup">
         <a href="#" class="close"><img src="images/close.png"
            class="btn_close" title="Close Window" alt="Close" /></a>
         <div class="login_main">
            <p class="login_sign" align="center">회원가입</p>
            <br>
            <form class="login_form1" action="memberRegister.mb" method="get">
               <input class="login_username" type="text" align="center"
                  placeholder="아이디를 입력해주세요." name="id" id="register_id"> <input
                  class="login_password" type="password" align="center"
                  placeholder="비밀번호를 입력해주세요." name="pw" id="register_pw" required="required">
               <input class="login_password" type="password" align="center"
                  placeholder="비밀번호 확인" name="pw2" id="register_check_pw" required="required">
               <input class="login_email" type="email" align="center"
                  placeholder="사용하실 이메일을 입력해주세요." name="email" id="email"
                  required="required"> 
                  <input type="submit" class="login_submit" align="center" value="가입하기" id="btn2">
     



               
            </form>
         </div>
      </div>

      <div id="idsearch-box" class="login-popup">
         <a href="#" class="close"><img src="images/close.png"
            class="btn_close" title="Close Window" alt="Close" /></a>
          <div class="login_main">
            <p class="login_sign" align="center">아이디 찾기</p>
            <br>
            <form class="login_form2" action="memberSearch.mb" method="get">
               <input class="login_email" type="email" align="center"
                  placeholder="등록하신 이메일을 작성해주세요." name="email" id="email" required="required"> 
                  <input type="submit" class="login_submit" align="center" value="아이디찾기">
   
       
            </form>
         </div>

      </div>

      <div id="pwsearch-box" class="login-popup">
         <a href="#" class="close"><img src="images/close.png"
            class="btn_close" title="Close Window" alt="Close" /></a>
        <div class="login_main">
            <p class="login_sign" align="center">비밀번호 찾기</p>
            <br>
            <form class="login_form2" action="pwSearch.mb" method="get">
            <input class="login_username" type="text" align="center" placeholder="등록하신 아이디를 작성해주세요." name="id" id="id"> 
               <input class="login_email" type="email" align="center" placeholder="등록하신 이메일을 작성해주세요." name="email" id="email"> 
                  <input type="submit" class="login_submit" align="center" value="비밀번호 찾기">
        
            
            </form>
         </div>

      </div>

   </nav>





</body>
</html>