package kr.or.kh.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO implements IBoard {
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
   
   @Override   //다형성을 표시해줌 부모에도 같은 함수가 있으니 다르게 표현하겠다.
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
   
   @Override 
   public int totalCount() {  //페이징처리:전체 레코드 갯수 구하기 
   	int count = 0;
   	try {
			conn = getConnection();
			sql = "select count(*) from boardNJ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}   // 행의 개수를 찍어주기 위해서 ex)게시글이 100개면 100이 찍히는 것임
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	return count;
   	
   } //페이징처리:전체 레코드 갯수 구하기 
    
  
   @Override  
   public PageTo page(int cursorPage) { //페이지구현
   	PageTo pageTo = new PageTo();
   	int totalCount = totalCount();
   	ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
   	try {
			conn = getConnection();
			sql = "select no,title,content,author,nal,readCount from boardNJ";
			pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
			//  TYPE_SCROLL_INSENSITIVE => SQL만 사용하며 결국 스크롤은 가능하나, 변경된 사항은 적용되지 않는다.
			//  양방향 스크롤 시 업데이트를 반영하지 않겠다.
			//  ResultSet.CONCUR_READ_ONLY => 커서의 위치에서 정보를 업데이트 할 수 없음, ResultSet의 변경이 불가능
			rs = pstmt.executeQuery();
			int perPage = pageTo.getPerPage();       //레코드의 갯수를 가져와서 perPage변수에 담는다.
			int skip = (cursorPage-1)*perPage;
			if(skip>0) {
				rs.absolute(skip);
			}
			//ResultSet의 absolute메소드를 이용하여 해당페이지의 커서의 위치로 이동한다.
			for(int i=0; i<perPage && rs.next();i++) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String author = rs.getString("author");
				String nal = rs.getString("nal");
				int readCount = rs.getInt("readCount");
				
				BoardDTO data = new BoardDTO();
				data.setNo(no);
				data.setTitle(title);
				data.setContent(content);
				data.setAuthor(author);
				data.setNal(nal);
				data.setReadCount(readCount);
				list.add(data);        	
			}
			pageTo.setList(list); //ArrayList배열을 저장
			pageTo.setTotalCount(totalCount); // 전체레코드갯수를 저장
			pageTo.setCursorPage(cursorPage); // 현재페이지를 저장
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	return pageTo;
   	
   }
   @Override 
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
   @Override
   public int boardDelete(int no) throws SQLException{
	   conn = getConnection();
	   sql = "delete from boardNJ where no=?";
	   pstmt = conn.prepareStatement(sql);
	   pstmt.setInt(1, no);
	   cnt = pstmt.executeUpdate();
	   return cnt;
   }
   @Override
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
   @Override
  public int boardReadCount(BoardDTO boardDTO)throws SQLException {
	  conn = getConnection();
	  sql = "update boardNJ set readCount=? where no=?";
	  pstmt = conn.prepareStatement(sql);
	  pstmt.setInt(1, boardDTO.getReadCount()+1);
	  pstmt.setInt(2, boardDTO.getNo());
	  cnt = pstmt.executeUpdate();
	  return cnt;
  }
   @Override
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