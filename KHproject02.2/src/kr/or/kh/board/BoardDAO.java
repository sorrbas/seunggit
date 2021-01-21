package kr.or.kh.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
   private Connection conn;
   private BoardDTO boardDTO;
   private BoardDAO boardDAO;
   private ResultSet rs;
   private PreparedStatement pstmt;
   private String sql;
   private int cnt;
   private ArrayList<BoardDTO> boardList;
   
   
   public BoardDAO() {
	      boardDTO = new BoardDTO();
	      boardList = new ArrayList<BoardDTO>();

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
   
   public void boardClose() throws SQLException{
      conn.close();
      rs.close();
      pstmt.close();
   }
   
   public int boardWrite(BoardDTO boardDTO) throws SQLException {
      conn = getConnection();
      sql = "insert into boardNJ(title,content,author,nal,readCount) values (?,?,?,?,?)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, boardDTO.getTitle());
      pstmt.setString(2, boardDTO.getContent());
      pstmt.setString(3, boardDTO.getAuthor());
      pstmt.setString(4, boardDTO.getNal());
      pstmt.setInt(5, boardDTO.getReadCount());
      cnt = pstmt.executeUpdate();
      return cnt;
   }
   public ArrayList<BoardDTO> boardList() throws SQLException{
	   conn = getConnection();
	   sql = "select no,title,content,author,nal,readCount from boardNJ order by no asc";
	   pstmt = conn.prepareStatement(sql);
	   rs = pstmt.executeQuery();
	   boardList = new ArrayList<BoardDTO>();
	   while(rs.next()) {
		   boardDTO = new BoardDTO();
		   boardDTO.setNo(rs.getInt("no"));
		   boardDTO.setTitle(rs.getString("title"));
		   boardDTO.setContent(rs.getString("content"));
		   boardDTO.setAuthor(rs.getString("author"));
		   boardDTO.setNal(rs.getString("nal"));
		   boardDTO.setReadCount(Integer.parseInt(rs.getString("readCount")));
		   boardList.add(boardDTO); //boardDTO의 값을 boardList에 담아준것임
		   
	   }
	   return boardList;   //그냥 배열에 담아버려서 리턴으로 돌려주겠다.
   }
   
   public int boardDelete(int no) throws SQLException{
	   conn = getConnection();
	   sql = "delete from boardNJ where no=?";
	   pstmt = conn.prepareStatement(sql);
	   pstmt.setInt(1, no);
	   cnt = pstmt.executeUpdate();
	   return cnt;
   }
   
  public BoardDTO boardSearch(String titleSearch) throws SQLException{
	  conn = getConnection();
	  sql = "select no,title,content,author,nal,readCount from boardNJ where title=?";
	  pstmt = conn.prepareStatement(sql);
	  pstmt.setString(1, titleSearch);
	  rs = pstmt.executeQuery();
	  while(rs.next()) {
		  boardDTO.setNo(rs.getInt("no"));
		  boardDTO.setTitle(rs.getString("title"));
		  boardDTO.setContent(rs.getString("content"));
		  boardDTO.setAuthor(rs.getString("author"));
		  boardDTO.setNal(rs.getString("nal"));
		  boardDTO.setReadCount(rs.getInt("readCount"));
	  }
	  return boardDTO;
  }
  public int boardReadCount(BoardDTO boardDTO)throws SQLException {
	  conn = getConnection();
	  sql = "update boardNJ set readCount=? where no=?";
	  pstmt = conn.prepareStatement(sql);
	  pstmt.setInt(1, boardDTO.getReadCount()+1);
	  pstmt.setInt(2, boardDTO.getNo());
	  cnt = pstmt.executeUpdate();
	  return cnt;
  }
  
  public int boardUpdateFinal(BoardDTO boardDTO,String titleUpSearch)throws SQLException {
	  conn = getConnection();
	  sql = "update boardNJ set title=?,content=?,author=?,nal=?,readCount=? where title=?";
	  pstmt = conn.prepareStatement(sql);
	  pstmt.setString(1, boardDTO.getTitle());
	  pstmt.setString(2, boardDTO.getContent());
	  pstmt.setString(3, boardDTO.getAuthor());
	  pstmt.setString(4, boardDTO.getNal());
	  pstmt.setInt(5, boardDTO.getReadCount());
	  pstmt.setString(6, titleUpSearch);
	  cnt = pstmt.executeUpdate();
	  return cnt;
	  
  }
  
 
 

}