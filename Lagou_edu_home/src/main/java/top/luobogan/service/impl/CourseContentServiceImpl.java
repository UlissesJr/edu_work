package top.luobogan.service.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import top.luobogan.dao.CourseContentDao;
import top.luobogan.dao.impl.CourseContentDaoImpl;
import top.luobogan.pojo.Course_Section;
import top.luobogan.service.CourseContentService;
import top.luobogan.utils.DruidUtils;

import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/6/12
 * 课程内容管理Service层 实现类
 */
public class CourseContentServiceImpl implements CourseContentService {

    CourseContentDao courseContentDao = new CourseContentDaoImpl();


    @Override
    public List<Course_Section> findSectionAndLessonByCourseId(int courseId) {

        List<Course_Section> sectionList = courseContentDao.findSectionAndLessonByCourseId(courseId);
        return sectionList;
    }
}
