package kr.co.kh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberExecuter {
	public static String session;
	static { 
		session = null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
	      
		  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));	
		  Connection conn = null;
		  Statement stmt = null;
		  String sql = null;
		  int cnt = 0;
		  
		  try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		while(true) {  //반복문
			
			System.out.println("R:회원가입 S:ID찾기 D:회원탈퇴 E:회원수정 I:로그인 O:로그아웃 L:회원목록");
			String idlogin = null;
			try {
				String protocol = input.readLine();
				if(protocol.equals("R")||protocol.equals("r")) {//회원가입
				    try {
						stmt = conn.createStatement();
						sql = "select id from member";
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							idlogin = rs.getString("id");
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    if(session != null) {
				    	System.out.println("로그인중입니다");
				    	continue;
				    }
				    System.out.println("아이디 입력 : ");
				    String id = input.readLine();
				    System.out.println("패스워드 입력 : ");
				    String pw = input.readLine();
				    System.out.println("주소 입력: ");
				    String addr =input.readLine();
				    System.out.println("전화번호 입력 : ");
				    String tel = input.readLine();
				    try {
						stmt = conn.createStatement();
						sql = "insert into member(id,pw,addr,tel) values('"+id+"','"+pw+"','"+addr+"','"+tel+"')";
						cnt = stmt.executeUpdate(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    System.out.println(cnt+" 건 회원이 등록되었습니다");
					
				}//회원가입
				else if (protocol.equals("S") || protocol.equals("s")) {//id찾기
					
					System.out.println("찾는 ID를 입력해주세요 : ");
					String idSearch = input.readLine();
					System.out.println("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");
					String id = null;
					String pw = null;
					String addr = null;
					String tel = null;
					
					
					try {
						stmt = conn.createStatement();
						sql = "select id,pw,addr,tel from member where id = '"+idSearch+"'";
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							id= rs.getString("id");
							pw = rs.getString("pw");
							addr = rs.getString("addr");
							tel = rs.getString("tel");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
					if (id==null) { 
						System.out.println("찾는 아이디가 없습니다");
						continue;
					}
						
			System.out.println(id+"\t"+pw+"\t"+addr+"\t"+tel+"\n");
						
				
					
				} //id찾기
				else if (protocol.equals("D") || protocol.equals("d")) {//회원탈퇴
					String id =null;
					if(session ==null) {
						System.out.println("로그인하세요");
						continue;
					}
					 /*try {
						stmt = conn.createStatement();
						sql = "select id from member";
						ResultSet rs = stmt.executeQuery(sql);
						
						while(rs.next()) {
							id= rs.getString("id");
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
							if(id.equals(session))	 {
								stmt = conn.createStatement();
								sql ="delete from member where id = '"+session+"'";
								cnt = stmt.executeUpdate(sql);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} */
					
					System.out.println("정말 탈퇴하시겠습니까? y/n");
					String result = input.readLine();
					if(result.equals("y")||result.equals("Y")) {
						try {
							stmt = conn.createStatement();
							sql ="delete from member where id = '"+session+"'";
							cnt = stmt.executeUpdate(sql);
							session = null;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					}else if(result.equals("n")||result.equals("N")) {
						continue;
					}
					
						
						System.out.println("회원탈퇴 되었습니다");
						
					
				}//회원탈퇴
				else if (protocol.equals("E") || protocol.equals("e")) { //회원수정
					
					System.out.print("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");
					String id = null;
					String pw = null;
					String addr = null;
					String tel = null;
					try {
						stmt = conn.createStatement();
						sql = "select * from member where id='"+session+"'";
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							 id = rs.getString("id");
							 pw = rs.getString("pw");
							 addr =rs.getString("addr");
							 tel = rs.getString("tel");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(id.equals(session)) {
						System.out.print(id+"\t"+pw+"\t"+addr+"\t"+tel+"\n");
						System.out.println("회원아이디 입력 : ");
						String idupdate = input.readLine();
						System.out.println("회원 패스워드 입력 : ");
						String pwupdate = input.readLine();
						System.out.println("회원 주소 입력 : ");
						String addrupdate = input.readLine();
						System.out.println("회원 전화번호 입력 : "); 
						String telupdate = input.readLine();
						
						try {
							stmt = conn.createStatement();
							sql = "update member set id = '"+idupdate+"',pw='"+pwupdate+"',addr='"+addrupdate+"',tel='"+telupdate+"' where id ='"+session+"'";
							cnt = stmt.executeUpdate(sql);
							session = idupdate; // 세션에는 전의 아이디가 누적되어있기때문에
							System.out.println(cnt+"명 회원이 수정되었습니다");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
					
					
					
				}//회원수정
				else if(protocol.equals("I") || protocol.equals("i")) {
					if(session!=null) {
						System.out.println("로그인중입니다");
						continue;
					}
					System.out.println("아이디 입력 : ");
					String loginid = input.readLine();
					System.out.println("패스워드 입력 : ");
					String loginpw = input.readLine();
					String id = null;
					String pw = null;
					try {
						stmt = conn.createStatement();
						sql = "select id,pw from member where id = '"+loginid+"'";
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							id = rs.getString("id");
							pw = rs.getString("pw");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(!(loginid.equals(id))) {
						System.out.println("아이디가 틀렸습니다");
						continue;
					}
					if(!(loginpw.equals(pw))) {
						System.out.println("비밀번호가 틀렸습니다");
						continue;
					}
					System.out.println("환영합니다. 로그인되었습니다");
					session = loginid;
					
				}//로그인
				else if (protocol.equals("O") || protocol.equals("o")) {
					
					session = null;   
					//static 전역변수 프로토콜에 영향을 받지 않고 로그인과 로그아웃을 설정할 수 있음
					System.out.println("로그아웃 되었습니다");
					
				}//로그아웃
				else if(protocol.equals("L") || protocol.equals("l")) { //회원목록
					
					System.out.print("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");
					
					try {
						stmt = conn.createStatement();
						sql = "select * from member";
						ResultSet rs = stmt.executeQuery(sql);
						
						while(rs.next()) {
							String id = rs.getString("id");
							String pw = rs.getString("pw");
							String addr = rs.getString("addr");
							String tel = rs.getString("tel");
							System.out.println(id+"\t"+pw+"\t"+addr+"\t"+tel+"\n");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}//회원목록
				
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} // 반복문
		  
		  
		
	}
}
