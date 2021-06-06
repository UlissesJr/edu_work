package top.luobogan.service.impl;

import top.luobogan.base.StatusCode;
import top.luobogan.dao.CourseDao;
import top.luobogan.dao.impl.CourseDaoImpl;
import top.luobogan.pojo.Course;
import top.luobogan.service.CourseService;
import top.luobogan.utils.DateUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public String saveCourseSalesInfo(Course course) {

        // 补全课程营销信息   表单中没有输入的信息
        String strDate = DateUtils.getDateFormart();
        course.setCreate_time(strDate);
        course.setUpdate_time(strDate);
        course.setStatus(1);

        // 执行插入操作

        int i = courseDao.saveCourseSalesInfo(course);
        if (i > 0) {
            return StatusCode.SUCCESS.toString();
        }else {
            return StatusCode.FAIL.toString();
        }
    }

    @Override
    public Course findCourseById(int id) {

        return courseDao.findCourseById(id);

    }

    @Override
    public String updateCourseSalesInfo(Course course) {

        int row = courseDao.updateCourseSalesInfo(course);

        if (row > 0) {
            return StatusCode.SUCCESS.toString();
        }

        return StatusCode.FAIL.toString();
    }

    @Override
    public Map<String, Integer> updateCourseStatus(Course course) {

        // 调用DAO
        int row = courseDao.updateCourseStatus(course);
        Map<String,Integer> map = new HashMap<>();

        if (row > 0) {

            if (course.getStatus() == 0) {
                map.put("status",0);
            }else{
                map.put("status",1);
            }

        }


        return null;
    }
}
