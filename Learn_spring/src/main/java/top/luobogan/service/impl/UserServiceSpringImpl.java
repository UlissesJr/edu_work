package top.luobogan.service.impl;

import top.luobogan.dao.IUserDaoSpring;
import top.luobogan.service.IUserServiceSpring;

/**
 * Created by LuoboGan
 * Date:2021/7/22
 */
public class UserServiceSpringImpl implements IUserServiceSpring {

    /*
        依赖注入
     */
    private IUserDaoSpring userDaoSpring;

    public UserServiceSpringImpl() {
    }

    public UserServiceSpringImpl(IUserDaoSpring userDaoSpring) {
        this.userDaoSpring = userDaoSpring;
    }

    public void save() {

        userDaoSpring.save();

    }
}
