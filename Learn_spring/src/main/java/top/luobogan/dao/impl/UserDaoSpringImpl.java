package top.luobogan.dao.impl;

import org.springframework.stereotype.Repository;
import top.luobogan.dao.IUserDaoSpring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by LuoboGan
 * Date:2021/7/21
 */
@Repository("userDao")
public class UserDaoSpringImpl implements IUserDaoSpring {

    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行了！");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法执行了！");
    }

    public void save() {
        System.out.println("Dao被调用了。");
    }

}
