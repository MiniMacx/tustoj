package com.tustcs.matrix.entity;

public class Token {
    private Integer recId;

    private String userId;

    private String token;

    private String createTime;

    private String expireTime;

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime == null ? null : expireTime.trim();
    }

    public Token(Integer recId, String userId, String token, String createTime, String expireTime) {
        this.recId = recId;
        this.userId = userId;
        this.token = token;
        this.createTime = createTime;
        this.expireTime = expireTime;
    }

    public Token(String userId, String token, String createTime, String expireTime) {
        this.userId = userId;
        this.token = token;
        this.createTime = createTime;
        this.expireTime = expireTime;
    }

    public Token() {
    }
}