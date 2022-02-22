package com.lvg.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbUgcEval implements Serializable{
    private Long id;

    private Long reviewerId;

    private Long ugcId;

    private Long ugcevalId;

    private String content;

    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Long getUgcId() {
        return ugcId;
    }

    public void setUgcId(Long ugcId) {
        this.ugcId = ugcId;
    }

    public Long getUgcevalId() {
        return ugcevalId;
    }

    public void setUgcevalId(Long ugcevalId) {
        this.ugcevalId = ugcevalId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}