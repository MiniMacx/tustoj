package com.tustcs.matrix.entity;

public class Topic {
    private Integer tid;

    private Integer status;

    private Integer topLevel;

    private Integer cid;

    private Integer pid;

    private String authorId;

    private String time;

    private Integer deleteFlag;

    private byte[] title;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTopLevel() {
        return topLevel;
    }

    public void setTopLevel(Integer topLevel) {
        this.topLevel = topLevel;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public byte[] getTitle() {
        return title;
    }

    public void setTitle(byte[] title) {
        this.title = title;
    }

    public Topic(Integer tid, Integer status, Integer topLevel, Integer cid, Integer pid, String authorId,
                 String time, Integer deleteFlag, byte[] title) {
        this.tid = tid;
        this.status = status;
        this.topLevel = topLevel;
        this.cid = cid;
        this.pid = pid;
        this.authorId = authorId;
        this.time = time;
        this.deleteFlag = deleteFlag;
        this.title = title;
    }

    public Topic(Integer status, Integer topLevel, Integer cid,
                 Integer pid, String authorId, String time, Integer deleteFlag, byte[] title) {
        this.status = status;
        this.topLevel = topLevel;
        this.cid = cid;
        this.pid = pid;
        this.authorId = authorId;
        this.time = time;
        this.deleteFlag = deleteFlag;
        this.title = title;
    }

    public Topic() {
    }
}