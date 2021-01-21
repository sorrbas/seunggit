package kr.or.kh.haksa;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IProfessorDAO {
	public abstract void professorRegisterSql(ProfessorDTO professorDTO) throws SQLException;
	public abstract ResultSet professorListSql() throws SQLException;
	public abstract int professorDeleteSql(String irumDelete) throws SQLException;
	public abstract ResultSet professorSearchSql(String irumSearch) throws SQLException;
	public abstract int professorUpdateSql(String irumUpdate, ProfessorDTO professorDTO) throws SQLException;

}
