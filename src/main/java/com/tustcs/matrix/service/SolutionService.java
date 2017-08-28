package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.Solution;

import java.util.List;

/**
 * Created by polykickshaw on 17-6-6.
 */
public interface SolutionService {
    List<Solution> showSolutionByUserId(Integer pageNow, String userId);

    List<Solution> showSolutionByProblemId(Integer pageNow,String userId,Integer problemId);

    boolean addSolution(Solution solution);

    boolean updateSolution(Solution solution);

    boolean deleteSolution(Integer solutionId);

    Solution getSolution(Integer solutionId);

    boolean submitSourceCode(Integer solutionId,String source);
}
