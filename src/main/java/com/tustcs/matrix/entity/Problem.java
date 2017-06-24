package com.tustcs.matrix.entity;

import java.util.Date;

public class Problem {
    private Integer problemId;

    private String title;

    private String spj;

    private String source;

    private Date inDate;

    private Integer timeLimit;

    private Integer memoryLimit;

    private String defunct;

    private Integer accepted;

    private Integer submit;

    private Integer solved;

    private Integer deleteFlag;

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSpj() {
        return spj;
    }

    public void setSpj(String spj) {
        this.spj = spj == null ? null : spj.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(Integer memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public String getDefunct() {
        return defunct;
    }

    public void setDefunct(String defunct) {
        this.defunct = defunct == null ? null : defunct.trim();
    }

    public Integer getAccepted() {
        return accepted;
    }

    public void setAccepted(Integer accepted) {
        this.accepted = accepted;
    }

    public Integer getSubmit() {
        return submit;
    }

    public void setSubmit(Integer submit) {
        this.submit = submit;
    }

    public Integer getSolved() {
        return solved;
    }

    public void setSolved(Integer solved) {
        this.solved = solved;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Problem(Integer problemId, String title, String spj, String source, Date inDate, Integer timeLimit, Integer memoryLimit,
                   String defunct, Integer accepted, Integer submit, Integer solved, Integer deleteFlag) {
        this.problemId = problemId;
        this.title = title;
        this.spj = spj;
        this.source = source;
        this.inDate = inDate;
        this.timeLimit = timeLimit;
        this.memoryLimit = memoryLimit;
        this.defunct = defunct;
        this.accepted = accepted;
        this.submit = submit;
        this.solved = solved;
        this.deleteFlag = deleteFlag;
    }

    public Problem(String title, String spj, String source, Date inDate, Integer timeLimit, Integer memoryLimit, String defunct,
                   Integer accepted, Integer submit, Integer solved, Integer deleteFlag) {
        this.title = title;
        this.spj = spj;
        this.source = source;
        this.inDate = inDate;
        this.timeLimit = timeLimit;
        this.memoryLimit = memoryLimit;
        this.defunct = defunct;
        this.accepted = accepted;
        this.submit = submit;
        this.solved = solved;
        this.deleteFlag = deleteFlag;
    }

    public Problem() {
    }
}