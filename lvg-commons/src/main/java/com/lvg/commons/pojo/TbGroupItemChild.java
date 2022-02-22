package com.lvg.commons.pojo;

import com.lvg.pojo.TbGroupItem;

public class TbGroupItemChild extends TbGroupItem{
	private String[] images;
	private long hostId;
	private String hostImage;
	private boolean collect;
	private int bedNum;
	private String restype;
    private String province;
    private String city;
    private String adress;
    private String introduce;
    private String[] infrastArra;
    private String[] safefaciArra;
    private String[] supfaciArra;
    private String[] bedsArra;
    
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
	public long getHostId() {
		return hostId;
	}
	public void setHostId(long hostId) {
		this.hostId = hostId;
	}
	public String getHostImage() {
		return hostImage;
	}
	public void setHostImage(String hostImage) {
		this.hostImage = hostImage;
	}
	public boolean isCollect() {
		return collect;
	}
	public void setCollect(boolean collect) {
		this.collect = collect;
	}
	public int getBedNum() {
		return bedNum;
	}
	public void setBedNum(int bedNum) {
		this.bedNum = bedNum;
	}
	public String getRestype() {
		return restype;
	}
	public void setRestype(String restype) {
		this.restype = restype;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String[] getInfrastArra() {
		return infrastArra;
	}
	public void setInfrastArra(String[] infrastArra) {
		this.infrastArra = infrastArra;
	}
	public String[] getSafefaciArra() {
		return safefaciArra;
	}
	public void setSafefaciArra(String[] safefaciArra) {
		this.safefaciArra = safefaciArra;
	}
	public String[] getSupfaciArra() {
		return supfaciArra;
	}
	public void setSupfaciArra(String[] supfaciArra) {
		this.supfaciArra = supfaciArra;
	}
	public String[] getBedsArra() {
		return bedsArra;
	}
	public void setBedsArra(String[] bedsArra) {
		this.bedsArra = bedsArra;
	}
}
