package com.tustcs.matrix.controller;

import com.tustcs.matrix.service.UserService;
import com.tustcs.matrix.utils.Res;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by L.key on 2017/6/2.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @RequestMapping("/login")
    @ResponseBody
    public String login(String userId, String userPwd) {
        JSONObject jsonObject = new JSONObject();
        if (null == userId || "".equals(userId) || null == userPwd || "".equals(userPwd)) {
            jsonObject.put("msg", "用户名或密码为空")
                    .put("status", 0);
            return Res.jsonToString(jsonObject);
        }
        if (!userService.loginService(userId, userPwd)) {
            jsonObject.put("msg", "用户名或密码错误")
                    .put("status", 0);
            return Res.jsonToString(jsonObject);
        }
        jsonObject.put("msg", "登陆成功")
                .put("status", 1)
                .put("userId", userId);
        return Res.jsonToString(jsonObject).toString();
    }

    @RequestMapping("personalsubmit")
    @ResponseBody
    public String getPersonalSubmit(String userId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("personalSubmit",userService.queryOwnSubmit(userId))
                .put("status",1);
        return Res.jsonToString(jsonObject);
    }

    @RequestMapping("allsubmit")
    @ResponseBody
    public String getAllSubmit(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("personalSubmit",userService.queryAllSubmit())
                .put("status",1);
        return Res.jsonToString(jsonObject);

    }

    @RequestMapping("courselist")
    @ResponseBody
    public String getCourseList(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String userId=request.getParameter("userId");
        if (null == userId || "".equals(userId)) {
            jsonObject.put("msg", "用户名为空")
                    .put("status", 0);
            return Res.jsonToString(jsonObject);
        }
        jsonObject.put("status", 1)
                .put("courseList", userService.queryCourseList(userId));
        return Res.jsonToString(jsonObject);
    }

    @RequestMapping("homeworklist")
    @ResponseBody
    public String getHomeworkList(String userId) {
        JSONObject jsonObject = new JSONObject();
        if (null == userId || "".equals(userId)) {
            jsonObject.put("msg", "用户名为空")
                    .put("status", 0);
            return Res.jsonToString(jsonObject);
        }
        jsonObject.put("status", 1)
                .put("homeWorkList", userService.queryHomeWorkList(userId));
        return Res.jsonToString(jsonObject);
    }

    @RequestMapping("usercontest")
    @ResponseBody
    public String getUserContest(final String userId) {
        JSONObject jsonObject = new JSONObject();
        if (null == userId || "".equals(userId)) {
            jsonObject.put("msg", "用户名为空")
                    .put("status", 0);
            return Res.jsonToString(jsonObject);
        }
        jsonObject.put("userContest",userService.queryContestList(userId));
        return Res.jsonToString(jsonObject);
    }
}
