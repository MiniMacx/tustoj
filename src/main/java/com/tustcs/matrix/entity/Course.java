package com.tustcs.matrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"deleteFlag"})
public class Course {
    private Integer courseId;

    private String courseName;

    private String courseTeacher;

    private String courseTime;

    private String courseWeek;

    private String courseSection;

    private Integer deleteFlag;

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

    public String getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(String courseWeek) {
        this.courseWeek = courseWeek == null ? null : courseWeek.trim();
    }

    public String getCourseSection() {
        return courseSection;
    }

    public void setCourseSection(String courseSection) {
        this.courseSection = courseSection == null ? null : courseSection.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Course(Integer courseId, String courseName, String courseTeacher, String courseTime,
                  String courseWeek, String courseSection, Integer deleteFlag) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
        this.courseTime = courseTime;
        this.courseWeek = courseWeek;
        this.courseSection = courseSection;
        this.deleteFlag = deleteFlag;
    }

    public Course(String courseName, String courseTeacher, String courseTime, String courseWeek,
                  String courseSection, Integer deleteFlag) {
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
        this.courseTime = courseTime;
        this.courseWeek = courseWeek;
        this.courseSection = courseSection;
        this.deleteFlag = deleteFlag;
    }

    public Course() {
    }
}