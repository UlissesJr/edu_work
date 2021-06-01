package top.luobogan.web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import top.luobogan.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/5/31
 */
@WebServlet("/upload")
public class FileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = -2525043118670867112L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // 1. 创建磁盘的文件的工厂对象
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 2. 创建文件上传的核心类
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 2.1 设置文件上传编码
            upload.setHeaderEncoding("utf-8");
            // 2.2 判断表单是否是文件上传表单
            boolean multipartContent = ServletFileUpload.isMultipartContent(req);
            // 2.3 是文件上传表单
            if (multipartContent) {
                // 3. 解析 request --- 获取表单项的集合
                List<FileItem> list = upload.parseRequest(req);
                if (list != null) {
                    for (FileItem item : list) {
                        // 5. 判断当前表单项是不是普通表单项
                        boolean formField = item.isFormField();
                        if (formField) {
                            // 普通表单项
                            String fieldName = item.getFieldName();
                            String fieldValue = item.getString("utf-8");
                            System.out.println(fieldName + "=" + fieldValue);
                        }else{
                            // 文件上传项
                            // 获取文件名
                            String fileName = item.getName();

                            // 拼接新的用户名，使用UUID保证不重复
                            String newFileName = UUIDUtils.getUUID() + "_" + fileName;

                            // 获取输入流
                            // 1. 获取项目的运行目录 //E:\apache-tomcat-8.5.59\webapps\lagou_edu_home\
                            String realPath = this.getServletContext().getRealPath("/");
                            // 2. 截取到 webapps 目录路径
                            String webappsPath = realPath.substring(0, realPath.indexOf("lagou_edu_home"));

                            InputStream inputStream = item.getInputStream();
                            // 3. 拼接输出路径，将图片保存到upload
                            // 创建输出流
                            FileOutputStream fileOutputStream = new FileOutputStream(webappsPath + "/upload/" + newFileName);

                            // 使用 IOUtils 完成文件的 copy
                            IOUtils.copy(inputStream, fileOutputStream);

                            // 关闭流
                            fileOutputStream.close();
                            inputStream.close();

                        }

                    }
                }

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
