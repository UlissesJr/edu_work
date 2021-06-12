package top.luobogan.dao;

import org.junit.jupiter.api.Test;
import top.luobogan.dao.impl.CourseContentDaoImpl;
import top.luobogan.pojo.Course_Lesson;
import top.luobogan.pojo.Course_Section;

import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/6/12
 */
public class TestCourseContentDao {

    CourseContentDao dao = new CourseContentDaoImpl();

    // 测试 查询对应课程下的章节与课时
    @Test
    public void testFindSectionAndLessonByCourseId(){

        List<Course_Section> sectionAndLessonByCourseId = dao.findSectionAndLessonByCourseId(59);
        for (Course_Section course_section : sectionAndLessonByCourseId) {
            System.out.println(course_section.getSection_name());

            List<Course_Lesson> courseLessonList = course_section.getCourseLessonList();
            for (Course_Lesson course_lesson : courseLessonList) {
                System.out.println(course_lesson.getTheme());
            }
        }
    }
}
