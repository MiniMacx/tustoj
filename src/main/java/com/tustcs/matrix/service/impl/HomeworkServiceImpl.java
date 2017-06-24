package com.tustcs.matrix.service.impl;

import com.tustcs.matrix.dao.HomeworkMapper;
import com.tustcs.matrix.entity.Homework;
import com.tustcs.matrix.service.HomeworkService;
import com.tustcs.matrix.utils.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by polykickshaw on 17-6-24.
 */
@Service
@Transactional
public class HomeworkServiceImpl implements HomeworkService {
    @Resource
    HomeworkMapper homeworkMapper;

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
    public boolean addHomework(Homework homework) {
        return homeworkMapper.insert(homework)>0;
    }

    @Override
    public boolean updateHomework(Homework homework) {
        return homeworkMapper.updateByPrimaryKeySelective(homework)>0;
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
        return null;
    }
}
