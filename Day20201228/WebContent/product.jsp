<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트</title>
</head>
<body>
<h1>상품 리스트</h1>
<form action="CartSave" method="GET">
 <input type="radio" name="product"  value="BMW">BMW<br>
 <input type="radio" name="product"  value="SM5">SM5<br>
 <input type="radio" name="product"  value="K7">K7<br>
 <input type="submit" value="카드저장">
</form>
</body>
</html>
