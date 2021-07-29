package top.luobogan.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by LuoboGan
 * Date:2021/7/29
 */
@Component
@Aspect // 升级为切面类
public class MyAdvice {

    @Before("execution(* *..*.AccountServiceImpl.transfer(..))")
    public void before(){
        System.out.println("前置通知执行了");
    }



}
