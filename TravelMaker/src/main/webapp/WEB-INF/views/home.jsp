<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
//     HttpSession session = request.getSession();
//     Object islogin = session.getAttribute("login");
//     String is_login = (String)islogin;
%>
<%
HttpSession session = request.getSession();
String id = (String) session.getAttribute("id");
// if(id == null) response.sendRedirect("/");
%>
<html>
<head>
<title>Home</title>
<link href="${path}/resources/css/home.css?v=2" rel="stylesheet" />
<link href="${path}/resources/css/total.css?v=2" rel="stylesheet" />
<link href="${path}/resources/css/ryan.css?v=4" rel="stylesheet" />
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js" 
integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" 
crossorigin="anonymous">
</script>
</head>
<body>
<%-- <input type="hidden" value="<%=is_login%>" id = "login_checkk"> --%>
   <div id="index_background">
      <div id="index_title">Travel Maker</div>
      <div class="sign">
         <div>
            <div id="sign_in">로그인</div>
         </div>
         <div>
            <div id="sign_up">회원가입</div>
         </div>
      </div>
   </div>
   <!-- 로그인 -->
   <div id="login_modal">
      <form id = "login_form" method = "post">
         <div id="modal_close">
            <div id="close_btn">닫기</div>
         </div>
         <svg id="ryan" viewBox="0 0 120 120"
            xmlns="http://www.w3.org/2000/svg">
            <path d="M0,150 C0,65 120,65 120,150" fill="#e0a243"
               stroke="#000" stroke-width="2.5" />
            <g class="ears">
                <path d="M46,32 L46,30 C46,16 26,16 26,30 L26,32"
               fill="#e0a243" stroke="#000" stroke-width="2.5"
               stroke-linecap="round" transform="rotate(-10,38,24)" />
                <path d="M74,32 L74,30 C74,16 94,16 94,30 L94,32"
               fill="#e0a243" stroke="#000" stroke-width="2.5"
               stroke-linecap="round" transform="rotate(10,82,24)" />
            </g>
            <circle cx="60" cy="60" r="40" fill="#e0a243" stroke="#000"
               stroke-width="2.5" />
            <g class="eyes">
                <!-- left eye and eyebrow-->
                <line x1="37" x2="50" y1="46" y2="46" stroke="#000"
               stroke-width="3" stroke-linecap="round" />
                <circle cx="44" cy="55" r="3" fill="#000" />
                <!-- right eye and eyebrow -->
                <line x1="70" x2="83" y1="46" y2="46" stroke="#000"
               stroke-width="3" stroke-linecap="round" />
                <circle cx="76" cy="55" r="3" fill="#000" />
            </g>
            <g class="muzzle">
                <path
               d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71"
               fill="#fff" />
                <path
               d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71"
               fill="#fff" stroke="#000" stroke-width="2.5"
               stroke-linejoin="round" stroke-linecap="round" />
                <polygon points="59,63.5,60,63.4,61,63.5,60,65"
               fill="#000" stroke="#000" stroke-width="5" stroke-linejoin="round" />
            </g>
            <path
               d="M40,105 C10,140 110,140 80,105 L80,105 L70,111 L60,105 L50,111 L40,105"
               fill="#fff" />
        </svg>
         <input type="text" class = "login_id" id = "login_id" name = "id" placeholder="email@domain.com"> 
         <input type="password" class = "login_pw" id = "login_pw" name = "password" placeholder="Password">
         <c:if test="${result == 0 }">
         <div class = "login_warn">사용자 ID 또는 비밀번호를 잘못 입력하였습니다.</div>
         </c:if>
         <input type="button" class = "login_btn" value="로그인">
         <div id = "idpwsearch" style = "margin-top: 10px;">
         <input type = "button" id = "search_id" value = "아이디 찾기" style = "color :orange; margin-left: 10px;">
         <input type = "button" id = "search_pw" value = "비밀번호 찾기" style = "color :orange; ">
