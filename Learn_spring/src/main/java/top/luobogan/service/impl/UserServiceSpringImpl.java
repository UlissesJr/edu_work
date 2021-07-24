package top.luobogan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.luobogan.dao.IUserDaoSpring;
import top.luobogan.service.IUserServiceSpring;

/**
 * Created by LuoboGan
 * Date:2021/7/22
 */
@Service("userService")
public class UserServiceSpringImpl implements IUserServiceSpring {

    /*
        依赖注入
     */
    @Autowired
    private IUserDaoSpring userDaoSpring;

    public void save() {

        userDaoSpring.save();

    }
}
