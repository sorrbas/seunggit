package kr.co.kh.obj1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Search {

	
	private String titleSearch;
    private Connection conn;	
    private Statement stmt;
    private String sql;
    private ResultSet rs;
	private int readcount;
    private int cnt;
    
    
	public Search() {
		
	}
	
	public void setTitlesearch() {
		System.out.println("ã�� �Խñ��� �Է��ϼ��� : ");
		titleSearch = Register.input.next();
		
		
	}
	
	
	public void boardsearchTitle() {
		System.out.println("��ȣ\t����\t����\t�ۼ���\t��¥\t��ȸ��");
		
	}

       public void boardstmtsql ()throws SQLException {
    	   conn =  Register.getConnection();
    	    stmt = conn.createStatement();
    	     sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD WHERE TITLE ='" + titleSearch + "'";
    	   
       }
	
       public void  boardsearchExecuter()throws SQLException {
    	   
    	    rs = stmt.executeQuery(sql);
    	   
       }
       public void boardsearchProcess()throws SQLException {
    	   while (rs.next()) {
    			int no = rs.getInt("no");
    			String title = rs.getString("title");
    			String content = rs.getString("content");
    			String author = rs.getString("author");
    			String nal = rs.getString("nal");
    			System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount);
    			readcount++;
    		}
    	   
       }
       public void boardsearchReadcount()throws SQLException {
    	   stmt = conn.createStatement();
    		sql = "update board set readcount= " + readcount + " where title = '" + titleSearch + "'";
    		cnt = stmt.executeUpdate(sql);
      }
//       public static void main(String[] args)throws SQLException {
//    	   Search search = new Search();
//    	   search.setTitlesearch();
//    	   search.boardsearchTitle();
//    	   search.boardstmtsql();
//    	   search.boardsearchExecuter();
//    	   search.boardsearchProcess();
//    	   search.boardsearchReadcount();
//    	   
//    	   
//    	   
//       }
	}
/*
public void search()throws SQLException {

// 1.�ε�(����) 2.���� 3.�غ�(����/����) 4.����



	
	// ǥ �ȿ� �ִ� �͵��� ����Ű�� �� rs�� �������̽� �������̽��� ��� ���� ����Ű�� ���� rs�� ���� ����Ű�� ����
	
	stmt = conn.createStatement();
	sql = "update board set readcount= " + readcount + " where title = '" + titleSearch + "'";
	int cnt = stmt.executeUpdate(sql);
	}
	*/