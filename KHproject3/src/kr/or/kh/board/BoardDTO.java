package kr.or.kh.board;

import java.io.Serializable;

public class BoardDTO implements Serializable {

	private int no;
	private String title;
	private String content;
	private String author;
	private String nal;
	private int readCount;
	
	
	
	
	
	public BoardDTO(int no, String title, String content, String author, String nal, int readCount) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.author = author;
		this.nal = nal;
		this.readCount = readCount;
	}





	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}





	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", title=" + title + ", content=" + content + ", author=" + author + ", nal="
				+ nal + ", readCount=" + readCount + "]";
	}





	public int getNo() {
		return no;
	}





	public void setNo(int no) {
		this.no = no;
	}





	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getContent() {
		return content;
	}





	public void setContent(String content) {
		this.content = content;
	}





	public String getAuthor() {
		return author;
	}





	public void setAuthor(String author) {
		this.author = author;
	}





	public String getNal() {
		return nal;
	}





	public void setNal(String nal) {
		this.nal = nal;
	}





	public int getReadCount() {
		return readCount;
	}





	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	
	
	
	
}



