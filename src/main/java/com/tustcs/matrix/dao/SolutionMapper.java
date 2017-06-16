package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Solution;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SolutionMapper {
    int deleteByPrimaryKey(Integer solutionId);

    int insert(Solution record);

    int insertSelective(Solution record);

    Solution selectByPrimaryKey(Integer solutionId);

    int updateByPrimaryKeySelective(Solution record);

    int updateByPrimaryKey(Solution record);

    /**
     * 分页
     * 获取提交记录
     * @param startPos
     * @param pageSize
     * @param userId
     * @return
     */
<<<<<<< HEAD
    List<Solution> selectSolutionByPage(@Param("startPos") Integer startPos, @Param("pageSize") Integer pageSize,
=======
    List<Solution> selectSolutionByPage(@Param("startPos") Integer startPos,@Param("pageSize") Integer pageSize,
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
                                        @Param("userId") String userId);

    /**
     * 取得用户提交数量
     * @param userId
     * @return
     */
<<<<<<< HEAD
    int selectSolutionCountUsingUserId(@Param("userId") String userId);
=======
    int selectSolutionCountUsingUserId(@Param("userId")String userId);
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d

    /**
     * 分页
     * 获取Accepted的提交记录
     * @param startPos
     * @param pageSize
     * @param userId
     * @param result
     * @return
     */
<<<<<<< HEAD
    List<Solution> selectAcceptedSolutionByPage(@Param("startPos") Integer startPos, @Param("pageSize") Integer pageSize,
                                                @Param("userId") String userId, @Param("result") Short result);
=======
    List<Solution> selectAcceptedSolutionByPage(@Param("startPos") Integer startPos,@Param("pageSize") Integer pageSize,
                                             @Param("userId") String userId,@Param("result") Short result);
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d

    /**
     * 获取某个用户通过的（accepted）提交记录的数量
     * @param userId
     * @param result
     * @return
     */
<<<<<<< HEAD
    Integer selectAcceptedSolutionCountUsingUserId(@Param("userId") String userId, @Param("result") Short result);
=======
    Integer selectAcceptedSolutionCountUsingUserId(@Param("userId") String userId,@Param("result") Short result);
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d


}