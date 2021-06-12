package top.luobogan.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import top.luobogan.dao.CourseContentDao;
import top.luobogan.pojo.Course_Lesson;
import top.luobogan.pojo.Course_Section;
import top.luobogan.utils.DruidUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/6/12
 * 课程内容管理Dao层实现类
 */
public class CourseContentDaoImpl implements CourseContentDao {

    // 根据课程id查看课程相关信息
    @Override
    public List<Course_Section> findSectionAndLessonByCourseId(int courseId) {

        try {
            // 1.创建 QueryRunner
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

            // 2.编写SQL
            String sql = "select\n" +
                    "id,course_id,section_name,description,order_num,status\n" +
                    "from course_section\n" +
                    "where course_id = ?;";

            // 3.执行查询
            List<Course_Section> sectionList = qr.query(sql, new BeanListHandler<Course_Section>(Course_Section.class), courseId);

            // 根据章节id查询课时信息
            for (Course_Section course_section : sectionList) {

                //
                List<Course_Lesson> lessonBySectionId = findLessonBySectionId(course_section.getId());

                // 将课时数据封装到 章节对象中
                course_section.setCourseLessonList(lessonBySectionId);

            }

            return sectionList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    // 根据章节ID，查询章节相关的课时信息
    @Override
    public List<Course_Lesson> findLessonBySectionId(int sectionId) {

        try {
            // 1.创建 QueryRunner
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

            // 2.编写SQL
            String sql = "select\n" +
                    "id,course_id,section_id,theme,duration,is_free,order_num,status\n" +
                    "from course_lesson where section_id = ?;";

            // 3.执行查询
            List<Course_Lesson> lessonList = qr.query(sql, new BeanListHandler<Course_Lesson>(Course_Lesson.class), sectionId);

            return lessonList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
