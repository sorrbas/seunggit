<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>

   <form action="textfieldProcess.jsp" method="get">
      <fieldset>
         <legend>텍스트필드</legend>
         <ul>
            <li><label for="이름">이름</label> <input type="text" name="irum"
               autofocus="autofocus" required="required" placeholder="이름을 입력해주세요">
               <!--autofocus = 자동으로 커서가 가고 커서가 깜빡임 / required = 입력정보가 없으면 경고뜨게 / placeholder = 입력창안에 텍스트  -->
            </li>

            <li><input type="submit" value="눌러라"></li>
         </ul>

      </fieldset>


   </form>
</body>
</html>