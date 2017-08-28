package com.tustcs.matrix.dao;


import com.tustcs.matrix.entity.Token;

public interface TokenMapper {
    int insert(Token record);

    int insertSelective(Token record);

    Token selectByUserId(String userId);

    Token selectByRecId(Integer recId);

    Token selectByToken(String token);

    int updateByRecId(Token record);
}