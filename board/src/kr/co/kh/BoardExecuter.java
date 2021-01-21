package kr.co.kh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardExecuter {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      // 1.�ε�(����=�ڹٿ��� ���� �����ͺ��̽��� ������ ���ڴ�.)
      // ���� �ڹٿ��� �����ͺ��̽� ������ ���ڴ� �˷��ֱ�
      try {
         Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }
      Connection conn=null;
      ResultSet rs = null;
      while (true) {
         // 2.����(connection)�����ϴ�. DriverManager.getConnection
         try {
        	 conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         System.out.println("======�Խ����ۼ�======");
         System.out.println("R:���\tS:�˻�\tD:����\tU:����\tL:���");
         // String protocol = input.next();
         char protocol = input.next().charAt(0);
         // if(protocol.equals("R"))

         if (protocol == 'R' || protocol == 'r') {
            System.out.println("����|����: ");
            String titleContent = input.next();
            int indexI = titleContent.indexOf("|");// indexI�� |�̰� 2�� ��.'
            String title = titleContent.substring(0, indexI);// �ڸ��� �޼ҵ�
            String content = titleContent.substring(indexI + 1);
            // ������� �������
            System.out.println("�ۼ����Է�: ");
            String author = input.next();
            System.out.println("��¥: ");
            String nal = input.next();// data�� ������ DB����
            System.out.println("��ȸ��: ");
            int readcount = input.nextInt();
            // 3.�غ�(Statement����) �����غ�. 3-1 ������ �غ�
            // 3.�غ�(Statement����) �����غ�. 3-2 �����غ�
                                                                         
               try {
				Statement stmt = conn.createStatement();// �� conn�� �־��� ������ ������ش�.
				   String sql = "INSERT INTO board(title,content,author,nal,readcount) values('"
				         + title + "','" + content + "','" + author + "','" + nal + "'," + readcount + ")";
				   // �� �κ� ������ �ٲ���� values(board_no.nextval,'����1','����1','kh','2020.11.12',0) ��ó��
				   // ����� �Ѵ�.
				   // '""'<<���ڿ� ""<<����
				   // 4.���� execute
				   int cnt = stmt.executeUpdate(sql);// ���������� ����
				   System.out.println(cnt + "�� �Խñ��� ��ϵǾ����ϴ�.");
				   System.out.println();
				   // ���� ���� ��Ʈ��
				   // stmt.close();
				   // connection �� ����
				   // conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          

         } else if (protocol == 'S' || protocol == 's') {
            System.out.print("ã�� �Խñ� ���� �Է�:");
            String searchTitle = input.next();
            System.out.print("��ȣ\t����\t����\t�۰�\t��¥\t\t��ȸ��\n");
            // �����ͺ��̽��� ��Ʈ�� �ε�=���� ���� �� �ʿ�� ���� . �غ����ֱ�
            try {
               Statement stmt = conn.createStatement();
               String sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM board WHERE TITLE = '" + searchTitle+ "'";
               // String sql = "select * from board where title = '"+searchTitle+"'"; //3.�غ�
               // 3-2 ������ �غ�
               rs = stmt.executeQuery(sql);// ���̺�(ǥ) �ȿ� �ִ� ù ��°, �� ��° �� ��° ... ���� ����Ų��.
               int readcount = 0;
               while (rs.next()) {// �����ͺ��̽����� ������ ������ ����ִ´�. �׷��� DB���� ���ϴ� �����͸� ����;ߵ�. �׷��� rs�� �����Ѿ� �Ѵ�.
                  int no = rs.getInt("no");
                  String title = rs.getString("title");
                  String content = rs.getString("content");
                  String author = rs.getString("author");
                  String nal = rs.getString("nal");
                  readcount = rs.getInt("readcount");
                  System.out.println(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount);
                  readcount++;
                  System.out.println();
                  // int newReadcount
//                System.out.println("No = " + rs.getInt(1) + "Title = " + rs.getString(2) + " Content = " + rs.getString(3) + " Author = " + rs.getString(4) + " NAL = " + rs.getString(5) + " ��ȸ�� = " + newReadCount);
               }
               stmt = conn.createStatement();
               sql = "UPDATE board SET readcount = "+readcount+" WHERE TITLE = '"+searchTitle+"'";
               int cnt = stmt.executeUpdate(sql);
               stmt.close();
               conn.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }

         } else if (protocol == 'D' || protocol == 'd') {
            System.out.println("������ ������ �Է��ϼ��� : ");
            String deleteTitle = input.next();
            // 3.�غ�
            // 3-1 ������ �غ��Ѵ�.
            // 3-2 ������ �غ��Ѵ�.
            try {
               Statement stmt = conn.createStatement();
               String sql = "DELETE FROM board WHERE TITLE = '" + deleteTitle + "'";// ������ ������ ������ ��� ���� �־��ִ°���.
               int cnt = stmt.executeUpdate(sql);
               System.out.println(cnt + "�� �Խñ��� ���� �Ǿ����ϴ�.");
               System.out.println();
               conn.close();
               stmt.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }

         } else if (protocol == 'U' || protocol == 'u') {
            System.out.println("������ �Խñ� ������ �Է��ϼ��� : ");
            String searchTitle = input.next();
            //3. ���� �����غ�
            Statement stmt = null;
            String sql = null;
            try {
               stmt = conn.createStatement();
               sql = "SELECT TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM board WHERE TITLE = '"+searchTitle+"'";
               rs = stmt.executeQuery(sql);
               System.out.println("======�����ϱ� �� �Խñ��Դϴ�.======");
               while(rs.next()) {
                  String title = rs.getString("title");
                  String content = rs.getString("content");
                  String author = rs.getString("author");
                  String nal = rs.getString("nal");
                  int readcount = rs.getInt("readcount");
                  System.out.print( title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount + "\n");
               }
               System.out.println("������ ���� �Ͻðڽ��ϱ�y/n");//y�� ������ �����ϰ� n�� ������ ��������
               char option = input.next().charAt(0);
               if(option == 'Y'|| option == 'y') {
                  System.out.println("����|����: ");
                  String titleContent = input.next();
                  int indexI = titleContent.indexOf("|");// indexI�� |�̰� 2�� ��.'
                  String updateTitle = titleContent.substring(0, indexI);// �ڸ��� �޼ҵ�
                  String contentUpdate = titleContent.substring(indexI + 1);
                  // ������� �������
                  System.out.println("�ۼ����Է�: ");
                  String authorUpdate = input.next();
                  System.out.println("��¥: ");
                  String nalUpdate = input.next();// data�� ������ DB����
                  System.out.println("��ȸ��: ");
                  int readcountUpdate = input.nextInt();
                  stmt = conn.createStatement();
                  sql = "UPDATE board SET title ='"+updateTitle+"', content = '"+contentUpdate+"', author = '"+authorUpdate+"', nal = '"+nalUpdate+"', readcount = '"+readcountUpdate+"' WHERE title = '"+searchTitle+"'";
                  int cnt = stmt.executeUpdate(sql);
                  System.out.print("��ȣ\t����\t����\t�۰�\t��¥\t\t��ȸ��\n");
                  System.out.println(updateTitle + "\t" + updateTitle + "\t" + contentUpdate + "\t" + authorUpdate + "\t" + nalUpdate + "\t" + readcountUpdate);
                  System.out.println();
                  stmt.close();
                  conn.close();
               }else {
                  stmt.close();
                  conn.close();
                  continue;//�ݺ������� �ö󰡶�. �׷� ��� �˻� �޴��� ���´�.
               }
               
            } catch (SQLException e) {
               e.printStackTrace();
            }
         } else if (protocol == 'L' || protocol == 'l') {
            System.out.println("=======�Խ��� ��ü���=========");
            System.out.print("��ȣ\t����\t����\t�۰�\t��¥\t\t��ȸ��\n");
            // 3.����,�����غ�
            try {
               Statement stmt = conn.createStatement();
               String sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM board order by title asc";// ���� �ʿ��� WHERE �� �־���.
               rs = stmt.executeQuery(sql);
               while (rs.next()) {
                  int no = rs.getInt("no");
                  String title = rs.getString("title");
                  String content = rs.getString("content");
                  String author = rs.getString("author");
                  String nal = rs.getString("nal");
                  int readcount = rs.getInt("readcount");
                  System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount + "\n");
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
//            stmt.close();
//            conn.close();
         }

      } // �ݺ���

   }

}