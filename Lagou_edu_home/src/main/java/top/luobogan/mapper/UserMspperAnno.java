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
public interface UserMspperAnno {

    @Select("Select * from user")
    public List<User> findAll();

    @Insert("Insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    public void save(User user);

    @Update("update user set username = #{username} where id = #{id}")
    public void update(User user);

    @Delete("delete from user where id = #{id}")
    public void delete(Integer id);



}
