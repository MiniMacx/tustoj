package com.tustcs.matrix.service;

import com.tustcs.matrix.dto.ContestSum;
import com.tustcs.matrix.dto.Exposer;
import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.entity.Problem;

import java.util.List;

/**
 * Created by polykickshaw on 17-6-9.
 */
public interface ContestService {
    List<Contest> showContest(Integer pageNow);

    List<Contest> showContestByTitle(Integer pageNow, String title);

    Contest getContest(Integer contestId);

    boolean addContest(Contest contest);

    boolean deleteContest(Integer contestId);

    boolean updateContest(Contest contest);

    boolean enrollContest(String userId, Integer contestId);

    Exposer exportContestUrl(Integer contestId);

    List<Problem> getContestProblem(Integer contestId);

    ContestSum execution(Integer contestId,String userId,String md5);

}

