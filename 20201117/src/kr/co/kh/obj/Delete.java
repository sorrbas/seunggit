package kr.co.kh.obj;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Delete {

	private Connection conn;
	private String titleDelete;
	private Statement stmt;
	private String sql;
	private int cnt;
	
	
	
	public Delete() {
	}
	
	public void boardDeleteTitle() {
		
		System.out.println("������ ������ �Է� : ");
		titleDelete = Register.input.next();
	}
	public void boardDeletesql()throws SQLException {
		 conn = Register.getConnection();
		stmt = conn.createStatement();
		 sql = "delete from board where title = '" + titleDelete + "'";
	}
	
	public void boardDeleteExecuter()throws SQLException {
		cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�");
	}
	
//	public static void main(String[] args)throws SQLException {
//		Delete delete = new Delete();
//		
//		delete.boardDeleteTitle();
//		delete.boardDeletesql();
//		delete.boardDeleteExecuter();
//		
//		
//	}
		
	
}
	/*public delete(Scanner sc,)throws SQLException {
	

	
			
			int cnt = stmt.executeUpdate(sql);
		System.out.println(cnt + "�� �Խñ��� �����Ǿ����ϴ�");*/

	
	

