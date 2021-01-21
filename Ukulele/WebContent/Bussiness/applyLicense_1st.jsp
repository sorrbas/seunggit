<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
	#apply_cover{
		padding-right: 30%;
		text-align: center;
	}
	#apply_cover span{
		font-size: xxx-large;
	}
	#apply_notice{
		border:3px solid black;
		border-radius: 3px;
		margin-top: 50px;
		margin-bottom: 50px;
		text-align: left;
	}
	#accept_check{
		border:3px solid black;
		border-radius: 3px;
		text-align: left;
	}
	#acception{
		text-align: center;
	}
	#write_data{
	text-align: left;
	}
	.write_data2{
		display: flex;
		margin-bottom: 20px;
	}
	.write_data2 label{
		width: 200px;
	}
</style>
</head>
<body>
<div id="apply_cover">
<span>1급 자격증 신청</span>
<div id="apply_notice">
<div>응시료 100,000원 (자격증 발급비 포함)</div>
<div>시험 전 자격증 발급을 위해 별도의 사진촬영이 있으며, 자격시험 중 반주곡 및 연주곡은 동영상촬영이 진행 됩니다.</div>
<div>촬영된 사진 및 영상의 저작권은 한국우쿨렐레예술협회에 속하게 됩니다.(본인의 영상을 원하시는 분은 E-mail로 발송해드립니다.)</div>
<div>자격시험 신청인원은 한국우쿨렐레예술협회 정회원으로 자동 등록 됩니다.</div>
</div>
<form action="Bussiness/applyLicenseProc.jsp" method="get">
	<div id="accept_check">
	<div>개인정보 활용 동의서</div>
	<div>본인은 「한국우쿨렐레예술협회」의 우쿨렐레문화예술사업의 원활한 수행을 위해 개인정보를 제공 및 
아래와 같이 활용하는 것에 동의합니다. ※ 관련 법규 : 개인정보 보호법 제15조, 제22조, 제24조</div>
<div>
<div>〇 개인정보 수집목적</div>
<div>- 우쿨렐레 자격 심사, 평가 및 자격발급, 기타 문화예술교육 관련 사업 홍보를 위한 목적에만 이용</div>
<div>〇 개인정보 수집항목</div>
<div>- 협회 회원 : 이름, 생년월일, 연락처, 등</div>
<div>〇 개인정보 이용방법</div>
<div>- 한국우쿨렐레예술협회에서 업무 처리 시 사용</div>
</div>
</div>
	<label>동의<input type="checkbox" name="accept" value="동의" required="required" id="acception"></label>
	<div id="write_data">
	<div class="write_data2">
	<label>이름</label>
	<input type="text" name="name" required="required" id="name">
	</div>
	<div class="write_data2">
	<label>전화번호</label>
	<input type="text" name="tel" required="required" id="tel">
	</div>
	<div class="write_data2">
	<label>주소</label>
	<input type="text" name="addr" required="required" id="addr">
	</div>
	<div class="write_data2">
	<label>생년월일</label>
	<input type="text" name="birth" required="required" id="birth">
	</div>
	<input type="hidden" name="license_id" value="<%=session.getAttribute("id") %>">
	<input type="hidden" name="license_email" value="<%=session.getAttribute("email") %>">
	<input type="hidden" name="grade" value="1">
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
%>
	<input type="hidden" name="date" value="<%= sf.format(nowTime) %>">
	<input type="submit" value="신청하기">
	<input type="reset" value="취소">
	</div>
</form>
</div>
</body>
</html>