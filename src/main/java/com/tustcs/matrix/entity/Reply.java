package com.tustcs.matrix.entity;

import java.util.Date;

public class Reply {
    private Integer rid;

    private String authorId;

    private Date time;

    private Integer topicId;

    private Integer status;

    private String ip;

    private Integer voteUp;

    private Integer voteDown;

    private Integer deleteFlag;

    private String content;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getVoteUp() {
        return voteUp;
    }

    public void setVoteUp(Integer voteUp) {
        this.voteUp = voteUp;
    }

    public Integer getVoteDown() {
        return voteDown;
    }

    public void setVoteDown(Integer voteDown) {
        this.voteDown = voteDown;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Reply(Integer rid, String authorId, Date time, Integer topicId, Integer status, String ip,
                 Integer voteUp, Integer voteDown, Integer deleteFlag, String content) {
        this.rid = rid;
        this.authorId = authorId;
        this.time = time;
        this.topicId = topicId;
        this.status = status;
        this.ip = ip;
        this.voteUp = voteUp;
        this.voteDown = voteDown;
        this.deleteFlag = deleteFlag;
        this.content = content;
    }

    public Reply(String authorId, Date time, Integer topicId, Integer status, String ip,
                 Integer voteUp, Integer voteDown, Integer deleteFlag, String content) {
        this.authorId = authorId;
        this.time = time;
        this.topicId = topicId;
        this.status = status;
        this.ip = ip;
        this.voteUp = voteUp;
        this.voteDown = voteDown;
        this.deleteFlag = deleteFlag;
        this.content = content;
    }

    public Reply() {
    }
}