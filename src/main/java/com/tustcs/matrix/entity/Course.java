package com.tustcs.matrix.entity;

public class Course {
    private Integer courseId;

    private String courseName;

    private String courseTeacher;

    private String courseTime;

<<<<<<< HEAD
    private Integer deleteFlag;

=======
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher == null ? null : courseTeacher.trim();
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime == null ? null : courseTime.trim();
    }
<<<<<<< HEAD

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
=======
>>>>>>> c46d0824de76fd787bbb6dee4e96a3670765b74d
}