package kr.co.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseRedirect")
public class ResponseRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String username =(String)request.getAttribute("username");
	         String useraddress = (String)request.getAttribute("useraddress");
	         
	         
	         request.setCharacterEncoding("utf-8");
	         response.setContentType("text/html;charset=utf-8");
	         PrintWriter out = response.getWriter();
	         out.print("이름:"+username+"<br>");
	         out.print("주소:"+useraddress);
	}

}
