<%@page import="java.sql.Connection"%>
<%@page import="org.apache.catalina.connector.OutputBuffer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp"/>
</head>

<body>
<%
   String id = (String)session.getAttribute("id");
   String pw = (String)session.getAttribute("pw");
   String email = (String)session.getAttribute("email");
%>
<div class="row">
   <div class="col-md-2"></div>
   <div class="col-md-8">
      <h2 class="text-center">게시글 쓰기</h2>
      <form action="UploadService" method="post" enctype="multipart/form-data">
        <table class="table table-striped">
          <tr>
             <td>작성자</td>
             <td><input type="text"  class="form-control" name="writer" value="<%=id%>"readonly="readonly"></td>
          </tr>
          <tr>
             <td>제목</td>
             <td><input type="text"  class="form-control" name="subject"></td>
          </tr>
          <tr>
             <td>이메일</td>
             <td><input type="email"  class="form-control" name="email" value="<%=email%>"readonly="readonly"></td>
          </tr>          
          <tr>
          <td>파일</td>
          <td><input type = "file" name = "fileName" value = "파일 선택"></td>
          </tr>
          <tr>
             <td>글내용</td>
             <td><textarea rows="10" cols="50" name="content" class="form-control"></textarea></td>
          </tr>
           <tr>
             
             <td colspan="2"  class="text-center">
               <input type="submit" value="글쓰기" class="btn btn-success">                
               <input type="reset" value="다시작성" class="btn btn-warning">
                <button type="button"  class="btn btn-primary" onclick="location.href='selectService'">전체 게시글보기</button>
             </td>
          </tr>
        </table>
             <input type="hidden"  class="form-control" name="password" value="<%=pw%>">
      </form>
   </div>
</div>

<script>
CKEDITOR.replace('content', {
      
   width:'100%',
   height:'350'
      
});

</script>
</body>
</html>

