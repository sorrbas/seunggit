<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <meta charset="utf-8">
  <title>대구가톨릭대학교</title>
  <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
  <style>
  <link href="css/top.css">
   body {
   	background-image: url("images/backg.png");
   	background-repeat: no-repeat;
   	background-size: 2000px;
	background-attachment: fixed;
	width: 1500px; height: 1000px;
	}
    
   #ALL {
    width: 700px;
    margin: 30px auto;
    /*background: #FFF;*/
    padding: 20px;}  
   .menu { 
    height: 45px;
    background: #FFA8E4;} /*#000*/
   .menu ul {
    list-style: none;
    padding: 0;
    margin: 0;}
   .menu ul li {
    float: left;
    overflow: hidden;
    text-align: center;    
    line-height: 45px;}
   .menu ul li a {
    position: relative;
    display: block;
    width: 110px;
    height: 45px;
    color: #FFF; 
    font-family: Sans-serif;
    font-size: 12px;
    font-weight: bold;
    letter-spacing: 1px;
    text-transform: uppercase;
    text-decoration: none;
    cursor: pointer;}

   .menu ul li a span {
    position: absolute;
    top: 0px;
    left: 0;
    width: 110px; } 
   .menu ul li a span.over{
    top: -45px; } 
   .menu ul li a span.over {
    background: #FFF;
    color: #000;}
    
    .khlogo {
	width: 200px; height: 100px;
}
#khmember {
	position: absolute;
	top: 5px; left: 570px;
	width: 260px; height: 20px;
	/*border: 0px solid red;*/
	font-family : Malgun Gothic;
	font-size: 14px;
}
#news1 {
	position: absolute;
	top: 200px; left: 710px;
	width: 200px; height: 30px;
}

ul {
	list-style-type: none;
}
a {
text-decoration : none;
}
a:hover { 
text- decoration : underline;
}
#logout {
	position : absolute;
	top : 178px; left : -80px;
	font-size : 12px;
}
  </style>
    <script src="js/jquery-1.10.2.js"></script>
	<script src="js/jquery.innerfade.js"></script>
 </head>
 <body>

  <div id="ALL">
  <h1><img src="images/khkh.jpg" class="khlogo"></h1>
   <!-- <h1>DAEGU CU</h1> -->
    <div id="khmember">
		<a href="index.jsp">홈 |</a> 
		<a href="index.jsp?page=member/memberForm">회원가입 | </a> 
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
     <li><a href="#">KH-B클래스</a></li>
     <li><a href="#">포트폴리오</a></li>
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
	<script>
	$('#news').innerfade({
		animationtype : 'slide',
		speed : 750,
		timeout : 2000,
		type : 'sequence',
		containerheight : '1em'
	});
</script>
  </div>

  <script type="text/javascript">
   $(function(){
    $(".menu li a").wrapInner( '<span class="out"></span>' );

    $(".menu li a").each(function() {
     $( '<span class="over">' +  $(this).text() + '</span>' ).appendTo( this );
    });


    $(".menu li a").hover(function() {
     $(".out", this).stop().animate({'top': '45px'}, 200); 
     $(".over", this).stop().animate({'top': '0px'}, 200);

    }, function() {
     $(".out", this).stop().animate({'top': '0px'},  200); 
     $(".over", this).stop().animate({'top': '-45px'}, 200);
    });
   });
  </script>
     </body>
</html>