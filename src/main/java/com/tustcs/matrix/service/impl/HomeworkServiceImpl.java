package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.dao.*;
import com.tustcs.matrix.dto.HomeworkDTO;
import com.tustcs.matrix.dto.HomeworkProblemDTO;
import com.tustcs.matrix.entity.Homework;
import com.tustcs.matrix.entity.UserCourse;
import com.tustcs.matrix.entity.UserHomework;
import com.tustcs.matrix.service.HomeworkService;
import com.tustcs.matrix.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-24.
 */
@Service
@Transactional
public class HomeworkServiceImpl implements HomeworkService {
    @Resource
    HomeworkMapper homeworkMapper;

    @Resource
    HomeworkProblemMapper homeworkProblemMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    CourseMapper courseMapper;

    @Resource
    UserHomeworkMapper userHomeworkMapper;

    @Resource
    UserCourseMapper userCourseMapper;

    @Override
    public List<Homework> showHomework(Integer pageNow) {
        List<Homework> homeworkList;
        if(pageNow!=null){
            homeworkList=homeworkMapper.selectHomeworkList((pageNow-1)* Page.pageSize,Page.pageSize);
        }else {
            return null;
        }
        return homeworkList;
    }

    @Override
    public List<Homework> showHomeworkByCreatorId(Integer pageNow, String creatorId) {
        List<Homework> homeworkList;
        if(pageNow!=null){
            homeworkList=homeworkMapper.selectHomeworkByCreatorId((pageNow-1)* Page.pageSize,Page.pageSize,
                                                                    creatorId);
        }else {
            return null;
        }
        return homeworkList;
    }

    @Override
    public boolean addHomework(HomeworkDTO homeworkDTO) {
        if(homeworkMapper.insertSelective(homeworkDTO)>0) {
            Integer homeworkId=homeworkDTO.getHomeworkId();
            List<UserHomework> userHomeworkList= new ArrayList<UserHomework>();
            if (homeworkId != null && homeworkId > 0) {
                for (Integer problemId :
                        homeworkDTO.getProblems()) {
                    homeworkProblemMapper.insert(homeworkId, problemId);
                }
            if(homeworkDTO.getCourseId()!=null){
                List<String> userList = userCourseMapper.selectCourseUser(homeworkDTO.getCourseId());
                for (String userId:
                     userList) {
                    userHomeworkList.add(new UserHomework(userId,homeworkDTO.getHomeworkId()));
                }
                if(userHomeworkMapper.insertUserHomework(userHomeworkList)>0)
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean updateHomework(HomeworkDTO homeworkDTO) {
        if (homeworkDTO.getHomeworkId()!=null) {
            if (homeworkDTO.getProblems() != null) {
                if(homeworkProblemMapper.delete(homeworkDTO.getHomeworkId())>0){
                    for (int problemId :
                            homeworkDTO.getProblems()) {
                        homeworkProblemMapper.insert(homeworkDTO.getHomeworkId(), problemId);
                    }
                }
            }

            return homeworkMapper.updateByPrimaryKeySelective(homeworkDTO)>0;
        }
        return false;
    }

    @Override
    public boolean deleteHomework(Integer homeworkId) {
        Homework homework=new Homework();
        homework.setDeleteFlag(1);
        homework.setHomeworkId(homeworkId);
        return homeworkMapper.updateByPrimaryKeySelective(homework)>0;
    }

    @Override
    public Homework getHomework(Integer homeworkId) {

       return homeworkMapper.selectByPrimaryKey(homeworkId);
    }

    @Override
    public List<HomeworkProblemDTO> getHomeworkProblem(Integer homeworkId) {
        return homeworkProblemMapper.selectHomeworkProblem(homeworkId);
    }
}
