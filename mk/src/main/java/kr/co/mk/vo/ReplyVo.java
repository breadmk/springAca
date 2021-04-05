package kr.co.mk.vo;

import java.util.Date;

public class ReplyVo {
	
	private int gdsNum,repNum;
	private String userId,repCon;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRepCon() {
		return repCon;
	}
	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}
	public Date getRepDate() {
		return repDate;
	}
	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}
	@Override
	public String toString() {
		return "ReplyVo [gdsNum=" + gdsNum + ", repNum=" + repNum + ", userId=" + userId + ", repCon=" + repCon
				+ ", repDate=" + repDate + "]";
	}
	
	
	
}
