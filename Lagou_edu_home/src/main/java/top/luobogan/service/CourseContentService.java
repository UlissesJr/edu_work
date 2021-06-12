package top.luobogan.service;

import top.luobogan.pojo.Course;
import top.luobogan.pojo.Course_Section;

import java.util.List;

/**
 * 课程内容管理 Service层操作
 */
public interface CourseContentService {

    // 根据课程id查看课程相关信息
    public List<Course_Section> findSectionAndLessonByCourseId(int courseId);

    // 根据课程id 回显课程信息
    public Course findCourseByCourseId(int CourseId);

    // 保存章节的信息
    public String saveSection(Course_Section courseSection);

    // 修改章节
    public String updateSection(Course_Section courseSection);

    // 修改章节状态
    public String updateSectionStatus(int id, int status);


}
