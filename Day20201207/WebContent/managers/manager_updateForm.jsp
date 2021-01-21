<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.kh01 {
	width: 100px; height: 80px;
}

ul {list-style-type: none;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<h1>관리자수정</h1>
 <div id="managerUpdate">
      <form action="manager_updateConfirm.jsp" method="get">
         <ul>
            <li><label for="수정할이름">수정할이름</label> 
            <input type="text" name="irum"></li>
            <li><input type="image" src="../images/update.jpg" class="kh01">
            </li>
         </ul>
      </form>
   </div>
</body>
</html>