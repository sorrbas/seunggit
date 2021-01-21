<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.effects.core.js"></script>
<style>
body {
	background-color: #ffd0d1
}

* {
	margin: 0;
	padding: 0;
}

.title {
	font-family: "궁서", Arial, Dotum, Helvetica, AppleGothic, Sans-serif;
	font-size: 40px;
	font-weight: bold;
	position: absolute;
	top: 70px;
	left: 30px;
}

.title span {
	font-size: 20px
}

#menu {
	font-family: "Trebuchet MS", sans-serif;
	font-size: 24px;
	font-style: normal;
	font-weight: bold;
	letter-spacing: 1.4px;
	position: fixed;
}

#menu .item {
	position: absolute;
}

.daegu1 {
	top: 450px;
	left: 100px;
}

.daegu2 {
	top: 350px;
	left: 200px;
}

.daegu3 {
	top: 300px;
	left: 300px;
}

.daegu4 {
	top: 200px;
	left: 400px;
}

.daegu5 {
	top: 400px;
	left: 500px;
}

.daegu6 {
	top: 500px;
	left: 700px;
}

.item img.circle {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 50px;
	height: 50px;
	opacity: 0.1;
}

a.icon {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 50px;
	height: 50px;
	background: #ccc;
	border-radius: 25px;
}

.daegu1 a.icon {
	background: #dda0dd;
}

.daegu2 a.icon {
	background: #fef0ef;
}

.daegu3 a.icon {
	background: #dda0dd;
}

.daegu4 a.icon {
	background: #fef0ef;
}

.daegu5 a.icon {
	background: #fff0cf;
}

.daegu6 a.icon {
	background: #fff0cf;
}

.item h2 {
	color: #555;
	font-size: 20px;
	position: absolute;
	top: 10px;
	left: 40px;
	text-shadow: 1px 1px 1px #fff;
	text-transform: uppercase;
}

.item ul {
	list-style: none;
	position: absolute;
	top: 50px;
	left: 50px;
	display: none;
}

.item ul li a {
	font-size: 15px;
	text-decoration: none;
	color: #555;
	text-shadow: 1px 1px 1px #fff;
	padding: 2px;
	float: left;
	clear: both;
}

.item ul li a:hover {
	color: #fff;
	text-shadow: 1px 1px 1px #555;
}

.item h2.active {
	color: #fff;
	text-shadow: 1px 0px 1px #555;
}
</style>
<meta charset="UTF-8">
<title>학사정보</title>
</head>
<body>

	<div id="menu">
		<div class="item daegu1">
			<img src="images/goguma.png" title="" class="circle" /> <a href="#"
				class="icon"></a>
			<h2>register</h2>
			<ul>
				<li><a href="student/student.jsp">student</a></li>
				<li><a href="professor/professor_register_form.jsp">professor</a></li>
				<li><a href="manager/manager_register_form.jsp">manager</a></li>
			</ul>
		</div>
		<div class="item daegu2">
			<img src="images/goguma.png" title="" class="circle" /> <a href="#"
				class="icon"></a>
			<h2>search</h2>
			<ul>
				<li><a href="student/student_search_form.jsp">student</a></li>
				<li><a href="professor/professor_search_form.jsp">professor</a></li>
				<li><a href="manager/manager_search_form.jsp">manager</a></li>
			</ul>
		</div>
		<div class="item daegu3">
			<img src="images/goguma.png" title="" class="circle" /> <a href="#"
				class="icon"></a>
			<h2>delete</h2>
			<ul>
				<li><a href="student/student_delete_form.jsp">student</a></li>
				<li><a href="professor/professor_delete_form.jsp">professor</a></li>
				<li><a href="manager/manager_delete_form.jsp">manager</a></li>
			</ul>
		</div>
		<div class="item daegu4">
			<img src="images/goguma.png" title="" class="circle" /> <a href="#"
				class="icon"></a>
			<h2>list</h2>
			<ul>
				<li><a href="student/studentList.jsp">student</a></li>
				<li><a href="professor/professor_list.jsp">professor</a></li>
				<li><a href="manager/manager_list.jsp">manager</a></li>
				<li><a href="haksaList">haksaList</a></li>
			</ul>
		</div>
		<div class="item daegu5">
			<img src="images/goguma.png" title="" class="circle" /> <a href="#"
				class="icon"></a>
			<h2>update</h2>
			<ul>
				<li><a href="student/student_update_form.jsp">student</a></li>
				<li><a href="professor/professor_update_form.jsp">professor</a></li>
				<li><a href="manager/manager_update_form.jsp">manager</a></li>
			</ul>
		</div>
		<div class="item daegu6">
			<img src="images/goguma.png" title="" class="circle" /> <a
				href="index.jsp" class="icon"></a>
			<h2>Home</h2>
		</div>
	</div>


	<script>
		$(function() {
			$('#menu > div').hover(function() {
				var $el = $(this);
				$el.find('.circle').stop().animate({
					'width' : '199px',
					'height' : '199px',
					'opacity' : '0.8',
					'top' : '-25px',
					'left' : '-25px'
				}, 500, 'easeOutBack', function() {
					$(this).parent().find('ul').fadeIn(400);
				});
				$el.find('h2').addClass('active');
			}, function() {
				var $el = $(this);
				$el.find('ul').fadeOut(500);
				$el.find('.circle').stop().animate({
					'width' : '50px',
					'height' : '50px',
					'top' : '0px',
					'left' : '0px',
					'opacity' : '0.1'
				}, 4000, 'easeOutBack');
				$el.find('h2').removeClass('active');
			});
		});
	</script>
</body>
</html>