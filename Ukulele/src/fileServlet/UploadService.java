package fileServlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import file.FileBean;
import file.FileDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/UploadService")
public class UploadService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = request.getParameter("file");

		ServletContext context = getServletContext(); // 어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨. (서버의 절대경로를 구하는 데 필요)
		String saveDir = context.getRealPath("Upload"); // 절대경로를 가져옴

		int maxSize = 3 * 1024 * 1024; // 3MB
		String encoding = "UTF-8";

		// saveDir: 경로
		// maxSize: 크기제한 설정
		// encoding: 인코딩타입 설정
		// new DefaultFileRenamePolicy(): 동일한 이름일 경우 자동으로 (1),(2)..붙게 해줌

		boolean isMulti = ServletFileUpload.isMultipartContent(request);// boolean타입. ??????
		if (isMulti) {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());
			FileDAO dao = new FileDAO();
			FileBean bean = new FileBean();

//			String writer = multi.getParameter("writer");
//			String subject = multi.getParameter("subject");
//			String email = multi.getParameter("email");
//			String password = multi.getParameter("password");
//			String file = multi.getFilesystemName("fileName");
//			String content = multi.getParameter("content");
			bean.setWriter(multi.getParameter("writer"));
			bean.setSubject(multi.getParameter("subject"));
			bean.setEmail(multi.getParameter("email"));
			bean.setPassword(multi.getParameter("password"));
			bean.setFileName(multi.getFilesystemName("fileName"));
			bean.setContent(multi.getParameter("content"));

			try {
				int result = dao.uploadFile(bean);
				String moveUrl = "";
				if (result > 0) {
					moveUrl = "selectService";
				} else {
					moveUrl = "Gallery/GalleryWrite.jsp";
				}
				response.sendRedirect(moveUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
		}

	}

}
