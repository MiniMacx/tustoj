package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by polykickshaw on 17-6-18.
 */
public interface TokenService {

    boolean tokenVerify(int recId, String userId, String token);

    Token createToken(String userId);

    boolean expireToken(String userId);
}