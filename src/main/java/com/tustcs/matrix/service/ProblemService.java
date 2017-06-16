package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.ProblemWithBLOBs;

import java.util.List;

/**
 * Created by polykickshaw on 17-6-9.
 */
public interface ProblemService {
    List<ProblemWithBLOBs> showProblem(Integer pageNow);

    List<ProblemWithBLOBs> showProblemByTitle(Integer pageNow, String title);
}
