<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KHJSP</title>
</head>
<body>

    <form action="checkboxprocess.jsp" method="get">
        <fieldset>
            <legend>과일을 선택하세요</legend>

            <ul>

                <li><label for="사과">사과</label> <input type="checkbox"
                    name="fruit" value="사과"></li>

                <li><label for="배">배</label> <input type="checkbox"
                    name="fruit" value="배"></li>

                <li><label for="바나나">바나나</label> <input type="checkbox"
                    name="fruit" value="바나나"></li>

                <li><input type="submit" value="누르세요"></li>

            </ul>

        </fieldset>
    </form>
</body>
</html>