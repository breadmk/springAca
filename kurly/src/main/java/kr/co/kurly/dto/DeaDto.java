package kr.co.kurly.dto;

public class DeaDto {
	
	private int id;
	private String code,title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "DeaDto [id=" + id + ", code=" + code + ", title=" + title + "]";
	}
	
	
	
}
