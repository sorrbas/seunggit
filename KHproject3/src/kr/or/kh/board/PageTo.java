package kr.or.kh.board;

import java.io.Serializable;
import java.util.ArrayList;

public class PageTo implements Serializable {

	private ArrayList<BoardDTO> list;   //목록리스트를 저장한다
	private int cursorPage; // 현재페이지번호
	private int perPage; //페이지 당 보여줄 레코드 갯수
	private int totalCount; //전체 레코드 갯수 ( 전체의 행이 몇개냐 )
	
	
	
	public PageTo(ArrayList<BoardDTO> list, int cursorPage, int perPage, int totalCount) {
		super();
		this.list = list;
		this.cursorPage = cursorPage;
		this.perPage = perPage;
		this.totalCount = totalCount;
	}
	
	public PageTo() {
		this.perPage=5;
		
	}

	@Override
	public String toString() {
		return "PageTo [list=" + list + ", cursorPage=" + cursorPage + ", perPage=" + perPage + ", totalCount="
				+ totalCount + "]";
	}




	public ArrayList<BoardDTO> getList() {
		return list;
	}




	public void setList(ArrayList<BoardDTO> list) {
		this.list = list;
	}




	public int getCursorPage() {
		return cursorPage;
	}




	public void setCursorPage(int cursorPage) {
		this.cursorPage = cursorPage;
	}




	public int getPerPage() {
		return perPage;
	}




	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}




	public int getTotalCount() {
		return totalCount;
	}




	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
	
}
