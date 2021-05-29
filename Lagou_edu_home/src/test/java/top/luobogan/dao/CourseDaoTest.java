package top.luobogan.dao;

import org.junit.Test;
import top.luobogan.dao.impl.CourseDaoImpl;
import top.luobogan.pojo.Course;

import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/5/29
 */
public class CourseDaoTest {

    CourseDao courseDao = new CourseDaoImpl();

    // 测试课程列表查询
    @Test
    public void testQuery(){
        List<Course> courseList = courseDao.findCourseList();
        System.out.println(courseList);
    }
}
