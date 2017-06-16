package com.tustcs.matrix.entity;

import java.math.BigDecimal;

public class Homework {
    private Long homeworkId;

    private String homeworkCreatorId;

    private String homeworkCreateTime;

    private String homeworkEndTime;

    private BigDecimal homeworkScore;

<<<<<<< HEAD
    private Integer deleteFlag;

=======
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
    private String homeworkProblem;

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getHomeworkCreatorId() {
        return homeworkCreatorId;
    }

    public void setHomeworkCreatorId(String homeworkCreatorId) {
        this.homeworkCreatorId = homeworkCreatorId == null ? null : homeworkCreatorId.trim();
    }

    public String getHomeworkCreateTime() {
        return homeworkCreateTime;
    }

    public void setHomeworkCreateTime(String homeworkCreateTime) {
        this.homeworkCreateTime = homeworkCreateTime == null ? null : homeworkCreateTime.trim();
    }

    public String getHomeworkEndTime() {
        return homeworkEndTime;
    }

    public void setHomeworkEndTime(String homeworkEndTime) {
        this.homeworkEndTime = homeworkEndTime == null ? null : homeworkEndTime.trim();
    }

    public BigDecimal getHomeworkScore() {
        return homeworkScore;
    }

    public void setHomeworkScore(BigDecimal homeworkScore) {
        this.homeworkScore = homeworkScore;
    }

<<<<<<< HEAD
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

=======
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
    public String getHomeworkProblem() {
        return homeworkProblem;
    }

    public void setHomeworkProblem(String homeworkProblem) {
        this.homeworkProblem = homeworkProblem == null ? null : homeworkProblem.trim();
    }
}