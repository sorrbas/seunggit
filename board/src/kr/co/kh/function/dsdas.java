package kr.co.kh.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dsdas {

	public static String Session;
	static {
		Session = null;
	}
	
	public static void main(String[] args) {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));	
		  Connection conn = null;
		  int cnt = 0;
		  Statement stmt = null;
		   String protocol = null;
  	  	
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   System.out.println("회원가입란 입니다 원하시는 것을 선택해주세요");
		   while(true) { 
			  
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "khbclass", "dkdlxl");
				   System.out.println("R:회원가입 L:회원목록 S:ID찾기 D:회원탈퇴 E:회원수정 I:로그인 O:로그아웃");
				   protocol = input.readLine();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   
			   switch(protocol) {
			   
			   case "R" : case "r" :
				   
			
				try {
					System.out.println("아이디입력 :");
						String id = input.readLine();
						System.out.println("패스워드입력:");
						String pw1 = input.readLine();
						System.out.println("주소입력:");
						String addr = input.readLine();
						System.out.println("전화번호입력 : ");
						String tel1 = input.readLine();
						
						int pw = Integer.parseInt(pw1);
						int tel = Integer.parseInt(tel1);
						stmt = conn.createStatement();
						String sql = "insert into member(id,pw,addr,tel) values('"+id+"','"+pw+"','"+addr+"','"+tel+"')";
						cnt = stmt.executeUpdate(sql);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
					System.out.println("회원가입이"+cnt+"건 완료되었습니다");
			
					break;
					
			   case "L" : case "l" :
				   
				   
		    		 System.out.println("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");
		    		
		    		
				try {
					stmt = conn.createStatement();
					 String sql = "select * from member order by id asc";
					 ResultSet rs = stmt.executeQuery(sql);
					 
					 while(rs.next()) {
						 String id = rs.getString("id");
						 String pw  = rs.getString("pw");
						 String addr = rs.getString("addr");
						 String tel = rs.getString("tel");
						 System.out.println(id+"\t"+pw+"\t"+addr+"\t"+tel);
					
   }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						break;
						
			   case "S" : case "s" :
				   
				   try {
					System.out.println("찾는 ID를 입력:");
					   String searchid = input.readLine();
					   
					   stmt = conn.createStatement();
					   String sql = "select * from member where id = '"+searchid+"'";
					   ResultSet rs = stmt.executeQuery(sql);
						 
						 while(rs.next()) {
							 String id = rs.getString("id");
							 String pw  = rs.getString("pw");
							 String addr = rs.getString("addr");
							 String tel = rs.getString("tel");
							 System.out.println("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");
							 System.out.println(id+"\t"+pw+"\t"+addr+"\t"+tel);
							
   
						 }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   break;
	
			   } // switch문
	
	} // while문 
	} // main
}
