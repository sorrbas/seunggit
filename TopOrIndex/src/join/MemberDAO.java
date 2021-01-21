package join;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;



public class MemberDAO {

public int insertMember(Member member)throws SQLException {
Connection conn = null;
PreparedStatement pstmt = null;

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "khbclass", "dkdlxl");
String query = "insert into member_tbl(MEMBER_ID,MEMBER_PW,MEMBER_NAME) values(?,?,?)";
pstmt = conn.prepareStatement(query);
pstmt.setString(1,member.getMemberId());
pstmt.setString(2,member.getMemberPw());
pstmt.setString(3,member.getMemberName());
pstmt.executeUpdate();
int result = 0;
if(result>0) {
conn.commit();
}else {
conn.rollback();
}

pstmt.close();
conn.close();




return result;

}

}