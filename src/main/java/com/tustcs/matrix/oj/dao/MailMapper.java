package com.tustcs.matrix.oj.dao;

import com.tustcs.matrix.oj.entity.Mail;

public interface MailMapper {
    int deleteByPrimaryKey(Integer mailId);

    int insert(Mail record);

    int insertSelective(Mail record);

    Mail selectByPrimaryKey(Integer mailId);

    int updateByPrimaryKeySelective(Mail record);

    int updateByPrimaryKeyWithBLOBs(Mail record);

    int updateByPrimaryKey(Mail record);
}