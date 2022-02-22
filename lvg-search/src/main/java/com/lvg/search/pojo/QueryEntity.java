package com.lvg.search.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueryEntity {
	private String keywords;
	private int people;
	private long minprice;
	private long maxprice;
	private int room;
	private int beds;
	private int toilet;
	private String type;
	private String[] infrast;
	private String[] safefaci;
	private String[] supfaci;
	private String fieldname;
	@JsonProperty("desc")
	private boolean desc;
	
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public long getMinprice() {
		return minprice;
	}
	public void setMinprice(long minprice) {
		this.minprice = minprice;
	}
	public long getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(long maxprice) {
		this.maxprice = maxprice;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public int getToilet() {
		return toilet;
	}
	public void setToilet(int toilet) {
		this.toilet = toilet;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String[] getInfrast() {
		return infrast;
	}
	public void setInfrast(String[] infrast) {
		this.infrast = infrast;
	}
	public String[] getSafefaci() {
		return safefaci;
	}
	public void setSafefaci(String[] safefaci) {
		this.safefaci = safefaci;
	}
	public String[] getSupfaci() {
		return supfaci;
	}
	public void setSupfaci(String[] supfaci) {
		this.supfaci = supfaci;
	}
	public String getFieldname() {
		return fieldname;
	}
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}
	public boolean isDesc() {
		return desc;
	}
	public void setDesc(boolean desc) {
		this.desc = desc;
	}
}