<!--          <a href = "#searchid_modal" class = "searchid" style = "text-decoration: none; margin-left: 25px; margin-right: 30px;">아이디 찾기</a> -->
<!--          <a href = "" class = "searchpw" style = "text-decoration: none;">비밀번호 찾기</a> -->
         </div>
      </form>
   </div>
   
   <!-- 아이디 찾기 -->
    <div id="searchid_modal">
      <form id = "searchid_form" method = "post">
         <div id="modal_close">
            <div id="close_btn_id">닫기</div>
         </div>
         <svg id="ryan" viewBox="0 0 120 120"
            xmlns="http://www.w3.org/2000/svg">
            <path d="M0,150 C0,65 120,65 120,150" fill="#e0a243"
               stroke="#000" stroke-width="2.5" />
            <g class="ears">
                <path d="M46,32 L46,30 C46,16 26,16 26,30 L26,32"
               fill="#e0a243" stroke="#000" stroke-width="2.5"
               stroke-linecap="round" transform="rotate(-10,38,24)" />
                <path d="M74,32 L74,30 C74,16 94,16 94,30 L94,32"
               fill="#e0a243" stroke="#000" stroke-width="2.5"
               stroke-linecap="round" transform="rotate(10,82,24)" />
            </g>
            <circle cx="60" cy="60" r="40" fill="#e0a243" stroke="#000"
               stroke-width="2.5" />
            <g class="eyes">
                <!-- left eye and eyebrow-->
                <line x1="37" x2="50" y1="46" y2="46" stroke="#000"
               stroke-width="3" stroke-linecap="round" />
                <circle cx="44" cy="55" r="3" fill="#000" />
                <!-- right eye and eyebrow -->
                <line x1="70" x2="83" y1="46" y2="46" stroke="#000"
               stroke-width="3" stroke-linecap="round" />
                <circle cx="76" cy="55" r="3" fill="#000" />
            </g>
            <g class="muzzle">
                <path
               d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71"
               fill="#fff" />
                <path
               d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71"
               fill="#fff" stroke="#000" stroke-width="2.5"
               stroke-linejoin="round" stroke-linecap="round" />
                <polygon points="59,63.5,60,63.4,61,63.5,60,65"
               fill="#000" stroke="#000" stroke-width="5" stroke-linejoin="round" />
            </g>
            <path
               d="M40,105 C10,140 110,140 80,105 L80,105 L70,111 L60,105 L50,111 L40,105"
               fill="#fff" />
        </svg>
         <input type="text" class = "input_searchid_email" id = "input_searchid_email" name = "input_searchid_email" placeholder="email@domain.com"> 
     	<input type="button" class = "search_id_btn" value="아이디 찾기">
      </form>
   </div>
   
   <!-- 비밀번호 찾기 -->
<div id="searchpw_modal">
      <form id = "searchpw_form" method = "post">
         <div id="modal_close">
            <div id="close_btn_pw">닫기</div>
         </div>
         <svg id="ryan" viewBox="0 0 120 120"
            xmlns="http://www.w3.org/2000/svg">
            <path d="M0,150 C0,65 120,65 120,150" fill="#e0a243"
               stroke="#000" stroke-width="2.5" />
            <g class="ears">
                <path d="M46,32 L46,30 C46,16 26,16 26,30 L26,32"
               fill="#e0a243" stroke="#000" stroke-width="2.5"
               stroke-linecap="round" transform="rotate(-10,38,24)" />
                <path d="M74,32 L74,30 C74,16 94,16 94,30 L94,32"
               fill="#e0a243" stroke="#000" stroke-width="2.5"
               stroke-linecap="round" transform="rotate(10,82,24)" />
            </g>
            <circle cx="60" cy="60" r="40" fill="#e0a243" stroke="#000"
               stroke-width="2.5" />
            <g class="eyes">
                <!-- left eye and eyebrow-->
                <line x1="37" x2="50" y1="46" y2="46" stroke="#000"
               stroke-width="3" stroke-linecap="round" />
                <circle cx="44" cy="55" r="3" fill="#000" />
                <!-- right eye and eyebrow -->
                <line x1="70" x2="83" y1="46" y2="46" stroke="#000"
               stroke-width="3" stroke-linecap="round" />
                <circle cx="76" cy="55" r="3" fill="#000" />
            </g>
            <g class="muzzle">
                <path
               d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71"
               fill="#fff" />
                <path
               d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71"
               fill="#fff" stroke="#000" stroke-width="2.5"
               stroke-linejoin="round" stroke-linecap="round" />
                <polygon points="59,63.5,60,63.4,61,63.5,60,65"
               fill="#000" stroke="#000" stroke-width="5" stroke-linejoin="round" />
            </g>
            <path
               d="M40,105 C10,140 110,140 80,105 L80,105 L70,111 L60,105 L50,111 L40,105"
               fill="#fff" />
        </svg>
