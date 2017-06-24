package com.tustcs.matrix.entity;

import java.util.Date;

public class Contest {
    private Integer contestId;

    private String title;

    private Date startTime;

    private Date endTime;

    private String defunct;

    private Byte privateFlag;

    private Integer langmask;

    private String password;

    private Integer deleteFlag;

    private String description;

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDefunct() {
        return defunct;
    }

    public void setDefunct(String defunct) {
        this.defunct = defunct == null ? null : defunct.trim();
    }

    public Byte getPrivateFlag() {
        return privateFlag;
    }

    public void setPrivateFlag(Byte privateFlag) {
        this.privateFlag = privateFlag;
    }

    public Integer getLangmask() {
        return langmask;
    }

    public void setLangmask(Integer langmask) {
        this.langmask = langmask;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Contest(Integer contestId, String title, Date startTime, Date endTime, String defunct,
                   Byte privateFlag, Integer langmask, String password, Integer deleteFlag, String description) {
        this.contestId = contestId;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.defunct = defunct;
        this.privateFlag = privateFlag;
        this.langmask = langmask;
        this.password = password;
        this.deleteFlag = deleteFlag;
        this.description = description;
    }

    public Contest(String title, Date startTime, Date endTime, String defunct, Byte privateFlag,
                   Integer langmask, String password, Integer deleteFlag, String description) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.defunct = defunct;
        this.privateFlag = privateFlag;
        this.langmask = langmask;
        this.password = password;
        this.deleteFlag = deleteFlag;
        this.description = description;
    }

    public Contest() {
    }
}