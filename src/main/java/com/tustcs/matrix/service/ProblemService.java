package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.ProblemWithBLOBs;

import java.util.Date;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-9.
 */
public interface ProblemService {
    List<ProblemWithBLOBs> showProblem(Integer pageNow);

    List<ProblemWithBLOBs> showProblemById(Integer pageNow,Integer problemId);

    List<ProblemWithBLOBs> showProblemByTitle(Integer pageNow, String title);

    ProblemWithBLOBs getProblem(Integer problemId);

    boolean addProblem(ProblemWithBLOBs problem);

    boolean deleteProblem(Integer problemId);

    boolean updateProblem(ProblemWithBLOBs problem);

}
