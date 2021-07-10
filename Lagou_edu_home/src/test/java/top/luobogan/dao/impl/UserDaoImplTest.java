package top.luobogan.dao.impl;

import org.junit.jupiter.api.Test;
import top.luobogan.dao.UserDao;
import top.luobogan.pojo.User;

import java.io.IOException;
import java.util.List;

class UserDaoImplTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void testFindAll() throws IOException {
        List<User> all = userDao.findAll();
        for (User user: all) {
            System.out.println(user);
        }
    }

}