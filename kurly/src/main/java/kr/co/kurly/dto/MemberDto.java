package kr.co.kurly.dto;

public class MemberDto {
	private int id,sung,state;
	private String userid,pwd,name,email,phone,zip,juso,juso_etc;
	private String birth,writeday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSung() {
		return sung;
	}
	public void setSung(int sung) {
		this.sung = sung;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getJuso() {
		return juso;
	}
	public void setJuso(String juso) {
		this.juso = juso;
	}
	public String getJuso_etc() {
		return juso_etc;
	}
	public void setJuso_etc(String juso_etc) {
		this.juso_etc = juso_etc;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", sung=" + sung + ", state=" + state + ", userid=" + userid + ", pwd=" + pwd
				+ ", name=" + name + ", email=" + email + ", phone=" + phone + ", zip=" + zip + ", juso=" + juso
				+ ", juso_etc=" + juso_etc + ", birth=" + birth + ", writeday=" + writeday + "]";
	}
	
	
	
	
}
