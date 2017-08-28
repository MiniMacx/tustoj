package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Contest;
import com.tustcs.matrix.entity.UserContest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserContestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserContest record);

    int insertSelective(UserContest record);

    UserContest selectByPrimaryKey(Integer id);

    List<UserContest> selectUserContestList(String userId);

    int selectContest(@Param("contestId") Integer contestId,@Param("userId") String userId);

    int updateByPrimaryKeySelective(UserContest record);

    int updateByPrimaryKey(UserContest record);

    int selectScore(@Param("userId")String userId,@Param("contestId")Integer contestId);

}