package com.tustcs.matrix.service;

import com.tustcs.matrix.entity.*;


import java.util.List;

/**
 * Created by polykickshaw on 17-6-3.
 */

public interface AdminService {

    /**
     * User
     */

    List<User> getUserByUserId(String userId);

    List<User> getUser(int level);

    List<User> getUserList(int offset, int limit);

    User getUser(String userId);

    int deleteUser(String userId);

    int updateUser(User user);

    int addUser(User user);


    /**
     * Problem
     */
    List<ProblemWithBLOBs> getProblemList(int offset, int limit);

    List<ProblemWithBLOBs> getProblemByTitle(String title);

    int deleteProblem(Integer problemId);

    int updateProblem(ProblemWithBLOBs problem);

    int addProblem(ProblemWithBLOBs problem);

    Problem getProbelm(Integer problemId);

    /**
     * Contest
     */
    List<Contest> getContestList(int offset, int limit);

    List<Contest> getContestByTitle(String title);

    int deleteContest(Integer contestId);

    int updateContest(Contest contest);

    int addContest(Contest contest);

    Contest getContest(Integer contestId);

    /**
     * Solution
     */
    List<Solution> getSolutionList(int offset, int limit);

    List<Solution> getSolutionByUserId(String userId);

    int deleteSolution(Integer solutionId);

    int updateSolution(Solution solution);

    int addSolution(Solution solution);

    Solution getSolution(Integer solutionId);


    /**
     * Course
     */
    List<Course> getCourseList(int offset, int limit);

    List<Course> getCourseByCourseName(String courseName);

    List<Course> getCourseByCourseTeacher(String courseTeacher);

    int deleteCourse(Integer courseId);

    int updateCourse(Course course);

    int addCourse(Course course);

    Course getCourse(Integer courseId);

}

