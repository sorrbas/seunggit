package kr.or.kh.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.bo")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardDTO boardDTO;
	private BoardDAO boardDAO;
	private int cnt;
	private ArrayList<BoardDTO> boardList;
	private String titleUpSearch;
	private RequestDispatcher dis;
	



	public BoardServlet() {
		boardDTO = new BoardDTO();
		boardDAO = new BoardDAO();
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

		if (command.equals("/boardRegister.bo")) { //게시판등록
			boardDTO.setTitle(request.getParameter("title"));
			boardDTO.setContent(request.getParameter("content"));
			boardDTO.setAuthor(request.getParameter("author"));
			boardDTO.setNal(request.getParameter("nal"));
			boardDTO.setReadCount(Integer.parseInt(request.getParameter("readCount")));
			try {
				cnt = boardDAO.boardWrite(boardDTO);
				out.print(cnt + "건 등록");
				response.sendRedirect("boardList.bo");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}// 게시판등록
		
		else if(command.equals("/boardList.bo")) { //페이지목록
			int cursorPage = 1; //기본페이지는 1에서부터 시작하기때문에
			if(request.getParameter("cursorPage")!=null) {
				cursorPage = Integer.parseInt(request.getParameter("cursorPage"));
			}
			PageTo boardList = boardDAO.page(cursorPage);
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=board/listPage");
			request.setAttribute("page", boardList);
			//listPage.jsp에서 목록리스트 데이터 저장
			request.setAttribute("list", boardList.getList());
			//page.jsp에서 페이징처리 데이터저장
			dis.forward(request, response);
			
		} //페이지목록
		
		
		 else if(command.equals("/boardList.bo")) {  //게시판전체출력
			try {
				boardList = boardDAO.boardList();
				dis = request.getRequestDispatcher("index.jsp?page=board/boardList");       
				//RequestDispatcher 페이지뿐만이 아니라 값 또한 가져올 수 있다. 배열방도 가져올수있음
				request.setAttribute("boardList", boardList);  
				//setAttribute 속성이라는 의미이니 속성을 넣겠다라는 뜻 속성을 등록하겠다. "boardList"(앞)는 name boardList(뒤)는 값을의미
				dis.forward(request, response);   //forward는 이동하겠다라는 뜻 request에다가 저장을 함
			} catch (SQLException e) {

				e.printStackTrace();
			}   

		}//게시판전체출력   
		
		
		else if(command.equals("/boardDelete.bo")) { //게시판글 삭제
			String no1 = request.getParameter("no");
			int no = Integer.parseInt(no1);
			try {
				cnt = boardDAO.boardDelete(no);
				response.sendRedirect("boardList.bo");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //게시판 글 삭제
		else if(command.equals("/boardSearch.bo")) { //게시판검색
			String titleSearch = request.getParameter("titleSearch");
			String readCount = request.getParameter("readCount");
			try {
				boardDTO = boardDAO.boardSearch(titleSearch);
				dis = request.getRequestDispatcher("index.jsp?page=board/boardSearch");
				//RequestDispatcher 페이지뿐만이 아니라 값 또한 가져올 수 있다. 배열방도 가져올수있음
				request.setAttribute("boardDTO", boardDTO);
				dis.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // 게시판검색
		else if(command.equals("/boardUpdateSearch.bo")) { //게시판수정전의 찾기기능
			titleUpSearch = request.getParameter("titleUpSearch");
			try {
				
				boardDTO = boardDAO.boardSearch(titleUpSearch);
				 dis = request.getRequestDispatcher("index.jsp?page=board/boardUpdateConfirm");
				//RequestDispatcher 페이지뿐만이 아니라 값 또한 가져올 수 있다. 배열방도 가져올수있음
				request.setAttribute("boardDTO", boardDTO);
				dis.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} //게시판 수정 전의 찾기기능
		
		else if(command.equals("/boardUpdateFinal.bo")) {
			//	titleUpSearch = request.getParameter("titleUpSearch");    이미 위에 전역변수를 설정이 되어있어 값이 담겨있따
				boardDTO.setNo(Integer.parseInt(request.getParameter("no")));
				boardDTO.setTitle(request.getParameter("title"));
				boardDTO.setContent(request.getParameter("content"));
				boardDTO.setAuthor(request.getParameter("author"));
				boardDTO.setNal(request.getParameter("nal"));
				boardDTO.setReadCount(Integer.parseInt(request.getParameter("readcount")));
				try {
					cnt = boardDAO.boardUpdateFinal(boardDTO,titleUpSearch);  //보드DTO와 TITLESEARCH를 불러와서 저장해줌
				//	boardList = boardDAO.page();
					dis = request.getRequestDispatcher("index.jsp?page=board/boardList");
					request.setAttribute("boardList", boardList);
					dis.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} 

		}
	}