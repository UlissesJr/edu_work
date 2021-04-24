package top.luobogan.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by LuoboGan
 * Date:2021/4/24
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {

    /*
    doGet方法作为一个调度器，根据请求功能的不同，调用对应的方法
    规定必须传递一个参数  methodName=功能名
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1.获取参数 要访问的方法名
        String methodName = req.getParameter("methodName");

        // 2.判断 执行的方法
        if("addCourse".equals(methodName)){
            addCourse(req,resp);
        }else if("findByName".equals(methodName)){
            findBuName(req, resp);
        }else if("findByStatus".equals(methodName)){
            findByStatus(req,resp);
        }else{
            System.out.println("请求的功能不存在");
        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    // 添加课程
    public void addCourse(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("新建课程");
    }

    //
    public void findBuName(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("根据课程名进行查询");
    }

    // 添加课程
    public void findByStatus(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("根据课程状态进行查询");
    }
}
