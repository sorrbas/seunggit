package kr.co.kh.obj1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class List {

	private Connection conn;
	private Statement stmt;
	private String sql;
	private ResultSet rs;
	private int no;
	private String title;
	private String content;
	private String author;
	private String nal;
	private int readcount;
	
	
	
	
	public List() {
	}
	

	public void listboardTitle() {
		System.out.println("***게시판 전체출력***");
		System.out.println("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
	}

	public void listBoardsql()throws SQLException {
		conn=Register.getConnection();
		 stmt = conn.createStatement();
		 sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD order by no asc";
	}

	public void listBoardExecuter()throws SQLException {
	 rs = stmt.executeQuery(sql);
	}

	public void listBoardProcess()throws SQLException {
		while (rs.next()) {
			 no = rs.getInt("no");
			 title = rs.getString("title");
			 content = rs.getString("content");
			 author = rs.getString("author");
			 nal = rs.getString("nal");
			 readcount = rs.getInt("readcount");
			System.out.print(
					no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount + "\n"); 
	
	}
	
	}
//	public static void main(String[] args)throws SQLException {
//		List list = new List();
//		list.listboardTitle();
//		list.listBoardsql();
//		list.listBoardExecuter();
//		list.listBoardProcess();
//	}
}	
	
	
	   
  