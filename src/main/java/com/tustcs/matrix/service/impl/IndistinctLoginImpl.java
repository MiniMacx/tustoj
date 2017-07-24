package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.config.Config;
import com.tustcs.matrix.dao.UserMapper;
import com.tustcs.matrix.entity.User;
import com.tustcs.matrix.service.IndistinctLoginService;
import com.tustcs.matrix.utils.URLUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Map;


/**
 * @Author L.key.
 * @Date 2017/6/15 21:30
 */
@Service
public class IndistinctLoginImpl implements IndistinctLoginService {

    @Resource
    private UserMapper userDao;



    public boolean indistinctLogin(String studentId, String password) throws IOException {

        String params = Config.FILED_NAME +"="+ studentId +"&" + Config.FILED_PASSWORD + "=" + password;
        String cookie = URLUtils.accessUrl(Config.LOGIN,params,"12",1);
        //判断登陆是否成功
       // System.out.println(params+"            "+cookie);
        if (!cookie.contains("iPlanetDirectoryPro")){
            return false;
        }
        //返回用户信息
        String html = URLUtils.accessUrl(Config.OWN_INDEX,"",cookie,0);
        Map<String,Object> userMsg = URLUtils.resolveHtml(html);

        //将用户信息插入数据库
        User user = new User();
        user.setUserId((String)userMsg.get("userId"));
        user.setPassword(password);
        user.setNick((String)userMsg.get("nick"));
        user.setRegTime(new Date(System.currentTimeMillis()));
        user.setSchool((String) userMsg.get("school"));

        user.setLevel(1);
        return userDao.insertSelective(user) > 0? true:false;
    }
}
