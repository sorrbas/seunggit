package kr.co.kh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberExecuter {
	public static String session;
	static { 
		session = null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
	      
		  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));	
		  Connection conn = null;
		  Statement stmt = null;
		  String sql = null;
		  int cnt = 0;
		  
		  try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		while(true) {  //�ݺ���
			
			System.out.println("R:ȸ������ S:IDã�� D:ȸ��Ż�� E:ȸ������ I:�α��� O:�α׾ƿ� L:ȸ�����");
			String idlogin = null;
			try {
				String protocol = input.readLine();
				if(protocol.equals("R")||protocol.equals("r")) {//ȸ������
				    try {
						stmt = conn.createStatement();
						sql = "select id from member";
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							idlogin = rs.getString("id");
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    if(session != null) {
				    	System.out.println("�α������Դϴ�");
				    	continue;
				    }
				    System.out.println("���̵� �Է� : ");
				    String id = input.readLine();
				    System.out.println("�н����� �Է� : ");
				    String pw = input.readLine();
				    System.out.println("�ּ� �Է�: ");
				    String addr =input.readLine();
				    System.out.println("��ȭ��ȣ �Է� : ");
				    String tel = input.readLine();
				    try {
						stmt = conn.createStatement();
						sql = "insert into member(id,pw,addr,tel) values('"+id+"','"+pw+"','"+addr+"','"+tel+"')";
						cnt = stmt.executeUpdate(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    System.out.println(cnt+" �� ȸ���� ��ϵǾ����ϴ�");
					
				}//ȸ������
				else if (protocol.equals("S") || protocol.equals("s")) {//idã��
					
					System.out.println("ã�� ID�� �Է����ּ��� : ");
					String idSearch = input.readLine();
					System.out.println("ȸ�����̵�\tȸ���н�����\tȸ���ּ�\tȸ����ȭ��ȣ\n");
					String id = null;
					String pw = null;
					String addr = null;
					String tel = null;
					
					
					try {
						stmt = conn.createStatement();
						sql = "select id,pw,addr,tel from member where id = '"+idSearch+"'";
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							id= rs.getString("id");
							pw = rs.getString("pw");
							addr = rs.getString("addr");
							tel = rs.getString("tel");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
					if (id==null) { 
						System.out.println("ã�� ���̵� �����ϴ�");
						continue;
					}
						
			System.out.println(id+"\t"+pw+"\t"+addr+"\t"+tel+"\n");
						
				
					
				} //idã��
				else if (protocol.equals("D") || protocol.equals("d")) {//ȸ��Ż��
					String id =null;
					if(session ==null) {
						System.out.println("�α����ϼ���");
						continue;
					}
					 /*try {
						stmt = conn.createStatement();
						sql = "select id from member";
						ResultSet rs = stmt.executeQuery(sql);
						
						while(rs.next()) {
							id= rs.getString("id");
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
							if(id.equals(session))	 {
								stmt = conn.createStatement();
								sql ="delete from member where id = '"+session+"'";
								cnt = stmt.executeUpdate(sql);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
					
					System.out.println("���� Ż���Ͻðڽ��ϱ�? y/n");
					String result = input.readLine();
					if(result.equals("y")||result.equals("Y")) {
						try {
							stmt = conn.createStatement();
							sql ="delete from member where id = '"+session+"'";
							cnt = stmt.executeUpdate(sql);
							session = null;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					}else if(result.equals("n")||result.equals("N")) {
						continue;
					}
					
						
						System.out.println("ȸ��Ż�� �Ǿ����ϴ�");
						
					
				}//ȸ��Ż��
				else if (protocol.equals("E") || protocol.equals("e")) { //ȸ������
					
					System.out.print("ȸ�����̵�\tȸ���н�����\tȸ���ּ�\tȸ����ȭ��ȣ\n");
					String id = null;
					String pw = null;
					String addr = null;
					String tel = null;
					try {
						stmt = conn.createStatement();
						sql = "select * from member where id='"+session+"'";
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							 id = rs.getString("id");
							 pw = rs.getString("pw");
							 addr =rs.getString("addr");
							 tel = rs.getString("tel");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(id.equals(session)) {
						System.out.print(id+"\t"+pw+"\t"+addr+"\t"+tel+"\n");
						System.out.println("ȸ�����̵� �Է� : ");
						String idupdate = input.readLine();
						System.out.println("ȸ�� �н����� �Է� : ");
						String pwupdate = input.readLine();
						System.out.println("ȸ�� �ּ� �Է� : ");
						String addrupdate = input.readLine();
						System.out.println("ȸ�� ��ȭ��ȣ �Է� : "); 
						String telupdate = input.readLine();
						
						try {
							stmt = conn.createStatement();
							sql = "update member set id = '"+idupdate+"',pw='"+pwupdate+"',addr='"+addrupdate+"',tel='"+telupdate+"' where id ='"+session+"'";
							cnt = stmt.executeUpdate(sql);
							session = idupdate; // ���ǿ��� ���� ���̵� �����Ǿ��ֱ⶧����
							System.out.println(cnt+"�� ȸ���� �����Ǿ����ϴ�");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
					
					
					
				}//ȸ������
				else if(protocol.equals("I") || protocol.equals("i")) {
					if(session!=null) {
						System.out.println("�α������Դϴ�");
						continue;
					}
					System.out.println("���̵� �Է� : ");
					String loginid = input.readLine();
					System.out.println("�н����� �Է� : ");
					String loginpw = input.readLine();
					String id = null;
					String pw = null;
					try {
						stmt = conn.createStatement();
						sql = "select id,pw from member where id = '"+loginid+"'";
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							id = rs.getString("id");
							pw = rs.getString("pw");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(!(loginid.equals(id))) {
						System.out.println("���̵� Ʋ�Ƚ��ϴ�");
						continue;
					}
					if(!(loginpw.equals(pw))) {
						System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�");
						continue;
					}
					System.out.println("ȯ���մϴ�. �α��εǾ����ϴ�");
					session = loginid;
					
				}//�α���
				else if (protocol.equals("O") || protocol.equals("o")) {
					
					session = null;   
					//static �������� �������ݿ� ������ ���� �ʰ� �α��ΰ� �α׾ƿ��� ������ �� ����
					System.out.println("�α׾ƿ� �Ǿ����ϴ�");
					
				}//�α׾ƿ�
				else if(protocol.equals("L") || protocol.equals("l")) { //ȸ�����
					
					System.out.print("ȸ�����̵�\tȸ���н�����\tȸ���ּ�\tȸ����ȭ��ȣ\n");
					
					try {
						stmt = conn.createStatement();
						sql = "select * from member";
						ResultSet rs = stmt.executeQuery(sql);
						
						while(rs.next()) {
							String id = rs.getString("id");
							String pw = rs.getString("pw");
							String addr = rs.getString("addr");
							String tel = rs.getString("tel");
							System.out.println(id+"\t"+pw+"\t"+addr+"\t"+tel+"\n");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}//ȸ�����
				
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} // �ݺ���
		  
		  
		
	}
}
