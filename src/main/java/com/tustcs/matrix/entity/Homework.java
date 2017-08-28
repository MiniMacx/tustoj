package com.tustcs.matrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties({"deleteFlag","homeworkScore"})
public class Homework {
    protected Integer homeworkId;

    protected String homeworkCreatorId;

    protected String homeworkCreateTime;

    protected String homeworkEndTime;

    protected Double homeworkScore;

    protected Integer deleteFlag;


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


    public Homework() {
    }


}