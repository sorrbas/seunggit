package kr.or.kh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmpDAO {
	
	DataSource dataFactory;
	//데이터팩토리라는 공장을 멤버변수로 선언 이 공장은 커넥션을 해줄 수 있음 
	
	public EmpDAO() {
		try {
			Context ctx = new InitialContext(); 
			//Context는 통로와 관문을 뜻함 통로를 이용하여 접근/초기화를 하려는 목적임
			dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			//DataSource
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<EmpDTO> select() {
		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			String sql = "select emp_id,ename,salary,depart from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String emp_id = rs.getString("emp_id");
				String ename = rs.getString("ename");
				int salary = rs.getInt("salary");
				String depart = rs.getString("depart");
				EmpDTO dto = new EmpDTO(emp_id,ename,salary,depart);
				list.add(dto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

}
