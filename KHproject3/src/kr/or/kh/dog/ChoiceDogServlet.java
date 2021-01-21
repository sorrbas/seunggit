package kr.or.kh.dog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/choiceDog")
public class ChoiceDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<style>");
		out.print("img{width: 100px; height:100px;);}");

		out.print("</style>");
		String[] dog = request.getParameterValues("dog");
		//배열을 사용해서 정보를 받을때는 파라미터밸루로 받아야함
		for(int i=0; i<dog.length;i++) {
			out.print("<img src=images/"+dog[i]+">");
		}
		out.print("<a href=index.jsp>메인으로</a>");
	}

}
