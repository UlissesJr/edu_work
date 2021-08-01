package top.luobogan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LuoboGan
 * Date:2021/8/1
 */
@Controller
public class UserController {


    @RequestMapping("/quick")
    public String quick(){
        // 业务逻辑
        System.out.println("Spring MVC 入门成功");
        // 视图跳转 请求转发
        return "/WEB-INF/pages/success.jsp";
    };

}
