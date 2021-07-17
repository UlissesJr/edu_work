package top.luobogan.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import top.luobogan.pojo.Orders;
import top.luobogan.pojo.User;

import java.util.List;

/*
    基于注解的方式开发Mybatis

 */
public interface UserMapperAnno {

    @Select("Select * from user")
    public List<User> findAll();

    @Insert("Insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    public void save(User user);

    @Update("update user set username = #{username} where id = #{id}")
    public void update(User user);

    @Delete("delete from user where id = #{id}")
    public void delete(Integer id);

    /*
        注意这一返回值写错也不可以，之前写Void，一直提示找不到Void对应的构造函数
     */
    @Select("select * from user where id = #{uid}")
    public User findById(Integer uid);

    /*
        一对多查询，查询用户并且查询用户拥有的订单
     */
    @Select("select * from user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "address", property = "address"),
            @Result(property = "ordersList", javaType = List.class, // 注意这里为List
                    column = "id", many = @Many(select =
                    "top.luobogan.mapper.OrderMapperAnno.findByUid", fetchType = FetchType.EAGER))
    })
    public List<User> findAllWithOrder();

    /*
        多对多查询,与一对多相比如要查询在SQL编写上,多了一张中间表
     */
    @Select("select * from user")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "roleList", javaType = List.class,
            column = "id" , many = @Many(
                    select = "top.luobogan.mapper.RoleMapperAnno.finbdByUid",
                    fetchType = FetchType.EAGER
            ))
    })
    public List<User> findAllWithRole();



}
