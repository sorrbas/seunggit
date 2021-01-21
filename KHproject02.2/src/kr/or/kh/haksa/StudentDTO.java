package kr.or.kh.haksa;

import java.io.Serializable;

public class StudentDTO extends HaksaDTO implements Serializable, IStudentDTO {
	private String hakbun;

	public StudentDTO() {
		super();
		}

	public StudentDTO(int no, String nai, String irum, String hakbun) {
		super(no, nai, irum);
		this.hakbun = hakbun;
	}

	@Override
	public String getHakbun() {
		return hakbun;
	}

	@Override
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	
	@Override
	public String toString() {
		return super.toString() + "StudentDTO [hakbun=" + hakbun + "]";
	}
}
