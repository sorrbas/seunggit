package network.tcp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
public class Client {
	public static void main(String[] args) {
		int port = 8500;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			String serverIP = InetAddress.getLocalHost().getHostAddress();
			Socket socket = new Socket(serverIP, port);
			if(socket != null){
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();
				br = new BufferedReader(new InputStreamReader(input));
				pw = new PrintWriter(output);
				Scanner sc = new Scanner(System.in);
				do{
					System.out.print("대화 입력 : ");
					String message = sc.nextLine();
					pw.println(message);
					pw.flush();
					if(message.equals("exit")){
						break;
					}
					String recieveMessage = br.readLine();
					System.out.println(recieveMessage);
					sc.nextLine();
				}while(true);
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
