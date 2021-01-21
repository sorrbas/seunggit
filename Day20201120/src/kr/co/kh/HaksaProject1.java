package kr.co.kh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HaksaProject1 {

	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String protocol=null;
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		Statement stmt =null;
		while(true) {//반복문
		try {
			conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		System.out.println("======학사관리=====");
		System.out.println("1.등록");
		System.out.println("2.검색");
		System.out.println("3.삭제");
		System.out.println("4.전체출력");
		System.out.println("=================");
		System.out.println("0.종료");
		System.out.println("번호를 선택해 주세요..");		
		try {
			protocol = input.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(protocol.equals("1")) {
			System.out.println("=====메뉴선택======");
			System.out.println("1.학생");
			System.out.println("2.교수");
			System.out.println("3.관리자");
			System.out.println("4.이전메뉴");
			System.out.println("번호를 선택해 주세요..");
			try {
				protocol=input.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(protocol.equals("1")) {
				System.out.println("학생등록");
				try {
					System.out.println("나이:");
					String age1 = input.readLine();
					System.out.println("이름:");
					String name = input.readLine();
					System.out.println("학번:");
					String hakbun1 = input.readLine();
					int cnt=0;
					try {
						stmt=conn.createStatement();
						int age=Integer.parseInt(age1);
						int hakbun = Integer.parseInt(hakbun1);
						String sql = "insert into student(age,name,hakbun) values("+age+",'"+name+"',"+hakbun+")";
						cnt = stmt.executeUpdate(sql);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					System.out.println(cnt+"건 학생이 등록되었습니다.");
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
		           try {
					conn.close();
					   stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				}
			}else if(protocol.equals("2")) {
				System.out.println("교수등록");
				try {
					System.out.println("나이:");
					String age1 = input.readLine();
					System.out.println("이름:");
					String name = input.readLine();
					System.out.println("과목:");
					String subject = input.readLine();
					int age=Integer.parseInt(age1);
					try {
						stmt = conn.createStatement();
						String sql = "insert into professor(age,name,subject) values("+age+",'"+name+"','"+subject+"')";
						int cnt=stmt.executeUpdate(sql);
						System.out.println(cnt+"건 교수님이 등록되었습니다.");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						conn.close();
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}else if(protocol.equals("3")) {
				System.out.println("관리자등록");
			    try {
					System.out.println("나이:");
					String age1 = input.readLine();
					System.out.println("이름:");
					String name = input.readLine();
					System.out.println("부서:");
					String part = input.readLine();
					int cnt=0;
					try {
						stmt = conn.createStatement();
						int age = Integer.parseInt(age1);
						String sql = "insert into manager(age,name,part) values("+age+",'"+name+"','"+part+"')";
						cnt = stmt.executeUpdate(sql);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						try {
							conn.close();
							stmt.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					System.out.println(cnt+"건 관리자님이 등록되었습니다.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(protocol.equals("4")) {
				continue;
			}
			System.out.println("계속하시려면 1,종료하시려면0을 입력해 주세요..");
			try {
				String cnt = input.readLine();
				if(cnt.equals("1")) {
					continue;
				}else {
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}else if(protocol.equals("2")) {
			System.out.println("찾기");
			System.out.println("찾을대상:");
			System.out.println("1.학생2.교수3.관리자");
		  
				try {
					String gubun = input.readLine();
					if(gubun.equals("1")) {
						System.out.println("찾을 학생이름입력:");
						String nameSearch = input.readLine();
						stmt = conn.createStatement();
						String sql = "select age,name,hakbun from student where name='"+nameSearch+"'";
						ResultSet rs=stmt.executeQuery(sql);
						String name=null;
						int age=0;
						int hakbun=0;
						if(!rs.isBeforeFirst()) {
							System.out.println("찾는학생이 없습니다.");
						}
						while(rs.next()) {
							name=rs.getString("name");
							age=rs.getInt("age");
							hakbun=rs.getInt("hakbun");
							System.out.print("이름:"+name);
							System.out.print("나이:"+age);
							System.out.print("학번:"+hakbun+"\n");
						}
						
					}else if(gubun.equals("2")) {
						System.out.println("찾을 교수이름입력:");
						String nameSearch = input.readLine();
						stmt = conn.createStatement();
						String sql = "select age,name,subject from professor where name='"+nameSearch+"'";
						ResultSet rs=stmt.executeQuery(sql);
						String name=null;
						int age=0;
						String subject=null;
						if(!rs.isBeforeFirst()) {
							System.out.println("찾는교수님이 없습니다.");
						}
						while(rs.next()) {
							name=rs.getString("name");
							age=rs.getInt("age");
							subject=rs.getString("subject");
							System.out.print("이름:"+name);
							System.out.print("나이:"+age);
							System.out.print("과목:"+subject+"\n");
						}
					}else if(gubun.equals("3")) {
						System.out.println("찾을 관리자이름입력:");
						String nameSearch = input.readLine();
						stmt = conn.createStatement();
						String sql = "select age,name,part from manager where name='"+nameSearch+"'";
						ResultSet rs=stmt.executeQuery(sql);
						String name=null;
						int age=0;
						String part=null;
						if(!rs.isBeforeFirst()) {
							System.out.println("찾는관리자님이 없습니다.");
						}
						while(rs.next()) {
							name=rs.getString("name");
							age=rs.getInt("age");
							part=rs.getString("part");
							System.out.print("이름:"+name);
							System.out.print("나이:"+age);
							System.out.print("부서:"+part+"\n");
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			
		}else if(protocol.equals("3")) {
			System.out.println("삭제");
			System.out.println("삭제대상:");
			System.out.println("1.학생2.교수3.관리자");
			try {
				String gubun = input.readLine();
				if(gubun.equals("1")) {
					System.out.println("삭제할이름:");
					String nameDelete = input.readLine();
					stmt = conn.createStatement();
					String sql = "delete from student where name='"+nameDelete+"'";
					int cnt=stmt.executeUpdate(sql);
					System.out.println(cnt+"건 학생이 삭제되었습니다.");				
				}
				else if(gubun.equals("2")) {
					System.out.println("삭제할이름:");
					String nameDelete =input.readLine();
					stmt = conn.createStatement();
					String sql = "delete from professor where name='"+nameDelete+"'";
					int cnt = stmt.executeUpdate(sql);
					System.out.println(cnt+"건 교수님이 삭제되었습니다.");
				}
				else if(gubun.equals("3")) {
					System.out.println("삭제할이름:");
					String nameDelete = input.readLine();
					stmt = conn.createStatement();
					String sql = "delete from manager where name='"+nameDelete+"'";
					int cnt = stmt.executeUpdate(sql);
					System.out.println(cnt+"건 관리자님이 삭제되었습니다.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else if(protocol.equals("4")) {
			System.out.println("전체출력");
			try {
				stmt=conn.createStatement();
				String sql = "select no,age,name,hakbun from student";
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					int no=rs.getInt("no");
					int age=rs.getInt("age");
					String name=rs.getString("name");
					int hakbun=rs.getInt("hakbun");
					System.out.print("이름:");
					System.out.print(name+"\t");
					System.out.print("나이:");
					System.out.print(age+"\t");
					System.out.print("학번:");
					System.out.print(hakbun+"\n");
				}
				stmt = conn.createStatement();
				sql = "select no,age,name,subject from professor";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int no = rs.getInt("no");
					int age = rs.getInt("age");
					String name = rs.getString("name");
					String subject = rs.getString("subject");
					System.out.print("이름:");
					System.out.print(name+"\t");
					System.out.print("나이:");
					System.out.print(age+"\t");
					System.out.print("과목:");
					System.out.print(subject+"\n");
				}
				stmt = conn.createStatement();
				sql = "select no,age,name,part from manager";
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int no = rs.getInt("no");
					int age = rs.getInt("age");
					String name = rs.getString("name");
					String part = rs.getString("part");
					System.out.print("이름:");
					System.out.print(name+"\t");
					System.out.print("나이:");
					System.out.print(age+"\t");
					System.out.print("부서:");
					System.out.print(part+"\n");
				}
				stmt = conn.createStatement();
				sql = "select s.no as 번호,s.age as 나이,s.name as 이름,s.hakbun as 학번,p.age as 교수나이,p.name as 교수이름,p.subject as 과목,m.age as 관리자나이,m.name as 관리자이름,m.part as 부서 from (student s full outer join professor p on s.no=p.no) full outer join manager m on s.no=m.no ORDER BY 번호 ASC";
				System.out.println("학사전체출력");
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int sage=rs.getInt("나이");
					String sname=rs.getString("이름");
					int shakbun=rs.getInt("학번");
					int page = rs.getInt("교수나이");
					String pname=rs.getString("교수이름");
					String psubject=rs.getString("과목");
					int mage = rs.getInt("관리자나이");
					String mname=rs.getString("관리자이름");
					String mpart=rs.getString("부서");
					System.out.print(sage+"\t"+sname+"\t"+shakbun+"\t"+page+"\t"+pname+"\t"+psubject+"\t"+mage+"\t"+mname+"\t"+mpart+"\n");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
		}else if(protocol.equals("0")) {			
			System.out.println("학사프로그램을 종료합니다.");
			System.exit(0);
		}
	 }//반복문
	}
}
