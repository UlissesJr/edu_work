package top.luobogan.service.impl;

import top.luobogan.base.StatusCode;
import top.luobogan.dao.CourseContentDao;
import top.luobogan.dao.impl.CourseContentDaoImpl;
import top.luobogan.pojo.Course;
import top.luobogan.pojo.Course_Section;
import top.luobogan.service.CourseContentService;
import top.luobogan.utils.DateUtils;

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

    @Override
    public Course findCourseByCourseId(int CourseId) {
        Course courseByCourseId = courseContentDao.findCourseByCourseId(CourseId);
        return courseByCourseId;
    }

    @Override
    public String saveSection(Course_Section courseSection) {
        // 补全章节信息
        courseSection.setStatus(2); // 状态: 0 隐藏, 1 待更新, 2 已发布
        String date = DateUtils.getDateFormart();
        courseSection.setUpdate_time(date);
        courseSection.setCreate_time(date);
        int row = courseContentDao.saveSection(courseSection);

        if (row > 0) {
            //保存成功
            String result = StatusCode.SUCCESS.toString();
            return result;
        }

        String result = StatusCode.FAIL.toString();
        return result;

    }

    @Override
    public String updateSection(Course_Section courseSection) {

        // 补全章节信息
        String date = DateUtils.getDateFormart();
        courseSection.setUpdate_time(date);

        // 调用DAO
        int row = courseContentDao.saveSection(courseSection);

        if (row > 0) {
            //保存成功
            String result = StatusCode.SUCCESS.toString();
            return result;
        }

        String result = StatusCode.FAIL.toString();
        return result;
    }

    @Override
    public String updateSectionStatus(int id, int status) {

        // 调用DAO
        int row = courseContentDao.updateSectionStatus(id,status);

        if (row > 0) {
            //保存成功
            String result = StatusCode.SUCCESS.toString();
            return result;
        }

        String result = StatusCode.FAIL.toString();
        return result;
    }
}
