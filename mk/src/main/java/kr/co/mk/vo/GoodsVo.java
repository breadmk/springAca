package kr.co.mk.vo;

import java.util.Date;

public class GoodsVo {
	
	private int gdsNum, gdsPrice, gdsStock;
	private String gdsName, gdsDes, gdsImg, cateCode;
	private Date gdsDate;
	private String gdsThumbImg;
	
	public String getGdsThumbImg() {
		return gdsThumbImg;
	}
	public void setGdsThumbImg(String gdsThumbImg) {
		this.gdsThumbImg = gdsThumbImg;
	}
	public int getGdsNum() {
		return gdsNum;
	}
	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}
	public int getGdsPrice() {
		return gdsPrice;
	}
	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}
	public int getGdsStock() {
		return gdsStock;
	}
	public void setGdsStock(int gdsStock) {
		this.gdsStock = gdsStock;
	}
	public String getGdsName() {
		return gdsName;
	}
	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}
	public String getGdsDes() {
		return gdsDes;
	}
	public void setGdsDes(String gdsDes) {
		this.gdsDes = gdsDes;
	}
	public String getGdsImg() {
		return gdsImg;
	}
	public void setGdsImg(String gdsImg) {
		this.gdsImg = gdsImg;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public Date getGdsDate() {
		return gdsDate;
	}
	public void setGdsDate(Date gdsDate) {
		this.gdsDate = gdsDate;
	}
	
	@Override
	public String toString() {
		return "GoodsVo [gdsNum=" + gdsNum + ", gdsPrice=" + gdsPrice + ", gdsStock=" + gdsStock + ", gdsName="
				+ gdsName + ", gdsDes=" + gdsDes + ", gdsImg=" + gdsImg + ", cateCode=" + cateCode + ", gdsDate="
				+ gdsDate + ", gdsThumbImg=" + gdsThumbImg + "]";
	}
	
	
	
	
}
