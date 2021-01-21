package kr.or.kh.member;

import java.io.Serializable;

public class MemberDTO implements Serializable {

	
	private String id;
	private String pw;
	private String addr;
	private String tel;
	
	
	
	
	
	public MemberDTO(String id, String pw, String addr, String tel) {
		super();
		this.id = id;
		this.pw = pw;
		this.addr = addr;
		this.tel = tel;
	}





	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}





	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", addr=" + addr + ", tel=" + tel + "]";
	}





	public String getId() {
		return id;
	}





	public void setId(String id) {
		this.id = id;
	}





	public String getPw() {
		return pw;
	}





	public void setPw(String pw) {
		this.pw = pw;
	}





	public String getAddr() {
		return addr;
	}





	public void setAddr(String addr) {
		this.addr = addr;
	}





	public String getTel() {
		return tel;
	}





	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
	
	
	
}
