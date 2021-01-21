package kr.co.kh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestRedirect")
public class RequestRedirectSerrvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("username", "이승기");
		request.setAttribute("useraddress", "경기도 광명시 디지털로64, 철산한신아파트 107동 501호");
		
		response.sendRedirect("ResponseRedirect");
		//지정한 위치로 이동해주라는 말
	}

}
