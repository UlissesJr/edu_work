package top.luobogan.mapper;

import org.apache.ibatis.annotations.Param;
import top.luobogan.pojo.User;

import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/7/10
 */
public interface UserMapper {

    public User findUserById(int id);

    public List<User> findAllResultMap();

    public User findByIdAndUsername(int id, String username);

    public User findByIdAndUsername2(@Param("id") int id, @Param("username") String username);

    // 多条件查询推荐使用该种方式
    public User findByIdAndUsername3(User user);

    // 模糊查询
    public List<User> findByUsername(String username);


}
