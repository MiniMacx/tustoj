package com.tustcs.matrix.oj.entity;

public class CustomInput {
    private Integer solutionId;

    private String inputText;

    public Integer getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Integer solutionId) {
        this.solutionId = solutionId;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText == null ? null : inputText.trim();
    }
}