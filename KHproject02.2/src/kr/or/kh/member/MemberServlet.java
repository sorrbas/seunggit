package kr.or.kh.member;

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
import javax.servlet.http.HttpSession;


@WebServlet("*.mb")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDTO memberDTO;
	private MemberDAO memberDAO;
	private int cnt;
	private ArrayList<MemberDTO> memberList;
	



	public MemberServlet () {
		memberDTO = new MemberDTO();
		memberDAO = new MemberDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		HttpSession session = request.getSession();



		if(command.equals("/memberRegister.mb")) {   //멤버등록(회원가입)란
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setPw(request.getParameter("pw"));
			memberDTO.setAddr(request.getParameter("addr"));
			memberDTO.setTel(request.getParameter("tel"));
			try {
				cnt = memberDAO.memberRegister(memberDTO);
				out.print(cnt+"건 회원이 등록되었습니다");
				response.sendRedirect("memberList.mb");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} //멤버등록(회원가입)란
		else if(command.equals("/memberList.mb")) { //멤버목록
			try {
				memberList = memberDAO.memberList();
				RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=member/memberList");       
				//RequestDispatcher 페이지뿐만이 아니라 값 또한 가져올 수 있다. 배열방도 가져올수있음
				request.setAttribute("memberList", memberList);  
				//setAttribute 속성이라는 의미이니 속성을 넣겠다라는 뜻 속성을 등록하겠다. "boardList"(앞)는 name boardList(뒤)는 값을의미
				dis.forward(request, response);   //forward는 이동하겠다라는 뜻 request에다가 저장을 함
			} catch (SQLException e) {

				e.printStackTrace();
			} 
		}  //멤버목록
		else if(command.equals("/memberLogin.mb")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			try {
				memberDTO = memberDAO.memberLogin(id, pw);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!id.equals(memberDTO.getId())){
				out.print("<script>alert('아이디가 일치하지 않습니다');"
						+ "history.back();</script>");
			}
			else if(!pw.equals(memberDTO.getPw())){
				out.print("<script>alert('패스워드가 틀렸습니다.');"
						+ "history.back();</script>");
			}
			else {
				out.print("환영합니다.");
				session.setAttribute("id", id);
				session.setAttribute("pw", pw);
				response.sendRedirect("index.jsp?page=kh");
				
			}
			//response.sendRedirect("index.jsp?page=kh");

		}
		else if(command.equals("/memberLogout.mb")) {			
			session.invalidate(); //session에 들어가있는값을 지운다.
			response.sendRedirect("index.jsp?page=kh");

		}
		else if(command.equals("/memberDelete.mb")) {
			String pw = request.getParameter("pw");
			   
			  if(pw.equals((String)session.getAttribute("pw"))) {
				 
				String deleteId = (String)session.getAttribute("id");
				String deletePw = (String)session.getAttribute("pw");
				try {
					cnt = memberDAO.memberDelete(deleteId,deletePw);					
					out.print("<script>alert('탈퇴되었습니다.'); location.href='memberLogout.mb'</script>");
				} catch (SQLException e) {
					e.printStackTrace();
				}			 
			 }else {
				 out.print("<a href=# onclick=test()>비밀번호틀림</a>");
			 }
			
		}
		else if(command.equals("/idCheckconfirm.mb")) {
			String telSearch = request.getParameter("tel");
			try {
				String id = memberDAO.memberIdcheck(telSearch);
				out.print("찾는 아이디는"+id+"입니다<br>");
			    out.print("<a href =index.jsp?page=kh>메인으로</a>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/passCheckconfirm.mb")) {
			String idSearch = request.getParameter("id");
			try {
				String pw = memberDAO.memberPwcheck(idSearch);
				out.print("찾는 비밀번호는"+pw+"입니다<br>");
				out.print("<a href=index.jsp?page=kh>메인으로</a>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(command.equals("/memberUpdateConfirm.mb")) {
			String id = request.getParameter("id");
			try {
				memberDTO = memberDAO.memberUpdateConfirm(id);
				RequestDispatcher dis =request.getRequestDispatcher("index.jsp?page=member/memberUpdateConfirm");
				request.setAttribute("memberDTO", memberDTO);
				dis.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/memberUpdateFinal.mb")) {
			 memberDTO.setId(request.getParameter("id"));   //데이터에 값을 가져와서 DTO에 저장해준다
			 memberDTO.setPw(request.getParameter("pw"));
			 memberDTO.setAddr(request.getParameter("addr"));
			 memberDTO.setTel(request.getParameter("tel"));
			 String idSearch = request.getParameter("idSearch");			 
			 try {
			  cnt = memberDAO.memberUpdateFinal(memberDTO,idSearch);      //DTO와 수정할 아이디를 보낸다.
			  response.sendRedirect("memberList.mb");	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}


}
