package top.luobogan.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import top.luobogan.dao.CourseDao;
import top.luobogan.pojo.Course;
import top.luobogan.utils.DruidUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/5/29
 */
// 课程模块的DAO层的实现类
public class CourseDaoImpl implements CourseDao {


    @Override
    public List<Course> findCourseList() {

        List<Course> query = null;

        try {
            // 1.创建QueryRunner 判断是否删除，取出 is_del = 0 的数据 --> 未删除的数据
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
            String sql = "SELECT\n" +
                    "    id,\n" +
                    "    course_name,\n" +
                    "    price,\n" +
                    "    sort_num,\n" +
                    "    status\n" +
                    "FROM course WHERE is_del = ?;";

            // 执行查询
            query = qr.query(sql, new BeanListHandler<Course>(Course.class), 0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return query;
    }
}
