<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
ul#leftmenu{
 position: fixed;
 top: 200px;
 left: 0px;
 z-index: 9999;
 list-style-type: none;
 margin: 0px;
 padding: 0px;
}
ul#leftmenu li{
 width: 100px;
 margin-bottom: 2px;
}

ul#leftmenu li a{
 background-color: #ccc;
 color: #fff;
 text-decoration: none;
 display: block;
 width: 90px;
 padding: 10px 0 10px 10px;
 -webkit-border-bottom-right-radius: 20px;
 -webkit-border-top-right-radius: 20px;
 margin-left: -1px;
 opacity: 0.6;
}
ul#leftmenu .daegu1 a{background-color: red;}
ul#leftmenu .daegu2 a{background-color: orange;}
ul#leftmenu .daegu3 a{background-color: pink;}
ul#leftmenu .daegu4 a{background-color: green;}
ul#leftmenu .daegu5 a{background-color: blue;}
ul#leftmenu .daegu6 a{background-color: purple;}

</style>
<script src="js/jquery-1.10.2.js"></script>
<meta charset="UTF-8">
<title>kh정보교육원</title>
</head>
<body>
<ul id="leftmenu">
 <li class="daegu1"><a href="index.jsp">메인페이지</a></li>
 <li class="daegu2"><a href="index.jsp">퐁퐁이</a></li>
 <li class="daegu3"><a href="">귤먹는</a></li>
 <li class="daegu4"><a href="">퐁퐁이</a></li>
 <li class="daegu5"><a href="">고구마먹는</a></li>
 <li class="daegu6"><a href="">퐁퐁이</a></li>
</ul>
<script>
$(function() {
 $('#leftmenu a').css('marginLeft','-85px');
  $('#leftmenu > li').hover(function() {
   $('a',$(this)).stop().animate({'marginLeft':'-1px'},300);
  },
  function() {
   $('a',$(this)).stop().animate({'marginLeft':'-85px'},300);
  });
});
</script>
</body>
</html>