package kr.co.kh.obj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class List {

	private Statement stmt;
	private Connection conn;
	private int age;
	private String irum;
	private int  hakbun;
	private String subject;
	private String part;
	private int sage;
	private String sirum;
	private int shakbun;
	private int page;
	private String pirum;
	private String psubject;
	private int mage;
	private String mirum;
	private String mpart;
	private int no;
	
	public List() {}
	
	public void listDispStudent() {
		
		System.out.print("이름:");
		System.out.print(irum+"\t");
		System.out.print("나이:");
		System.out.print(age+"\t");
		System.out.print("학번:");
		System.out.print(hakbun+"\n");
		
	}
	
	public void listDispProfessor() {
		
		System.out.print("이름:");
		System.out.print(irum+"\t");
		System.out.print("나이:");
		System.out.print(age+"\t");
		System.out.print("과목:");
		System.out.print(subject+"\n");
	}
	
	public void listDispManager() {
		
		System.out.print("이름:");
		System.out.print(irum+"\t");
		System.out.print("나이:");
		System.out.print(age+"\t");
		System.out.print("부서:");
		System.out.print(part+"\n");
		
	}
	
	public void listDispHaksa() {
		
		System.out.print(sage+"\t"+sirum+"\t"+shakbun+"\t"+page+"\t"+pirum+"\t"+psubject+"\t"+mage+"\t"+mirum+"\t"+mpart+"\n");

	}
	
	public void listProcess()throws IOException,SQLException {
	
		stmt=conn.createStatement();
		String sql = "select no,age,irum,hakbun from student";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			int no=rs.getInt("no");
			int age=rs.getInt("age");
			String irum=rs.getString("irum");
			int hakbun=rs.getInt("hakbun");
		    listDispStudent();
		}
		stmt = conn.createStatement();
		sql = "select no,age,irum,subject from professor";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
		     no = rs.getInt("no");
			 age = rs.getInt("age");
			 irum = rs.getString("irum");
			 subject = rs.getString("subject");
			
		}
		stmt = conn.createStatement();
		sql = "select no,age,irum,part from manager";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			no = rs.getInt("no");
			age = rs.getInt("age");
			irum = rs.getString("irum");
			part = rs.getString("part");
			
		}
		stmt = conn.createStatement();
		sql = "select s.no as 번호,s.age as 나이,s.irum as 이름,s.hakbun as 학번,p.age as 교수나이,p.irum as 교수이름,p.subject as 과목,m.age as 관리자나이,m.irum as 관리자이름,m.part as 부서 from (student s full outer join professor p on s.no=p.no) full outer join manager m on s.no=m.no ORDER BY 번호 ASC";
		System.out.println("학사전체출력");
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			sage=rs.getInt("나이");
			sirum=rs.getString("이름");
		    shakbun=rs.getInt("학번");
			page = rs.getInt("교수나이");
			pirum=rs.getString("교수이름");
			psubject=rs.getString("과목");
			mage = rs.getInt("관리자나이");
			mirum=rs.getString("관리자이름");
			mpart=rs.getString("부서");
}

}
	public static void main(String[] args) {
		List list = new List();
		try {
			list.listProcess();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}