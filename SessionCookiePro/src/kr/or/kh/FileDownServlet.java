package kr.or.kh;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileDown")
public class FileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String fileName = request.getParameter( "file_name" );

			String sDownloadPath = "C:\\upload\\";
			String sFilePath = sDownloadPath + fileName;

			byte b[] = new byte[4096];
			FileInputStream in = new FileInputStream(sFilePath);

			String sMimeType = getServletContext().getMimeType(sFilePath);
			System.out.println("sMimeType>>>"+sMimeType );

		 // octet-stream 은  8비트로 된 일련의 데이타를 뜻합니다. 지정되지 않은 파일 형식을 의미합니다.
	
			if(sMimeType == null) sMimeType = "application/octet-stream";

			response.setContentType(sMimeType);

			//한글 업로드
			String sEncoding = new String(fileName.getBytes("utf-8"),"8859_1");

			response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
			
			ServletOutputStream out = response.getOutputStream();
			int numRead;

			// 바이트 배열b의 0번 부터 numRead번 까지 브라우저로 출력
			while((numRead = in.read(b, 0, b.length)) != -1) {
				out.write(b, 0, numRead);
			}
			out.flush(); 
			out.close();
			in.close();

	}//end
}

