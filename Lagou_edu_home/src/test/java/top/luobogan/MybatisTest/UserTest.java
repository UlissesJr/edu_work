package top.luobogan.MybatisTest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.luobogan.mapper.UserMapper;
import top.luobogan.mapper.UserMapperAnno;
import top.luobogan.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/7/10
 */
public class UserTest {

    private SqlSessionFactory sqlSessionFactory;

    private SqlSession sqlSession;


    @BeforeEach
    public void _init() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获得SqlSessionFactory工厂对象
        sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(is);

        // 获得SqlSession会话对象
        sqlSession = sqlSessionFactory.openSession();
    }

    @AfterEach
    public void closeSqlSession(){
        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testFindAll() throws Exception {

        // 执行sql
        List<User> list = sqlSession.selectList("UserMapper.findAll");
        for (User user : list) {
            System.out.println(user);
        }

    }

    @Test
    public void testSave() throws Exception {

        // 执行sql
        User user = new User();
        user.setUsername("jack");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("北京海淀");
        sqlSession.insert("UserMapper.saveUser", user);

        // DML语句，手动提交事务
        sqlSession.commit();

    }

    @Test
    public void testUpdate() throws Exception {

        // 执行sql
        User user = new User();
        user.setId(3);
        user.setUsername("lucy");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("北京朝阳");
        sqlSession.update("UserMapper.update", user);

        // DML语句，手动提交事务
        sqlSession.commit();

    }

    @Test
    public void testDelete() throws Exception {

        // 执行sql
        sqlSession.delete("UserMapper.delete", 3);

        // DML语句，手动提交事务
        sqlSession.commit();

    }

    @Test
    public void testMapperFindAllById() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        User user = userMapper.findUserById(1); // 解决statement硬编码问题

        System.out.println(user);

    }

    @Test
    public void testMapperFindAll() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        List<User> allResultMap = userMapper.findAllResultMap();

        for(User user : allResultMap){
            System.out.println(user);
        }


    }

    @Test
    public void testfindByIdAndUsername() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        User user = userMapper.findByIdAndUsername(1,"子慕");

        System.out.println(user);

    }

    @Test
    public void testfindByIdAndUsername2() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        User user = userMapper.findByIdAndUsername2(1,"子慕");

        System.out.println(user);

    }

    @Test
    public void testfindByIdAndUsername3() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("子慕");
        User user = userMapper.findByIdAndUsername3(user1);
        System.out.println(user);

    }

    @Test
    public void findByUsername() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        List<User> byUsername = userMapper.findByUsername("%子%");

        for (User user : byUsername) {
            System.out.println(user);
        }

    }

    @Test
    public void saveUser() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        User user1 = new User();
        user1.setAddress("河南周口");
        user1.setUsername("管至伟");
        user1.setSex("男");
        user1.setBirthday(new Date());
        System.out.println(user1);

        userMapper.saveUser(user1);
        System.out.println(user1);

        sqlSession.commit();

    }

    @Test
    public void saveUser2() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        User user1 = new User();
        user1.setAddress("河南周口");
        user1.setUsername("管至伟");
        user1.setSex("男");
        user1.setBirthday(new Date());
        System.out.println(user1);

        userMapper.saveUser2(user1);
        System.out.println(user1);

        sqlSession.commit();

    }

    @Test
    public void findByIdAndUsernameIf() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        User user1 = new User();

        List<User> byIdAndUsernameIf = userMapper.findByIdAndUsernameIf(user1);

        for (User user : byIdAndUsernameIf) {
            System.out.println(user);
        }

    }

    @Test
    public void updateIf() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("甘富文");
        user1.setAddress("北京中南海");

        userMapper.updateIf(user1);

        sqlSession.commit();

    }

    @Test
    public void findByList() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        List<User> byList = userMapper.findByList(ids);

        for (User user : byList) {
            System.out.println(user);
        }

    }

    @Test
    public void findByArray() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        Integer[] ids = {1,2,4};

        List<User> byList = userMapper.findByArray(ids);

        for (User user : byList) {
            System.out.println(user);
        }

    }


    @Test
    public void findAllPageHelper() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //设置分页参数
        PageHelper.startPage(1,2);

        // 执行查询
        List<User> byList = userMapper.findAllResultMap();

        for(User user : byList){
            System.out.println(user);
        }

        //其他分页的数据
        PageInfo<User> pageInfo = new PageInfo<User>(byList);
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示长度："+pageInfo.getPageSize());
        System.out.println("是否第一页："+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+pageInfo.isIsLastPage());

    }


    @Test
    public void findAllWithOrder1vsN() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        List<User> byList = userMapper.findAllWithOrder1vsN();

        for(User user : byList){
            System.out.println(user);
        }

    }

    @Test
    public void findAllWithOrderNvsN() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        List<User> byList = userMapper.findAllWithRoleNvsN();

        for(User user : byList){
            System.out.println(user);
        }

    }

    @Test
    public void testfindAllWithOrder(){

        // 获得Mapper代理对象 不在写实现类
        UserMapperAnno userMapperAnno = sqlSession.getMapper(UserMapperAnno.class);

        // 执行查询
        List<User> allWithOrder = userMapperAnno.findAllWithOrder();

        for(User user : allWithOrder){
            System.out.println(user);
        }



    }

}
