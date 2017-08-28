package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.config.Config;
import com.tustcs.matrix.dao.TokenMapper;
import com.tustcs.matrix.entity.Token;
import com.tustcs.matrix.service.TokenService;
import com.tustcs.matrix.utils.MD5Utils;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author L.key.
 * @Date 2017/7/24 16:08
 */
@Service("TokenService")
public class TokenServiceImpl implements TokenService {

    @Resource
    TokenMapper tokenDao;

    public boolean expireToken(String userId){
        if(null == userId){
            return false;
        }
        Token tok = tokenDao.selectByUserId(userId);
        Long expireTime = Long.valueOf(tok.getExpireTime());
        if (expireTime < System.currentTimeMillis())
            return false;
        else
            return true;
    }

    public boolean tokenVerify(int recId,String userId,String token) {
        if (null == String.valueOf(recId) || null == userId || null == token){
            return false;
        }
        Token tok = tokenDao.selectByRecId(recId);
        if (userId.equals(tok.getUserId()) && token.equals(tok.getToken()))
            return true;
        else
            return false;
    }

    public Token createToken(String userId) {
        Token token = tokenDao.selectByUserId(userId);
        if(token == null){
            Token token1 = new Token();
            token1.setUserId(userId);
            token1.setCreateTime(System.currentTimeMillis() + "");
            token1.setExpireTime(System.currentTimeMillis() + ((long)7) * 24 * 60 * 60 * 1000 + "");
            token1.setToken(MD5Utils.getMD5(System.currentTimeMillis() + Config.CODEKEY));
            tokenDao.insertSelective(token1);
            Token token2 = tokenDao.selectByToken(token1.getToken());
            return token2;
        }
        token.setExpireTime(System.currentTimeMillis() + ((long)7) * 24 * 60 * 60 * 1000 + "");
        token.setToken(MD5Utils.getMD5(System.currentTimeMillis() + Config.CODEKEY));
        tokenDao.updateByRecId(token);
        return token;
    }
}
