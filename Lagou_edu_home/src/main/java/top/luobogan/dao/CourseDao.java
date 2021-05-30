package top.luobogan.dao;

import top.luobogan.pojo.Course;

import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/5/29
 */

// 课程模块DAO层接口
public interface CourseDao {

    // 查询课程列表信息
    public List<Course> findCourseList();

    // 根据条件查询课程信息
    public List<Course> findByCourseNameAndStatus(String courseName,String status);

    // 保存课程营销信息
    public int saveCourseSalesInfo(Course course);


}
