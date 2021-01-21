package fileServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.FileBean;
import file.FileDAO;


@WebServlet("/DeleteService")
public class DeleteService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileDAO dao = new FileDAO();
		FileBean bean = new FileBean();
		PrintWriter out = response.getWriter();
		String pw = request.getParameter("password");
		int num = Integer.parseInt(request.getParameter("num"));
		String fileSysGallery = request.getParameter("fileSysGallery");
		String password =dao.getPass(num);
		String id = dao.getID(num);
		if(!id.equals(request.getParameter("id"))){
			out.print("<script>alert('자신이 작성한 게시글만 삭제할 수 있습니다.'); history.go(-1);</script>");
		}
		else {
			if(pw.equals(password)){
				dao.deleteGallery(num);
				if(fileSysGallery != null) {
					dao.deleteGalleryFile(request, fileSysGallery);				
					}
				response.sendRedirect("index.jsp?page=Gallery/GalleryList");
			}
			else{
				out.print("<script>alert('패스워드가 틀려서 삭제 할 수 없습니다. 패스워드를 확인해 주세요.'); history.go(-1);</script>");
			}
		}
	}
}
