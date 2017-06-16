package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.Contest;

import java.util.List;

/**
 * Created by polykickshaw on 17-6-9.
 */
public interface ContestService {
    List<Contest> showContest(Integer pageNow);

    List<Contest> showContestByTitle(Integer pageNow,String title);
}
