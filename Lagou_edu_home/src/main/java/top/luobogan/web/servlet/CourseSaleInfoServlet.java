package top.luobogan.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import top.luobogan.base.Constants;
import top.luobogan.pojo.Course;
import top.luobogan.service.CourseService;
import top.luobogan.service.impl.CourseServiceImpl;
import top.luobogan.utils.DateUtils;
import top.luobogan.utils.UUIDUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LuoboGan
 * Date:2021/6/1
 */

@WebServlet("/courseSalesInfo")
public class CourseSaleInfoServlet extends HttpServlet {

    /*
    保存课程营销信息
        收集表单的数据，封装到course对象中，将图片上传到tomcat服务器中
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Course course = new Course();
            // 创建map 用来收集数据
            Map<String,Object> map = new HashMap<>();

            // 创建磁盘工程对象
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 文件上传核心对象
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            // 解析request对象，获取表单项的集合
            List<FileItem> list = fileUpload.parseRequest(req);
            // 遍历集合，判断哪些是普通的表单项，哪些是文件表单项
            for (FileItem fileItem : list) {

                boolean formField = fileItem.isFormField();
                if (formField) {
                    // 是普通表单项，获取表单项中的数据，保存map
                    String fieldName = fileItem.getFieldName(); // 属性名
                    String value = fileItem.getString("utf-8");
                    System.out.println(fieldName + " " + value);
                    // 使用map 收集数据
                    map.put(fieldName,value);
                } else {
                    // 是文件上传项
                    // 获取文件名
                    String fileName = fileItem.getName();
                    String newFileName = UUIDUtils.getUUID()+"_"+ fileName;

                    // 获取输入流
                    InputStream inputStream = fileItem.getInputStream();
                    // 获取当前项目的部署路径
                    String realPath = this.getServletContext().getRealPath("/");
                    // 获取 webapps的路径
                    String webappPath = realPath.substring(0, realPath.indexOf("lagou_edu_home")-1);

                    // 创建输出流
                    String separator = File.separator;
                    OutputStream outputStream = new FileOutputStream(webappPath+separator+"upload"+separator+newFileName);

                    // 使用 IOUtils 完成文件的 copy
                    IOUtils.copy(inputStream, outputStream);

                    // 关闭流
                    outputStream.close();
                    inputStream.close();

                    // 将图片路径进行保存
                    map.put("course_img_url", Constants.LOCAL_URL +separator + "upload" + separator + newFileName);

                }
            }

            // 使用BeanUtils将map中的数据封装到course对象
            BeanUtils.populate(course,map);

            // 根据是否有 id 字段，来确定是新增数据还是修改数据
            CourseService courseService = new CourseServiceImpl();
            String dateFormart = DateUtils.getDateFormart();
            String result;

            if (map.get("id") != null) {
                // 修改操作
                result = courseService.updateCourseSalesInfo(course);
            }else{
                // 新增操作
                course.setCreate_time(dateFormart);
                result = courseService.saveCourseSalesInfo(course);
            }

            resp.getWriter().print(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
