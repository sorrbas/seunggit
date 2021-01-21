package kr.co.kh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HaksaProject1 {

	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String protocol=null;
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		Statement stmt =null;
		while(true) {//�ݺ���
		try {
			conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		System.out.println("======�л����=====");
		System.out.println("1.���");
		System.out.println("2.�˻�");
		System.out.println("3.����");
		System.out.println("4.��ü���");
		System.out.println("=================");
		System.out.println("0.����");
		System.out.println("��ȣ�� ������ �ּ���..");		
		try {
			protocol = input.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(protocol.equals("1")) {
			System.out.println("=====�޴�����======");
			System.out.println("1.�л�");
			System.out.println("2.����");
			System.out.println("3.������");
			System.out.println("4.�����޴�");
			System.out.println("��ȣ�� ������ �ּ���..");
			try {
				protocol=input.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(protocol.equals("1")) {
				System.out.println("�л����");
				try {
					System.out.println("����:");
					String age1 = input.readLine();
					System.out.println("�̸�:");
					String name = input.readLine();
					System.out.println("�й�:");
					String hakbun1 = input.readLine();
					int cnt=0;
					try {
						stmt=conn.createStatement();
						int age=Integer.parseInt(age1);
						int hakbun = Integer.parseInt(hakbun1);
						String sql = "insert into student(age,name,hakbun) values("+age+",'"+name+"',"+hakbun+")";
						cnt = stmt.executeUpdate(sql);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					System.out.println(cnt+"�� �л��� ��ϵǾ����ϴ�.");
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
		           try {
					conn.close();
					   stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				}
			}else if(protocol.equals("2")) {
				System.out.println("�������");
				try {
					System.out.println("����:");
					String age1 = input.readLine();
					System.out.println("�̸�:");
					String name = input.readLine();
					System.out.println("����:");
					String subject = input.readLine();
					int age=Integer.parseInt(age1);
					try {
						stmt = conn.createStatement();
						String sql = "insert into professor(age,name,subject) values("+age+",'"+name+"','"+subject+"')";
						int cnt=stmt.executeUpdate(sql);
						System.out.println(cnt+"�� �������� ��ϵǾ����ϴ�.");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						conn.close();
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}else if(protocol.equals("3")) {
				System.out.println("�����ڵ��");
			    try {
					System.out.println("����:");
					String age1 = input.readLine();
					System.out.println("�̸�:");
					String name = input.readLine();
					System.out.println("�μ�:");
					String part = input.readLine();
					int cnt=0;
					try {
						stmt = conn.createStatement();
						int age = Integer.parseInt(age1);
						String sql = "insert into manager(age,name,part) values("+age+",'"+name+"','"+part+"')";
						cnt = stmt.executeUpdate(sql);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						try {
							conn.close();
							stmt.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					System.out.println(cnt+"�� �����ڴ��� ��ϵǾ����ϴ�.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(protocol.equals("4")) {
				continue;
			}
			System.out.println("����Ͻ÷��� 1,�����Ͻ÷���0�� �Է��� �ּ���..");
			try {
				String cnt = input.readLine();
				if(cnt.equals("1")) {
					continue;
				}else {
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}else if(protocol.equals("2")) {
			System.out.println("ã��");
			System.out.println("ã�����:");
			System.out.println("1.�л�2.����3.������");
		  
				try {
					String gubun = input.readLine();
					if(gubun.equals("1")) {
						System.out.println("ã�� �л��̸��Է�:");
						String nameSearch = input.readLine();
						stmt = conn.createStatement();
						String sql = "select age,name,hakbun from student where name='"+nameSearch+"'";
						ResultSet rs=stmt.executeQuery(sql);
						String name=null;
						int age=0;
						int hakbun=0;
						if(!rs.isBeforeFirst()) {
							System.out.println("ã���л��� �����ϴ�.");
						}
						while(rs.next()) {
							name=rs.getString("name");
							age=rs.getInt("age");
							hakbun=rs.getInt("hakbun");
							System.out.print("�̸�:"+name);
							System.out.print("����:"+age);
							System.out.print("�й�:"+hakbun+"\n");
						}
						
					}else if(gubun.equals("2")) {
						System.out.println("ã�� �����̸��Է�:");
						String nameSearch = input.readLine();
						stmt = conn.createStatement();
						String sql = "select age,name,subject from professor where name='"+nameSearch+"'";
						ResultSet rs=stmt.executeQuery(sql);
						String name=null;
						int age=0;
						String subject=null;
						if(!rs.isBeforeFirst()) {
							System.out.println("ã�±������� �����ϴ�.");
						}
						while(rs.next()) {
							name=rs.getString("name");
							age=rs.getInt("age");
							subject=rs.getString("subject");
							System.out.print("�̸�:"+name);
							System.out.print("����:"+age);
							System.out.print("����:"+subject+"\n");
						}
					}else if(gubun.equals("3")) {
						System.out.println("ã�� �������̸��Է�:");
						String nameSearch = input.readLine();
						stmt = conn.createStatement();
						String sql = "select age,name,part from manager where name='"+nameSearch+"'";
						ResultSet rs=stmt.executeQuery(sql);
						String name=null;
						int age=0;
						String part=null;
						if(!rs.isBeforeFirst()) {
							System.out.println("ã�°����ڴ��� �����ϴ�.");
						}
						while(rs.next()) {
							name=rs.getString("name");
							age=rs.getInt("age");
							part=rs.getString("part");
							System.out.print("�̸�:"+name);
							System.out.print("����:"+age);
							System.out.print("�μ�:"+part+"\n");
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			
		}else if(protocol.equals("3")) {
			System.out.println("����");
			System.out.println("�������:");
			System.out.println("1.�л�2.����3.������");
			try {
				String gubun = input.readLine();
				if(gubun.equals("1")) {
					System.out.println("�������̸�:");
					String nameDelete = input.readLine();
					stmt = conn.createStatement();
					String sql = "delete from student where name='"+nameDelete+"'";
					int cnt=stmt.executeUpdate(sql);
					System.out.println(cnt+"�� �л��� �����Ǿ����ϴ�.");				
				}
				else if(gubun.equals("2")) {
					System.out.println("�������̸�:");
					String nameDelete =input.readLine();
					stmt = conn.createStatement();
					String sql = "delete from professor where name='"+nameDelete+"'";
					int cnt = stmt.executeUpdate(sql);
					System.out.println(cnt+"�� �������� �����Ǿ����ϴ�.");
				}
				else if(gubun.equals("3")) {
					System.out.println("�������̸�:");
					String nameDelete = input.readLine();
					stmt = conn.createStatement();
					String sql = "delete from manager where name='"+nameDelete+"'";
					int cnt = stmt.executeUpdate(sql);
					System.out.println(cnt+"�� �����ڴ��� �����Ǿ����ϴ�.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else if(protocol.equals("4")) {
			System.out.println("��ü���");
			try {
				stmt=conn.createStatement();
				String sql = "select no,age,name,hakbun from student";
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					int no=rs.getInt("no");
					int age=rs.getInt("age");
					String name=rs.getString("name");
					int hakbun=rs.getInt("hakbun");
					System.out.print("�̸�:");
					System.out.print(name+"\t");
					System.out.print("����:");
					System.out.print(age+"\t");
					System.out.print("�й�:");
					System.out.print(hakbun+"\n");
				}
				stmt = conn.createStatement();
				sql = "select no,age,name,subject from professor";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int no = rs.getInt("no");
					int age = rs.getInt("age");
					String name = rs.getString("name");
					String subject = rs.getString("subject");
					System.out.print("�̸�:");
					System.out.print(name+"\t");
					System.out.print("����:");
					System.out.print(age+"\t");
					System.out.print("����:");
					System.out.print(subject+"\n");
				}
				stmt = conn.createStatement();
				sql = "select no,age,name,part from manager";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int no = rs.getInt("no");
					int age = rs.getInt("age");
					String name = rs.getString("name");
					String part = rs.getString("part");
					System.out.print("�̸�:");
					System.out.print(name+"\t");
					System.out.print("����:");
					System.out.print(age+"\t");
					System.out.print("�μ�:");
					System.out.print(part+"\n");
				}
				stmt = conn.createStatement();
				sql = "select s.no as ��ȣ,s.age as ����,s.name as �̸�,s.hakbun as �й�,p.age as ��������,p.name as �����̸�,p.subject as ����,m.age as �����ڳ���,m.name as �������̸�,m.part as �μ� from (student s full outer join professor p on s.no=p.no) full outer join manager m on s.no=m.no ORDER BY ��ȣ ASC";
				System.out.println("�л���ü���");
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int sage=rs.getInt("����");
					String sname=rs.getString("�̸�");
					int shakbun=rs.getInt("�й�");
					int page = rs.getInt("��������");
					String pname=rs.getString("�����̸�");
					String psubject=rs.getString("����");
					int mage = rs.getInt("�����ڳ���");
					String mname=rs.getString("�������̸�");
					String mpart=rs.getString("�μ�");
					System.out.print(sage+"\t"+sname+"\t"+shakbun+"\t"+page+"\t"+pname+"\t"+psubject+"\t"+mage+"\t"+mname+"\t"+mpart+"\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
		}else if(protocol.equals("0")) {			
			System.out.println("�л����α׷��� �����մϴ�.");
			System.exit(0);
		}
	 }//�ݺ���
	}
}
