package com.lvg.pojo;


import java.io.Serializable;
import java.util.Date;

public class TbGroupItem implements Serializable{
    private Long id;

    private Long groupId;

    private String title;

    private Integer price;

    private Integer discount;

    private String image;

    private Byte status;

    private Integer people;

    private Integer evaluation;

    private String type;

    private Integer room;

    private String beds;

    private Integer toilet;

    private String infrast;

    private String safefaci;

    private Date created;

    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Integer getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds == null ? null : beds.trim();
    }

    public Integer getToilet() {
        return toilet;
    }

    public void setToilet(Integer toilet) {
        this.toilet = toilet;
    }

    public String getInfrast() {
        return infrast;
    }

    public void setInfrast(String infrast) {
        this.infrast = infrast == null ? null : infrast.trim();
    }

    public String getSafefaci() {
        return safefaci;
    }

    public void setSafefaci(String safefaci) {
        this.safefaci = safefaci == null ? null : safefaci.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}