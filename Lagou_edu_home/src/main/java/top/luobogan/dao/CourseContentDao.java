package top.luobogan.dao;

import top.luobogan.pojo.Course;
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

    // 根据课程id 回显课程信息
    public Course findCourseByCourseId(int CourseId);

    // 保存章节的信息
    public int saveSection(Course_Section courseSection);

    // 修改章节
    public int updateSection(Course_Section courseSection);

    // 修改章节状态
    public int updateSectionStatus(int id, int status);

}
