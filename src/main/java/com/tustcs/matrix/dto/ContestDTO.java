package com.tustcs.matrix.dto;

import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.entity.ContestProblem;

import java.util.List;

/**
 * Created by polykickshaw on 17-7-30.
 */
public class ContestDTO extends Contest{
   private List<Integer> contestProblem;

    public List<Integer> getContestProblem() {
        return contestProblem;
    }

    public void setContestProblem(List<Integer> contestProblem) {
        this.contestProblem = contestProblem;
    }

    public ContestDTO() {
    }

    public ContestDTO(Contest contest, List<Integer> contestProblem) {
        this.contestId=contest.getContestId();
        this.defunct=contest.getDefunct();
        this.deleteFlag=contest.getDeleteFlag();
        this.description=contest.getDescription();
        this.enrollNum=contest.getEnrollNum();
        this.endTime=contest.getEndTime();
        this.startTime=contest.getStartTime();
        this.langmask=contest.getLangmask();
        this.password=contest.getPassword();
        this.privateFlag=contest.getPrivateFlag();
        this.title=contest.getTitle();
        this.contestProblem = contestProblem;
    }
}
