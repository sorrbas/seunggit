package kr.or.kh.haksa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO extends HaksaDAO implements IStudentDAO {
	
	public StudentDAO() throws ClassNotFoundException {

	}
	@Override
	public void studentRegisterSql(StudentDTO studentDTO) throws SQLException {
		sql = "insert into studentNJ(age, irum, hakbun) values(?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,studentDTO.getNai());
		pstmt.setString(2,studentDTO.getIrum());
		pstmt.setString(3,studentDTO.getHakbun());
		
	}
	@Override
	public ResultSet studentListSql() throws SQLException {
		conn = getConnection();
		sql = "select no,age,irum,hakbun from studentNJ";
		pstmt = conn.prepareStatement(sql);
		rs = studentExecuter(rs);
		return rs;
	}
	@Override
	public int studentDeleteSql(String irumDelete) throws SQLException {
		conn = getConnection();
		sql = "delete from studentNJ where irum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumDelete);
		cnt = studentExecuter();
		return cnt;
	}
	@Override
	public ResultSet studentSearchSql(String irumSearch) throws SQLException {
		conn = getConnection();
		sql = "select no,age,irum,hakbun from studentNJ where irum =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumSearch);
		rs = studentExecuter(rs);
		return rs;
	}
	@Override
	 public int studentUpdateSql(String irumUpdate, StudentDTO studentDTO) throws SQLException{
	      conn = getConnection();
	      sql = "update studentNJ set age=?, irum=?, hakbun=? where irum=?";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, studentDTO.getNai());
	      pstmt.setString(2,studentDTO.getIrum());
	      pstmt.setString(3, studentDTO.getHakbun());
	      pstmt.setString(4, irumUpdate);
	      cnt = studentExecuter();
	      return cnt;
	 }
}
