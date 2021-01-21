<%@page import="notice.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="notice.NoticeBean"%>
<%@ page import="java.util.Vector"%>
<%@ page import="notice.NoticeDAO"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="Header.jsp" />
<jsp:useBean id="noticebean" class="notice.NoticeBean">
<jsp:setProperty name="noticebean" property="*" />
</jsp:useBean>
<style>
.btn {
   background-color: gray;
   color: white;
}

.table, th {
text-align : center;
}

.th1 {
width: 70px;
}

.th2 {
width: 130px;
}

a {
text-decoration: none;
}
</style>
</head>
<body>
   <%
   	  request.setCharacterEncoding("UTF-8");  
      String pageNum = request.getParameter("pageNum");
      
      if (pageNum == null || pageNum == "0") {
         pageNum = "1";
      }
      
      int pageList = 10;
      
      String keyword = request.getParameter("keyword");
      if(keyword.equals("제목")){
    	  keyword="subject";
      }
      else if(keyword.equals("작성자")){
    	  keyword="writer";
      }
      else if(keyword.equals("내용")){
    	  keyword="content";
      }
      
      String searchSubject = request.getParameter("search");
      int pageNum1 = Integer.parseInt(pageNum);
      
      NoticeDAO ndao = new NoticeDAO();
      Paging paging = new Paging(pageNum);
      paging.setTotalCount(ndao.getCount(searchSubject, keyword));
      Vector<NoticeBean> vec = ndao.searchNotice(pageNum1, pageList, searchSubject, keyword);
   %>

   <div class="row">
      <div class="col-xs-2"></div>
      <div class="col-xs-8 col-md-8">
         <h2 class="text-center">공지사항</h2>
         	<p class="text-right">
				<input type="button" value="글쓰기" class="btn"
					onclick="location.href='index.jsp?page=notice/NoticeWrite'">
			</p>
        <div class="table-responsive">
           <table class="table table-striped"> <!-- bordered 세로줄 / -->
               <tr>
                  <th class="th1">번호</th>
                  <th>제목</th>
                  <th class="th2">작성자</th>
                  <th class="th2">작성일</th>
                  <th class="th1">조회수</th>
               </tr>
               <%
               		if(vec.size() > 0) {
                	  for (int i = 0; i < vec.size(); i++) {
                    	 NoticeBean bean = vec.get(i); //벡터에 저장되어 있는 빈클래스를 하나씩 추출
               %>
               <tr>
                  <td><%=paging.getNumber() - i%></td>
                  <td><a href="index.jsp?page=notice/NoticeInfo&&num=<%=bean.getNum()%>">
                        <%
                           if (bean.getRe_step() > 1) {
                                 for (int j = 0; j < (bean.getRe_step() * 5); j++) {
                        %> &nbsp; <%
                              }
                       }%> 
                      <%=bean.getSubject()%></a></td>
                  <td><%=bean.getWriter()%></td>
                  <td><%=bean.getReg_date()%></td>
                  <td><%=bean.getReadcount()%></td>
               </tr>
               <%
                  }
               	}else {
               		out.println("<tr><td colspan='6'>게시글이 없습니다.</td></tr>");
               	}
               %>
               <tr>
                  <td colspan="5" class="text-center">
                     <nav>
                        <ul class="pagination">
                           <%
                              if (paging.getStartPage() > 10) {
                           %>
                           <li><a href="index.jsp?page=notice/NoticeSearchProc&keyword=<%=keyword%>&search=<%=searchSubject %>&pageNum=<%=paging.getPrev()%>"
                              aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                           <%
                              }
                              for (int i = paging.getStartPage(); i <= paging.getEndPage(); i++) {
                           %>
                           <li
                              <%if (i == Integer.parseInt(pageNum))
               				  out.print("class='active'");%>><a href="index.jsp?page=notice/NoticeSearchProc&keyword=<%=keyword%>&search=<%=searchSubject %>&pageNum=<%=i%>"><%=i%>
               				  <span class="sr-only">(current)</span></a></li>
                           <%
                              }
                              if (paging.getEndPage() < paging.getPageCount()) {
                           %>
                           <li><a href="index.jsp?page=notice/NoticeSearchProc&keyword=<%=keyword%>&search=<%=searchSubject %>&pageNum=<%=paging.getNext()%>"
                              aria-label="next"><span aria-hidden="true">&raquo;</span></a></li>
                           <%
                              }
                           %>                          
                        </ul>
                        <p class="text-left">
								<input type="button" value="목록" name="list" class="btn1" onclick="location.href='index.jsp?page=notice/NoticeList'"
										style="vertical-align: text-top; color: white; font-size: 12pt; width: 50px; height: 33px; background-color: #8C8C8C; border-width: 0 0 0 0;">
						</p>
                     </nav>
                  </td>
               </tr>
            </table>
            </div>
         </div>
      </div>
</body>
</html>




