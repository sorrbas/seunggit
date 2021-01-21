<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
   width: 450px;
   margin: auto;
}

h1 {
   text-align: center;
}

td {
   border: 1px dotted black;
}
</style>
<meta charset="UTF-8">
<title>자바메일보내기폼</title>
</head>
<body>
   <form action="mailSend" method="post">


      <h1>자바메일 보내기</h1>
      <table>
         <tr>
            <td>보내는사람 메일:</td>
            <td><input type="text" name="sender"></td>
         </tr>
         <tr>
            <td>받는사람 메일:</td>
            <td><input type="text" name="receiver"></td>
         </tr>
         <tr>
            <td>제목:</td>
            <td><input type="text" name="subject"></td>
         </tr>
         <tr>

            <td>내용:</td>
            <td><textarea name="content" rows="20" cols="40"></textarea></td>
         </tr>
         <tr>
            <td align="center" colspan="2"><input type="submit" value="보내기"></td>
         </tr>


      </table>
   </form>

</body>
</html>