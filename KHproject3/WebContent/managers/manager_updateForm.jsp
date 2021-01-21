<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.kh01 {
	position : absolute;
	width: 60px; height: 50px;
	top: 75px; left: 305px;
}

ul {list-style-type: none;}
</style>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>
<h1>관리자수정</h1>
 <div id="managerUpdate">
      <form action="../managerUpdate.do" method="get">
         <ul>
            <li><label for="수정할이름">수정할이름</label> 
            <input type="text" name="irum"></li>
            <li><input type="image" src="../images/update1.png" class="kh01">
            </li>
         </ul>
      </form>
      &nbsp;&nbsp;&nbsp; <a href="managerList.jsp">관리자목록</a>
   </div>
</body>
</html>