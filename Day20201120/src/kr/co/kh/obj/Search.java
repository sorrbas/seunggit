package kr.co.kh.obj;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Search {
	private Statement stmt;
	private Connection conn;

	private String gubun;
	private String irumSearch;
	private int age;
	private String irum;
	private int hakbun;
	private String subject;
	private String part;
	private String sql;
	private ResultSet rs;

	public Search() {

	}

	public void setGubun() throws IOException {

		System.out.println("찾을대상:");
		System.out.println("1.학생2.교수3.관리자");
		gubun = Register.input.readLine();
	}

	public void setNameSearchStudent() throws IOException {

		System.out.println("찾을 학생이름입력:");
		irumSearch = Register.input.readLine();
	}

	public void setNameSearchProfessor() throws IOException {

		System.out.println("찾을 교수이름입력:");
		irumSearch = Register.input.readLine();
	}

	public void setNameSearchManager() throws IOException {

		System.out.println("찾을 관리자이름입력:");
		irumSearch = Register.input.readLine();
	}

	public void studentDisp() {

		System.out.print("이름:" + irum);
		System.out.print("나이:" + age);
		System.out.print("학번:" + hakbun + "\n");

	}

	public void professorDisp() {

		System.out.print("이름:" + irum);
		System.out.print("나이:" + age);
		System.out.print("과목:" + subject + "\n");

	}

	public void managerDisp() {

		System.out.print("이름:" + irum);
		System.out.print("나이:" + age);
		System.out.print("부서:" + part + "\n");
	}

	public void searchProcess() throws IOException, SQLException {

		conn = Register.getConnection();

		if (gubun.equals("1")) {

			setNameSearchStudent();

			stmt = conn.createStatement();

			sql = "select age,irum,hakbun from student where irum='" + irumSearch + "'";

			rs = stmt.executeQuery(sql);

			if (!rs.isBeforeFirst()) {
				System.out.println("찾는학생이 없습니다.");
			}

			while (rs.next()) {
				irum = rs.getString("irum");
				age = rs.getInt("age");
				hakbun = rs.getInt("hakbun");

				studentDisp();
			}

		} else if (gubun.equals("2")) {

			setNameSearchProfessor();

			stmt = conn.createStatement();

			sql = "select age,irum,subject from professor where irum='" + irumSearch + "'";

			rs = stmt.executeQuery(sql);

			if (!rs.isBeforeFirst()) {
				System.out.println("찾는교수님이 없습니다.");
			}

			while (rs.next()) {
				irum = rs.getString("irum");
				age = rs.getInt("age");
				subject = rs.getString("subject");

				professorDisp();
			}

		} else if (gubun.equals("3")) {

			setNameSearchManager();

			stmt = conn.createStatement();

			sql = "select age,irum,part from manager where irum='" + irumSearch + "'";

			rs = stmt.executeQuery(sql);

			if (!rs.isBeforeFirst()) {
				System.out.println("찾는관리자님이 없습니다.");
			}

			while (rs.next()) {
				irum = rs.getString("irum");
				age = rs.getInt("age");
				part = rs.getString("part");
				managerDisp();
			}
		}
	}

	public static void main(String[] args) {

		Search sea = new Search();

		try {
			sea.setGubun();
			sea.searchProcess();

		} catch (IOException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}