package top.luobogan.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import top.luobogan.dao.CourseDao;
import top.luobogan.pojo.Course;
import top.luobogan.utils.DateUtils;
import top.luobogan.utils.DruidUtils;

import javax.management.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/5/29
 */
// 课程模块的DAO层的实现类
public class CourseDaoImpl implements CourseDao {


    // 查询课程列表信息
    @Override
    public List<Course> findCourseList() {

        List<Course> query = null;

        try {
            // 1.创建QueryRunner 判断是否删除，取出 is_del = 0 的数据 --> 未删除的数据
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
            String sql = "SELECT id, course_name, price, sort_num, status FROM course WHERE is_del = ?;";

            // 执行查询
            query = qr.query(sql, new BeanListHandler<Course>(Course.class), 0);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    // 根据条件查询课程信息
    @Override
    public List<Course> findByCourseNameAndStatus(String courseName, String status) {

        List<Course> query = null;

        try {
            // 1.创建QueryRunner 判断是否删除，取出 is_del = 0 的数据 --> 未删除的数据
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

            // 2.编写SQL 当前的查询为多条件查询不定项查询
            // 2.1创建StringBuffer对象，将SQL字符串 添加进缓冲区
            StringBuffer sb = new StringBuffer("SELECT id,course_name,price,sort_num,status FROM course WHERE 1=1 AND is_del = ?");
            // 2.2创建LIST集合来保存参数
            List<Object> list = new ArrayList<>();
            list.add(0);
            // 2.3 判断传入的参数是否为null
            if (courseName != null && !courseName.equals("")) {
                sb.append(" AND course_name LIKE ?");
                // like查询需要拼接 %
                courseName = "%" + courseName + "%";
                list.add(courseName);
            }

            if (status != null && !status.equals("")) {
                sb.append(" AND status = ?");
                // 将status转换为 Int
                int i = Integer.parseInt(status);
                list.add(i);
            }

            // 执行查询
            // list.toArray() 将集合转为数组
            query = qr.query(sb.toString(), new BeanListHandler<Course>(Course.class),list.toArray());
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    // 保存课程营销信息
    @Override
    public int saveCourseSalesInfo(Course course) {

        try {
            // 1.创建QueryRunner
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

            //2.编写SQL
            String sql = "INSERT INTO course (\n" +
                    "                    course_name, \n" +
                    "                    brief, \n" +
                    "                    teacher_name, \n" +
                    "                    teacher_info,\n" +
                    "                    preview_first_field, \n" +
                    "                    preview_second_field,\n" +
                    "                    discounts,price,\n" +
                    "                    price_tag,\n" +
                    "                    share_image_title,\n" +
                    "                    share_title,\n" +
                    "                    share_description,\n" +
                    "                    course_description,\n" +
                    "                    course_img_url,\n" +
                    "                    status,create_time,\n" +
                    "                    update_time\n" +
                    ")values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            // 3.准备参数
            Object[] param = {course.getCourse_name(),course.getBrief(),course.getTeacher_name(),course.getTeacher_info()
            ,course.getPreview_first_field(),course.getPreview_second_field(),course.getDiscounts(),course.getPrice(),
            course.getPrice_tag(),course.getShare_image_title(),course.getShare_image_title(),course.getShare_description(),
            course.getCourse_description(),course.getCourse_img_url(),course.getStatus(),course.getCreate_time(),
            course.getUpdate_time()};

            // 执行插入操作
            int update = qr.update(sql, param);
            return update;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    // 根据ID查询课程信息
    @Override
    public Course findCourseById(int id) {

        try {
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
            String sql = "Select id,course_name,brief,teacher_name,teacher_info,preview_first_field,preview_second_field,\n" +
                    "discounts,price,price_tag,course_img_url,share_image_title,share_title,share_description,\n" +
                    "course_description,status from course where id = ?;";

            Course course = qr.query(sql, new BeanHandler<Course>(Course.class), id);
            return course;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    // 根据id修改课程营销信息
    @Override
    public int updateCourseSalesInfo(Course course) {

        try {
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
            String sql = "update course set\n" +
                    "course_name = ?,\n" +
                    "brief = ?,\n" +
                    "teacher_name = ?,\n" +
                    "teacher_info = ?,\n" +
                    "preview_first_field = ?,\n" +
                    "preview_second_field = ?,\n" +
                    "discounts = ?,\n" +
                    "price = ?,\n" +
                    "price_tag = ?,\n" +
                    "share_image_title = ?,\n" +
                    "share_title = ?,\n" +
                    "share_description = ?,\n" +
                    "course_description = ?,\n" +
                    "course_img_url = ?,\n" +
                    "status = ?,\n" +
                    "create_time = ?,\n" +
                    "update_time = ?\n" +
                    "where id = ?;";

            Object[] param = {course.getCourse_name(),course.getBrief(),course.getTeacher_name(),
            course.getCourse_name(),course.getPreview_first_field(),course.getPreview_second_field(),
            course.getDiscounts(),course.getPrice(),course.getPrice_tag(),course.getShare_image_title(),
            course.getShare_title(),course.getShare_description(),course.getCourse_description(),
            course.getCourse_img_url(),course.getStatus(),course.getCreate_time(),course.getUpdate_time(),course.getId()};

            int row = qr.update(sql, param);
            return row;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }


}
