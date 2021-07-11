package top.luobogan.MybatisTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
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

    @Test
    public void testFindAllWithUser() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获得SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(is);

        // 获得SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获得Mapper代理对象 不在写实现类
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        // 执行查询
        List<Orders> allWithUser = ordersMapper.findAllWithUser();

        for (Orders order : allWithUser) {
            System.out.println(order);
        }

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void findAllWithOrders() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获得SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(is);

        // 获得SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获得Mapper代理对象 不在写实现类
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

        // 执行查询
        List<Orders> allWithUser = ordersMapper.findAllWithOrders();

        for (Orders order : allWithUser) {
            System.out.println(order);
        }

        // 释放资源
        sqlSession.close();
    }

}
