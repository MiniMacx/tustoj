package com.tustcs.matrix.entity;

import java.util.Date;

public class ProblemWithBLOBs extends Problem {
    private String description;

    private String input;

    private String output;

    private String sampleInput;

    private String sampleOutput;

    private String hint;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input == null ? null : input.trim();
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output == null ? null : output.trim();
    }

    public String getSampleInput() {
        return sampleInput;
    }

    public void setSampleInput(String sampleInput) {
        this.sampleInput = sampleInput == null ? null : sampleInput.trim();
    }

    public String getSampleOutput() {
        return sampleOutput;
    }

    public void setSampleOutput(String sampleOutput) {
        this.sampleOutput = sampleOutput == null ? null : sampleOutput.trim();
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint == null ? null : hint.trim();
    }

    public ProblemWithBLOBs(Integer problemId, String title, String spj, String source, Date inDate, Integer timeLimit, Integer memoryLimit, String defunct,
                            Integer accepted, Integer submit, Integer solved, Integer deleteFlag, String description, String input,
                            String output, String sampleInput, String sampleOutput, String hint) {
        super(problemId, title, spj, source, inDate, timeLimit, memoryLimit, defunct, accepted, submit, solved, deleteFlag);
        this.description = description;
        this.input = input;
        this.output = output;
        this.sampleInput = sampleInput;
        this.sampleOutput = sampleOutput;
        this.hint = hint;
    }

    public ProblemWithBLOBs(String title, String spj, String source, Date inDate, Integer timeLimit,
                            Integer memoryLimit, String defunct, Integer accepted, Integer submit, Integer solved, Integer deleteFlag, String description, String input, String output, String sampleInput, String sampleOutput, String hint) {
        super(title, spj, source, inDate, timeLimit, memoryLimit, defunct, accepted, submit, solved, deleteFlag);
        this.description = description;
        this.input = input;
        this.output = output;
        this.sampleInput = sampleInput;
        this.sampleOutput = sampleOutput;
        this.hint = hint;
    }

    public ProblemWithBLOBs(String description, String input, String output, String sampleInput,
                            String sampleOutput, String hint) {
        this.description = description;
        this.input = input;
        this.output = output;
        this.sampleInput = sampleInput;
        this.sampleOutput = sampleOutput;
        this.hint = hint;
    }

    public ProblemWithBLOBs() {
    }
}