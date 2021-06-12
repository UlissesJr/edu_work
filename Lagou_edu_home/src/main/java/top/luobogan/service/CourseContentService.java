package top.luobogan.service;

import top.luobogan.pojo.Course_Section;

import java.util.List;

/**
 * 课程内容管理 Service层操作
 */
public interface CourseContentService {

    // 根据课程id查看课程相关信息
    public List<Course_Section> findSectionAndLessonByCourseId(int courseId);


}
