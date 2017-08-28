package com.tustcs.matrix.dto;

import com.tustcs.matrix.entity.Contest;

/**
 * Created by polykickshaw on 17-8-6.
 */
public class ContestProblemDTO{
    private int problemId;
    private String title;
    private short result;
    private int submit=0;

    public short getResult() {
        return result;
    }

    public void setResult(short result) {
        this.result = result;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSubmit() {
        return submit;
    }

    public void setSubmit(int submit) {
        this.submit = submit;
    }
}
