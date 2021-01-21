package kr.or.kh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//응답페이지!!

@WebServlet("/RequestRedirect")
public class RequestRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//속성 설정
		request.setAttribute("username", "이승기");
		request.setAttribute("useraddress", "경기도 광명시 철산동");

		//redirect
		response.sendRedirect("ResponseRedirect");
		//sendRedirect는 값을 저장하는 기능이 없음

	}

}
