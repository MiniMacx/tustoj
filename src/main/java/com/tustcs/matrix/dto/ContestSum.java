package com.tustcs.matrix.dto;

import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.enums.ContestEnums;

import java.util.List;
import java.util.Map;

/**
 * Created by polykickshaw on 17-7-19.
 */
public class ContestSum {
    private Integer contestId;

    private String userId;

    private int state;

    private String stateInfo;

    private List<ContestProblemDTO> problemList;

    private Integer sumScore;

    private boolean isValid;

    public ContestSum() {
    }

    public ContestSum(Integer contestId, String userId, ContestEnums contestEnums, boolean isValid) {
        this.contestId = contestId;
        this.userId = userId;
        this.state = contestEnums.getState();
        this.stateInfo = contestEnums.getStateInfo();
        this.isValid = isValid;
    }

    public ContestSum(Integer contestId, String userId, ContestEnums contestEnums, List<ContestProblemDTO> problemScore, Integer sumScore, boolean isValid) {
        this.contestId = contestId;
        this.userId = userId;
        this.state = contestEnums.getState();
        this.stateInfo = contestEnums.getStateInfo();
        this.problemList = problemScore;
        this.sumScore = sumScore;
        this.isValid = isValid;
    }

    public Integer getSumScore() {
        return sumScore;
    }

    public void setSumScore(Integer sumScore) {
        this.sumScore = sumScore;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<ContestProblemDTO> getProblemList() {
        return problemList;
    }

    public void setProblemList(List<ContestProblemDTO> problemList) {
        this.problemList = problemList;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }


    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean valid) {
        isValid = valid;
    }
}
