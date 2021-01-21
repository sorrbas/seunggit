<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#boardtitle {
	position: absolute;
	top: 250px;
	left: 430px;
}
#memberForm {
	position : absolute;
	top: 300px; left: 420px;
}
.kh01 {
	position : absolute;
	top: 120px; left: 60px;
	width: 50px; height: 40px;
}
ul { list-style-type: none; }
li label{
	width : 100px;
	float : left
}
.reset {
	position: absolute;
	top: 130px; left: 140px;
	border: 1px solid skyblue;
	border-radius:5px, 5px, 5px, 5px;
	background-color: white;
	color: black;
	padding: 5px;
}
</style>
<script type="text/javascript">

   function win01(idform){
	   if(idform.id.value==""){
		      alert("아이디 입력해주세요");
		      return;
		   }
		   if(idform.id.value==" "){
		      alert("공백은 안대애애애애");
		      return;
		   }
	   window.open("idcheck.mb?id="+idform.id.value,"win01","width=250 height=250");
	  
   }



</script>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<div id="boardtitle">
<h2>Sign Up</h2>
</div>
<div id="memberForm">
<form action="memberRegister.mb" method="get">
<ul>
	<li><label for="아이디">아이디</label>
	<input type="text" name="id" size="20" maxlength="14" autofocus="autofocus" required="required" placeholder="ID를 입력해주세요">
	<input type="button" value="아이디중복확인" onclick="win01(this.form)"> <!-- idform == this.form -->
	</li>
	<li><label for="패스워드">패스워드</label>
	<input type="password" name="pw" size="20" maxlength="16" placeholder="패스워드를 입력해주세요">
	</li>
	<li><label for="주소">주소</label>
	<input type="text" name="addr" size="50" maxlength="100" placeholder="주소를 입력해주세요">
	</li>
	<li><label for="핸드폰번호">핸드폰번호</label>
	<input type="text" name="tel" placeholder="ex>010-0000-0000"><br>
	</li>
	<li><input type="image" src="images/registerr.png" class="kh01">
	<input type="reset" value="취소" class="reset">
	</li>
</ul>
</form>
</div>
</body>
</html>