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
		System.out.println("삭제할이름:");
		String irumDelete =Register.input.readLine();
		
	}
	public void setGubum()throws IOException {
		System.out.println("삭제대상:");
		System.out.println("1.학생2.교수3.관리자");
		 gubun = Register.input.readLine();
	}
	public void studentDeleteDisp() {
		System.out.println(cnt+"건 학생이 삭제되었습니다.");		
	}
	public void professorDeleteDisp() {
		System.out.println(cnt+"건 교수님이 삭제되었습니다.");
	}
	public void managerDeleteDisp() {
		System.out.println(cnt+"건 관리자님이 삭제되었습니다.");
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


