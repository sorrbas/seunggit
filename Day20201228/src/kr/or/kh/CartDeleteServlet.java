package kr.or.kh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CartDelete")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("장바구니 비웠음!!");
		//세션객체 얻기
		HttpSession session = request.getSession(false);
		// false는 세션에 있는 값만 지우겠다라는 뜻임  false가 빠지면 새로운사용자로 가져오겠다는 뜻임
		if( session != null ){
			session.invalidate();
		}else{
			out.print("세션 없음" + "<br>");
		}
		out.print("<a href='product.jsp'>상품 선택 페이지</a><br>");
		out.print("</body></html>");

	}

}
