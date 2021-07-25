package top.luobogan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by LuoboGan
 * Date:2021/7/25
 */
/*
    事务管理器工具类：开启事务、提交事务、回滚事务、释放资源；
 */
@Component
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(true); // 改回自动提交事务
            connectionUtils.getThreadConnection().close();// 归还到连接池
            connectionUtils.removeThreadConnection();// 解除线程绑定
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
