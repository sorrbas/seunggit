package member;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import license.LicenseBean;



public class MemberDAO implements Serializable {
   
   private Connection conn;
   private MemberDTO memberDTO;
   private String sql;
   private PreparedStatement pstmt;
   private ResultSet rs;
   private int cnt;
   private ArrayList<MemberDTO> memberList;
   
   
   
   //DB연결1
   public MemberDAO() {
      memberDTO = new MemberDTO();
      memberList = new ArrayList<MemberDTO>();
      
      try {
         Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   //DB연결2
   public Connection getConnection()throws SQLException {
      conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb","underdogb","khacademy1!");
      return conn;
   }
    //로그인
   public MemberDTO memberLogin(String id, String pw)throws SQLException {
      conn = getConnection();
      sql = "select id,pw,email from memberUK where id=? and pw=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pw);
      rs = pstmt.executeQuery();
      while(rs.next()) {
         memberDTO.setId(rs.getString("id"));
         memberDTO.setPw(rs.getString("pw"));
         memberDTO.setEmail(rs.getString("email"));
      }
      return memberDTO;
   }
   
   public int checkID(String id) throws SQLException{
      conn = getConnection();
      int count =0;
      try{
         String sql ="select count(*) from memberUK where id=?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, id);
         rs=pstmt.executeQuery();
         if(rs.next()){
            count =rs.getInt(1);
         }
         conn.close();
      }catch(Exception e){
         e.printStackTrace();
      }
      return count;
   }
   
   //회원가입
   public int memberRegister(MemberDTO memberDTO)throws SQLException {
      conn = getConnection();
      sql = "insert into memberUK(id,pw,email) values(?,?,?)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, memberDTO.getId());
      pstmt.setString(2, memberDTO.getPw());
      pstmt.setString(3, memberDTO.getEmail());
      cnt = pstmt.executeUpdate();
      return cnt;
      
   }
   //아이디찾기
   public String memberSearch(String idSearch)throws SQLException {
      conn = getConnection();
      sql = "select id from memberUK where email=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, idSearch);
      rs = pstmt.executeQuery();
      String id =null;
      while(rs.next()) {
         id = rs.getString("id");
      }
      return id;
   }
   //비밀번호 찾기
   public String pwSearch(String idSearch, String pwSearch)throws SQLException {
       conn= getConnection();
       sql ="select pw from memberUK where id=? and email=?";
       pstmt = conn.prepareStatement(sql);
       pstmt.setString(1, idSearch);
       pstmt.setString(2, pwSearch);
       rs = pstmt.executeQuery();
       String pw =null;
       while(rs.next()) {
          pw = rs.getString("pw");       
          }
       return pw;
   }
   //회원목록
   public ArrayList<MemberDTO> memberList()throws SQLException{
      conn= getConnection();
      sql="select id,email from memberUK";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      memberList = new ArrayList<MemberDTO>();
      while(rs.next()) {
         memberDTO = new MemberDTO();
         memberDTO.setId(rs.getString("id"));
         memberDTO.setEmail(rs.getString("email"));
         memberList.add(memberDTO);
      }
      return memberList;
      
   }
   //회원탈퇴
   public int memberDelete(String idDelete, String pwDelete)throws SQLException{
      conn = getConnection();
      sql = "delete from memberUK where id=? and pw=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, idDelete);
      pstmt.setString(2, pwDelete);
      cnt = pstmt.executeUpdate();
      return cnt;
   }
   //회원수정
   public int memberUpdate(MemberDTO memberDTO)throws SQLException {
      conn = getConnection();
      sql = "update memberUK set pw=?, email=? where id=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, memberDTO.getPw());
      pstmt.setString(2, memberDTO.getEmail());
      pstmt.setString(3, memberDTO.getId());

      cnt = pstmt.executeUpdate();
      return cnt;
      
   }
   //아이디중복체크
   public ResultSet doubleIDcheck(String id)throws SQLException{
      conn = getConnection();
      sql="select id from memberUK where id=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();
      return rs;
   }

   public int getAllCount() throws SQLException{
      getConnection();
      //게시글 전체수를 저장하는 변수
      int count =0;
      try{
         //쿼리준비
         String sql ="select count(*) from memberUK";
         //쿼리를 실행할 객체 선언
         pstmt = conn.prepareStatement(sql);
         //쿼리 실행 후 결과를 리턴
         rs=pstmt.executeQuery();
         if(rs.next()){
            count =rs.getInt(1);
         }
         conn.close();
      }catch(Exception e){
         e.printStackTrace();
      }
      return count;
   }

   public Vector<MemberBean> getAllMember(int start, int end) throws SQLException{      
      //리넡할 객체 선언
      Vector<MemberBean> v =new Vector<>();
      getConnection();
      try{
         //쿼리 준비
         String sql = "SELECT * FROM memberUK ORDER BY id DESC LIMIT ?, 10";
         //쿼리를 실행할객체 선언
         pstmt =conn.prepareStatement(sql);
         pstmt.setInt(1, start-1);
//         pstmt.setInt(2, end);
         //쿼리실행 후 결과 저장
         rs=pstmt.executeQuery();
         //데이터 개수가 몇개인지 모르기에 반복문을 이용하여 데이터를 추출
         while(rs.next()){
            MemberBean bean =new MemberBean();
            bean.setId(rs.getString("id"));
            bean.setPw(rs.getString("pw"));
            bean.setEmail(rs.getString("email"));
            bean.setTrackingProgress(rs.getInt("trackingProgress"));
            bean.setLicenseGrade(rs.getInt("licenseGrade"));
            //패키징한 데이터를 벡터에 저장
            v.add(bean);
         }
         
      }catch(Exception e){
         e.printStackTrace();
      }
      return v;
   }
}
   

