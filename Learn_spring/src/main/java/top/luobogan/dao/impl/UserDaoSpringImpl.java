package top.luobogan.dao.impl;

import top.luobogan.dao.IUserDaoSpring;

/**
 * Created by LuoboGan
 * Date:2021/7/21
 */
public class UserDaoSpringImpl implements IUserDaoSpring {

    public void init(){
        System.out.println("初始化方法执行了！");
    }

    public void destroy(){
        System.out.println("销毁方法执行了！");
    }

    public void save() {
        System.out.println("Dao被调用了。");
    }

}
