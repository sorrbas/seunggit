package kr.or.kh.haksa;

public abstract class HaksaDTO {
	private int no;
	private String nai;
	private String irum;

	public HaksaDTO(int no, String nai, String irum) {
		super();
		this.no = no;
		this.nai = nai;
		this.irum = irum;
	}

	public HaksaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getNai() {
		return nai;
	}

	public void setNai(String nai) {
		this.nai = nai;
	}

	public String getIrum() {
		return irum;
	}

	public void setIrum(String irum) {
		this.irum = irum;
	}


	@Override
	public String toString() {
		return "HaksaDTO [no=" + no + ", nai=" + nai + ", irum=" + irum + "]";
	}

}
