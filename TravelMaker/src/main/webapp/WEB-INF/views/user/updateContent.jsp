<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
#updatetitle{
   margin-left: 330px;
   margin-top: 25px;
}
#updatetable{
margin-left: 300px;
margin-top: 60px;
}
#bbb{
margin-left: 500px;
margin-top: 10px;
}

table {
   width: 360px;
   height: 250px;
   border-right: none;
   border-left: none;
   border-top: none;
   border-bottom: none;
   
}

th {
   background-color: #B2CCFF;
   color: #050099;
   border-radius: 10px 10px 10px 10px;
   border-color: #4641D9;
 text-shadow: -1px 0 #F2F1F6, 0 1px #F2F1F6, 1px 0 #F2F1F6, 0 -1px #F2F1F6;
 -moz-text-shadow: -1px 0 #F2F1F6, 0 1px #F2F1F6, 1px 0 #F2F1F6, 0 -1px #F2F1F6;
 -webkit-text-shadow: -1px 0 #F2F1F6, 0 1px #F2F1F6, 1px 0 #F2F1F6, 0 -1px #F2F1F6;
}
td {
   width: 230px;
   text-align: center;
   border-color: #4641D9;
   border-radius: 10px 10px 10px 10px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="journalContentContainer">
<div id = "updatetitle">
      <h1>회원수정 페이지</h1>
      </div>
   <form action="/update.do" method="post" name="fr">
     <div id = "updatetable">
       <table border="1">
            <tr>
                <th>아이디</th>
                <td><input type="text" name="id" value="${VO.id }" readonly style="background-color:transparent; border:0 solid black;text-align:center;"></td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="password"  placeholder="비밀번호를 입력하세요" required style="background-color:transparent; border:0 solid black;text-align:center;"></td>
            </tr>
             <tr>
                <th>이름</th>
                <td><input type="text" name="name" value="${VO.name } " style="background-color:transparent; border:0 solid black;text-align:center;"></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="text" name="email" value="${VO.email }" style="background-color:transparent; border:0 solid black;text-align:center;"></td>
            </tr>
      </table>
        </div>
   <div id = "bbb">
<input type="submit" value="수정하기" style="width: 70px; height: 30px; color: #5D5D5D; font-size: 15px;
      background-color: #B2CCFF; border:0; border-radius: 10px 10px 10px 10px;">
<input type="button" value="메인으로" onclick="location.href='/main'" style="width: 70px; height: 30px; color: #5D5D5D; font-size: 15px;
      background-color: #B2CCFF; border:0; border-radius: 10px 10px 10px 10px;">
</div>
   </form>
   </div>
</body>
</html>