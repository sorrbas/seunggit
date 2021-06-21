<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% int journal_no = Integer.parseInt(request.getParameter("journal_no")); %>
<html>
	<head>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='updateForm']");
			
			$(".cancel_btn").on("click", function(){
				location.href = "/diary/info?diary_no=${replyUpdate.diary_no}"+"&journal_no="+<%=journal_no%>
			})
			
		})
		
	</script>
	<body>
	
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
		
			
			<section id="container">
				<form name="updateForm" role="form" method="post" action="/diary/replyUpdate">
					<input type="hidden" name="diary_no" value="${replyUpdate.diary_no}" readonly="readonly"/>
					<input type="hidden" id="reply" name="reply" value="${replyUpdate.reply}" />
					<input type="hidden" id="journal_no" name="journal_no" value="<%=journal_no %>"/>
					<table>
						<tbody>
							<tr>
								<td>
									<label for="content">댓글 내용</label><input type="text" id="content" name="content" value="${replyUpdate.content}"/>
								</td>
							</tr>	
							
						</tbody>			
					</table>
					<div>
						<button type="submit" class="update_btn">저장</button>
						<button type="button" class="cancel_btn">취소</button>
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>