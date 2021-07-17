package top.luobogan.MybatisTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.*;
import top.luobogan.mapper.OrderMapperAnno;
import top.luobogan.mapper.OrdersMapper;
import top.luobogan.mapper.UserMapper;
import top.luobogan.pojo.Orders;
import top.luobogan.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/7/11
 */
public class OrdersTest {

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
    public void testFindAllWithUser() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        // 执行查询
        List<Orders> allWithUser = ordersMapper.findAllWithUser();

        for (Orders order : allWithUser) {
            System.out.println(order);
        }
    }

    @Test
    public void findAllWithOrders() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        List<User> allWithOrders = userMapper.findAllWithOrders();

        for (User user : allWithOrders) {
            System.out.println(user);
        }

    }

    @Test
    public void findAllWithRole() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 执行查询
        List<User> allWithOrders = userMapper.findAllWithRole();

        for (User user : allWithOrders) {
            System.out.println(user);
        }

    }

    @Test
    public void findAllWithUser1On1() throws IOException {

        // 获得Mapper代理对象 不在写实现类
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        // 执行查询
        List<Orders> allWithOrders = ordersMapper.findAllWithUser1On1();

        for (Orders order : allWithOrders) {
            System.out.println(order);
        }

    }

    @Test
    public void testfindAllWithUser(){

        // 获得Mapper代理对象 不在写实现类
        OrderMapperAnno orderMapperAnno = sqlSession.getMapper(OrderMapperAnno.class);

        // 执行查询
        List<Orders> allWithOrders = orderMapperAnno.findAllWithUser();

        for (Orders order : allWithOrders) {
            System.out.println(order);
        }


    }

}
