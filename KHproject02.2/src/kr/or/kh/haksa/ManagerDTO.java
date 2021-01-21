package kr.or.kh.haksa;

import java.io.Serializable;

public class ManagerDTO extends HaksaDTO implements Serializable, IManagerDTO {
	
	private String part;

	public ManagerDTO() {
		super();
		}

	public ManagerDTO(int no, String nai, String irum, String part) {
		super(no, nai, irum);
		this.part = part;
	}
	
	@Override
	public String getPart() {
		return part;
	}
	
	@Override
	public void setPart(String part) {
		this.part = part;
	}
	
	@Override
	public String toString() {
		return super.toString() + "ManagerDTO [part=" + part + "]";
	}

	
	
}
