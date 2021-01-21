package kr.or.kh;

import java.io.Serializable;

public class LoginBean implements Serializable {
	
	
	private String userid;
	private String passwd;
	
	
	
	
	
	
	
	
	public LoginBean(String userid, String passwd) {
		super();
		this.userid = userid;
		this.passwd = passwd;
	}



	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "LoginBean [userid=" + userid + ", passwd=" + passwd + "]";
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getPasswd() {
		return passwd;
	}



	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	

}
