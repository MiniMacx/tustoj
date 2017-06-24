package com.tustcs.matrix.entity;

import java.math.BigDecimal;

public class Homework {
    private Integer homeworkId;

    private String homeworkCreatorId;

    private String homeworkCreateTime;

    private String homeworkEndTime;

    private Double homeworkScore;

    private Integer deleteFlag;

    private String homeworkProblem;

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
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

    public Double getHomeworkScore() {
        return homeworkScore;
    }

    public void setHomeworkScore(Double homeworkScore) {
        this.homeworkScore = homeworkScore;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getHomeworkProblem() {
        return homeworkProblem;
    }

    public void setHomeworkProblem(String homeworkProblem) {
        this.homeworkProblem = homeworkProblem == null ? null : homeworkProblem.trim();
    }

    public Homework(Integer homeworkId, String homeworkCreatorId, String homeworkCreateTime, String homeworkEndTime,
                    Double homeworkScore, Integer deleteFlag, String homeworkProblem) {
        this.homeworkId = homeworkId;
        this.homeworkCreatorId = homeworkCreatorId;
        this.homeworkCreateTime = homeworkCreateTime;
        this.homeworkEndTime = homeworkEndTime;
        this.homeworkScore = homeworkScore;
        this.deleteFlag = deleteFlag;
        this.homeworkProblem = homeworkProblem;
    }

    public Homework(String homeworkCreatorId, String homeworkCreateTime, String homeworkEndTime,
                    Double homeworkScore, Integer deleteFlag, String homeworkProblem) {
        this.homeworkCreatorId = homeworkCreatorId;
        this.homeworkCreateTime = homeworkCreateTime;
        this.homeworkEndTime = homeworkEndTime;
        this.homeworkScore = homeworkScore;
        this.deleteFlag = deleteFlag;
        this.homeworkProblem = homeworkProblem;
    }

    public Homework() {
    }
}