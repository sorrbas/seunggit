package kr.co.kh.obj1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardFunction {

	public static void register(Scanner sc, Connection conn)throws SQLException {
		System.out.println("����|���� :");
		String titleContent = sc.next();
		int indexI = titleContent.indexOf("|");
		String title = titleContent.substring(0, indexI);
		String content = titleContent.substring(indexI + 1);
		System.out.println("�ۼ����Է� :");
		String author = sc.next();
		System.out.println("��¥ �Է� : ");
		String nal = sc.next();
		System.out.println("��ȸ�� �Է� : ");
		int readcount = sc.nextInt();

		

			Statement stmt = conn.createStatement(); // �����غ�
			/*String sql = "insert into board(title,content,author,nal,readcount) values ('" + title
					+ "','" + content + "','" + author + "','" + nal + "'," + readcount + ")";*/
			String sql = "insert into board(no,title,content,author,nal,readcount) values (board_no.nextval,'" + title
					+ "','" + content + "','" + author + "','" + nal + "'," + readcount + ")";  
			// �ϳ��� ���� statement
			// 4. ���� execute <--�����ɾ�
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "�� �Խñ��� ��ϵǾ����ϴ�");
			
	
	}

	public static void search(Scanner sc, Connection conn)throws SQLException {
		System.out.println("ã�� �Խñ��� �Է��ϼ��� : ");
		String titleSearch = sc.next();
		System.out.println("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��");
		// 1.�ε�(����) 2.���� 3.�غ�(����/����) 4.����
	
	
			Statement stmt = conn.createStatement();
			String sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD WHERE TITLE ='" + titleSearch + "'";
			ResultSet rs = stmt.executeQuery(sql);
			int readcount = 0;
			// ǥ �ȿ� �ִ� �͵��� ����Ű�� �� rs�� �������̽� �������̽��� ��� ���� ����Ű�� ���� rs�� ���� ����Ű�� ����
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String author = rs.getString("author");
				String nal = rs.getString("nal");
				System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount);
				readcount++;
			}
			stmt = conn.createStatement();
			sql = "update board set readcount= " + readcount + " where title = '" + titleSearch + "'";
			int cnt = stmt.executeUpdate(sql);
		}
			
	
	public static void delete(Scanner sc, Connection conn)throws SQLException {
		System.out.println("������ ������ �Է� : ");
		String titleDelete = sc.next();

	
			Statement stmt = conn.createStatement();
			String sql = "delete from board where title = '" + titleDelete + "'";
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�");
			
		} 

	
	public static char update(Scanner sc, Connection conn) throws SQLException {

		System.out.println("���� �� �Խñ������� �Է��ϼ��� : ");
		String titlesearch = sc.next();
		Statement stmt = null;
		String sql = null;

		stmt = conn.createStatement();
		sql = "select title,content,author,nal,readcount from board where title = '" + titlesearch + "'";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("*** �����ϱ� �� �Խñ��Դϴ�.***");

		while (rs.next()) {
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			int readcount = rs.getInt("readcount");
			System.out.print(title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount + "\n");
		}
		System.out.println("������ �����Ͻðڽ��ϱ�? y/n");
		char option = sc.next().charAt(0);
		if (option == 'Y' | option == 'y') {
			System.out.println("����|���� :");
			String titleContent = sc.next();
			int indexI = titleContent.indexOf("|");
			String titleupdate = titleContent.substring(0, indexI);
			String contentupdate = titleContent.substring(indexI + 1);
			System.out.println("�ۼ����Է� :");
			String authorupdate = sc.next();
			System.out.println("��¥ �Է� : ");
			String nalupdate = sc.next();
			System.out.println("��ȸ�� �Է� : ");
			int readcountupdate = sc.nextInt();

			stmt = conn.createStatement();
			sql = "UPDATE board set title ='" + titleupdate + "',content='" + contentupdate + "',author='"
					+ authorupdate + "',nal = '" + nalupdate + "', readcount='" + readcountupdate + "'where title = '"
					+ titlesearch + "'";
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�");
			
		}
		return option;
	}

	public static void list(Connection conn)throws SQLException {

		System.out.println("***�Խ��� ��ü���***");
		System.out.println("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��\n");
		// 3. �����غ�
		// 3. �����غ�
	
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
				System.out.print(
						no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount + "\n");
			}
		} 

	}


