package top.luobogan.dao.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.luobogan.dao.UserDao;
import top.luobogan.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/7/10
 */
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAll() throws IOException {

        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(is);

        // 获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行sql
        List<User> list = sqlSession.selectList("UserMapper.findAll");

        // 释放资源
        sqlSession.close();

        return list;

    }


}
