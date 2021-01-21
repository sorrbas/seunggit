package kr.co.kh.obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HaksaFunction {
   public static String register(String protocol,BufferedReader input,Statement stmt,Connection conn,int cnt)throws IOException,SQLException {
	   System.out.println("=====메뉴선택======");
		System.out.println("1.학생");
		System.out.println("2.교수");
		System.out.println("3.관리자");
		System.out.println("4.이전메뉴");
		System.out.println("번호를 선택해 주세요..");
			protocol=input.readLine();
		if(protocol.equals("1")) {
			System.out.println("학생등록");
				System.out.println("나이:");
				String age1 = input.readLine();
				System.out.println("이름:");
				String irum = input.readLine();
				System.out.println("학번:");
				String hakbun1 = input.readLine();			
					stmt=conn.createStatement();
					int age=Integer.parseInt(age1);
					int hakbun = Integer.parseInt(hakbun1);
					String sql = "insert into student(no,age,irum,hakbun) values(student_no.nextval,"+age+",'"+irum+"',"+hakbun+")";
					cnt = stmt.executeUpdate(sql);
			
				System.out.println(cnt+"건 학생이 등록되었습니다.");
		}else if(protocol.equals("2")) {
			System.out.println("교수등록");
			
				System.out.println("나이:");
				String age1 = input.readLine();
				System.out.println("이름:");
				String irum = input.readLine();
				System.out.println("과목:");
				String subject = input.readLine();
				int age=Integer.parseInt(age1);			
					stmt = conn.createStatement();
					String sql = "insert into professor(no,age,irum,subject) values(professor_no.nextval,"+age+",'"+irum+"','"+subject+"')";
					cnt=stmt.executeUpdate(sql);
					System.out.println(cnt+"건 교수님이 등록되었습니다.");			
		}else if(protocol.equals("3")) {
			    System.out.println("관리자등록");		    
				System.out.println("나이:");
				String age1 = input.readLine();
				System.out.println("이름:");
				String irum = input.readLine();
				System.out.println("부서:");
				String part = input.readLine();
				cnt=0;
					stmt = conn.createStatement();
					int age = Integer.parseInt(age1);
					String sql = "insert into manager(no,age,irum,part) values(manager_no.nextval,"+age+",'"+irum+"','"+part+"')";
					cnt = stmt.executeUpdate(sql);
		}
				System.out.println(cnt+"건 관리자님이 등록되었습니다.");
				return protocol;
   }
   public static void search(BufferedReader input,Statement stmt,Connection conn)throws IOException,SQLException {
	   System.out.println("찾을대상:");
		System.out.println("1.학생2.교수3.관리자");		  
			
				String gubun = input.readLine();
				if(gubun.equals("1")) {
					System.out.println("찾을 학생이름입력:");
					String irumSearch = input.readLine();
					stmt = conn.createStatement();
					String sql = "select age,irum,hakbun from student where irum='"+irumSearch+"'";
					ResultSet rs=stmt.executeQuery(sql);
					String irum=null;
					int age=0;
					int hakbun=0;
					if(!rs.isBeforeFirst()) {
						System.out.println("찾는학생이 없습니다.");
					}
					while(rs.next()) {
						irum=rs.getString("irum");
						age=rs.getInt("age");
						hakbun=rs.getInt("hakbun");
						System.out.print("이름:"+irum);
						System.out.print("나이:"+age);
						System.out.print("학번:"+hakbun+"\n");
					}
					
				}else if(gubun.equals("2")) {
					System.out.println("찾을 교수이름입력:");
					String irumSearch = input.readLine();
					stmt = conn.createStatement();
					String sql = "select age,irum,subject from professor where irum='"+irumSearch+"'";
					ResultSet rs=stmt.executeQuery(sql);
					String irum=null;
					int age=0;
					String subject=null;
					if(!rs.isBeforeFirst()) {
						System.out.println("찾는교수님이 없습니다.");
					}
					while(rs.next()) {
						irum=rs.getString("irum");
						age=rs.getInt("age");
						subject=rs.getString("subject");
						System.out.print("이름:"+irum);
						System.out.print("나이:"+age);
						System.out.print("과목:"+subject+"\n");
					}
				}else if(gubun.equals("3")) {
					System.out.println("찾을 관리자이름입력:");
					String irumSearch = input.readLine();
					stmt = conn.createStatement();
					String sql = "select age,irum,part from manager where irum='"+irumSearch+"'";
					ResultSet rs=stmt.executeQuery(sql);
					String irum=null;
					int age=0;
					String part=null;
					if(!rs.isBeforeFirst()) {
						System.out.println("찾는관리자님이 없습니다.");
					}
					while(rs.next()) {
						irum=rs.getString("irum");
						age=rs.getInt("age");
						part=rs.getString("part");
						System.out.print("이름:"+irum);
						System.out.print("나이:"+age);
						System.out.print("부서:"+part+"\n");
					}
				}
			
   }
   public static void delete(BufferedReader input,Statement stmt,Connection conn)throws IOException,SQLException {
	   System.out.println("삭제대상:");
		System.out.println("1.학생2.교수3.관리자");
		
			String gubun = input.readLine();
			if(gubun.equals("1")) {
				System.out.println("삭제할이름:");
				String irumDelete = input.readLine();
				stmt = conn.createStatement();
				String sql = "delete from student where irum='"+irumDelete+"'";
				int cnt=stmt.executeUpdate(sql);
				System.out.println(cnt+"건 학생이 삭제되었습니다.");				
			}
			else if(gubun.equals("2")) {
				System.out.println("삭제할이름:");
				String irumDelete =input.readLine();
				stmt = conn.createStatement();
				String sql = "delete from professor where irum='"+irumDelete+"'";
				int cnt = stmt.executeUpdate(sql);
				System.out.println(cnt+"건 교수님이 삭제되었습니다.");
			}
			else if(gubun.equals("3")) {
				System.out.println("삭제할이름:");
				String irumDelete = input.readLine();
				stmt = conn.createStatement();
				String sql = "delete from manager where irum='"+irumDelete+"'";
				int cnt = stmt.executeUpdate(sql);
				System.out.println(cnt+"건 관리자님이 삭제되었습니다.");
			}
		
   }
   public static void list(Statement stmt,Connection conn)throws IOException,SQLException {
			stmt=conn.createStatement();
			String sql = "select no,age,irum,hakbun from student";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int no=rs.getInt("no");
				int age=rs.getInt("age");
				String irum=rs.getString("irum");
				int hakbun=rs.getInt("hakbun");
				System.out.print("이름:");
				System.out.print(irum+"\t");
				System.out.print("나이:");
				System.out.print(age+"\t");
				System.out.print("학번:");
				System.out.print(hakbun+"\n");
			}
			stmt = conn.createStatement();
			sql = "select no,age,irum,subject from professor";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int no = rs.getInt("no");
				int age = rs.getInt("age");
				String irum = rs.getString("irum");
				String subject = rs.getString("subject");
				System.out.print("이름:");
				System.out.print(irum+"\t");
				System.out.print("나이:");
				System.out.print(age+"\t");
				System.out.print("과목:");
				System.out.print(subject+"\n");
			}
			stmt = conn.createStatement();
			sql = "select no,age,irum,part from manager";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int no = rs.getInt("no");
				int age = rs.getInt("age");
				String irum = rs.getString("irum");
				String part = rs.getString("part");
				System.out.print("이름:");
				System.out.print(irum+"\t");
				System.out.print("나이:");
				System.out.print(age+"\t");
				System.out.print("부서:");
				System.out.print(part+"\n");
			}
			stmt = conn.createStatement();
			sql = "select s.no as 번호,s.age as 나이,s.irum as 이름,s.hakbun as 학번,p.age as 교수나이,p.irum as 교수이름,p.subject as 과목,m.age as 관리자나이,m.irum as 관리자이름,m.part as 부서 from (student s full outer join professor p on s.no=p.no) full outer join manager m on s.no=m.no ORDER BY 번호 ASC";
			System.out.println("학사전체출력");
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int sage=rs.getInt("나이");
				String sirum=rs.getString("이름");
				int shakbun=rs.getInt("학번");
				int page = rs.getInt("교수나이");
				String pirum=rs.getString("교수이름");
				String psubject=rs.getString("과목");
				int mage = rs.getInt("관리자나이");
				String mirum=rs.getString("관리자이름");
				String mpart=rs.getString("부서");
				System.out.print(sage+"\t"+sirum+"\t"+shakbun+"\t"+page+"\t"+pirum+"\t"+psubject+"\t"+mage+"\t"+mirum+"\t"+mpart+"\n");
			}
   }
}