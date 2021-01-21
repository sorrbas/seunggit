package kr.or.kh.board;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBoard {
	
	public abstract int boardWrite(BoardDTO boardDTO) throws SQLException;
	 public abstract int totalCount();
	 public abstract PageTo page(int cursorPage);
	 public abstract int boardDelete(int no) throws SQLException;
	 public abstract BoardDTO boardSearch(String titleSearch) throws SQLException;
	 public abstract int boardReadCount(BoardDTO boardDTO)throws SQLException;
	 public abstract int boardUpdateFinal(BoardDTO boardDTO,String titleUpSearch)throws SQLException;
	 public abstract ArrayList<BoardDTO> boardList() throws SQLException;
	
	 
	 //abstract는 클래스의 메소드를 하위클래스가 반드시 오버라이드 하도록 하는 것 
	 //abstract는 추상을 표현하는 것이니 추상클래스를 쓴다는 의미로 사용을 해줌 

}
