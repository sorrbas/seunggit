package org.zerock.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Test;
import lombok.extern.log4j.Log4j;
@Log4j
public class JDBCTests {
 static {
	 try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
 }
 @Test
 public void testConnection() {
	 try {
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "khbclass", "dkdlxl");
		log.info(conn);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 
 }
 
}
