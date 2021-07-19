package top.luobogan.dao.impl;

import top.luobogan.dao.IUserDao;

/**
 * Created by LuoboGan
 * Date:2021/7/19
 */
public class UserDaoImpl implements IUserDao {

    public void save() {
        System.out.println("dao层被调用了。");
    }

}
