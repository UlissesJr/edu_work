package top.luobogan.demo01;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by LuoboGan
 * Date:2021/6/20
 */
@WebServlet("/checkName")
public class CheckNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        HashMap<String,Object> map = new HashMap<>();

        if ("tom".equals(username)) {
            map.put("flag",true);
            map.put("msg","用户名已经被占用了！");

            String data = JSON.toJSONString(map);
            resp.getWriter().print(data);
        }else{
            map.put("flag",false);
            map.put("msg","用户名可以使用！");

            String data = JSON.toJSONString(map);
            resp.getWriter().print(data);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
