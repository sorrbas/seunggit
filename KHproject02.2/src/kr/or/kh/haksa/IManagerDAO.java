package kr.or.kh.haksa;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IManagerDAO {
	public abstract void managerRegisterSql(ManagerDTO managerDTO) throws SQLException;
	public abstract ResultSet managerListSql() throws SQLException;
	public abstract int managerDeleteSql(String irumDelete) throws SQLException;
	public abstract ResultSet managerSearchSql(String irumSearch) throws SQLException;
	 public abstract int managerUpdateSql(String irumUpdate, ManagerDTO managerDTO) throws SQLException;

}
