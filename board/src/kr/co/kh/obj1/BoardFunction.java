package kr.co.kh.obj1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardFunction {

	public static void register(Scanner sc, Connection conn)throws SQLException {
		System.out.println("제목|내용 :");
		String titleContent = sc.next();
		int indexI = titleContent.indexOf("|");
		String title = titleContent.substring(0, indexI);
		String content = titleContent.substring(indexI + 1);
		System.out.println("작성자입력 :");
		String author = sc.next();
		System.out.println("날짜 입력 : ");
		String nal = sc.next();
		System.out.println("조회수 입력 : ");
		int readcount = sc.nextInt();

		

			Statement stmt = conn.createStatement(); // 공간준비
			/*String sql = "insert into board(title,content,author,nal,readcount) values ('" + title
					+ "','" + content + "','" + author + "','" + nal + "'," + readcount + ")";*/
			String sql = "insert into board(no,title,content,author,nal,readcount) values (board_no.nextval,'" + title
					+ "','" + content + "','" + author + "','" + nal + "'," + readcount + ")";  
			// 하나의 문장 statement
			// 4. 실행 execute <--실행명령어
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "건 게시글이 등록되었습니다");
			
	
	}

	public static void search(Scanner sc, Connection conn)throws SQLException {
		System.out.println("찾는 게시글을 입력하세요 : ");
		String titleSearch = sc.next();
		System.out.println("번호\t제목\t내용\t작성자\t날짜\t조회수");
		// 1.로드(적재) 2.연결 3.준비(공간/쿼리) 4.실행
	
	
			Statement stmt = conn.createStatement();
			String sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD WHERE TITLE ='" + titleSearch + "'";
			ResultSet rs = stmt.executeQuery(sql);
			int readcount = 0;
			// 표 안에 있는 것들을 가리키는 것 rs는 인터페이스 인터페이스는 어떠한 값을 가리키는 것임 rs는 행을 가리키는 것임
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String author = rs.getString("author");
				String nal = rs.getString("nal");
				System.out.print(no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount);
				readcount++;
			}
			stmt = conn.createStatement();
			sql = "update board set readcount= " + readcount + " where title = '" + titleSearch + "'";
			int cnt = stmt.executeUpdate(sql);
		}
			
	
	public static void delete(Scanner sc, Connection conn)throws SQLException {
		System.out.println("삭제할 제목을 입력 : ");
		String titleDelete = sc.next();

	
			Statement stmt = conn.createStatement();
			String sql = "delete from board where title = '" + titleDelete + "'";
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "건 게시글이 삭제되었습니다");
			
		} 

	
	public static char update(Scanner sc, Connection conn) throws SQLException {

		System.out.println("변경 할 게시글제목을 입력하세요 : ");
		String titlesearch = sc.next();
		Statement stmt = null;
		String sql = null;

		stmt = conn.createStatement();
		sql = "select title,content,author,nal,readcount from board where title = '" + titlesearch + "'";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("*** 변경하기 전 게시글입니다.***");

		while (rs.next()) {
			String title = rs.getString("title");
			String content = rs.getString("content");
			String author = rs.getString("author");
			String nal = rs.getString("nal");
			int readcount = rs.getInt("readcount");
			System.out.print(title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount + "\n");
		}
		System.out.println("정말로 변경하시겠습니까? y/n");
		char option = sc.next().charAt(0);
		if (option == 'Y' | option == 'y') {
			System.out.println("제목|내용 :");
			String titleContent = sc.next();
			int indexI = titleContent.indexOf("|");
			String titleupdate = titleContent.substring(0, indexI);
			String contentupdate = titleContent.substring(indexI + 1);
			System.out.println("작성자입력 :");
			String authorupdate = sc.next();
			System.out.println("날짜 입력 : ");
			String nalupdate = sc.next();
			System.out.println("조회수 입력 : ");
			int readcountupdate = sc.nextInt();

			stmt = conn.createStatement();
			sql = "UPDATE board set title ='" + titleupdate + "',content='" + contentupdate + "',author='"
					+ authorupdate + "',nal = '" + nalupdate + "', readcount='" + readcountupdate + "'where title = '"
					+ titlesearch + "'";
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "건 게시글이 수정되었습니다");
			
		}
		return option;
	}

	public static void list(Connection conn)throws SQLException {

		System.out.println("***게시판 전체출력***");
		System.out.println("번호\t제목\t내용\t작성자\t날짜\t조회수\n");
		// 3. 공간준비
		// 3. 쿼리준비
	
			Statement stmt = conn.createStatement();
			String sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD order by no asc";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String author = rs.getString("author");
				String nal = rs.getString("nal");
				int readcount = rs.getInt("readcount");
				System.out.print(
						no + "\t" + title + "\t" + content + "\t" + author + "\t" + nal + "\t" + readcount + "\n");
			}
		} 

	}


