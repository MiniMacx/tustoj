package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.entity.UserContest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContestMapper {
    int deleteByPrimaryKey(Integer contestId);

    int insert(Contest record);

    int insertSelective(Contest record);

    Contest selectByPrimaryKey(Integer contestId);

    int updateByPrimaryKeySelective(Contest record);

    int updateByPrimaryKeyWithBLOBs(Contest record);

    int updateByPrimaryKey(Contest record);

    /**
     * 分页获取比赛记录
     * @param startPos
     * @param pageSize
     * @return
     */
    List<Contest> selectContestList(@Param("startPos") int startPos, @Param("pageSize") int pageSize);

    /**
     * 分页获取比赛记录数量
     * @return
     */
    Integer selectContestCount();

    /**
     * 根据标题
     * 分页获取比赛记录
     * @param title
     * @return
     */
    List<Contest> selectByTitle(@Param("title") String title, @Param("startPos") int startPos,
                                @Param("pageSize") int pageSize);

    /**
     * 根据标题
     * 分页获取比赛记录数量
     * @param title
     * @return
     */
    Integer selectContestCountUsingTitle(@Param("title") String title);

    List<Contest> listContest(List<UserContest> listUserContest);

    Integer updateEnrollNum();
}