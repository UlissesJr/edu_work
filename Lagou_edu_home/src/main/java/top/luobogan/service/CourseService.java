package top.luobogan.service;


import top.luobogan.dao.CourseDao;
import top.luobogan.dao.impl.CourseDaoImpl;
import top.luobogan.pojo.Course;

import java.util.List;

// 课程管理模块 Service层接口
public interface CourseService {

    public List<Course> findCourseList();
}
