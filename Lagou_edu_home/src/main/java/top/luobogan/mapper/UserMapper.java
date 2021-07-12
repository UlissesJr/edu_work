package top.luobogan.mapper;

import org.apache.ibatis.annotations.Param;
import top.luobogan.pojo.Orders;
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

    // 添加user，获取返回主键 useGeneratedKeys
    public void saveUser(User user);

    // 添加user，获取返回主键  selectKey
    public void saveUser2(User user);

    // 动态sql where
    public List<User> findByIdAndUsernameIf(User user);

    // 动态sql set
    public void updateIf(User user);

    // 动态sql foreach 多值查询 集合
    public List<User> findByList(List<Integer> ids);

    // 动态sql foreach 多值查询 数组
    public List<User> findByArray(Integer[] ids);

    /*
        一对多关联查询：查询所有用户，与此同时还要查询出每个用户拥有的订单信息
     */
    public List<User> findAllWithOrders();

    /*
        多对多关联查询：查询所有用户以及用户对应的角色
     */
    public List<User> findAllWithRole();

    /*
        根据id查询用户
     */
    public User findById(Integer id);

    /*
        1vsN 嵌套查询
     */
    public List<User> findAllWithOrder1vsN();

}
