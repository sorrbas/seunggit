<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>khjsp</title>
</head>
<body>
<form action="textareaprocess.jsp" method="get">
<fieldset>
    <legend>텍스트박스창</legend>
    <ul>
    <li><label for="텍스트">박스연습</label>
        <textarea rows="20" cols="80" name="content" placeholder="이곳에 내용을 입력하세요"></textarea>
        </li>
        <li><input type="submit" value="전송"></li>    
    </ul>

</fieldset>
</form>
</body>
</html>