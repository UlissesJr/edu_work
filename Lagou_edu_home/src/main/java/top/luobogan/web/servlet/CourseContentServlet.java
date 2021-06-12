package top.luobogan.web.servlet;

import com.alibaba.fastjson.JSON;
import top.luobogan.base.BaseServlet;
import top.luobogan.pojo.Course_Section;
import top.luobogan.service.CourseContentService;
import top.luobogan.service.impl.CourseContentServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
}
