package top.luobogan.MybatisTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import top.luobogan.pojo.User;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/7/10
 */
public class UserTest {

    @Test
    public void testFindAll() throws Exception {

        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(is);

        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql
        List<User> list = sqlSession.selectList("UserMapper.findAll");
        for (User user : list) {
            System.out.println(user);
        }

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testSave() throws Exception {

        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(is);

        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql
        User user = new User();
        user.setUsername("jack");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("北京海淀");
        sqlSession.insert("UserMapper.saveUser", user);

        // DML语句，手动提交事务
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws Exception {

        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(is);

        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

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

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void testDelete() throws Exception {

        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(is);

        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql
        sqlSession.delete("UserMapper.delete", 3);

        // DML语句，手动提交事务
        sqlSession.commit();

        // 释放资源
        sqlSession.close();
    }

}
