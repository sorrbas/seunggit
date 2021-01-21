<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>fileUpload 실습</h1>
<form action="Upload" method="post" enctype="multipart/form-data">
작성자:<input type="text" name="theAuthor">
파일 : <input type="file" name="theFile">
<input type="submit" value="upload">

</form>
</body>
</html>