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
<<<<<<< HEAD
    List<ProblemWithBLOBs> selectProblemList(@Param("startPos") int startPos, @Param("pageSize") int pageSize);

    /**
     * 分页获取问题数量
     * @return
     */
    Integer selectProblemCount();
=======
    List<ProblemWithBLOBs> selectProblemList(@Param("startPos") int startPos,@Param("pageSize") int pageSize);

    /**
     * 分页获取问题数量
     * @param startPos
     * @param pageSize
     * @return
     */
    Integer selectProblemCount(@Param("startPos") int startPos,@Param("pageSize") int pageSize);
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d

    /**
     * 根据标题搜索问题
     * @param title
     * @return
     */
<<<<<<< HEAD
    List<ProblemWithBLOBs> selectByTitle(@Param("title") String title, @Param("startPos") Integer startPos,
=======
    List<ProblemWithBLOBs> selectByTitle(@Param("title") String title,@Param("startPos") Integer startPos,
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
                                         @Param("pageSize") Integer pageSize);

    /**
     * 获取根据标题搜索问题记录的数量
     * @param title
     * @return
     */
    Integer selectProblemCountUsingTitle(@Param("title") String title);
}