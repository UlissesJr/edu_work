package top.luobogan.mapper;

import top.luobogan.pojo.User;

import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/7/10
 */
public interface UserMapper {

    public User findUserById(int id);

    public List<User> findAllResultMap();

}
