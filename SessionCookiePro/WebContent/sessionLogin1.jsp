<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#loginArea{
   width : 400px;
   margin : auto;
   border : 1px solid black;
}
table{
   margin : auto;
}
td{
   text-align: center;
}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<section id = "loginArea">
   <form action = "sessionLogin2.jsp" method = "post">
      <table>
         <tr>
            <td><label for="id">아이디</label></td>
            <td><input type = "text" name = "id" id = "id"></td>
         </tr>
         <tr>
            <td><label for = "pass">비밀번호</label></td>
            <td><input type = "password" name = "pass" id = "pass"></td>
         </tr>
         <tr>
            <td colspan="2"><input type = "submit" value = "로그인">
            <input type = "reset" value = "되돌려줘"></td>
         </tr>
      </table>
   </form>
</section>
</body>
</html>