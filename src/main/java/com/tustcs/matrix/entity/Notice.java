package com.tustcs.matrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"deleteFlag","weight"})
public class Notice {
    private Integer noticeId;

    private Integer deleteFlag;

    private Integer isShow;

    private Integer weight;

    private String noticeContent;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public Notice(Integer noticeId, Integer deleteFlag, Integer isShow, Integer weight, String noticeContent) {
        this.noticeId = noticeId;
        this.deleteFlag = deleteFlag;
        this.isShow = isShow;
        this.weight = weight;
        this.noticeContent = noticeContent;
    }

    public Notice(Integer deleteFlag, Integer isShow, Integer weight, String noticeContent) {
        this.deleteFlag = deleteFlag;
        this.isShow = isShow;
        this.weight = weight;
        this.noticeContent = noticeContent;
    }

    public Notice() {
    }
}