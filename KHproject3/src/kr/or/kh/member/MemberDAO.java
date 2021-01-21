package kr.or.kh.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kh.board.BoardDTO;

public class MemberDAO {

	private MemberDTO memberDTO;
	private ArrayList<MemberDTO> memberList;
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql;
	private int cnt;
	private ResultSet rs;




	public MemberDAO() {
		memberDTO = new MemberDTO();
		memberList = new ArrayList<MemberDTO>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://underdogb.cafe24.com:3306/underdogb", "underdogb","khacademy1!");
		return conn;
	}
	public int memberRegister(MemberDTO memberDTO)throws SQLException {

		conn = getConnection();
		sql = "insert into memberNJ(id,pw,addr,tel) values(?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberDTO.getId());
		pstmt.setString(2, memberDTO.getPw());
		pstmt.setString(3, memberDTO.getAddr());
		pstmt.setString(4, memberDTO.getTel());
		cnt = pstmt.executeUpdate();
		return cnt;

	}

	public ArrayList<MemberDTO> memberList() throws SQLException{
		conn = getConnection();
		sql = "select id,pw,addr,tel from memberNJ";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		memberList = new ArrayList<MemberDTO>();
		while(rs.next()) {
			memberDTO = new MemberDTO();      
			//중복을 막아주기 위해 객체를 생성해주는 것임 생성을 안해주면 키가 중복이 되어 마지막것만 저장이 되고 이전 것은 다 사라짐
			//새로운 것을 만들고 넣고 다시 새로운 것을 만들고 넣고 해주는 것
			memberDTO.setId(rs.getString("id"));
			memberDTO.setPw(rs.getString("pw"));
			memberDTO.setAddr(rs.getString("addr"));
			memberDTO.setTel(rs.getString("tel"));
			memberList.add(memberDTO); //boardDTO의 값을 boardList에 담아준것임

		}
		return memberList;   //그냥 배열에 담아버려서 리턴으로 돌려주겠다.
	}

	public MemberDTO memberLogin(String id, String pw)throws SQLException {
		conn = getConnection(); 
		sql = "select id,pw from memberNJ where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			memberDTO.setId(rs.getString("id"));
			memberDTO.setPw(rs.getString("pw"));
		}
		return memberDTO;
	}

	public int memberDelete(String idDelete,String pwDelete)throws SQLException {
		conn = getConnection();
		sql = "delete from memberNJ where id=? and pw=?";
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, idDelete);
	      pstmt.setString(2, pwDelete);
	      cnt = pstmt.executeUpdate();
	      return cnt;
	  
	}

	public String memberIdcheck(String telSearch)throws SQLException {
		conn = getConnection();
		sql = "select id from memberNJ where tel=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, telSearch);
		rs = pstmt.executeQuery();
		String id = null;
		while (rs.next()) {
		id = rs.getString("id");
		}
		return id;
	}
	
	public String memberPwcheck(String idSearch)throws SQLException {
		conn = getConnection();
		sql= "select pw from memberNJ where id =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, idSearch);
		rs = pstmt.executeQuery();
		String pw = null;
		while(rs.next()) {
		pw = rs.getString("pw");
		}
		return pw;
		
	}
	public MemberDTO memberUpdateConfirm(String idSearch)throws SQLException {
		conn = getConnection();
		sql = "select id,pw,addr,tel from memberNJ where id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, idSearch);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			memberDTO.setId(rs.getString("id"));      //memberDTO에다가 데이터베이스에서 받아온 정보를 받아준다는 것임
			memberDTO.setPw(rs.getString("pw"));
			memberDTO.setAddr(rs.getString("addr"));
			memberDTO.setTel(rs.getString("tel"));
		}
		return memberDTO;
		
	}
	
	public int memberUpdateFinal(MemberDTO memberDTO,String idSearch)throws SQLException {
		conn = getConnection();
		sql = "update memberNJ set id=?,pw=?,addr=?,tel=? where id=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberDTO.getId());
		pstmt.setString(2, memberDTO.getPw());
		pstmt.setString(3, memberDTO.getAddr());
		pstmt.setString(4, memberDTO.getTel());
		pstmt.setString(5, idSearch);
		cnt = pstmt.executeUpdate();
		return cnt;
	}
	
	public ResultSet memberIdCheckall(String id)throws SQLException {
		conn = getConnection();
		sql = "select id from memberNJ where id=?";
	    pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		return rs;
		
	}
	
	

}
