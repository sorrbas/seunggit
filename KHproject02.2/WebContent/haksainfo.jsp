<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/jquery.effects.core.js"></script>
<style>

/** {
	margin: 0;
	padding: 0;
}*/

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
   position: absolute;
   font-family: "Trebuchet MS", sans-serif;
   font-size: 24px;
   font-style: normal;
   font-weight: bold;
   letter-spacing: 1.4px;
}

#menu .item {
   position: absolute;
}


.daegu1 {
   top: 300px;
   left: 300px;
}

.daegu2 {
   top: 300px;
   left: 470px;
}

.daegu3 {
   top: 300px;
   left: 640px;
}

.daegu4 {
   top: 300px;
   left: 810px;
}

.daegu5 {
   top: 300px;
   left: 980px;
}

.daegu6 {
   top: 300px;
   left: 1150px;
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
	background: #FC5549;
}

.daegu2 a.icon {
	background: #FF9900;
}

.daegu3 a.icon {
	background: #FCEE53;
}

.daegu4 a.icon {
	background: #3DD158;
}

.daegu5 a.icon {
	background: #2492E0;
}

.daegu6 a.icon {
	background: #A047ED;
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
<title>Insert title here</title>
</head>
<body>
	<div id="menu">
		<div class="item daegu1">
			<img src="images/bubble.png" title="" class="circle" /> <a href="#"
				class="icon"></a>
			<h2>register</h2>
			<ul>
				<li><a href="student/student.jsp">student</a></li>
				<li><a href="professor/professor.jsp">professor</a></li>
				<li><a href="managers/manager.jsp">manager</a></li>
			</ul>
		</div>
		<div class="item daegu2">
			<img src="images/bubble.png" title="" class="circle" /> <a href="#"
				class="icon"></a>
			<h2>search</h2>
			<ul>
				<li><a href="student/student_searchForm.jsp">student</a></li>
				<li><a href="professor/professor_searchForm.jsp">professor</a></li>
				<li><a href="managers/manager_searchForm.jsp">manager</a></li>
			</ul>
		</div>
		<div class="item daegu3">
			<img src="images/bubble.png" title="" class="circle" /> <a href="#"
				class="icon"></a>
			<h2>delete</h2>
			<ul>
				<li><a href="student/student_deleteForm.jsp">student</a></li>
				<li><a href="professor/professor_deleteForm.jsp">professor</a></li>
				<li><a href="managers/manager_deleteForm.jsp">manager</a></li>
			</ul>
		</div>
		<div class="item daegu4">
			<img src="images/bubble.png" title="" class="circle" /> <a href="#"
				class="icon"></a>
			<h2>list</h2>
			<ul>
				<li><a href="studentList.do">student</a></li>
				<li><a href="professorList.do">professor</a></li>
				<li><a href="managerList.do">manager</a></li>
			</ul>
		</div>
		<div class="item daegu5">
			<img src="images/bubble.png" title="" class="circle" /> <a href="#"
				class="icon"></a>
			<h2>update</h2>
			<ul>
				<li><a href="student/student_updateForm.jsp">student</a></li>
				<li><a href="professor/professor_updateForm.jsp">professor</a></li>
				<li><a href="managers/manager_updateForm.jsp">manager</a></li>
			</ul>
		</div>
		<div class="item daegu6">
			<img src="images/bubble.png" title="" class="circle" /> <a href="#"
				class="icon"></a>
			<h2>mainpage</h2>
			<ul>
				<li><a href="index.jsp">main</a></li>
			</ul>
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