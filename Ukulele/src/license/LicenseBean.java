package license;

public class LicenseBean {
	private String name;
	private String tel;
	private String license_email;
	private String license_id;
	private String addr;
	private String birth;
	private String grade;
	private String date;
	private int apply_no;
	private int trackingProgress;
	
	
	public int getTrackingProgress() {
		return trackingProgress;
	}
	public void setTrackingProgress(int trackingProgress) {
		this.trackingProgress = trackingProgress;
	}
	public String getDate() {
		return date;
	}
	@Override
	public String toString() {
		return "LicenseBean [name=" + name + ", tel=" + tel + ", license_email=" + license_email + ", license_id="
				+ license_id + ", addr=" + addr + ", birth=" + birth + ", grade=" + grade + ", date=" + date
				+ ", apply_no=" + apply_no + ", trackingProgress=" + trackingProgress + "]";
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGrade() {
		return grade;
	}
	public int getApply_no() {
		return apply_no;
	}
	public void setApply_no(int apply_no) {
		this.apply_no = apply_no;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLicense_email() {
		return license_email;
	}
	public void setLicense_email(String license_email) {
		this.license_email = license_email;
	}
	public String getLicense_id() {
		return license_id;
	}
	public void setLicense_id(String license_id) {
		this.license_id = license_id;
	}
}
