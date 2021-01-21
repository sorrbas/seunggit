package board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.bo")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardBean bean;
	private BoardDAO boardDAO;
	
	public BoardServlet() {
		try {
			boardDAO = new BoardDAO();
			bean = new BoardBean();
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

		if (command.equals("/BoardWrite.bo")) { // 게시판 등록
			String fileBoardname = request.getParameter("fileBoardname");
			String fileBoardid = request.getParameter("fileBoardid");
			
			bean.setWriter(request.getParameter("writer"));
			bean.setEmail(request.getParameter("email"));
			bean.setSubject(request.getParameter("subject"));
			bean.setPassword(request.getParameter("password"));
			bean.setContent(request.getParameter("content"));
			bean.setFileBoardname(fileBoardname);
			bean.setFileBoardid(fileBoardid);
			
			boardDAO.insertBoard(bean);
			response.sendRedirect("index.jsp?page=Board/BoardList");
		} // 게시판 등록
		
		else if (command.equals("/BoardDelete.bo")) { // 게시판 글 삭제
			String pw = request.getParameter("password");
			int num = Integer.parseInt(request.getParameter("num"));
			String fileBoardid = request.getParameter("fileBoardid");
			String ref1 = request.getParameter("ref");
			String re_step1 = request.getParameter("re_step");
			int ref = Integer.parseInt(ref1);
			int re_step = Integer.parseInt(re_step1);
			String password =boardDAO.getPass(num);
			String id = boardDAO.getID(num);
			if(!id.equals(request.getParameter("id"))){
				out.print("<script>alert('자신이 작성한 게시글만 삭제할 수 있습니다.'); history.go(-1);</script>");
			}
			else {
				if(pw.equals(password)){
					boardDAO.deleteBoard(ref,re_step);
					if(fileBoardid != null) {
						boardDAO.deleteBoardFile(request, fileBoardid);
					}
					response.sendRedirect("index.jsp?page=Board/BoardList");
				}
				else{
					out.print("<script>alert('패스워드가 틀려서 삭제 할 수 없습니다. 패스워드를 확인해 주세요.'); history.go(-1);</script>");
				}
			}
		} // 게시판 글 삭제
		
		else if(command.equals("/BoardUpdate.bo")) {//게시판 글 수정
			String filename = request.getParameter("filename");
			String fileSysname = request.getParameter("fileSysname");
			int num = Integer.parseInt(request.getParameter("num")); 
			
			if(filename.equals("null") || fileSysname.equals("null")) {
				filename = request.getParameter("fileOrgname");
				fileSysname = request.getParameter("fileOrgsysname");
			}
			
			bean.setSubject(request.getParameter("subject"));
			bean.setContent(request.getParameter("content"));
			bean.setFileBoardname(filename);
			bean.setFileBoardid(fileSysname);
			bean.setNum(num);
			
			String pass=boardDAO.getPass(Integer.parseInt(request.getParameter("num")));
			String id = boardDAO.getID(Integer.parseInt(request.getParameter("num")));
			
			if(!id.equals(request.getParameter("id"))){
				out.print("<script>alert('자신이 작성한 게시글만 수정할 수 있습니다.'); history.go(-1);</script>");
			}
			else {
				if(pass.equals(request.getParameter("password"))){
					boardDAO.updateBoard(bean);
					out.println("<script>alert('게시글이 수정되었습니다.');");
					out.println("location.href='index.jsp?page=Board/BoardList.jsp?fileSysname="+fileSysname+"';");
					out.println("</script>");
				}
				else{
					out.print("<script>alert('패스워드가 틀려서 수정 할 수 없습니다. 패스워드를 확인해 주세요.'); history.go(-1);</script>");
				}	
			}
		} //게시판 글 수정
		
		else if(command.equals("/BoardReWrite.bo")) {//게시판 답글 작성
			bean.setRef(Integer.parseInt(request.getParameter("ref")));
			bean.setRe_level(Integer.parseInt(request.getParameter("re_level")));
			bean.setRe_step(Integer.parseInt(request.getParameter("re_step")));
			bean.setWriter(request.getParameter("writer"));
			bean.setEmail(request.getParameter("email"));
			bean.setSubject(request.getParameter("subject"));
			bean.setPassword(request.getParameter("password"));
			bean.setContent(request.getParameter("content"));
			boardDAO.reWriteBoard(bean);
			response.sendRedirect("index.jsp?page=Board/BoardList");	
		} //게시판 답글 작성
	}

}
