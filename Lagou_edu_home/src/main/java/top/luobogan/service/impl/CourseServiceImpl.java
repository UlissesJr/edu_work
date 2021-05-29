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

    @Override
    public List<Course> findCourseList() {
        List<Course> courseList = courseDao.findCourseList();
        return courseList;
    }
}
