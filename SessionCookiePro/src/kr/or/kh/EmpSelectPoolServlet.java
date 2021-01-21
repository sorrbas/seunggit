package kr.or.kh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmpSelectPool")
public class EmpSelectPoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
     PrintWriter out = response.getWriter();
     out.print("<html>");
     out.print("<body>");
     EmpDAO dao = new EmpDAO();
     ArrayList<EmpDTO> list = dao.select();
     
     for(EmpDTO dto : list) {
    	 String emp_id = dto.getEmp_id();
    	 String ename = dto.getEname();
    	 int salary = dto.getSalary();
    	 String depart = dto.getDepart();
    	 out.print(emp_id+"\t"+ename+"\t"+salary+"\t"+depart+"<br>");
    	 
     }
     out.print("</body>");
     out.print("</html>");
     
     
	}

}