<!--         <input type = "text" class = "input_searchpw_id" id = "input_searchpw_id" name = "input_searchpw_id" placeholder="아이디"> -->
                 <input type="text" class = "input_searchpw_email" id = "input_searchpw_email" name = "input_searchpw_email" placeholder="email@domain.com"> 
         <input type="button" class = "search_pw_btn" value="비밀번호 찾기">
      </form>
   </div>

<!-- 회원가입 -->
   <div id="signUp_modal">
      <form id = "signUp_form" method = "post">
         <div id="modal_closee">
            <div id="close_btnn">닫기</div>
         </div>
         <svg id="ryan" viewBox="0 0 120 120"
            xmlns="http://www.w3.org/2000/svg">
            <path d="M0,150 C0,65 120,65 120,150" fill="#e0a243"
               stroke="#000" stroke-width="2.5" />
            <g class="ears">
                <path d="M46,32 L46,30 C46,16 26,16 26,30 L26,32"
               fill="#e0a243" stroke="#000" stroke-width="2.5"
               stroke-linecap="round" transform="rotate(-10,38,24)" />
                <path d="M74,32 L74,30 C74,16 94,16 94,30 L94,32"
               fill="#e0a243" stroke="#000" stroke-width="2.5"
               stroke-linecap="round" transform="rotate(10,82,24)" />
            </g>
            <circle cx="60" cy="60" r="40" fill="#e0a243" stroke="#000"
               stroke-width="2.5" />
            <g class="eyes">
                <!-- left eye and eyebrow-->
                <line x1="37" x2="50" y1="46" y2="46" stroke="#000"
               stroke-width="3" stroke-linecap="round" />
                <circle cx="44" cy="55" r="3" fill="#000" />
                <!-- right eye and eyebrow -->
                <line x1="70" x2="83" y1="46" y2="46" stroke="#000"
               stroke-width="3" stroke-linecap="round" />
                <circle cx="76" cy="55" r="3" fill="#000" />
            </g>
            <g class="muzzle">
                <path
               d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71"
               fill="#fff" />
                <path
               d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71"
               fill="#fff" stroke="#000" stroke-width="2.5"
               stroke-linejoin="round" stroke-linecap="round" />
                <polygon points="59,63.5,60,63.4,61,63.5,60,65"
               fill="#000" stroke="#000" stroke-width="5" stroke-linejoin="round" />
            </g>
            <path
               d="M40,105 C10,140 110,140 80,105 L80,105 L70,111 L60,105 L50,111 L40,105"
               fill="#fff" />
        </svg>
         <input type="text" name="id" id = "input_id" class = "input_id" placeholder="아이디">
         <span class = "input_id1">사용가능한 아이디 입니다.</span>
         <span class = "input_id2">아이디가 이미 존재합니다.</span>
         <span class = "final_id_ck">아이디를 입력해주세요.</span>
         <input type="password" name="password" id = "input_pw" class = "input_pw" placeholder="비밀번호">
         <span class = "final_pw_ck">비밀번호를 입력해주세요.</span>
         <input type="password" name="password_check" id = "input_pwck" class = "input_pwck" placeholder="비밀번호 확인">         
         <span class = "final_pwck_ck">비밀번호 확인을 입력해주세요</span>
         <span class = "input_pwck1">비밀번호가 일치합니다.</span>
         <span class = "input_pwck2">비밀번호가 일치하지 않습니다.</span>
         <input type="text" name="name" id = "input_name" class = "input_name" placeholder="이름">       
         <span class = "final_name_ck">이름을 입력해주세요</span>
         <input type = "text" name = "email" id = "input_email" class = "input_email" placeholder = "email@domain.com">           
         <span class = "final_email_ck">이메일을 입력해주세요.</span>
        <span class = "input_email_box_warn"></span>
         <div class = "email_check_wrap">
         <div class = "input_email_check_box" id = "input_email_check_box_false">
         <input class = "input_email_check" placeholder="인증번호" disabled="disabled" size =15.5>
		<span class = "final_emailnum_ck">인증번호를 입력해주세요.</span>
		</div>
         <input type = "button" class = "email_checkbtn" id = "email_checkbtn" value = "전  송">
		<span id = "input_email_check_box_warn"></span>
		</div>
		
         <input type="button" class = "sign_btn" value="가입하기">
      </form>
   </div>
   
    <script src="${path}/resources/js/ryan.js?v=9"></script>
	<script src="${path}/resources/js/home.js?v=9"></script>
   <!-- 로그인 버튼 -->
   <script>
   $(".login_btn").click(function(){
// 	   alert("로그인 버튼 작동");
	$("#login_form").attr("action", "/login");
	$("#login_form").submit();

   });
   </script>
   <!-- 아이디찾기 -->
   <script>
   $(document).ready(function() {
	   $("#search_id").click(function() {
		   $("#searchid_modal").css('display', 'inherit');
		   $("#login_modal").css('display', 'none');
	   });
	   $("#close_btn_id").click(function(){
		  $("#searchid_modal").css('display','none');
		  $("#login_modal").css('display', 'inherit');
	   });
   });
   </script>
   <!-- 아이디 찾기 버튼 -->
   <script>
   $(".search_id_btn").click(function(){
   var email = $('.input_searchid_email').val();
	  $.ajax({
		 type:"POST",
		 url:"searchid_email?email=" +email
	  });
   });
   </script>
   <!-- 비밀번호 찾기 -->
   <script>
   $(document).ready(function() {
	   $("#search_pw").click(function() {
		   $("#searchpw_modal").css('display', 'inherit');
		   $("#login_modal").css('display', 'none');
	   });
	   $("#close_btn_pw").click(function(){
		  $("#searchpw_modal").css('display','none'); 
		  $("#login_modal").css('display', 'inherit');
	   });
   });
   </script>
   <!--  비밀번호 찾기 버튼 -->
   <script>
   $(".search_pw_btn").click(function(){
	  var email = $('.input_searchpw_email').val();
// 	  var id = $('.input_searchpw_id').val();
	  $.ajax({
		 type:"POST",
		 url:"searchpw_email?email=" +email
	  });
   });
   </script>
   
