package com.lvg.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbOrderEval implements Serializable{
    private Long id;

    private Long orderId;

    private Long userId;

    private String content;

    private String image;

    private String video;

    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}