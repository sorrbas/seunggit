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
		
		System.out.print("�̸�:");
		System.out.print(irum+"\t");
		System.out.print("����:");
		System.out.print(age+"\t");
		System.out.print("�й�:");
		System.out.print(hakbun+"\n");
		
	}
	
	public void listDispProfessor() {
		
		System.out.print("�̸�:");
		System.out.print(irum+"\t");
		System.out.print("����:");
		System.out.print(age+"\t");
		System.out.print("����:");
		System.out.print(subject+"\n");
	}
	
	public void listDispManager() {
		
		System.out.print("�̸�:");
		System.out.print(irum+"\t");
		System.out.print("����:");
		System.out.print(age+"\t");
		System.out.print("�μ�:");
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
		sql = "select s.no as ��ȣ,s.age as ����,s.irum as �̸�,s.hakbun as �й�,p.age as ��������,p.irum as �����̸�,p.subject as ����,m.age as �����ڳ���,m.irum as �������̸�,m.part as �μ� from (student s full outer join professor p on s.no=p.no) full outer join manager m on s.no=m.no ORDER BY ��ȣ ASC";
		System.out.println("�л���ü���");
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			sage=rs.getInt("����");
			sirum=rs.getString("�̸�");
		    shakbun=rs.getInt("�й�");
			page = rs.getInt("��������");
			pirum=rs.getString("�����̸�");
			psubject=rs.getString("����");
			mage = rs.getInt("�����ڳ���");
			mirum=rs.getString("�������̸�");
			mpart=rs.getString("�μ�");
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