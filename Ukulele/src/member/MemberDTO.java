package member;

import java.io.Serializable;

public class MemberDTO implements Serializable {

	private String id;
	private String pw;
	private String email;
	
	
	
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MemberDTO(String id, String pw, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.email = email;
	}



	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", email=" + email + "]";
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
