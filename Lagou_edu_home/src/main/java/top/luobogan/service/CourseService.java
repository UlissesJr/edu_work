package top.luobogan.service;


import top.luobogan.dao.CourseDao;
import top.luobogan.dao.impl.CourseDaoImpl;
import top.luobogan.pojo.Course;

import java.util.List;
import java.util.Map;

// 课程管理模块 Service层接口
public interface CourseService {

    // 查询课程列表信息
    public List<Course> findCourseList();

    // 根据条件查询课程信息
    public List<Course> findByCourseNameAndStatus(String courseName,String status);

    // 保存课程营销信息
    public String saveCourseSalesInfo(Course course);

    // 根据id查询课程信息
    public Course findCourseById(int id);

    // 根据id修改课程信息
    public String updateCourseSalesInfo(Course course);

    // 修改课程状态
    public Map<String,Integer> updateCourseStatus(Course course);
}
