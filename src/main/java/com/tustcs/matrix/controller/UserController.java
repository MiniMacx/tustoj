package com.tustcs.matrix.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.tustcs.matrix.entity.Token;
import com.tustcs.matrix.service.IndistinctLoginService;
import com.tustcs.matrix.service.TokenService;
import com.tustcs.matrix.service.UserService;
import com.tustcs.matrix.utils.Res;
import org.apache.ibatis.jdbc.SQL;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by L.key on 2017/6/2.
 */

@Controller
@RequestMapping(value = "/user",produces = {"application/json;charset=UTF-8"})
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private IndistinctLoginService indistinctLoginService;

    @Resource
    private TokenService tokenService;

    /**
     * 登陆
     * @param userId
     * @param userPwd
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String userId,String userPwd) {
        JSONObject jsonObject = new JSONObject();
        if (null == userId || "".equals(userId) || null == userPwd || "".equals(userPwd)) {
            jsonObject.put("msg", "用户名或密码错误")
                    .put("status", 0);
            return Res.jsonToString(jsonObject);
        }
        //生成token
        JSONObject jsonToken = new JSONObject();
        Token token = tokenService.createToken(userId);
        jsonToken.put("recId",token.getRecId())
                .put("userId",token.getUserId())
                .put("token",token.getToken());

        if (userService.loginService(userId, userPwd)) {
            jsonObject.put("msg", "登陆成功")
                    .put("status", 1)
                    .put("token",jsonToken);
            return Res.jsonToString(jsonObject);
        }
        //进行模拟登陆
        try {
            if (indistinctLoginService.indistinctLogin(userId, userPwd)) {
                jsonObject.put("msg", "登陆成功")
                        .put("status", 1)
                        .put("token",jsonToken);
                return Res.jsonToString(jsonObject);
            }
        }catch (IOException e){
            jsonObject.put("msg",e.getMessage())
                    .put("status", -1);
            return Res.jsonToString(jsonObject);
        }
        jsonObject.put("msg", "用户名或密码错误")
                .put("status", 0);
        return Res.jsonToString(jsonObject);
    }

    /**
     * 个人提交记录
     * @param userId
     * @return
     */
    @RequestMapping(value = "personal_submit",method = RequestMethod.POST)
    @ResponseBody
    public String getPersonalSubmit(String userId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("personalSubmit",userService.queryOwnSubmit(userId))
                .put("status",1);
        return Res.jsonToString(jsonObject);
    }

    /**
     * 全部提交记录
     * @return
     */
    @RequestMapping(value = "all_submit",method = RequestMethod.POST)
    @ResponseBody
    public String getAllSubmit(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("allSubmit",userService.queryAllSubmit())
                .put("status",1);
        return Res.jsonToString(jsonObject);

    }

    /**
     * 用户课程列表
     * @param userId
     * @return
     */
    @RequestMapping(value = "course_list",method = RequestMethod.POST)
    @ResponseBody
    public String getCourseList(String userId) {
        JSONObject jsonObject = new JSONObject();
        if (null == userId || "".equals(userId)) {
            jsonObject.put("msg", "用户名为空")
                    .put("status", 0);
            return Res.jsonToString(jsonObject);
        }
        jsonObject.put("status", 1)
                .put("courseList", userService.queryCourseList(userId));
        return Res.jsonToString(jsonObject);
    }

    /**
     * 用户作业列表
     * @param userId
     * @return
     */
    @RequestMapping(value = "homework_list",method = RequestMethod.POST)
    @ResponseBody
    public Res getHomeworkList(String userId) {
        Res res=new Res();
        if (null == userId || "".equals(userId)) {
            res.setMsg("用户名为空")
                    .setStatus(0);
            return res;
        }
        res.setStatus(1)
                .setData(userService.queryHomeWorkList(userId));
        return res;
    }

    /**
     * 某个人的竞赛记录
     * @param userId
     * @return
     */
    @RequestMapping(value = "user_contest",method = RequestMethod.POST)
    @ResponseBody
    public Res getUserContest(String userId) {
        Res res=new Res();
        if (null == userId || "".equals(userId)) {
            res.setMsg("用户名为空").setStatus(0);

            return res;
        }
        res.setData(userService.queryContestList(userId))
                .setStatus(1);
        return res;
    }
}
