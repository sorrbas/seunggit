package kr.co.kh.instance1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardExecuter {

	public static void main(String[] args) {   
		Scanner sc = new Scanner(System.in);
		    //1. 로드 (적재 = 자바에게 내가 데이터베이스의 뭘 쓸겠다라고 알려주는 것)
		    //2. 연결 (Connection)연결한다 .  DriverManager.getConnection
		    //3. 준비 (Statement) 3-1 공간을 준비 
		    //3. 준비                         3-2 쿼리를 준비(sql의 문장하나를 쿼리라고 부름)
		    //4. 실행   execute       <--실행명령어 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn =null;
		
		while(true) { //반복문
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","khbclass","dkdlxl");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		System.out.println("======게시판작성======");
		System.out.println("R:등록 S:검색 D:삭제 U:수정 L:목록 ");
		
		char protocol = sc.next().charAt(0);
		if(protocol=='r' || protocol=='R') { //등록구조
			
			
			try {
				BoardFunction.register(sc, conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
		} // 등록구조
		else if (protocol =='S' || protocol == 's') { //검색구조
		    
			
			
		try {
			BoardFunction.search(sc, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		      
		  
		  
		}//검색구조
		else if (protocol =='D' || protocol == 'd') { //삭제구조
			
			
			
		try {
			BoardFunction.delete(sc, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			
			
		}//삭제구조
		else if (protocol =='u' || protocol == 'U') { //수정구조
		  
			
	     char option='n';
		try {
			option = BoardFunction.update(sc, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	     if(option == 'n'||option == 'N') {
	     continue;
	     }
				}//수정구조
		else if (protocol =='L' || protocol == 'l') { //목록구조(전체출력 후 )
		
			
		try {
			BoardFunction.list(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			
		//stmt.close();
		//conn.close();
		}//목록구조
		
		} // 반복문
		
	}

}

