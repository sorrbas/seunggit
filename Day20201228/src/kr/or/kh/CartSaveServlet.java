package kr.or.kh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CartSave")
public class CartSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.setContentType("text/html; charset=UTF-8");
			
		 PrintWriter out = response.getWriter();
			
		 // 입력 파라미터 얻기
		 String product = request.getParameter("product");
		 
		 //세션객체 얻기
		 HttpSession session = request.getSession();
		 ArrayList<String> list = (ArrayList<String>)session.getAttribute("product");
		 if( list == null ){
			 list = new ArrayList<String>();
			 list.add(product);
			 session.setAttribute("product", list);
			 
		 }else{
			 
			 list.add(product);
		 }
		 
			out.print("<html><body>");
			out.print("Product 추가");
			out.print("<a href='CartBasket'>장바구니 보기</a>");	
			out.print("</body></html>");

	}

}
