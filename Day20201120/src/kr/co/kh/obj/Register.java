package kr.co.kh.obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Register {

   private String protocol;
   public static BufferedReader input;
   private Statement stmt;
   private static Connection conn;
   private int cnt;
   private String age1;
   private String irum;
   private String hakbun1;
   private String subject;
   private String part;

   static {

      input = new BufferedReader(new InputStreamReader(System.in));
   }

   public Register() {

      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");

      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }

   }

   public static Connection getConnection() throws SQLException {

      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "khbclass", "dkdlxl");
      return conn;
   }

   public void setInput() throws IOException {

      System.out.println("=====�޴�����======");
      System.out.println("1.�л�");
      System.out.println("2.����");
      System.out.println("3.������");
      System.out.println("4.�����޴�");
      System.out.println("��ȣ�� ������ �ּ���..");
      protocol = input.readLine();

   }

   public void setAge() throws IOException {

      System.out.println("����:");
      age1 = input.readLine();
   }

   public void setName() throws IOException {

      System.out.println("�̸�:");
      irum = input.readLine();
   }

   public void setHakbun() throws IOException {

      System.out.println("�й�:");
      hakbun1 = input.readLine();
   }

   public void setSubject() throws IOException {

      System.out.println("����:");
      subject = input.readLine();
   }

   public void setPart() throws IOException {

      System.out.println("�μ�:");
      part = input.readLine();
   }

   public void studentDisp() {

      System.out.println(cnt + "�� �л��� ��ϵǾ����ϴ�.");
   }

   public void professorDisp() {

      System.out.println(cnt + "�� �������� ��ϵǾ����ϴ�.");
   }

   public void managerDisp() {

      System.out.println(cnt + "�� �����ڴ��� ��ϵǾ����ϴ�.");
   }

   public String haksaProcess() throws IOException, SQLException {

      if (protocol.equals("1")) {

         setAge();
         setName();
         setHakbun();

         int age = Integer.parseInt(age1); // ����ȯ
         int hakbun = Integer.parseInt(hakbun1); // ����ȯ

         stmt = conn.createStatement();

         String sql = "insert into student(no,age,irum,hakbun) values(student_no.nextval," + age + ",'" + irum + "',"
               + hakbun + ")";

         cnt = stmt.executeUpdate(sql);
         
         studentDisp();

      } else if (protocol.equals("2")) {

         setAge();
         setName();
         setSubject();

         stmt = conn.createStatement();

         int age = Integer.parseInt(age1);

         String sql = "insert into professor(no,age,irum,subject) values(professor_no.nextval," + age + ",'" + irum
               + "','" + subject + "')";

         cnt = stmt.executeUpdate(sql);

         professorDisp();

      } else if (protocol.equals("3")) {

         setAge();
         setName();
         setPart();

         stmt = conn.createStatement();

         int age = Integer.parseInt(age1);

         String sql = "insert into manager(no,age,irum,part) values(manager_no.nextval," + age + ",'" + irum + "','"
               + part + "')";

         cnt = stmt.executeUpdate(sql);

         managerDisp();
      }
      return protocol;
   }

   public static void main(String[] args) {

      Register regi = new Register();

      try {
         Connection conn = regi.getConnection();

      } catch (SQLException e1) {
         e1.printStackTrace();
      }

      try {
         regi.setInput();
         regi.haksaProcess();

      } catch (IOException e) {
         e.printStackTrace();

      } catch (SQLException e) {
         e.printStackTrace();
      }

   }
}