package com.lvg.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbGroup implements Serializable{
    private Long id;

    private Long hostId;

    private String title;

    private String province;

    private String city;

    private String adress;

    private String restype;

    private String image;

    private String introduce;

    private String deline;

    private String earliest;

    private String latest;

    private String checkout;

    private String supfaci;

    private String rules;

    private Date created;

    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getRestype() {
        return restype;
    }

    public void setRestype(String restype) {
        this.restype = restype == null ? null : restype.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getDeline() {
        return deline;
    }

    public void setDeline(String deline) {
        this.deline = deline == null ? null : deline.trim();
    }

    public String getEarliest() {
        return earliest;
    }

    public void setEarliest(String earliest) {
        this.earliest = earliest == null ? null : earliest.trim();
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest == null ? null : latest.trim();
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout == null ? null : checkout.trim();
    }

    public String getSupfaci() {
        return supfaci;
    }

    public void setSupfaci(String supfaci) {
        this.supfaci = supfaci == null ? null : supfaci.trim();
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules == null ? null : rules.trim();
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