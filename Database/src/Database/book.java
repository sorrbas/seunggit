package Database;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class book {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      Connection con = null;
      ResultSet rs2 = null;

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch (ClassNotFoundException e3) {
         // TODO Auto-generated catch block
         e3.printStackTrace();
      }

      // 오라클과의 연결이 완료되었음

      System.out.println("***KH B클래스 출석부***");

      while (true) {

         try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "khbclass", "dkdlxl");
         } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
         }

         System.out.println(" 학생등록 / 출석부르기  / 학생검색  / 수정 및 삭제   / 출석부 보기 /  ");
         String member = sc.next();

         switch (member) {
                
         case "등록":
         case "학생등록":
        	 
            // 학생 등록 (이름/성별/생년월일/주소/인스타/)
            System.out.println("등록할 학생의 이름을 적어주쇼 => ");
            String name = sc.next();
            System.out.println(name + "학생의 성별을 적어주쇼 => ");
            String gender = sc.next();
            System.out.println(name + "학생의 생년월일을 적어주쇼  => ");
            int birth = sc.nextInt();
            System.out.println(name + "학생의 주소를 적어주쇼  => ");
            String address = sc.next();
            System.out.println(name + "학생의 인스타 ID를 적어주쇼 ㅎㅎ  => ");
            String insta = sc.next();
          
  
            
            
            try {
               Statement stmt = con.createStatement();
               String sql = "insert into book(no,name,gender,birth,address,insta) values(book_no.nextval,'" + name
                     + "','" + gender + "','" + birth + "','" + address + "','" + insta + "')";
               int cnt = stmt.executeUpdate(sql);
               System.out.println(name + "학생의 정보가" + cnt + "건 저장되었슈 ");
               stmt.close();
               con.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }

            break;

         case "출석":
         case "출석부르기": // 출석부르기

            // System.out.println("학생의 이름을 불러주쇼 => ");
            // String culname = sc.next();
            // System.out.println("이름\t성별\t생년월일\t주소\t인스타\t");
            // System.out.println(culname + "학생이 출석되었슈.");

            System.out.println("개발중이에유");

            break;

         case "검색":
         case "학생검색": // 검색기능

            System.out.println("찾아보실 학생의 이름을 입력해주쇼 => ");
            String searchname = sc.next();

            try {
            	Statement stmt = con.createStatement();
               String sql = "select * from book where name ='" + searchname + "'";
               ResultSet rs = stmt.executeQuery(sql);

               while (rs.next()) {
                  int no = rs.getInt("no");
                  name = rs.getString("name");
                  gender = rs.getString("gender");
                  birth = rs.getInt("birth");
                  address = rs.getString("address");
                  insta = rs.getString("insta");
                  int culsuk = rs.getInt("culsuk");
                  System.out.println("번호\t이름\t성별\t생년월일\t주소\t인스타\t총 출석일수");
                  System.out.println(no + "\t" + name + "\t" + birth + "\t" + address + "\t" + insta + "\t" + culsuk);
                  // ++;
               }
                    stmt.close();
                    con.close();
            } catch (SQLException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }

            break;

         case "수정":
         case "삭제":

            System.out.println("수정할거면 1을 입력  / 삭제를 할거면 2를 입력");
            int choice = sc.nextInt();

            if (choice == 1) {

            	
               System.out.println("누구를 수정하시겠습니까?");
               String rename = sc.next();
                
               try {
            	   Statement stmt = con.createStatement();
                   String sql = "select * from book where name ='" + rename + "'";
                   ResultSet rs = stmt.executeQuery(sql);

                   while (rs.next()) {
                      int no = rs.getInt("no");
                      name = rs.getString("name");
                      gender = rs.getString("gender");
                      birth = rs.getInt("birth");
                      address = rs.getString("address");
                      insta = rs.getString("insta");
                      System.out.println("번호\t이름\t성별\t생년월일\t주소\t인스타\t총 출석일수");
                      System.out.println(no + "\t" + name + "\t" + gender+ "\t" + birth + "\t" + address + "\t" + insta);
                   
                   }
                        
                } catch (SQLException e1) {
                   // TODO Auto-generated catch block
                   e1.printStackTrace();
                }
             
               
          
               System.out.println(rename+"의 정보를 수정합니다");
               
               System.out.println("1.전체수정 2.이름수정  3.성별수정 4.생년월일수정 5.주소수정 6.인스타ID수정");
               int nameup = sc.nextInt();

                
        switch (nameup) { 
                 
               
           
               case 1 :   //전체수정
            	    
                   System.out.print("앞으로 사용할  학생의 이름을 적어주세요 =>");
                   String nameupdate = sc.next();
                   System.out.print(nameupdate + "학생의 성별을 적어주쇼 =>");
                   String genderupdate = sc.next();
                   System.out.print(nameupdate + "학생의 생년월일을 적어주쇼 \nex)920727 => ");
                   int birthupdate = sc.nextInt();
                   System.out.print(nameupdate + "학생의 주소를 적어주쇼  \nex)경기도 광명시 => ");
                   String addressupdate = sc.next();
                   System.out.print(nameupdate + "학생의 인스타 ID를 적어주쇼 ㅎㅎ \n => ");
                   String instaupdate = sc.next();

                   try {
                	   Statement stmt = con.createStatement();                      
                      String sql = "update book set  name = '" + nameupdate + "', gender ='" + genderupdate
                            + "', birth = '" + birthupdate + "', address = '" + addressupdate + "',  insta = '"
                            + instaupdate + "'";
                      int cnt = stmt.executeUpdate(sql);
                      System.out.println(nameupdate + "학생의 정보가 수정되었슈");
                      stmt.close();
                      con.close();
                   } catch (SQLException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
                   }
                   
                   break;
                   
              case 2 :  // 이름수정
            	   
            	   try {
					System.out.println("*******이름 수정 페이지입니다*******");
					   System.out.println("앞으로 사용할 이름을 입력해주세요 : ");
					   String onlyname = sc.next();
					   
					   Statement stmt = con.createStatement();
					   String sql ="update book set name = '"+onlyname+"' where name = '"+rename+"'";
					   int cnt = stmt.executeUpdate(sql);
					   System.out.println(onlyname+"(이)로 수정되었습니다");
					   stmt.close();
					   con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
           
            	   
                    break;
                   
               case 3 :       //성별수정 
            	   
            	   System.out.println("*******성별 수정 페이지입니다*******");
            	   System.out.println("앞으로 사용할 성별을 입력해주세요  : ");
            	   String onlygender = sc.next();
            	   
            	   try {
            		   Statement stmt = con.createStatement();
					   String sql = "update book set gender = '"+onlygender+"'";
					   int cnt = stmt.executeUpdate(sql);
					   System.out.println(onlygender+"로 수정되었습니다");
					   stmt.close();
					   con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	   
            	   break;
            	   
               case 4 :  //생년월일 수정
            	   
            	   System.out.println("*******생년월일 수정 페이지입니다*******");
            	   System.out.println("앞으로 사용할 생년월일을 적어주세요 : ");
            	   String onlybirth = sc.next();
            	   
            	   try {
            		   Statement stmt = con.createStatement();
					   String sql = "update book set birth = '"+onlybirth+"'";
					   int cnt = stmt.executeUpdate(sql);
					   System.out.println(onlybirth+"로 수정되었습니다");
					   stmt.close();
					   con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	 break;
            	 
               case 5 :   //주소수정
            	   
            	   System.out.println("*******주소 수정 페이지입니다*******");
            	   System.out.println("앞으로 사용하실 주소를 적어주세요 : ");
            	   String onlyaddress = sc.next();
            	   
            	   try {
            		   Statement stmt = con.createStatement();
					   String sql = "update book set address = '"+onlyaddress+"'";
					   int cnt = stmt.executeUpdate(sql);
					   System.out.println(onlyaddress+"로 수정되었습니다");
					   stmt.close();
					   con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	   break;
            	   
               case 6 :  //인스타ID수정
            	   
            	   try {
					System.out.println("*******인스타ID 수정 페이지입니다*******");
					   System.out.println("앞으로 사용하실 인스타ID를 적어주세요 : ");
					   String onlyinsta = sc.next();
					   
					   Statement stmt = con.createStatement();
					   String sql = "update book set insta = '"+onlyinsta+"'";
					   int cnt  = stmt.executeUpdate(sql);
					   stmt.close();
					   con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	   break;
            	   
            	   default : 
            		   break;
               }
            
            } else if (choice == 2) {  //삭제구문

               System.out.println("삭제할 학생을 적어주쇼 => ");
               String namedelete = sc.next();

               try {
            	   Statement stmt = con.createStatement();
                  String sql = "delete from book where name = '" + namedelete + "'";
                  int cnt = stmt.executeUpdate(sql);
                  System.out.println(namedelete + "학생이" + cnt + "건 삭제되었슈");
                
               } catch (Exception e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
              
            }

            break;
            
         case "출석부":
         case "보기":
         case "출석부보기":
         case "출석부 보기":

            System.out.println("***KH B클래스 출석부 명단***");
            System.out.println("번호\t이름\t성별\t생년월일\t주소\t인스타\t총 출석일수");

            try {
               Statement stmt2 = con.createStatement();
               String sql = "select * from book order by no asc ";
               rs2 = stmt2.executeQuery(sql);
               while (rs2.next()) {
                  int no = rs2.getInt("no");
                  String rs2name = rs2.getString("name");
                  String rs2gender = rs2.getString("gender");
                  int rs2birth = rs2.getInt("birth");
                  String rs2address = rs2.getString("address");
                  String rs2insta = rs2.getString("insta");
                  System.out.println(no + "\t" + rs2name + "\t" + rs2gender + "\t" + rs2birth + "\t" + rs2address
                        + "\t" + rs2insta + "\t");

               }
               stmt2.close();
               con.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
           
            
            break;
         default:
            System.out.println("꺼져");
         }
      }
   }
}