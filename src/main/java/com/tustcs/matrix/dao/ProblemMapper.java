package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Problem;
import com.tustcs.matrix.entity.ProblemWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProblemMapper {
    int deleteByPrimaryKey(Integer problemId);

    int insert(ProblemWithBLOBs record);

    int insertSelective(ProblemWithBLOBs record);

    ProblemWithBLOBs selectByPrimaryKey(Integer problemId);

    int updateByPrimaryKeySelective(ProblemWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProblemWithBLOBs record);

    int updateByPrimaryKey(Problem record);


    /**
     * 分页获取问题
     * @param startPos
     * @param pageSize
     * @return
     */
    List<ProblemWithBLOBs> selectProblemList(@Param("startPos") int startPos, @Param("pageSize") int pageSize);

    /**
     * 分页获取问题数量
     * @return
     */
    Integer selectProblemCount();

    /**
     * 根据标题搜索问题
     * @param title
     * @return
     */
    List<ProblemWithBLOBs> selectByTitle(@Param("title") String title, @Param("startPos") Integer startPos,
                                         @Param("pageSize") Integer pageSize);

    /**
     * 获取根据标题搜索问题记录的数量
     * @param title
     * @return
     */
    Integer selectProblemCountUsingTitle(@Param("title") String title);
}