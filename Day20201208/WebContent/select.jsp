<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>khjsp</title>
</head>
<body>
<form action="selectprocess.jsp" method="get">
<fieldset>
<legend>선택창</legend>
<ul>
  <li><label for="방송국">방송국</label>
  <select name="tv">
     <option value="kbs">kbs</option>
     <option value="imbc" selected="selected">imbc</option>
     <option value="sbs">sbs</option>
  </select>
  </li>
  <li><input type="submit" value="전송"></li>
</ul>
</fieldset>
</form>
</body>
</html>