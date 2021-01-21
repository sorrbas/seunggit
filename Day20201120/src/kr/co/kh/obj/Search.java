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

		System.out.println("ã�����:");
		System.out.println("1.�л�2.����3.������");
		gubun = Register.input.readLine();
	}

	public void setNameSearchStudent() throws IOException {

		System.out.println("ã�� �л��̸��Է�:");
		irumSearch = Register.input.readLine();
	}

	public void setNameSearchProfessor() throws IOException {

		System.out.println("ã�� �����̸��Է�:");
		irumSearch = Register.input.readLine();
	}

	public void setNameSearchManager() throws IOException {

		System.out.println("ã�� �������̸��Է�:");
		irumSearch = Register.input.readLine();
	}

	public void studentDisp() {

		System.out.print("�̸�:" + irum);
		System.out.print("����:" + age);
		System.out.print("�й�:" + hakbun + "\n");

	}

	public void professorDisp() {

		System.out.print("�̸�:" + irum);
		System.out.print("����:" + age);
		System.out.print("����:" + subject + "\n");

	}

	public void managerDisp() {

		System.out.print("�̸�:" + irum);
		System.out.print("����:" + age);
		System.out.print("�μ�:" + part + "\n");
	}

	public void searchProcess() throws IOException, SQLException {

		conn = Register.getConnection();

		if (gubun.equals("1")) {

			setNameSearchStudent();

			stmt = conn.createStatement();

			sql = "select age,irum,hakbun from student where irum='" + irumSearch + "'";

			rs = stmt.executeQuery(sql);

			if (!rs.isBeforeFirst()) {
				System.out.println("ã���л��� �����ϴ�.");
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
				System.out.println("ã�±������� �����ϴ�.");
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
				System.out.println("ã�°����ڴ��� �����ϴ�.");
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