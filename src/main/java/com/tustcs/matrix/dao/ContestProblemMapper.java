package com.tustcs.matrix.dao;

import com.tustcs.matrix.dto.ContestProblemDTO;
import com.tustcs.matrix.entity.ContestProblem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContestProblemMapper {
    int insert(@Param("contestId") Integer contestId,@Param("problemId") Integer problemId
            ,@Param("num")Integer num);

    int insertSelective(ContestProblem record);

    List<ContestProblem> selectProblem(Integer contestId);

    List<Integer> selectProblemId(Integer contestId);

    List<ContestProblemDTO> selectProblemsForContest(Integer contestId);
}