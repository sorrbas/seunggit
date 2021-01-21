<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>khjsp</title>
</head>
<body>

<form action="fileUpload.jsp" method="post" enctype="multipart/form-data">

파일 업로드 폼 <br>
올린사람 : <input type="text" name="name" ><br>
제목 : <input type ="text" name="subject"><br>
파일명1<input type="file" name="fileName1"><br>
파일명2<input type="file" name="fileName2"><br>
<input type="submit" vlaue="전송">




</form>

</body>
</html>