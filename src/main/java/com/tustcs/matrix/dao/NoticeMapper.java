package com.tustcs.matrix.dao;

import com.tustcs.matrix.entity.Notice;
import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);

<<<<<<< HEAD
    int selectNoticeList(@Param("offset") int offset, @Param("limit") int limit);
=======
    int selectNoticeList(@Param("offset") int offset,@Param("limit") int limit);
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
}