<!--    <script>
    $(window).load( function() {
        var loginModal = document.getElementById('login_modal');
        var checkk = $('#login_checkk').val();
       if(checkk == "false"){
       loginModal.style.display = 'inherit';
        } 
       
    });
    </script> -->
<!--회원가입 js -->
   <script>

   /* 유효성 검사 통과유무 변수 */
   var idCheck = false;            // 아이디
   var idckCheck = false;            // 아이디 중복 검사
   var pwCheck = false;            // 비번
   var pwckCheck = false;            // 비번 확인
   var pwckorCheck = false;        // 비번 확인 일치 확인
   var nameCheck = false;            // 이름
   var emailCheck = false;            // 이메일
   var emailnum = false;			// 인증번호 입력 확인
   var emailnumCheck = false;        // 이메일 인증번호 확인
//    var addressCheck = false         // 주소
   
   $(document).ready(function() {
// 	   var checkk = $('#login_checkk').val();
// 	   alert(checkk);
         
	   $(".sign_btn").click(function() {
		   /* 입력값 변수 */
	        var id = $('.input_id').val();                 // id 입력란
	        var pw = $('.input_pw').val();                // 비밀번호 입력란
	        var pwck = $('.input_pwck').val();            // 비밀번호 확인 입력란
	        var name = $('.input_name').val();            // 이름 입력란
	        var email = $('.input_email').val();            // 이메일 입력란
	        var emailnum = $('.input_email_check').val();	// 인증번호 입력란
// 	        var addr = $('.address_input_3').val();        // 주소 입력란
	        
	        /* 아이디 유효성 검사 */
	        if(id == "") {
	        	$('.final_id_ck').css('display','block');
	        	idCheck = false;
	        } else {
	        	$('.final_id_ck').css('display', 'none');
	        	idCheck = true;
	        }
	        
	        /* 비밀번호 유효성 검사 */
	        if(pw == "") {
	        	$('.final_pw_ck').css('display', 'block');
	        	pwCheck = false;
	        } else {
	        	$('.final_pw_ck').css('display', 'none');
	        	pwCheck = true;
	        }
	        
	        /* 비밀번호 확인 유효성 검사 */
	        if(pwck == "") {
	        	$('.final_pwck_ck').css('display', 'block');
	        	pwckCheck = false;
	        } else {
	        	$('.final_pwck_ck').css('display', 'none');
	        	pwckCheck = true;
	        }
	        	
	      	/* 이름 유효성 검사 */
	      	if(name == "") {
	      		$('.final_name_ck').css('display', 'block');
	      		nameCheck = false;
	      	} else {
	      		$('.final_name_ck').css('display', 'none');
	      		nameCheck = true;
	      	}
	      	
	      	/* 이메일 유효성 검사 */
	      	if(email == "") {
	      		$('.final_email_ck').css('display', 'block');
	      		emailCheck = false;
	      	} else {
	      		$('.final_email_ck').css('display', 'none');
	      		emailCheck = true;
	      	}
	      	/* 인증번호 유효성 검사 */
	      	 if(emailnum == "") {
		        	$('.final_emailnum_ck').css('display','block');
		        	emailnumCheck = false;
		        } else {
		        	$('.final_emailnum_ck').css('display', 'none');
		        	emailnumCheck = true;
		        }
	      	
	      	/* 최종 유효성 검사 */
	        if(idCheck&&idckCheck&&pwCheck&&pwckCheck&&pwckorCheck&&nameCheck&&emailCheck&&emailnumCheck&&emailnumCheck) {
		   $("#signUp_form").attr("action", "/signUp");
		   $("#signUp_form").submit();
		   }	       
			return false;
	   });
	   /* 비밀번호 확인 일치 유효성 검사 */
	    $('.input_pwck').on("propertychange change keyup paste input", function(){
	    	var pw = $('.input_pw').val();
	    	var pwck = $('.input_pwck').val();
	    	$('.final_pwck_ck').css('display', 'none');
	    	
	    	if(pw == pwck) {
	    		$('.input_pwck1').css('display', 'block');
	    		$('.input_pwck2').css('display', 'none');
	    		pwckorCheck = true;
	    	} else {
	    		$('.input_pwck1').css('display', 'none');
	    		$('.input_pwck2').css('display', 'block');
	    		pwckorCheck = false;
	    	}
	    });
	   
	   /* 입력 이메일 형식 유효성 검사 */
// 	   function emailFormCheck(email) {
// 		   var form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
// 		    return form.test(email);
// 	   }

   });
   </script>
   
