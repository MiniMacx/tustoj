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

    private Map<Integer,Short> problemScore;

    private Integer SumScore;

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

    public ContestSum(Integer contestId, String userId, ContestEnums contestEnums, Map<Integer,Short> problemScore, Integer sumScore, boolean isValid) {
        this.contestId = contestId;
        this.userId = userId;
        this.state = contestEnums.getState();
        this.stateInfo = contestEnums.getStateInfo();
        this.problemScore = problemScore;
        SumScore = sumScore;
        this.isValid = isValid;
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

    public Integer getSumScore() {
        return SumScore;
    }

    public void setSumScore(Integer sumScore) {
        SumScore = sumScore;
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean valid) {
        isValid = valid;
    }
}
