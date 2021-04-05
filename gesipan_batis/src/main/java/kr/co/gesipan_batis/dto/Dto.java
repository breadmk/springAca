package kr.co.gesipan_batis.dto;

public class Dto {
	
	private int id,hit;
	private String content,pwd,sung,kind,email,writeday,title,email2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSung() {
		return sung;
	}
	public void setSung(String sung) {
		this.sung = sung;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	
	@Override
	public String toString() {
		return "Dto [id=" + id + ", hit=" + hit + ", content=" + content + ", pwd=" + pwd + ", sung=" + sung + ", kind="
				+ kind + ", email=" + email + ", writeday=" + writeday + ", title=" + title + ", email2=" + email2
				+ "]";
	}
	
	
}
