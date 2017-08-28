package com.tustcs.matrix.dao;

import com.tustcs.matrix.dto.HomeworkProblemDTO;
import com.tustcs.matrix.entity.HomeworkProblem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeworkProblemMapper {
    int insert(@Param("homeworkId") Integer homeworkId,@Param("problemId") Integer problemId);

    int insertSelective(HomeworkProblem record);

    int delete(Integer homeworkId);

    List<HomeworkProblemDTO> selectHomeworkProblem(Integer homeworkId);
}