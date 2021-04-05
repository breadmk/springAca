package kr.co.bread.dto;


public class BoardDTO {
	
	private int no;
	private String name;
	private String content;
	private String writedate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", name=" + name + ", content=" + content + ", writedate=" + writedate + "]";
	}
	
	
}
