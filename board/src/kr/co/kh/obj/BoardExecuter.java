package kr.co.kh.obj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardExecuter {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Register register = new Register();
      Search search = new Search();
      Delete delete = new Delete();
      Update update = new Update();
      List list = new List();
      Connection conn = null;
      
      
      while (true) {
         // 2.����(connection)�����ϴ�. DriverManager.getConnection
         try {
         conn = register.getConnection();
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         System.out.println("======�Խ����ۼ�======");
         System.out.println("R:���\tS:�˻�\tD:����\tU:����\tL:���");
         // String protocol = input.next();
         char protocol = input.next().charAt(0);
         // if(protocol.equals("R"))

         if (protocol == 'R' || protocol == 'r') { // ���
            try {
               register.setTitleContent();
               register.titleContentProcess();
               register.setAuthor();
               register.setNal();
               register.setReadCount();
               register.boardQuery();
               register.boardExcuter();
            } catch (Exception e) {
               e.printStackTrace();
            } finally { //������ �����ϴ°�
               try {
                  conn.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
         } // ���
         else if (protocol == 'S' || protocol == 's') { // �˻�
            try {
               search.setTitlesearch();
               search.boardsearchTitle();
               search.boardstmtsql();
               search.boardsearchExecuter();
               search.boardsearchProcess();
               search.boardsearchReadcount();
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
               try {
                  conn.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }

         } // �˻�
         else if (protocol == 'D' || protocol == 'd') { // ����
            try {
               delete.boardDeleteTitle();
               delete.boardDeletesql();
               delete.boardDeleteExecuter();
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
               try {
                  conn.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
         } // ����
         else if (protocol == 'U' || protocol == 'u') { // ����
            char option = 'n';
            try {
               update.boardUpdateTitle();
               update.boardUpdateSearch();
               update.boardUpdateExecutersql();
               update.boardUpdateOld();
               option = update.boardUpdateOption();
               if(option == 'n'||option == 'N') {
                  continue;
               }
               update.boardUpdateConfirm();
               update.boardUpdateFinal();
               //option = boardObj.update(input, conn);
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
               try {
                  conn.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            if (option == 'n' || option == 'N') {
               continue;
            }
         } // ����
         else if (protocol == 'L' || protocol == 'l') {// ��ü���
            try {
               list.listboardTitle();
               list.listBoardsql();
               list.listBoardExecuter();
               list.listBoardProcess();
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
               try {
                  conn.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
         } //��ü���
      }

   }

}
