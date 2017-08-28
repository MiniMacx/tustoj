package com.tustcs.matrix.dto;

import com.tustcs.matrix.entity.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by polykickshaw on 17-7-30.
 */
public class HomeworkDTO extends Homework {


    private Integer[] problems;

    private Integer courseId;

    public Integer[] getProblems() {
        return problems;
    }

    public void setProblems(Integer[] problems) {
        this.problems = problems;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {

        return super.toString()+"HomeworkDTO{" +
                "problems=" + Arrays.toString(problems) +
                '}';
    }
}
