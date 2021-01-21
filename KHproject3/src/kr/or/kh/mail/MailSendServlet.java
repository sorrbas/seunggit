
package kr.or.kh.mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mailSend")
public class MailSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
         String sender = request.getParameter("sender");
         String receiver = request.getParameter("receiver");
         String subject = request.getParameter("title");
         String content = request.getParameter("content");
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         
         
         
         try {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.starttls.enable", "true"); // gmail
            properties.put("mail.smtp.host", "smtp.gmail.com"); // smtp 
            properties.put("mail.smtp.auth", "true"); // gmail
            properties.put("mail.smtp.port", "587"); // gmail 포트
            Authenticator auth = new GoogleAuthentication();
            Session s = Session.getDefaultInstance(properties, auth);
            //Session s = Session.getdefultInstance(properties, auth);
            Message message = new MimeMessage(s);
            Address sender_address = new InternetAddress(sender);
            Address receiver_address = new InternetAddress(receiver);
            message.setHeader("content-type","text/html;charset=UTF-8");
            message.setFrom(sender_address);
            message.addRecipient(Message.RecipientType.TO, receiver_address);
            message.setSubject(subject);
            message.setContent(content, "text/html;charset=UTF-8");
            message.setSentDate(new java.util.Date());
            Transport.send(message);
            out.println("<h3>메일이 정상적으로 전송되었습니다.</h3>");
         } catch (Exception e) {
            out.println("SMTP 서버가 잘못 설정되었거나 서비스에 문제가 있습니다.");
            e.printStackTrace();
         }

	}

}