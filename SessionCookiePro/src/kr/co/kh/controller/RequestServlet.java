package kr.co.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Request")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setAttribute("username", "이승기");
         request.setAttribute("useraddress", "경기도 광명시 철산동");
         
         
         RequestDispatcher dis = request.getRequestDispatcher("Response");
         dis.forward(request, response); //포워드를 사용하였끼에 주소에는 전 주소가 나오고 바디(내용)에는 리스폰의 내용이 산출된다. 왜그럴가
         
        
	}

}
