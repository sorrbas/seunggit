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
      // 1.로드(적재=자바에게 내가 데이터베이스를 무엇을 쓰겠다.)
      // 내가 자바에게 데이터베이스 무엇을 쓰겠다 알려주기
      try {
         Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }
      Connection conn=null;
      ResultSet rs = null;
      while (true) {
         // 2.연결(connection)연결하다. DriverManager.getConnection
         try {
        	 conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb?characterEncoding=utf8", "underdogb", "khacademy1!");
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         System.out.println("======게시판작성======");
         System.out.println("R:등록\tS:검색\tD:삭제\tU:수정\tL:목록");
         // String protocol = input.next();
         char protocol = input.next().charAt(0);
         // if(protocol.equals("R"))

         if (protocol == 'R' || protocol == 'r') {
            System.out.println("제목|내용: ");
            String titleContent = input.next();
            int indexI = titleContent.indexOf("|");// indexI에 |이건 2에 들어감.'
            String title = titleContent.substring(0, indexI);// 자르는 메소드
            String content = titleContent.substring(indexI + 1);
            // 제목따로 내용따로
            System.out.println("작성자입력: ");
            String author = input.next();
            System.out.println("날짜: ");
            String nal = input.next();// data는 예약임 DB에서
            System.out.println("조회수: ");
            int readcount = input.nextInt();
            // 3.준비(Statement문장) 연결준비. 3-1 공간을 준비
            // 3.준비(Statement문장) 연결준비. 3-2 쿼리준비
                                                                         
               try {
				Statement stmt = conn.createStatement();// 저 conn을 넣어줄 공간을 만들어준다.
				   String sql = "INSERT INTO board(title,content,author,nal,readcount) values('"
				         + title + "','" + content + "','" + author + "','" + nal + "'," + readcount + ")";
				   // 이 부분 내용이 바뀌려면 values(board_no.nextval,'제목1','내용1','kh','2020.11.12',0) 위처럼
				   // 해줘야 한다.
				   // '""'<<문자열 ""<<숫자
				   // 4.실행 execute
				   int cnt = stmt.executeUpdate(sql);// 정수형으로 리턴
				   System.out.println(cnt + "건 게시글이 등록되었습니다.");
				   System.out.println();
				   // 문장 끊기 스트림
				   // stmt.close();
				   // connection 도 끊기
				   // conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          

         } else if (protocol == 'S' || protocol == 's') {
            System.out.print("찾는 게시글 제목 입력:");
            String searchTitle = input.next();
            System.out.print("번호\t제목\t내용\t작가\t날짜\t\t조회수\n");
            // 데이터베이스로 컨트롤 로드=적재 연결 할 필요는 없다 . 준비해주기
            try {
               Statement stmt = conn.createStatement();
               String sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM board WHERE TITLE = '" + searchTitle+ "'";
               // String sql = "select * from board where title = '"+searchTitle+"'"; //3.준비
               // 3-2 쿼리를 준비
               rs = stmt.executeQuery(sql);// 테이블(표) 안에 있는 첫 번째, 두 번째 세 번째 ... 열을 가리킨다.
               int readcount = 0;
               while (rs.next()) {// 데이터베이스에서 꺼내서 변수로 집어넣는다. 그래서 DB에서 원하는 데이터를 갖고와야됨. 그래서 rs로 가리켜야 한다.
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
//                System.out.println("No = " + rs.getInt(1) + "Title = " + rs.getString(2) + " Content = " + rs.getString(3) + " Author = " + rs.getString(4) + " NAL = " + rs.getString(5) + " 조회수 = " + newReadCount);
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
            System.out.println("삭제할 제목을 입력하세요 : ");
            String deleteTitle = input.next();
            // 3.준비
            // 3-1 공간을 준비한다.
            // 3-2 쿼리를 준비한다.
            try {
               Statement stmt = conn.createStatement();
               String sql = "DELETE FROM board WHERE TITLE = '" + deleteTitle + "'";// 제목이 같으면 지워라 라고 조건 넣어주는것임.
               int cnt = stmt.executeUpdate(sql);
               System.out.println(cnt + "건 게시글이 삭제 되었습니다.");
               System.out.println();
               conn.close();
               stmt.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }

         } else if (protocol == 'U' || protocol == 'u') {
            System.out.println("변경할 게시글 제목을 입력하세요 : ");
            String searchTitle = input.next();
            //3. 공간 쿼리준비
            Statement stmt = null;
            String sql = null;
            try {
               stmt = conn.createStatement();
               sql = "SELECT TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM board WHERE TITLE = '"+searchTitle+"'";
               rs = stmt.executeQuery(sql);
               System.out.println("======변경하기 전 게시글입니다.======");
               while(rs.next()) {
                  String title = rs.getString("title");
                  String content = rs.getString("content");
                  String author = rs.getString("author");
                  String nal = rs.getString("nal");
                  int readcount = rs.getInt("readcount");
                  System.out.print( title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount + "\n");
               }
               System.out.println("정말로 변경 하시겠습니까y/n");//y가 들어오면 수정하고 n이 들어오면 수정안함
               char option = input.next().charAt(0);
               if(option == 'Y'|| option == 'y') {
                  System.out.println("제목|내용: ");
                  String titleContent = input.next();
                  int indexI = titleContent.indexOf("|");// indexI에 |이건 2에 들어감.'
                  String updateTitle = titleContent.substring(0, indexI);// 자르는 메소드
                  String contentUpdate = titleContent.substring(indexI + 1);
                  // 제목따로 내용따로
                  System.out.println("작성자입력: ");
                  String authorUpdate = input.next();
                  System.out.println("날짜: ");
                  String nalUpdate = input.next();// data는 예약임 DB에서
                  System.out.println("조회수: ");
                  int readcountUpdate = input.nextInt();
                  stmt = conn.createStatement();
                  sql = "UPDATE board SET title ='"+updateTitle+"', content = '"+contentUpdate+"', author = '"+authorUpdate+"', nal = '"+nalUpdate+"', readcount = '"+readcountUpdate+"' WHERE title = '"+searchTitle+"'";
                  int cnt = stmt.executeUpdate(sql);
                  System.out.print("번호\t제목\t내용\t작가\t날짜\t\t조회수\n");
                  System.out.println(updateTitle + "\t" + updateTitle + "\t" + contentUpdate + "\t" + authorUpdate + "\t" + nalUpdate + "\t" + readcountUpdate);
                  System.out.println();
                  stmt.close();
                  conn.close();
               }else {
                  stmt.close();
                  conn.close();
                  continue;//반복문으로 올라가라. 그럼 등록 검색 메뉴가 나온다.
               }
               
            } catch (SQLException e) {
               e.printStackTrace();
            }
         } else if (protocol == 'L' || protocol == 'l') {
            System.out.println("=======게시판 전체출력=========");
            System.out.print("번호\t제목\t내용\t작가\t날짜\t\t조회수\n");
            // 3.공간,쿼리준비
            try {
               Statement stmt = conn.createStatement();
               String sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM board order by title asc";// 조건 필요없어서 WHERE 안 넣어줌.
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

      } // 반복문

   }

}