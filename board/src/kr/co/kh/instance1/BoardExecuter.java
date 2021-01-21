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
		    //1. �ε� (���� = �ڹٿ��� ���� �����ͺ��̽��� �� ���ڴٶ�� �˷��ִ� ��)
		    //2. ���� (Connection)�����Ѵ� .  DriverManager.getConnection
		    //3. �غ� (Statement) 3-1 ������ �غ� 
		    //3. �غ�                         3-2 ������ �غ�(sql�� �����ϳ��� ������� �θ�)
		    //4. ����   execute       <--�����ɾ� 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn =null;
		
		while(true) { //�ݺ���
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","khbclass","dkdlxl");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		System.out.println("======�Խ����ۼ�======");
		System.out.println("R:��� S:�˻� D:���� U:���� L:��� ");
		
		char protocol = sc.next().charAt(0);
		if(protocol=='r' || protocol=='R') { //��ϱ���
			
			
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
			
			
		} // ��ϱ���
		else if (protocol =='S' || protocol == 's') { //�˻�����
		    
			
			
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
		      
		  
		  
		}//�˻�����
		else if (protocol =='D' || protocol == 'd') { //��������
			
			
			
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
			
			
			
		}//��������
		else if (protocol =='u' || protocol == 'U') { //��������
		  
			
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
				}//��������
		else if (protocol =='L' || protocol == 'l') { //��ϱ���(��ü��� �� )
		
			
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
		}//��ϱ���
		
		} // �ݺ���
		
	}

}

