package com.lvg.order.pojo;

import com.lvg.pojo.TbOrder;

public class TbOrderChild extends TbOrder{
	private String title;
	private String restype;
	private String type;
	private int room;
	private int bedNum;
	private int price;
	private String[] images;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRestype() {
		return restype;
	}
	public void setRestype(String restype) {
		this.restype = restype;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getBedNum() {
		return bedNum;
	}
	public void setBedNum(int bedNum) {
		this.bedNum = bedNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
}
