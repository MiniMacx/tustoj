package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.dao.*;
import com.tustcs.matrix.entity.*;
import com.tustcs.matrix.service.UserService;
import com.tustcs.matrix.utils.DateUtils;
import com.tustcs.matrix.utils.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by L.key on 2017/6/2.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userDao;

    @Resource
    private UserCourseMapper userCourseDao;

    @Resource
    private CourseMapper courseDao;

    @Resource
    private UserHomeworkMapper userHomeworkDao;

    @Resource
    private HomeworkMapper homeworkDao;

    @Resource
    private UserContestMapper userContestDao;

    @Resource
    private ContestMapper contestDao;

    public boolean loginService(String userId, String userPwd) {
        User user = userDao.selectByPrimaryKey(userId);
        if (null == user)
            return false;
        String MDPwd = MD5Utils.getMD5(MD5Utils.getMD5(MD5Utils.getMD5(MD5Utils.getMD5(userPwd))));
        
        System.out.println(MDPwd);
//        System.out.println(user.getPassword());
        //不用==比较，因为==比较的是内存中的地址，字符串是引用类型，地址不同。
        if (!MDPwd.equals(user.getPassword())) {
            return false;
        }
        return true;
    }

    public int queryOwnSubmit(String userId) {
        User user = userDao.selectByPrimaryKey(userId);
        if (null == user) {
            return 0;
        }
        return user.getSubmit();
    }

    public List queryAllSubmit() {
        Map<String, Object> submitMap;
        List<Map<String, Object>> listSubmit = new ArrayList<Map<String, Object>>();
        List<User> listUser = userDao.selectAllUser();
        for (int i = 0; i < listUser.size(); i++) {
            submitMap = new HashMap<String, Object>();
            submitMap.put("userId", listUser.get(i).getUserId());
            submitMap.put("submit", listUser.get(i).getSubmit());
            listSubmit.add(submitMap);
        }
        return listSubmit;
    }

    /*
    * 先在user_course表中找到user_id对应的course_id列表
    * 然后在course表中查找course_id对应的course，形成course列表
    * */
    public List<Course> queryCourseList(String userId) {
        UserCourse userCourse = new UserCourse();
        userCourse.setUserId(userId);
        List<UserCourse> listUC = userCourseDao.listUserCourse(userCourse);
        if (null == listUC || listUC.size() <= 0) {
            return null;
        }
        int[] listCourseId = new int[listUC.size()];
        for (int i = 0; i < listUC.size(); i++) {
            listCourseId[i] = listUC.get(i).getCourseId();
        }
        List<Course> listCourse = courseDao.listCourse(listCourseId);
        if (null == listCourse || listCourse.size() <= 0) {
            return null;
        }
        return listCourse;
    }

    public List<Homework> queryHomeWorkList(String userId) {
        List<UserHomework> listUserHomework = userHomeworkDao.listUserHomework(userId);
        if (null == listUserHomework || listUserHomework.size() <= 0) {
            return null;
        }
        return homeworkDao.listHomework(listUserHomework);
    }

    public List<Contest> queryContestList(String userId) {
        List<UserContest> userContestList = userContestDao.selectUserContestList(userId);
        if (null == userContestList || userContestList.size() <= 0)
            return null;
        contestDao.listContest(userContestList);

        return contestDao.listContest(userContestList);
    }
}
