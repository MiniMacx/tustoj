package com.tustcs.matrix.entity;

public class News {
    private Integer newsId;

    private String title;

    private String picUrl;

    private String userId;

    private Integer isTop;

    private Integer isReport;

    private Integer deleteFlag;

    private Integer weight;

    private String addTime;

    private String content;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsReport() {
        return isReport;
    }

    public void setIsReport(Integer isReport) {
        this.isReport = isReport;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public News(Integer newsId, String title, String picUrl, String userId, Integer isTop, Integer isReport,
                Integer deleteFlag, Integer weight, String addTime, String content) {
        this.newsId = newsId;
        this.title = title;
        this.picUrl = picUrl;
        this.userId = userId;
        this.isTop = isTop;
        this.isReport = isReport;
        this.deleteFlag = deleteFlag;
        this.weight = weight;
        this.addTime = addTime;
        this.content = content;
    }

    public News(String title, String picUrl, String userId, Integer isTop, Integer isReport, Integer deleteFlag,
                Integer weight, String addTime, String content) {
        this.title = title;
        this.picUrl = picUrl;
        this.userId = userId;
        this.isTop = isTop;
        this.isReport = isReport;
        this.deleteFlag = deleteFlag;
        this.weight = weight;
        this.addTime = addTime;
        this.content = content;
    }

    public News() {
    }
}