package kr.co.mk.vo;

import java.util.Date;

public class ReplyListVo {
	
	private int gdsNum,repNum;
	private String useId,repCon,userName;
	private Date repDate;
	public int getGdsNum() {
		return gdsNum;
	}
	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}
	public int getRepNum() {
		return repNum;
	}
	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}
	public String getUseId() {
		return useId;
	}
	public void setUseId(String useId) {
		this.useId = useId;
	}
	public String getRepCon() {
		return repCon;
	}
	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getRepDate() {
		return repDate;
	}
	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}
	
	@Override
	public String toString() {
		return "ReplyListVo [gdsNum=" + gdsNum + ", repNum=" + repNum + ", useId=" + useId + ", repCon=" + repCon
				+ ", userName=" + userName + ", repDate=" + repDate + "]";
	}
	
	
	
}
