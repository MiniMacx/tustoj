package com.tustcs.matrix.entity;

public class UserHomework {
    private Integer id;

    private String userId;

    private Integer homeworkId;

    public UserHomework() {
    }

    public UserHomework(String userId, Integer homeworkId) {
        this.userId = userId;
        this.homeworkId = homeworkId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }
}