package kr.co.kh.obj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	private Statement stmt;
	private Connection conn;
	private String gubun;
	private String irumDelete;
	private  int cnt;
	
	
	public Delete() {
		
	}
	public void setDelete()throws IOException {
		System.out.println("�������̸�:");
		String irumDelete =Register.input.readLine();
		
	}
	public void setGubum()throws IOException {
		System.out.println("�������:");
		System.out.println("1.�л�2.����3.������");
		 gubun = Register.input.readLine();
	}
	public void studentDeleteDisp() {
		System.out.println(cnt+"�� �л��� �����Ǿ����ϴ�.");		
	}
	public void professorDeleteDisp() {
		System.out.println(cnt+"�� �������� �����Ǿ����ϴ�.");
	}
	public void managerDeleteDisp() {
		System.out.println(cnt+"�� �����ڴ��� �����Ǿ����ϴ�.");
	}
	public void deleteProcess()throws IOException,SQLException {
		conn = Register.getConnection();
		if(gubun.equals("1")) {
			 setDelete();
			stmt = conn.createStatement();
			String sql = "delete from student where irum='"+irumDelete+"'";
			cnt=stmt.executeUpdate(sql);
			studentDeleteDisp();
				
		}
		else if(gubun.equals("2")) {
			 setDelete();
			stmt = conn.createStatement();
			String sql = "delete from professor where irum='"+irumDelete+"'";
			cnt = stmt.executeUpdate(sql);
			professorDeleteDisp();
		
		}
		else if(gubun.equals("3")) {
			 setDelete();
			stmt = conn.createStatement();
			String sql = "delete from manager where irum='"+irumDelete+"'";
			cnt = stmt.executeUpdate(sql);
			managerDeleteDisp();
			
		}

		
		
	}
	
}


