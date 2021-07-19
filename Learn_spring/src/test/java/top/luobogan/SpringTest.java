package top.luobogan;

import org.junit.Test;
import top.luobogan.service.IUserService;
import top.luobogan.service.impl.UserServiceImpl;

/**
 * Created by LuoboGan
 * Date:2021/7/19
 */
public class SpringTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        // 获取业务层对象
        IUserService userService = new UserServiceImpl();
        userService.save();

    }


}
