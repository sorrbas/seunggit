package kr.co.kh.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dsdas {

	public static String Session;
	static {
		Session = null;
	}
	
	public static void main(String[] args) {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));	
		  Connection conn = null;
		  int cnt = 0;
		  Statement stmt = null;
		   String protocol = null;
  	  	
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   System.out.println("ȸ�����Զ� �Դϴ� ���Ͻô� ���� �������ּ���");
		   while(true) { 
			  
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "khbclass", "dkdlxl");
				   System.out.println("R:ȸ������ L:ȸ����� S:IDã�� D:ȸ��Ż�� E:ȸ������ I:�α��� O:�α׾ƿ�");
				   protocol = input.readLine();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			   switch(protocol) {
			   
			   case "R" : case "r" :
				   
			
				try {
					System.out.println("���̵��Է� :");
						String id = input.readLine();
						System.out.println("�н������Է�:");
						String pw1 = input.readLine();
						System.out.println("�ּ��Է�:");
						String addr = input.readLine();
						System.out.println("��ȭ��ȣ�Է� : ");
						String tel1 = input.readLine();
						
						int pw = Integer.parseInt(pw1);
						int tel = Integer.parseInt(tel1);
						stmt = conn.createStatement();
						String sql = "insert into member(id,pw,addr,tel) values('"+id+"','"+pw+"','"+addr+"','"+tel+"')";
						cnt = stmt.executeUpdate(sql);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
					System.out.println("ȸ��������"+cnt+"�� �Ϸ�Ǿ����ϴ�");
			
					break;
					
			   case "L" : case "l" :
				   
				   
		    		 System.out.println("ȸ�����̵�\tȸ���н�����\tȸ���ּ�\tȸ����ȭ��ȣ\n");
		    		
		    		
				try {
					stmt = conn.createStatement();
					 String sql = "select * from member order by id asc";
					 ResultSet rs = stmt.executeQuery(sql);
					 
					 while(rs.next()) {
						 String id = rs.getString("id");
						 String pw  = rs.getString("pw");
						 String addr = rs.getString("addr");
						 String tel = rs.getString("tel");
						 System.out.println(id+"\t"+pw+"\t"+addr+"\t"+tel);
					
   }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						break;
						
			   case "S" : case "s" :
				   
				   try {
					System.out.println("ã�� ID�� �Է�:");
					   String searchid = input.readLine();
					   
					   stmt = conn.createStatement();
					   String sql = "select * from member where id = '"+searchid+"'";
					   ResultSet rs = stmt.executeQuery(sql);
						 
						 while(rs.next()) {
							 String id = rs.getString("id");
							 String pw  = rs.getString("pw");
							 String addr = rs.getString("addr");
							 String tel = rs.getString("tel");
							 System.out.println("ȸ�����̵�\tȸ���н�����\tȸ���ּ�\tȸ����ȭ��ȣ\n");
							 System.out.println(id+"\t"+pw+"\t"+addr+"\t"+tel);
							
   
						 }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   break;
	
			   } // switch��
	
	} // while�� 
	} // main
}
