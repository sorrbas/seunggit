package kr.or.kh.haksa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDAO extends HaksaDAO implements IProfessorDAO {
	
	public ProfessorDAO() throws ClassNotFoundException {
		
	}
	@Override
	public void professorRegisterSql(ProfessorDTO professorDTO) throws SQLException {
		sql = "insert into professorNJ(age, irum, subject) values(?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,professorDTO.getNai());
		pstmt.setString(2,professorDTO.getIrum());
		pstmt.setString(3,professorDTO.getSubject());
		
	}
	@Override
	public ResultSet professorListSql() throws SQLException {
		conn = getConnection();
		sql = "select no,age,irum,subject from professorNJ";
		pstmt = conn.prepareStatement(sql);
		rs = professorExecuter(rs);
		return rs;
	}
	@Override
	public int professorDeleteSql(String irumDelete) throws SQLException {
		conn = getConnection();
		sql = "delete from professorNJ where irum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumDelete);
		cnt = professorExecuter();
		return cnt;
	}
	@Override
	public ResultSet professorSearchSql(String irumSearch) throws SQLException {
		conn = getConnection();
		sql = "select no,age,irum,subject from professorNJ where irum =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumSearch);
		rs = professorExecuter(rs);
		return rs;
	}
	@Override
	 public int professorUpdateSql(String irumUpdate, ProfessorDTO professorDTO) throws SQLException{
	      conn = getConnection();
	      sql = "update professorNJ set age=?, irum=?, subject=? where irum=?";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, professorDTO.getNai());
	      pstmt.setString(2,professorDTO.getIrum());
	      pstmt.setString(3, professorDTO.getSubject());
	      pstmt.setString(4, irumUpdate);
	      cnt = professorExecuter();
	      return cnt;
	 }
}
