package kr.co.kh.obj;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {

	private String titleSearch;
	private Statement stmt;
	private String sql;
	private Connection conn;
	private ResultSet rs;
	private int no;
	private String title;
	private String content;
	private String author;
	private String nal;
	private int readcount;
	private char option;
	private String titleContent;
	private String titleupdate;
	private int indexI;
	private String contentupdate;
	private String authorupdate;
	private String nalupdate;
	private int readcountupdate;
	
	
	public Update() {
		
	}
	public void boardUpdateTitle() {
		System.out.println("���� �� �Խñ������� �Է��ϼ��� : ");
		titleSearch = Register.input.next();
	}
	public void boardUpdateSearch()throws SQLException {
		conn=Register.getConnection();
		stmt = conn.createStatement();
		sql = "select title,content,author,nal,readcount from board where title = '" + titleSearch + "'";
	}
	public void boardUpdateExecutersql()throws SQLException {
		 rs = stmt.executeQuery(sql);
	}
	
	public void boardUpdateOld()throws SQLException {
		
		while (rs.next()) {
			title = rs.getString("title");
			content = rs.getString("content");
			author = rs.getString("author");
			nal = rs.getString("nal");
			readcount = rs.getInt("readcount");
			System.out.print(title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount + "\n");
		}
	}
	public char boardUpdateOption() {
		
		System.out.println("������ �����Ͻðڽ��ϱ�? y/n");
		
		option = Register.input.next().charAt(0);
		return option;
	}
	public void boardUpdateConfirm() {
		
		if (option == 'Y' | option == 'y') {
			System.out.println("����|���� :");
			 titleContent = Register.input.next();
			 indexI = titleContent.indexOf("|");
			 titleupdate = titleContent.substring(0, indexI);
			 contentupdate = titleContent.substring(indexI + 1);
			System.out.println("�ۼ����Է� :");
			 authorupdate = Register.input.next();
			System.out.println("��¥ �Է� : ");
			 nalupdate = Register.input.next();
			System.out.println("��ȸ�� �Է� : ");
			readcountupdate = Register.input.nextInt();
	}
	}
		public void boardUpdateFinal()throws SQLException {
			stmt = conn.createStatement();
			sql = "UPDATE board set title ='" + titleupdate + "',content='" + contentupdate + "',author='"
					+ authorupdate + "',nal = '" + nalupdate + "', readcount='" + readcountupdate + "'where title = '"
					+ titleSearch + "'";
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�");
		}
}
		
		/*public static void main(String[] args)throws SQLException {
			Update update = new Update();
			update.boardUpdateTitle();
			update.boardUpdateSearch();
			update.boardUpdateExecutersql();
			update.boardUpdateOld();
			update.boardUpdateOption();
			update.boardUpdateConfirm();
			update.boardUpdateFinal();   
		}
	}*/

/*	public char update(Scanner sc, Connection conn)throws SQLException {
	
			stmt = conn.createStatement();
			sql = "UPDATE board set title ='" + titleupdate + "',content='" + contentupdate + "',author='"
					+ authorupdate + "',nal = '" + nalupdate + "', readcount='" + readcountupdate + "'where title = '"
					+ titlesearch + "'";
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�");
			
		}
		return option;
	}
	}  */

