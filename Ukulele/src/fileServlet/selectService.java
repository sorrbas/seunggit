package fileServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.FileBean;
import file.FileDAO;
import file.Paging;

@WebServlet("/selectService")
public class selectService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB에 저장된 file정보를 모두 검색해서 jsp로 전송
		FileDAO dao = new FileDAO();
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		Paging paging = new Paging(pageNum);
		
		try{
			paging.setTotalCount(dao.getAllCount());
			Vector<FileBean> list = dao.selectAll(paging.getStartRow(), paging.getEndRow());
			
			if(list!=null) {
				request.setAttribute("list", list);
				
			}else {
			}
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp?page=Gallery/GalleryList");
			dis.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
