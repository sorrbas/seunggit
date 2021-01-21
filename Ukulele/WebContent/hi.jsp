<%@page import="java.sql.Connection"%>
<%@page import="org.apache.catalina.connector.OutputBuffer"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Board/Header.jsp" />
<%-- <jsp:include page = "left-sidebar.jsp"/> --%>

</head>
<meta charset="UTF-8">
<title>인사말</title>

<body>
<div class="all" style="margin-left:550px;  width: 50%; padding: 10px; font-size:1.5em; "><strong style="color: #CCA63D;">인사말</strong>
</div>
<hr>
<div class="all_two" style="margin: auto; width: 600px; height:100%;  padding: 26px; text-align-last: left;">
<img src="images/ukukuku.jpg" style="display: block; position:absolute; left:500px;display: inline-block; width:200px; height:250px;">
<div style="line-height: 30px; font-size: 15px; text-align:center; ">
<p style="color: #9FC93C; font-size: 22px; font-weight: 600; padding-bottom: 20px; ">&nbsp;"Ukulele for a better world 우쿨렐레와 함께 세상을 아름답게라는 모토와 함께하는 비영리민간단체 입니다."</p>
<br>
<p style="color: #4C4C4C; font-size: 18px; font-weight: 600; padding-bottom: 20px; ">&nbsp;
본 협회는 다양한 문화예술 나눔활동을 통해 소통과 공감을 이끄는 문화예술의 가치를 실현합니다.<br><br>
본 협회는 문화예술의 발전에 기여하는데 그 목적을 두기에 문화예술 전통 및 전문성 확립, 인재양성을 위한 프로그램 개발을 시행하고 있습니다.
또한  청소년, 노인, 다문화가정 등 문화예술 취약계층에게 문화예술교육지원과 재능기부 활동을 통해 문화복지에 이바지 하고 있습니다.<br><br>
본 협회는  문화예술의 가치를 향유하는 사회 통합예술 교육을 통해 국제 문화예술 교류를 지향할뿐만 아니라  한국우쿨렐레 음악교육 보급에 앞장서 세계 각국의 우쿨렐레 단체 및 협회들과 음악교류를 통해 국제우쿨렐레 저변확대에 노력하고 있습니다. 
더 많은 사람들에게 우쿨렐레를 알리기 위해 꾸준히 성장할 것입니다. 감사합니다.</p>
<br><br>
<p style="color: #4C4C4C; font-size: 18px; font-weight: 600; padding-bottom: 10px; text-align-last: right;">한국우쿨렐레예술협회 대표  김이학
</p>
</div>
</div>
</body>
</html>