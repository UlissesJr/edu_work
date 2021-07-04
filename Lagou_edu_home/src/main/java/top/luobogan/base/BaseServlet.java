package top.luobogan.base;

import com.alibaba.fastjson.JSON;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by LuoboGan
 * Date:2021/5/29
 */
public class BaseServlet extends HttpServlet {

    private static final long serialVersionUID = 1016221467564616276L;

    /*
        doGet方法作为一个调度器，根据请求功能的不同，调用对应的方法
        规定必须传递一个参数  methodName=功能名
         */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        // 1.获取参数 要访问的方法名
//        String methodName = req.getParameter("methodName");
        String methodName = null;
        // 1. 获取Content-Type 请求的类型
        String contentType = req.getHeader("Content-Type");
        // 判断传递的数据是不是JSON格式
        if ( contentType.contains("application/json") ) {
            // 是JSON格式，调用getPostJson方法
            String postJson = this.getPostJson(req);
            // 将JSON格式的字符串转换为map
            Map<String,Object> postMap = JSON.parseObject(postJson, Map.class);
            // 从map集合中获取methodName
            methodName = (String)postMap.get("methodName");
            // 将获取到的数据保存到request域对象中
            req.setAttribute("map",postMap);
        }else{
            methodName = req.getParameter("methodName");
        }

        // 2.判断 执行的方法
        if(methodName != null){
            // 通过反射优化代码，提升代码的可维护性
            try {
                // 1.获取字节码文件对象
                Class c = this.getClass();
                // 2.根据传入的方法名，获取对应的方法对象
                Method method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                // 3.调用method对象的 invoke方法， 执行对应的功能
                method.invoke(this,req,resp);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("请求的功能不存在！");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /*
    POST请求格式为： Content-Type : application/json ; charset=utf-8
    使用该方法进行读取
     */
    public String getPostJson(HttpServletRequest req){

        try {
            // 1.从request中 获取缓冲输入流对象
            BufferedReader reader = req.getReader();
            // 2.创建StringBuffer 保存读取出的数据
            StringBuffer sb = new StringBuffer();
            // 3.循环读取
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            // 4. 返回结果
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
