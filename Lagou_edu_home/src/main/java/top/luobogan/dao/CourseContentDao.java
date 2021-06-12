package top.luobogan.dao;

import top.luobogan.pojo.Course_Lesson;
import top.luobogan.pojo.Course_Section;

import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/6/12
 * 课程内容管理 DAO层接口
 */
public interface CourseContentDao {

    // 根据课程id查看课程相关信息
    public List<Course_Section> findSectionAndLessonByCourseId(int courseId);

    // 根据章节ID，查询章节相关的课时信息
    public List<Course_Lesson> findLessonBySectionId(int sectionId);

}