<!--아이디 중복검사 -->
    <script>
   $('.input_id').on("propertychange change keyup paste input", function(){
// 		   console.log("ketup 테스트");
	var id = $('.input_id').val();
	var data = {id : id}
   
   $.ajax({
	   type : "post",
	   url : "/userIdCheck",
	   data : data,
	   success : function(result) {
// 		   console.log("성공여부" + result);
		if(result != 'fail') {
			$('.input_id1').css("display", "inline-block");
			$('.input_id2').css("display", "none");
			idckCheck = true;
		} else {
			$('.input_id2').css("display", "inline-block");
			$('.input_id1').css("display", "none");
			idckCheck = false;
		}
	   }
   
   });	
   }); 
   </script>
    
    <!-- 인증번호 이메일 전송 -->
    <script>
    
    var code = "";	// 이메일전송 인증번호 저장위한 코드 
    
	$('.email_checkbtn').click(function() {
		var email = $('.input_email').val(); // 입력한 이메일
		var cehckBox = $('.input_email_check');
		var boxWrap = $('.input_email_check_box');
// 		var warnMsg = $(".input_email_box_warn");
		
		/* 이메일 형식 유효성 검사 */
// 		if(emailFormCheck(email)) {
// 			warnMsg.html("이메일이 전송 되었습니다. 이메일을 확인해주세요.");
// 			warnMsg.css("display", "inline-block");
// 		} else {
// 			warnMsg.html("올바르지 못한 이메일형식 입니다.");
// 			warnMsg.css("display", "inline-block");
// 			return false;
// 		}
		
		$.ajax({
			type:"GET",
			url:"emailCheck?email=" + email,
					success:function(data){
// 						console.log("data : " + data);
						cehckBox.attr("disabled", false);
						boxWrap.attr("id", "input_email_check_box_true")
						code = data;
					}
		});
	});
	
    // 인증번호 비교
    $(".input_email_check").blur(function(){
    	var inputCode = $(".input_email_check").val();	// 입력코드
    	var checkResult = $("#input_email_check_box_warn");	// 비교 결과
    	
    	if(inputCode == code) {
    		checkResult.html("인증번호가 일치합니다");
    		checkResult.attr("class", "correct");
    		emailnumCheck = true;
    	} else {
    		checkResult.html("인증번호를 다시 확인해주세요.");
    		checkResult.attr("class", "incorrect");
    		emailnumCheck = false;
    	}
    });
   </script>
</body>
</html>