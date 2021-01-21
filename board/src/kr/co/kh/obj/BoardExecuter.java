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
         // 2.연결(connection)연결하다. DriverManager.getConnection
         try {
         conn = register.getConnection();
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         System.out.println("======게시판작성======");
         System.out.println("R:등록\tS:검색\tD:삭제\tU:수정\tL:목록");
         // String protocol = input.next();
         char protocol = input.next().charAt(0);
         // if(protocol.equals("R"))

         if (protocol == 'R' || protocol == 'r') { // 등록
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
            } finally { //무조건 수행하는거
               try {
                  conn.close();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
         } // 등록
         else if (protocol == 'S' || protocol == 's') { // 검색
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

         } // 검색
         else if (protocol == 'D' || protocol == 'd') { // 삭제
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
         } // 삭제
         else if (protocol == 'U' || protocol == 'u') { // 수정
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
         } // 수정
         else if (protocol == 'L' || protocol == 'l') {// 전체출력
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
         } //전체출력
      }

   }

}
