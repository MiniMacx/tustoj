package com.tustcs.matrix.service;

import com.tustcs.matrix.annotation.UserAccess;
import com.tustcs.matrix.dao.UserMapper;
import com.tustcs.matrix.entity.User;
import com.tustcs.matrix.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by polykickshaw on 17-8-28.
 */
@Component
@Aspect
public class PermissionAspect {
    @Resource
    UserService userService;

    @Resource
    UserMapper userMapper;

    @Before("@annotation(com.tustcs.matrix.annotation.UserAccess)&&@annotation(log)")
    public void checkPermission(JoinPoint joinPoint,UserAccess log) throws Exception{

        System.out.println("前置通知");
        int level=log.level();

                HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                HttpServletResponse response=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
                String userId=request.getParameter("userId");
                System.out.println("前置通知 userId:"+userId);
                User user=userMapper.selectByPrimaryKey(userId);
                if(user.getLevel()> level){
                    PrintWriter printWriter = response.getWriter();
                    printWriter.print(new JSONObject().put("status", -5).put("msg", "权限不足！"));
                    printWriter.close();
                }
            }







}
