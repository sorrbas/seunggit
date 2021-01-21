package kr.or.kh.haksa;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IStudentDAO {
	public abstract void studentRegisterSql(StudentDTO studentDTO) throws SQLException;
	public abstract ResultSet studentListSql() throws SQLException;
	public abstract int studentDeleteSql(String irumDelete) throws SQLException;
	public abstract ResultSet studentSearchSql(String irumSearch) throws SQLException;
	public abstract int studentUpdateSql(String irumUpdate, StudentDTO studentDTO) throws SQLException;

}
