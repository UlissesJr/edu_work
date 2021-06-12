package top.luobogan.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import org.apache.commons.beanutils.BeanUtils;
import top.luobogan.base.BaseServlet;
import top.luobogan.pojo.Course;
import top.luobogan.pojo.Course_Section;
import top.luobogan.service.CourseContentService;
import top.luobogan.service.impl.CourseContentServiceImpl;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by LuoboGan
 * Date:2021/6/12
 */

@WebServlet("/courseContent")
public class CourseContentServlet extends BaseServlet {

    // 展示对应课程的章节和课时信息
    public void findSectionAndLessonByCourseId(HttpServletRequest request, HttpServletResponse response){

        try {
            // 1.获取参数
            String course_id = request.getParameter("course_id");

            // 2.业务处理
            CourseContentService contentService = new CourseContentServiceImpl();
            List<Course_Section> course_sectionList = contentService.findSectionAndLessonByCourseId(Integer.parseInt(course_id));

            // 3.返回结果
            String sectionJsonString = JSON.toJSONString(course_sectionList);
            response.getWriter().print(sectionJsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 根据课程id 回显课程信息
    public void findCourseById(HttpServletRequest request, HttpServletResponse response) {

        try {
            // 1.获取参数
            String course_id = request.getParameter("course_id");

            // 2.业务处理
            CourseContentService contentService = new CourseContentServiceImpl();
            Course course = contentService.findCourseByCourseId(Integer.parseInt(course_id));

            // 3.返回JSON数据
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Course.class, "id", "course_name");
            String result = JSON.toJSONString(course,filter);
            response.getWriter().write(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 保存或者修改章节信息
    public void saveOrUpdateSection(HttpServletRequest request, HttpServletResponse response){

        try {
            // 获取参数 从域对象中获取
            Map<String,Object> map = (Map)request.getAttribute("map");

            // 创建Course_Section
            Course_Section course_section = new Course_Section();

            // 使用BeanUtils工具类，将map重点而数据封装到section中
            BeanUtils.populate(course_section,map);

            // 业务处理
            CourseContentService courseContentService = new CourseContentServiceImpl();
            String result = courseContentService.saveSection(course_section);

            //响应结果
            response.getWriter().write(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
