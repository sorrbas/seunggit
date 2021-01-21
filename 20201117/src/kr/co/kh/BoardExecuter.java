package kr.co.kh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardExecuter {

	public static void main(String[] args) {   
		Scanner sc = new Scanner(System.in);
		    //1. �ε� (���� = �ڹٿ��� ���� �����ͺ��̽��� �� ���ڴٶ�� �˷��ִ� ��)
		    //2. ���� (Connection)�����Ѵ� .  DriverManager.getConnection
		    //3. �غ� (Statement) 3-1 ������ �غ� 
		    //3. �غ�                         3-2 ������ �غ�(sql�� �����ϳ��� ������� �θ�)
		    //4. ����   execute       <--�����ɾ� 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn =null;
		
		while(true) { //�ݺ���
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "khbclass", "dkdlxl");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		System.out.println("======�Խ����ۼ�======");
		System.out.println("R:��� S:�˻� D:���� U:���� L:��� ");
		
		char protocol = sc.next().charAt(0);
		if(protocol=='r' || protocol=='R') { //��ϱ���
			System.out.println("����|���� :");
			String titleContent = sc.next();
			int indexI = titleContent.indexOf("|");
			String title = titleContent.substring(0,indexI);
			String content = titleContent.substring(indexI+1);
			System.out.println("�ۼ����Է� :");
			String author = sc.next();
			System.out.println("��¥ �Է� : ");
			String nal = sc.next();
			System.out.println("��ȸ�� �Է� : ");
		    int readcount = sc.nextInt();
		    
		  
			
				try {
				
					  Statement stmt = conn.createStatement(); //�����غ�
					  String sql = "insert into board(no,title,content,author,nal,readcount) values (board_no.nextval,'"+title+"','"+content+"','"+author+"','"+nal+"',"+readcount+")";
					  //�ϳ��� ���� statement
					//4. ����   execute       <--�����ɾ� 
					  int cnt = stmt.executeUpdate(sql);
					  System.out.println(cnt+"�� �Խñ��� ��ϵǾ����ϴ�");
					  stmt.close();
					  conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			
		} // ��ϱ���
		else if (protocol =='S' || protocol == 's') { //�˻�����
		     System.out.println("ã�� �Խñ��� �Է��ϼ��� : ");
		     String titleSearch = sc.next();
		     System.out.println("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��");
		     //1.�ε�(����) 2.����    3.�غ�(����/����) 4.����
		     //3. �غ�
		     try {
				Statement stmt = conn.createStatement();
				 String sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD WHERE TITLE ='"+ titleSearch+"'";
				 ResultSet rs = stmt.executeQuery(sql);
                  int readcount = 0;
				 //ǥ �ȿ� �ִ� �͵��� ����Ű�� ��  rs�� �������̽� �������̽��� ��� ���� ����Ű�� ����  rs�� ���� ����Ű�� ���� 
				 while(rs.next()) {
					int no = rs.getInt("no");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String author =  rs.getString("author");
					String nal =  rs.getString("nal");
				    System.out.print(no+"\t"+title+"\t"+content+"\t"+author+"\t"+nal+"\t"+readcount);
				    readcount++;
				 }
				 stmt = conn.createStatement();
				 sql = "update board set readcount= "+readcount+" where title = '"+titleSearch+"'"; 
				 int cnt  =stmt.executeUpdate(sql);
				 stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		      
		}//�˻�����
		else if (protocol =='D' || protocol == 'd') { //��������
			System.out.println("������ ������ �Է� : ");
			String titleDelete = sc.next();
			
			try {
				Statement stmt = conn.createStatement();
				String sql = "delete from board where title = '"+titleDelete+"'";
				int cnt =  stmt.executeUpdate(sql);
				System.out.println(cnt+"�� �Խñ��� �����Ǿ����ϴ�");
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//��������
		else if (protocol =='u' || protocol == 'U') { //��������
		   System.out.println("���� �� �Խñ������� �Է��ϼ��� : ");
		   String titlesearch = sc.next();
		   Statement stmt =null;
		String sql = null;
		try {
			stmt = conn.createStatement();
			   sql = "select title,content,author,nal,readcount from board where title = '"+titlesearch+"'";
			   ResultSet rs = stmt.executeQuery(sql);
			   System.out.println("*** �����ϱ� �� �Խñ��Դϴ�.***");
			   
			   while (rs.next()) {
				   String title = rs.getString("title");
					String content = rs.getString("content");
					String author =  rs.getString("author");
					String nal =  rs.getString("nal");
					int readcount =  rs.getInt("readcount");
				    System.out.print(title+"\t"+content+"\t"+author+"\t"+nal+"\t"+readcount+"\n");
			   }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   System.out.println("������ �����Ͻðڽ��ϱ�? y/n");
		   char option =sc.next().charAt(0);
		   if(option == 'Y' | option == 'y') {
				System.out.println("����|���� :");
				String titleContent = sc.next();
				int indexI = titleContent.indexOf("|");
				String titleupdate = titleContent.substring(0,indexI);
				String contentupdate = titleContent.substring(indexI+1);
				System.out.println("�ۼ����Է� :");
				String authorupdate = sc.next();
				System.out.println("��¥ �Է� : ");
				String nalupdate = sc.next();
				System.out.println("��ȸ�� �Է� : ");
			    int readcountupdate = sc.nextInt();
			  try {
				stmt = conn.createStatement();
				  sql = "UPDATE board set title ='"+titleupdate+"',content='"+contentupdate+"',author='"+authorupdate+"',nal = '"+nalupdate+"', readcount='"+readcountupdate+"'where title = '"+titlesearch+"'" ;
				  int cnt = stmt.executeUpdate(sql);
				  System.out.println(cnt+"�� �Խñ��� �����Ǿ����ϴ�");
				  stmt.close();
				  conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }else  {
			   try {
				   stmt.close();
				   conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   continue;
		   }
		}//��������
		else if (protocol =='L' || protocol == 'l') { //��ϱ���(��ü��� �� )
		System.out.println("***�Խ��� ��ü���***");
		System.out.println("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
		//3. �����غ�
		//3. �����غ� 
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD order by no asc";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String author = rs.getString("author");
				String nal = rs.getString("nal");
				int readcount = rs.getInt("readcount");
				System.out.print(no+"\t"+title+"\t"+content+"\t"+author+"\t"+nal+"\t"+readcount+"\n");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		//stmt.close();
		//conn.close();
		}//��ϱ���
		
		} // �ݺ���
		
	}


