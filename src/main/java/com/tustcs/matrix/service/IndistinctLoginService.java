package com.tustcs.matrix.service;

import java.io.IOException;

/**
 * @Author L.key.
 * @Date 2017/6/15 21:28
 */
public interface IndistinctLoginService {

    public boolean indistinctLogin(String studentId, String password) throws IOException;
}
