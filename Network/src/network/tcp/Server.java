package network.tcp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static void main(String[] agrs) throws IOException{
		int port = 8500;
		ServerSocket server = new ServerSocket(port);
		while(true){
			Socket client = server.accept();
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			PrintWriter pw = new PrintWriter(output);
			while(true){
				String message = br.readLine();
				if(!message.equals("exit")){
					System.out.println(client.getInetAddress().getHostAddress() + "�� ���� �޼��� : " + message);
								pw.println("�޼��� �ޱ� ����");
					pw.flush();
				}else{
					System.out.println("���� ����");
					break;
				}
			}
			br.close();
			pw.close();
			client.close();
		}
	}
}