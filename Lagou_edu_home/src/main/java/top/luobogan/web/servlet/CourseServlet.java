package top.luobogan.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import top.luobogan.base.BaseServlet;
import top.luobogan.pojo.Course;
import top.luobogan.service.CourseService;
import top.luobogan.service.impl.CourseServiceImpl;
import top.luobogan.utils.DateUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by LuoboGan
 * Date:2021/5/29
 */
@WebServlet("/course")
public class CourseServlet extends BaseServlet {

    private static final long serialVersionUID = 246531092441870669L;

    // 查询课程信息的列表
    public void findCourseList(HttpServletRequest request, HttpServletResponse response){

        try {
            // 业务处理
            CourseService cs = new CourseServiceImpl();
            List<Course> courseList = cs.findCourseList();

            // 响应结果
            SimplePropertyPreFilter propertyPreFilter = new SimplePropertyPreFilter(Course.class,
                    "id","course_name","price","sort_num","status");

            String result = JSON.toJSONString(courseList,propertyPreFilter);
            response.getWriter().print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 根据条件查询课程信息
    public void findByCourseNameAndStatus(HttpServletRequest request, HttpServletResponse response){

        try {
            // 接收参数
            String course_name = request.getParameter("course_name");
            String status = request.getParameter("status");

            // 业务处理
            CourseService cs = new CourseServiceImpl();
            List<Course> courseList = cs.findByCourseNameAndStatus(course_name,status);

            // 响应结果
            SimplePropertyPreFilter propertyPreFilter = new SimplePropertyPreFilter(Course.class,
                    "id","course_name","price","sort_num","status");

            String result = JSON.toJSONString(courseList,propertyPreFilter);
            response.getWriter().print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 根据条件查询课程信息

    /*
        服务端获取上传文件步骤
        1. 通过request获取请求体的内容
        2. 解析请求体 多部件上传的特点：每一个input 都是一个表单项，根据分隔符将请求中的所有内容进行切割，
        获取到数组，数组中每一个元素就是一个表单项
        3. 遍历数组，分清哪个是普通上传项，哪个是文件上传项，判断是否有fileName
        4. 获取普通上传项中的内容 通过属性 name获取
        5. 获取文件上传项， 文件名 文件内容
        6. 使用IO将文件的内容保存到服务器
     */
//    public void saveCourseSalesInfo(HttpServletRequest request, HttpServletResponse response){
//
//    }

    // 根据课程id查询课程信息
    public void findCourseById(HttpServletRequest request, HttpServletResponse response){

        try {
            // 1. 接收参数
            String id = request.getParameter("id");

            // 2. 业务处理
            CourseService service = new CourseServiceImpl();
            Course courseById = service.findCourseById(Integer.parseInt(id));

            // 3. 返回结果
            String result = JSON.toJSONString(courseById);

            response.getWriter().print(result);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // 修改课程状态
    public void updateCourseStatus(HttpServletRequest request, HttpServletResponse response){

        // 1.获取参数
        String id = request.getParameter("id");

        // 2.业务处理
        CourseService service = new CourseServiceImpl();

        // 根据课程id 传递课程信息
        Course course = service.findCourseById(Integer.parseInt(id));

        // 判断课程信息状态，进行取反设置
        int status = course.getStatus();
        if (status == 0) {
            course.setStatus(1);
        }else{
            course.setStatus(0);
        }

        // 设置更新时间
        course.setUpdate_time(DateUtils.getDateFormart());

        // 修改课程状态
        Map<String, Integer> stringIntegerMap = service.updateCourseStatus(course);

        // 响应结果
        String result = JSON.toJSONString(stringIntegerMap);

        try {
            response.getWriter().print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
