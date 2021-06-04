package top.luobogan.dao;

import org.junit.jupiter.api.Test;
import top.luobogan.dao.impl.CourseDaoImpl;
import top.luobogan.pojo.Course;
import top.luobogan.utils.DateUtils;

import java.io.File;
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

    // 测试课程列表查询
    @Test
    public void testFindByCourseNameAndStatus(){
        List<Course> courseList = courseDao.findByCourseNameAndStatus("微服务","1");
        courseList.forEach(course -> {
            System.out.println(course.getId() + " " + course.getCourse_name() + " " + course.getStatus());
        });
    }

    // 测试保存课程营销信息
    @Test
    public void testSaveCourseSalesInfo(){

        Course course = new Course();
        course.setCourse_name("爱情36计");
        course.setBrief("学会去找对象");
        course.setTeacher_name("药水哥");
        course.setTeacher_info("人人都是药水哥");
        course.setPreview_first_field("共十讲");
        course.setPreview_second_field("每周日更新");
        course.setDiscounts(88.88);
        course.setPrice(188.0);
        course.setShare_image_title("爱情36计图片");
        course.setShare_title("嘻嘻嘻");
        course.setShare_description("天天向上");
        course.setCourse_description("爱情36计，就像一场游戏");
        course.setCourse_img_url("https://www.xx.com/xxx.jpg");
        course.setStatus(1);
        String format = DateUtils.getDateFormart();
        course.setCreate_time(format);
        course.setUpdate_time(format);

        int row = courseDao.saveCourseSalesInfo(course);
        System.out.println(row);
    }

    @Test
    public void testPathSeperate(){

        String separator = File.separator;
        System.out.println(separator);
    }

    @Test
    public void testUpdateCourse(){

        // 1. 根据id查询课程信息
        Course courseById = courseDao.findCourseById(1);
        System.out.println(courseById);

        // 2.修改数据
        courseById.setCourse_name("32个Java面试必考点");
        courseById.setTeacher_name("甘老师");

        // 3.更新数据
        int i = courseDao.updateCourseSalesInfo(courseById);
        System.out.println(i);

        Course course = courseDao.findCourseById(1);
        System.out.println(course);

    }

}
