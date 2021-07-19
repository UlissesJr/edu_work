package top.luobogan.service.impl;

import top.luobogan.dao.IUserDao;
import top.luobogan.dao.impl.UserDaoImpl;
import top.luobogan.service.IUserService;
import top.luobogan.utils.BeanFactory;

/**
 * Created by LuoboGan
 * Date:2021/7/19
 */
public class UserServiceImpl implements IUserService {

    public void save() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 调用dao层方法 传统方式
//        IUserDao userDao = new UserDaoImpl();

        //反射 这种方式存在硬编码
//        IUserDao userDao = (IUserDao) Class.forName("top.luobogan.dao.impl.UserDaoImpl").newInstance();

        // 使用配置文件的方式
        UserDaoImpl userDao = (UserDaoImpl) BeanFactory.getBean("userdao");

        userDao.save();

    }

}
