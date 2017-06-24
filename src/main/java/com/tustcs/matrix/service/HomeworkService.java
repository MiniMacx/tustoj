package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.Homework;

import java.util.List;

/**
 * Created by polykickshaw on 17-6-24.
 */
public interface HomeworkService {
    List<Homework> showHomework(Integer pageNow);

    List<Homework> showHomeworkByCreatorId(Integer pageNow,String creatorId);

    boolean addHomework(Homework homework);

    boolean updateHomework(Homework homework);

    boolean deleteHomework(Integer homeworkId);

    Homework getHomework(Integer homeworkId);
}
