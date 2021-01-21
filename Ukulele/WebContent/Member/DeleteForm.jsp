<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>회원탈퇴</title>
        <link rel="stylesheet" href="css/Mypage.css"> 
    </head>
    <body>
        <!-- header -->
        <div id="Mypage_header">
            <img src="images/logo.png" id="logo"><a href="index.jsp"></a>
        </div>


        <!-- wrapper -->
        <div id="Mypage_wrapper">

            <!-- content-->
            <div id="Mypage_content">
               <form action="memberDelete.mb" method="get">
                <!-- PW1 -->
                <div>
                    <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
                    <span class="box int_pass">
                        <input type="password" id="pswd1" class="int" maxlength="20" name="pw">
                        <span id="alertTxt">사용불가</span>
                        <img src="m_icon_pass.png" id="pswd1_img1" class="pswdImg">
                    </span>
                    <span class="error_next_box"></span>
                </div>
               
              

                <!-- JOIN BTN-->
                <div class="btn_area">
                    <input type="submit" id="btnJoin" name="" value="탈퇴완료">
                     
                </div>
                  </form>
                

            </div> 
            <!-- content-->

        </div> 
        <!-- wrapper -->
    <script src="main.js"></script>
    </body>
</html>