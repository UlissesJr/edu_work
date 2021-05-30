package top.luobogan.service.impl;

import top.luobogan.dao.CourseDao;
import top.luobogan.dao.impl.CourseDaoImpl;
import top.luobogan.pojo.Course;
import top.luobogan.service.CourseService;

import java.util.List;

/**
 * 课程管理模块
 * Created by LuoboGan
 * Date:2021/5/29
 */
public class CourseServiceImpl implements CourseService {

    CourseDao courseDao = new CourseDaoImpl();

    // 查询课程列表信息
    @Override
    public List<Course> findCourseList() {
        List<Course> courseList = courseDao.findCourseList();
        return courseList;
    }

    // 根据条件查询课程信息
    @Override
    public List<Course> findByCourseNameAndStatus(String courseName, String status) {
        List<Course> courseList = courseDao.findByCourseNameAndStatus(courseName,status);
        return courseList;
    }


}
