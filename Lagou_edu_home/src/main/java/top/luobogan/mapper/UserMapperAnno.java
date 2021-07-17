package top.luobogan.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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



}
