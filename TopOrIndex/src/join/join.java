package join;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "Join", urlPatterns = { "/join" })

public class join extends HttpServlet {

	private static final long serialVersionUID = 1L;



	public join() {

		super();



	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		Member member= new Member();
		try {
			int result = new MemberDAO().insertMember(member);
			String msg = "";
			if(result==0) {
				msg = "회원가입 실패입니다.";
			}else {
				msg = "회원가입 성공입니다.";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/joinResult.jsp");
			request.setAttribute("msg", msg);
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub

		doGet(request, response);

	}

}