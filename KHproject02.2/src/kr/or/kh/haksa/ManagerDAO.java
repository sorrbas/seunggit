package kr.or.kh.haksa;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDAO extends HaksaDAO implements IManagerDAO {
	
	public ManagerDAO() throws ClassNotFoundException {

	}
	@Override
	public void managerRegisterSql(ManagerDTO managerDTO) throws SQLException {
		sql = "insert into managerNJ(age, irum, part) values(?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,managerDTO.getNai());
		pstmt.setString(2,managerDTO.getIrum());
		pstmt.setString(3,managerDTO.getPart());
		
	}
	@Override
	public ResultSet managerListSql() throws SQLException {
		conn = getConnection();
		sql = "select no,age,irum,part from managerNJ";
		pstmt = conn.prepareStatement(sql);
		rs = managerExecuter(rs);
		return rs;
	}
	@Override
	public int managerDeleteSql(String irumDelete) throws SQLException {
		conn = getConnection();
		sql = "delete from managerNJ where irum=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumDelete);
		cnt = managerExecuter();
		return cnt;
	}
	@Override
	public ResultSet managerSearchSql(String irumSearch) throws SQLException {
		conn = getConnection();
		sql = "select no,age,irum,part from managerNJ where irum =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, irumSearch);
		rs = managerExecuter(rs);
		return rs;
	}
	@Override
	 public int managerUpdateSql(String irumUpdate, ManagerDTO managerDTO) throws SQLException{
	      conn = getConnection();
	      sql = "update managerNJ set age=?, irum=?, part=? where irum=?";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, managerDTO.getNai());
	      pstmt.setString(2,managerDTO.getIrum());
	      pstmt.setString(3, managerDTO.getPart());
	      pstmt.setString(4, irumUpdate);
	      cnt = managerExecuter();
	      return cnt;
	 }
}

