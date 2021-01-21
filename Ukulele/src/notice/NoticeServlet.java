package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardBean;
import board.BoardDAO;

@WebServlet("*.no")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeBean bean;
	private NoticeDAO noticeDAO;

	public NoticeServlet() {
		try {
			noticeDAO = new NoticeDAO();
			bean = new NoticeBean();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		if (command.equals("/NoticeWrite.no")) { // 공지사항 등록
			String filename = request.getParameter("filename");
			String fileSysname = request.getParameter("fileSysname");
			
			bean.setWriter(request.getParameter("writer"));
			bean.setEmail(request.getParameter("email"));
			bean.setSubject(request.getParameter("subject"));
			bean.setPassword(request.getParameter("password"));
			bean.setContent(request.getParameter("content"));
			bean.setFilename(filename);
			bean.setFileSysname(fileSysname);

			noticeDAO.insertNotice(bean);
			response.sendRedirect("index.jsp?page=notice/NoticeList");
		} // 공지사항 등록

		else if (command.equals("/NoticeDelete.no")) { // 공지사항 삭제
			String pw = request.getParameter("password");
			int num = Integer.parseInt(request.getParameter("num"));
			String fileSysname = request.getParameter("fileSysname");
			String password = noticeDAO.getPass(num);
			if (pw.equals(password)) {
				noticeDAO.deleteNotice(num);
				if(fileSysname != null) {
					noticeDAO.deleteNoticeFile(request, fileSysname);
				}
				response.sendRedirect("index.jsp?page=notice/NoticeList");
			} else {
				out.print("<script>alert('패스워드가 틀려서 삭제 할 수 없습니다. 패스워드를 확인해 주세요.'); history.go(-1);</script>");
			}
		} // 공지사항 삭제
		
		else if(command.equals("/NoticeUpdate.no")) {//공지사항 수정
			String filename = request.getParameter("filename");
			String fileSysname = request.getParameter("fileSysname");
			String num = request.getParameter("num");
			
			if(filename.equals("null") || fileSysname.equals("null")) {
				filename = request.getParameter("fileOrgname");
				fileSysname = request.getParameter("fileOrgsysname");
			}
			
			bean.setSubject(request.getParameter("subject"));
			bean.setContent(request.getParameter("content"));
			bean.setFilename(filename);
			bean.setFileSysname(fileSysname);
			bean.setNum(Integer.parseInt(num));
			
			String pass = noticeDAO.getPass(Integer.parseInt(num)); //패스워드값을 가져옴
			
			if(pass.equals(request.getParameter("password"))){
				noticeDAO.updateNotice(bean);
				out.println("<script>alert('게시글이 수정되었습니다.');");
				out.println("location.href='index.jsp?page=notice/NoticeList.jsp?fileSysname="+fileSysname+"';");
				out.println("</script>");
			}
			else{
				out.print("<script>alert('패스워드가 틀려서 수정 할 수 없습니다. 패스워드를 확인해 주세요.'); history.go(-1);</script>");
			}	
		} //공지사항 수정
	}

}
