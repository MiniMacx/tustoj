package com.tustcs.matrix.dto;

import com.tustcs.matrix.entity.Homework;

/**
 * Created by polykickshaw on 17-8-13.
 */
public class HomeworkProblemDTO {
    private int problemId;
    private String title;
    private short result;

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

    public short getResult() {
        return result;
    }

    public void setResult(short result) {
        this.result = result;
    }

    public HomeworkProblemDTO(int problemId, String title, short result) {
        this.problemId = problemId;
        this.title = title;
        this.result = result;
    }

    public HomeworkProblemDTO() {
    }
}
