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

      // ����Ŭ���� ������ �Ϸ�Ǿ���

      System.out.println("***KH BŬ���� �⼮��***");

      while (true) {

         try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "khbclass", "dkdlxl");
         } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
         }

         System.out.println(" �л���� / �⼮�θ���  / �л��˻�  / ���� �� ����   / �⼮�� ���� /  ");
         String member = sc.next();

         switch (member) {
                
         case "���":
         case "�л����":
        	 
            // �л� ��� (�̸�/����/�������/�ּ�/�ν�Ÿ/)
            System.out.println("����� �л��� �̸��� �����ּ� => ");
            String name = sc.next();
            System.out.println(name + "�л��� ������ �����ּ� => ");
            String gender = sc.next();
            System.out.println(name + "�л��� ��������� �����ּ�  => ");
            int birth = sc.nextInt();
            System.out.println(name + "�л��� �ּҸ� �����ּ�  => ");
            String address = sc.next();
            System.out.println(name + "�л��� �ν�Ÿ ID�� �����ּ� ����  => ");
            String insta = sc.next();
          
  
            
            
            try {
               Statement stmt = con.createStatement();
               String sql = "insert into book(no,name,gender,birth,address,insta) values(book_no.nextval,'" + name
                     + "','" + gender + "','" + birth + "','" + address + "','" + insta + "')";
               int cnt = stmt.executeUpdate(sql);
               System.out.println(name + "�л��� ������" + cnt + "�� ����Ǿ��� ");
               stmt.close();
               con.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }

            break;

         case "�⼮":
         case "�⼮�θ���": // �⼮�θ���

            // System.out.println("�л��� �̸��� �ҷ��ּ� => ");
            // String culname = sc.next();
            // System.out.println("�̸�\t����\t�������\t�ּ�\t�ν�Ÿ\t");
            // System.out.println(culname + "�л��� �⼮�Ǿ���.");

            System.out.println("�������̿���");

            break;

         case "�˻�":
         case "�л��˻�": // �˻����

            System.out.println("ã�ƺ��� �л��� �̸��� �Է����ּ� => ");
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
                  System.out.println("��ȣ\t�̸�\t����\t�������\t�ּ�\t�ν�Ÿ\t�� �⼮�ϼ�");
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

         case "����":
         case "����":

            System.out.println("�����ҰŸ� 1�� �Է�  / ������ �ҰŸ� 2�� �Է�");
            int choice = sc.nextInt();

            if (choice == 1) {

            	
               System.out.println("������ �����Ͻðڽ��ϱ�?");
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
                      System.out.println("��ȣ\t�̸�\t����\t�������\t�ּ�\t�ν�Ÿ\t�� �⼮�ϼ�");
                      System.out.println(no + "\t" + name + "\t" + gender+ "\t" + birth + "\t" + address + "\t" + insta);
                   
                   }
                        
                } catch (SQLException e1) {
                   // TODO Auto-generated catch block
                   e1.printStackTrace();
                }
             
               
          
               System.out.println(rename+"�� ������ �����մϴ�");
               
               System.out.println("1.��ü���� 2.�̸�����  3.�������� 4.������ϼ��� 5.�ּҼ��� 6.�ν�ŸID����");
               int nameup = sc.nextInt();

                
        switch (nameup) { 
                 
               
           
               case 1 :   //��ü����
            	    
                   System.out.print("������ �����  �л��� �̸��� �����ּ��� =>");
                   String nameupdate = sc.next();
                   System.out.print(nameupdate + "�л��� ������ �����ּ� =>");
                   String genderupdate = sc.next();
                   System.out.print(nameupdate + "�л��� ��������� �����ּ� \nex)920727 => ");
                   int birthupdate = sc.nextInt();
                   System.out.print(nameupdate + "�л��� �ּҸ� �����ּ�  \nex)��⵵ ����� => ");
                   String addressupdate = sc.next();
                   System.out.print(nameupdate + "�л��� �ν�Ÿ ID�� �����ּ� ���� \n => ");
                   String instaupdate = sc.next();

                   try {
                	   Statement stmt = con.createStatement();                      
                      String sql = "update book set  name = '" + nameupdate + "', gender ='" + genderupdate
                            + "', birth = '" + birthupdate + "', address = '" + addressupdate + "',  insta = '"
                            + instaupdate + "'";
                      int cnt = stmt.executeUpdate(sql);
                      System.out.println(nameupdate + "�л��� ������ �����Ǿ���");
                      stmt.close();
                      con.close();
                   } catch (SQLException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
                   }
                   
                   break;
                   
              case 2 :  // �̸�����
            	   
            	   try {
					System.out.println("*******�̸� ���� �������Դϴ�*******");
					   System.out.println("������ ����� �̸��� �Է����ּ��� : ");
					   String onlyname = sc.next();
					   
					   Statement stmt = con.createStatement();
					   String sql ="update book set name = '"+onlyname+"' where name = '"+rename+"'";
					   int cnt = stmt.executeUpdate(sql);
					   System.out.println(onlyname+"(��)�� �����Ǿ����ϴ�");
					   stmt.close();
					   con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
           
            	   
                    break;
                   
               case 3 :       //�������� 
            	   
            	   System.out.println("*******���� ���� �������Դϴ�*******");
            	   System.out.println("������ ����� ������ �Է����ּ���  : ");
            	   String onlygender = sc.next();
            	   
            	   try {
            		   Statement stmt = con.createStatement();
					   String sql = "update book set gender = '"+onlygender+"'";
					   int cnt = stmt.executeUpdate(sql);
					   System.out.println(onlygender+"�� �����Ǿ����ϴ�");
					   stmt.close();
					   con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	   
            	   break;
            	   
               case 4 :  //������� ����
            	   
            	   System.out.println("*******������� ���� �������Դϴ�*******");
            	   System.out.println("������ ����� ��������� �����ּ��� : ");
            	   String onlybirth = sc.next();
            	   
            	   try {
            		   Statement stmt = con.createStatement();
					   String sql = "update book set birth = '"+onlybirth+"'";
					   int cnt = stmt.executeUpdate(sql);
					   System.out.println(onlybirth+"�� �����Ǿ����ϴ�");
					   stmt.close();
					   con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	 break;
            	 
               case 5 :   //�ּҼ���
            	   
            	   System.out.println("*******�ּ� ���� �������Դϴ�*******");
            	   System.out.println("������ ����Ͻ� �ּҸ� �����ּ��� : ");
            	   String onlyaddress = sc.next();
            	   
            	   try {
            		   Statement stmt = con.createStatement();
					   String sql = "update book set address = '"+onlyaddress+"'";
					   int cnt = stmt.executeUpdate(sql);
					   System.out.println(onlyaddress+"�� �����Ǿ����ϴ�");
					   stmt.close();
					   con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	   break;
            	   
               case 6 :  //�ν�ŸID����
            	   
            	   try {
					System.out.println("*******�ν�ŸID ���� �������Դϴ�*******");
					   System.out.println("������ ����Ͻ� �ν�ŸID�� �����ּ��� : ");
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
            
            } else if (choice == 2) {  //��������

               System.out.println("������ �л��� �����ּ� => ");
               String namedelete = sc.next();

               try {
            	   Statement stmt = con.createStatement();
                  String sql = "delete from book where name = '" + namedelete + "'";
                  int cnt = stmt.executeUpdate(sql);
                  System.out.println(namedelete + "�л���" + cnt + "�� �����Ǿ���");
                
               } catch (Exception e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
              
            }

            break;
            
         case "�⼮��":
         case "����":
         case "�⼮�κ���":
         case "�⼮�� ����":

            System.out.println("***KH BŬ���� �⼮�� ���***");
            System.out.println("��ȣ\t�̸�\t����\t�������\t�ּ�\t�ν�Ÿ\t�� �⼮�ϼ�");

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
            System.out.println("����");
         }
      }
   }
}