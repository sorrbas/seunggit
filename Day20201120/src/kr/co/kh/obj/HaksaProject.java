package kr.co.kh.obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HaksaProject {

	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String protocol=null;
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		Statement stmt =null;
		while(true) {//�ݺ���
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","khbclass","dkdlxl");
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
					String irum = input.readLine();
					System.out.println("�й�:");
					String hakbun1 = input.readLine();
					int cnt=0;
					try {
						stmt=conn.createStatement();
						int age=Integer.parseInt(age1);
						int hakbun = Integer.parseInt(hakbun1);
						String sql = "insert into student(no,age,irum,hakbun) values(student_no.nextval,"+age+",'"+irum+"',"+hakbun+")";
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
					String irum = input.readLine();
					System.out.println("����:");
					String subject = input.readLine();
					int age=Integer.parseInt(age1);
					try {
						stmt = conn.createStatement();
						String sql = "insert into professor(no,age,irum,subject) values(professor_no.nextval,"+age+",'"+irum+"','"+subject+"')";
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
					String irum = input.readLine();
					System.out.println("�μ�:");
					String part = input.readLine();
					int cnt=0;
					try {
						stmt = conn.createStatement();
						int age = Integer.parseInt(age1);
						String sql = "insert into manager(no,age,irum,part) values(manager_no.nextval,"+age+",'"+irum+"','"+part+"')";
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
						String irumSearch = input.readLine();
						stmt = conn.createStatement();
						String sql = "select age,irum,hakbun from student where irum='"+irumSearch+"'";
						ResultSet rs=stmt.executeQuery(sql);
						String irum=null;
						int age=0;
						int hakbun=0;
						if(!rs.isBeforeFirst()) {
							System.out.println("ã���л��� �����ϴ�.");
						}
						while(rs.next()) {
							irum=rs.getString("irum");
							age=rs.getInt("age");
							hakbun=rs.getInt("hakbun");
							System.out.print("�̸�:"+irum);
							System.out.print("����:"+age);
							System.out.print("�й�:"+hakbun+"\n");
						}
						
					}else if(gubun.equals("2")) {
						System.out.println("ã�� �����̸��Է�:");
						String irumSearch = input.readLine();
						stmt = conn.createStatement();
						String sql = "select age,irum,subject from professor where irum='"+irumSearch+"'";
						ResultSet rs=stmt.executeQuery(sql);
						String irum=null;
						int age=0;
						String subject=null;
						if(!rs.isBeforeFirst()) {
							System.out.println("ã�±������� �����ϴ�.");
						}
						while(rs.next()) {
							irum=rs.getString("irum");
							age=rs.getInt("age");
							subject=rs.getString("subject");
							System.out.print("�̸�:"+irum);
							System.out.print("����:"+age);
							System.out.print("����:"+subject+"\n");
						}
					}else if(gubun.equals("3")) {
						System.out.println("ã�� �������̸��Է�:");
						String irumSearch = input.readLine();
						stmt = conn.createStatement();
						String sql = "select age,irum,part from manager where irum='"+irumSearch+"'";
						ResultSet rs=stmt.executeQuery(sql);
						String irum=null;
						int age=0;
						String part=null;
						if(!rs.isBeforeFirst()) {
							System.out.println("ã�°����ڴ��� �����ϴ�.");
						}
						while(rs.next()) {
							irum=rs.getString("irum");
							age=rs.getInt("age");
							part=rs.getString("part");
							System.out.print("�̸�:"+irum);
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
					String irumDelete = input.readLine();
					stmt = conn.createStatement();
					String sql = "delete from student where irum='"+irumDelete+"'";
					int cnt=stmt.executeUpdate(sql);
					System.out.println(cnt+"�� �л��� �����Ǿ����ϴ�.");				
				}
				else if(gubun.equals("2")) {
					System.out.println("�������̸�:");
					String irumDelete =input.readLine();
					stmt = conn.createStatement();
					String sql = "delete from professor where irum='"+irumDelete+"'";
					int cnt = stmt.executeUpdate(sql);
					System.out.println(cnt+"�� �������� �����Ǿ����ϴ�.");
				}
				else if(gubun.equals("3")) {
					System.out.println("�������̸�:");
					String irumDelete = input.readLine();
					stmt = conn.createStatement();
					String sql = "delete from manager where irum='"+irumDelete+"'";
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
				String sql = "select no,age,irum,hakbun from student";
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					int no=rs.getInt("no");
					int age=rs.getInt("age");
					String irum=rs.getString("irum");
					int hakbun=rs.getInt("hakbun");
					System.out.print("�̸�:");
					System.out.print(irum+"\t");
					System.out.print("����:");
					System.out.print(age+"\t");
					System.out.print("�й�:");
					System.out.print(hakbun+"\n");
				}
				stmt = conn.createStatement();
				sql = "select no,age,irum,subject from professor";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int no = rs.getInt("no");
					int age = rs.getInt("age");
					String irum = rs.getString("irum");
					String subject = rs.getString("subject");
					System.out.print("�̸�:");
					System.out.print(irum+"\t");
					System.out.print("����:");
					System.out.print(age+"\t");
					System.out.print("����:");
					System.out.print(subject+"\n");
				}
				stmt = conn.createStatement();
				sql = "select no,age,irum,part from manager";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int no = rs.getInt("no");
					int age = rs.getInt("age");
					String irum = rs.getString("irum");
					String part = rs.getString("part");
					System.out.print("�̸�:");
					System.out.print(irum+"\t");
					System.out.print("����:");
					System.out.print(age+"\t");
					System.out.print("�μ�:");
					System.out.print(part+"\n");
				}
				stmt = conn.createStatement();
				sql = "select s.no as ��ȣ,s.age as ����,s.irum as �̸�,s.hakbun as �й�,p.age as ��������,p.irum as �����̸�,p.subject as ����,m.age as �����ڳ���,m.irum as �������̸�,m.part as �μ� from (student s full outer join professor p on s.no=p.no) full outer join manager m on s.no=m.no ORDER BY ��ȣ ASC";
				System.out.println("�л���ü���");
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int sage=rs.getInt("����");
					String sirum=rs.getString("�̸�");
					int shakbun=rs.getInt("�й�");
					int page = rs.getInt("��������");
					String pirum=rs.getString("�����̸�");
					String psubject=rs.getString("����");
					int mage = rs.getInt("�����ڳ���");
					String mirum=rs.getString("�������̸�");
					String mpart=rs.getString("�μ�");
					System.out.print(sage+"\t"+sirum+"\t"+shakbun+"\t"+page+"\t"+pirum+"\t"+psubject+"\t"+mage+"\t"+mirum+"\t"+mpart+"\n");
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
