package com.lvg.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbOrder implements Serializable{
    private Long id;

    private Long cusId;

    private Long itemId;

    private Date intime;

    private Date outtime;

    private Integer night;

    private Integer total;

    private Integer discount;

    private Integer coupons;

    private Integer payment;

    private Byte status;

    private String cusName;

    private String cusPhone;

    private Integer point;

    private Date created;

    private Date updated;

    private Long hostId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public Integer getNight() {
        return night;
    }

    public void setNight(Integer night) {
        this.night = night;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getCoupons() {
        return coupons;
    }

    public void setCoupons(Integer coupons) {
        this.coupons = coupons;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone == null ? null : cusPhone.trim();
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
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

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }
}