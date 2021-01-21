package kr.or.kh.haksa;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class HaksaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDTO studentDTO;
	private StudentDAO studentDAO;
	private ProfessorDTO professorDTO;
	private ProfessorDAO professorDAO;
	private ManagerDTO managerDTO;
	private ManagerDAO managerDAO;
	private Connection conn;
	private int cnt = 0;
	private ResultSet rs;
	private String irumSearch;
	
	public HaksaServlet() {
		studentDTO = new StudentDTO();
		professorDTO = new ProfessorDTO();
		managerDTO = new ManagerDTO();
		try {
			studentDAO = new StudentDAO();
			professorDAO = new ProfessorDAO();
			managerDAO = new ManagerDAO();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()); // /studentList.do
		
		if(command.equals("/studentRegister.do")) { //학생등록
		String nai = request.getParameter("nai");
		String irum = request.getParameter("irum");
		String hakbun = request.getParameter("hakbun");
		studentDTO.setNai(nai);
		studentDTO.setIrum(irum);
		studentDTO.setHakbun(hakbun);
		try {
			conn = studentDAO.getConnection();
			studentDAO.studentRegisterSql(studentDTO);
			cnt = studentDAO.studentExecuter();
			out.print(cnt+"건 학생이 등록되었습니다.<br>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("student/studentList.jsp");
		}
	} //학생등록 끝
		 else if(command.equals("/studentList.do")) { //학생전체목록	
				response.sendRedirect("student/studentList.jsp");
	} //학생전체목록 끝
		 else if(command.equals("/studentDelete.do")) { //학생삭제
			 	String irumDelete = request.getParameter("irum");
			 	try {
					cnt = studentDAO.studentDeleteSql(irumDelete);
					out.print(cnt+"건 학생이 삭제되었습니다.<br>");
					response.sendRedirect("student/studentList.jsp");
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		 } //학생삭제 끝
		 else if(command.equals("/studentSearch.do")) { //학생검색
			 irumSearch = request.getParameter("irum");
			 try {
				rs = studentDAO.studentSearchSql(irumSearch);
				out.print("학생검색결과");
				out.print("<table border=1 cellspacing=0 cellpadding=0>");
				out.print("<tr>");
				out.print("<th>번호</th> <th>나이</th> <th>이름</th> <th>학번</th>");
				out.print("</tr>");
				while(rs.next()) {
					out.print("<tr>");
					out.print("<td>"+rs.getInt("no")+"</td>");
					out.print("<td>"+rs.getString("age")+"</td>");
					out.print("<td>"+rs.getString("irum")+"</td>");
					out.print("<td>"+rs.getString("hakbun")+"</td>");
					out.print("</tr>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 } //학생검색 끝
		 else if(command.equals("/studentUpdate.do")) { //학생수정
			 irumSearch = request.getParameter("irum");
			 try {
				rs = studentDAO.studentSearchSql(irumSearch);
				while(rs.next()) {
					studentDTO.setNo(rs.getInt("no"));
					studentDTO.setNai(rs.getString("age"));
					studentDTO.setIrum(rs.getString("irum"));
					studentDTO.setHakbun(rs.getString("hakbun"));
				}
				response.sendRedirect("studentConfirm.do");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 } 
		 else if(command.equals("/studentConfirm.do")) {
			 out.print("<style>");
			 out.print("ul{list-style-type : none;}");
			 out.print(".kh01 {width: 60px; height: 50px;}");
			 out.print("</style>");
			 out.print("번호:"+studentDTO.getNo()+"나이:"+studentDTO.getNai()+"이름:"+studentDTO.getIrum()+"학번:"+studentDTO.getHakbun()+"<br>");
			 out.print("정말로 수정하시겠습니까 ??");
			 out.print("<h1>최종수정하기 전 내용입니다.</h1>");
			 out.print("<form action=studentUpdateFinal.do method=get>");
			 out.print("<input type=hidden name=irumUpdate value="+irumSearch+">");
			 out.print("<ul>");
			 out.print("<li><label for=나이변경>나이변경</label>"); 
			 out.print("<input type=number name=age >");
			 out.print("</li>");
			 out.print("<li><label for=이름변경>이름변경</label>"); 
			 out.print("<input type=text name=irum >");
			 out.print("</li>");
			 out.print("<li><label for=학번변경>학번변경</label>"); 
			 out.print("<input type=text name=hakbun >");
			 out.print("</li>");
			 out.print("<li><input type=image src=images/update1.png class=kh01>");
			 out.print("</li>");
			 out.print("</ul>");
			 out.print("</form>");
		 }
		 else if(command.equals("/studentUpdateFinal.do")) { //학생최종수정
			 String irumUpdate = request.getParameter("irumUpdate");
			 studentDTO.setNai(request.getParameter("age"));
			 studentDTO.setIrum(request.getParameter("irum"));
			 studentDTO.setHakbun(request.getParameter("hakbun"));
			 try {
				cnt = studentDAO.studentUpdateSql(irumUpdate, studentDTO);
				out.print(cnt+"건 학생이 수정되었습니다.");
				response.sendRedirect("student/studentList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 } //학생최종수정 끝
		 else if (command.contentEquals("/professorRegister.do")) { //교수등록
	         String nai = request.getParameter("nai");
	         String irum = request.getParameter("irum");
	         String subject = request.getParameter("subject");
	         professorDTO.setNai(nai);
	         professorDTO.setIrum(irum);
	         professorDTO.setSubject(subject);

	         try {
	            conn = professorDAO.getConnection();
	            professorDAO.professorRegisterSql(professorDTO);
	            cnt = professorDAO.professorExecuter();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	         out.print(cnt + "건 교수님이 등록되었습니다.<br>");
	         response.sendRedirect("professor/professorList.jsp");
	      } //교수등록
		 else if (command.equals("/professorList.do")) { // 교수전체목록
	         response.sendRedirect("professor/professorList.jsp");
	      } // 교수전체목록
		 else if(command.equals("/professorDelete.do")) { //교수삭제
			 	String irumDelete = request.getParameter("irum");
			 	try {
					cnt = professorDAO.professorDeleteSql(irumDelete);
					out.print(cnt+"건 교수님이 삭제되었습니다.<br>");
					response.sendRedirect("professor/professorList.jsp");
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		 } //교수삭제 끝
		 else if(command.equals("/professorSearch.do")) { //교수검색
			 irumSearch = request.getParameter("irum");
			 try {
				rs = professorDAO.professorSearchSql(irumSearch);
				out.print("교수검색결과");
				out.print("<table border=1 cellspacing=0 cellpadding=0>");
				out.print("<tr>");
				out.print("<th>번호</th> <th>나이</th> <th>이름</th> <th>과목</th>");
				out.print("</tr>");
				while(rs.next()) {
					out.print("<tr>");
					out.print("<td>"+rs.getInt("no")+"</td>");
					out.print("<td>"+rs.getString("age")+"</td>");
					out.print("<td>"+rs.getString("irum")+"</td>");
					out.print("<td>"+rs.getString("subject")+"</td>");
					out.print("</tr>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 } //교수검색 끝
		 else if(command.equals("/professorUpdate.do")) { //교수수정
			 irumSearch = request.getParameter("irum");
			 try {
				rs = professorDAO.professorSearchSql(irumSearch);
				while(rs.next()) {
					professorDTO.setNo(rs.getInt("no"));
					professorDTO.setNai(rs.getString("age"));
					professorDTO.setIrum(rs.getString("irum"));
					professorDTO.setSubject(rs.getString("subject"));
				}
				response.sendRedirect("professorConfirm.do");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 } 
		 else if(command.equals("/professorConfirm.do")) {
			 out.print("<style>");
			 out.print("ul{list-style-type : none;}");
			 out.print(".kh01 {width: 60px; height: 50px;}");
			 out.print("</style>");
			 out.print("번호:"+professorDTO.getNo()+"나이:"+professorDTO.getNai()+"이름:"+professorDTO.getIrum()+"과목:"+professorDTO.getSubject()+"<br>");
			 out.print("정말로 수정하시겠습니까 ??");
			 out.print("<h1>최종수정하기 전 내용입니다.</h1>");
			 out.print("<form action=professorUpdateFinal.do method=get>");
			 out.print("<input type=hidden name=irumUpdate value="+irumSearch+">");
			 out.print("<ul>");
			 out.print("<li><label for=나이변경>나이변경</label>"); 
			 out.print("<input type=number name=age >");
			 out.print("</li>");
			 out.print("<li><label for=이름변경>이름변경</label>"); 
			 out.print("<input type=text name=irum >");
			 out.print("</li>");
			 out.print("<li><label for=과목변경>과목변경</label>"); 
			 out.print("<input type=text name=subject >");
			 out.print("</li>");
			 out.print("<li><input type=image src=images/update1.png class=kh01>");
			 out.print("</li>");
			 out.print("</ul>");
			 out.print("</form>");
		 }
		 else if(command.equals("/professorUpdateFinal.do")) { //교수최종수정
			 String irumUpdate = request.getParameter("irumUpdate");
			 professorDTO.setNai(request.getParameter("age"));
			 professorDTO.setIrum(request.getParameter("irum"));
			 professorDTO.setSubject(request.getParameter("subject"));
			 try {
				cnt = professorDAO.professorUpdateSql(irumUpdate, professorDTO);
				out.print(cnt+"건 교수님이 수정되었습니다.");
				response.sendRedirect("professor/professorList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 } //교수최종수정 끝
		 else if (command.contentEquals("/managerRegister.do")) { //관리자등록
	         String nai = request.getParameter("nai");
	         String irum = request.getParameter("irum");
	         String part = request.getParameter("part");
	         managerDTO.setNai(nai);
	         managerDTO.setIrum(irum);
	         managerDTO.setPart(part);

	         try {
	            conn = managerDAO.getConnection();
	            managerDAO.managerRegisterSql(managerDTO);
	            cnt = managerDAO.managerExecuter();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	         out.print(cnt + "건 관리자님이 등록되었습니다.<br>");
	         response.sendRedirect("managers/managerList.jsp");
	      } //관리자등록
		 else if (command.equals("/managerList.do")) { // 관리자전체목록
	         response.sendRedirect("managers/managerList.jsp");
	      } // 관리자전체목록
		 else if(command.equals("/managerDelete.do")) { //관리자삭제
			 	String irumDelete = request.getParameter("irum");
			 	try {
					cnt = managerDAO.managerDeleteSql(irumDelete);
					out.print(cnt+"건 관리자님이 삭제되었습니다.<br>");
					response.sendRedirect("managers/managerList.jsp");
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		 } //관리자삭제 끝
		 else if(command.equals("/managerSearch.do")) { //관리자검색
			 irumSearch = request.getParameter("irum");
			 try {
				rs = managerDAO.managerSearchSql(irumSearch);
				out.print("관리자검색결과");
				out.print("<table border=1 cellspacing=0 cellpadding=0>");
				out.print("<tr>");
				out.print("<th>번호</th> <th>나이</th> <th>이름</th> <th>부서</th>");
				out.print("</tr>");
				while(rs.next()) {
					out.print("<tr>");
					out.print("<td>"+rs.getInt("no")+"</td>");
					out.print("<td>"+rs.getString("age")+"</td>");
					out.print("<td>"+rs.getString("irum")+"</td>");
					out.print("<td>"+rs.getString("part")+"</td>");
					out.print("</tr>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		 } //관리자검색 끝
		 else if(command.equals("/managerUpdate.do")) { //관리자수정
			 irumSearch = request.getParameter("irum");
			 try {
				rs = managerDAO.managerSearchSql(irumSearch);
				while(rs.next()) {
					managerDTO.setNo(rs.getInt("no"));
					managerDTO.setNai(rs.getString("age"));
					managerDTO.setIrum(rs.getString("irum"));
					managerDTO.setPart(rs.getString("part"));
				}
				response.sendRedirect("managerConfirm.do");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 } 
		 else if(command.equals("/managerConfirm.do")) {
			 out.print("<style>");
			 out.print("ul{list-style-type : none;}");
			 out.print(".kh01 {width: 60px; height: 50px;}");
			 out.print("</style>");
			 out.print("번호:"+managerDTO.getNo()+"나이:"+managerDTO.getNai()+"이름:"+managerDTO.getIrum()+"부서:"+managerDTO.getPart()+"<br>");
			 out.print("정말로 수정하시겠습니까 ??");
			 out.print("<h1>최종수정하기 전 내용입니다.</h1>");
			 out.print("<form action=managerUpdateFinal.do method=get>");
			 out.print("<input type=hidden name=irumUpdate value="+irumSearch+">");
			 out.print("<ul>");
			 out.print("<li><label for=나이변경>나이변경</label>"); 
			 out.print("<input type=number name=age >");
			 out.print("</li>");
			 out.print("<li><label for=이름변경>이름변경</label>"); 
			 out.print("<input type=text name=irum >");
			 out.print("</li>");
			 out.print("<li><label for=부서변경>부서변경</label>"); 
			 out.print("<input type=text name=part >");
			 out.print("</li>");
			 out.print("<li><input type=image src=images/update1.png class=kh01>");
			 out.print("</li>");
			 out.print("</ul>");
			 out.print("</form>");
		 }
		 else if(command.equals("/managerUpdateFinal.do")) { //관리자최종수정
			 String irumUpdate = request.getParameter("irumUpdate");
			 managerDTO.setNai(request.getParameter("age"));
			 managerDTO.setIrum(request.getParameter("irum"));
			 managerDTO.setPart(request.getParameter("part"));
			 try {
				cnt = managerDAO.managerUpdateSql(irumUpdate, managerDTO);
				out.print(cnt+"건 관리자님이 수정되었습니다.");
				response.sendRedirect("managers/managerList.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 } //관리자최종수정 끝

	}
}