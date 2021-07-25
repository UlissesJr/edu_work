package top.luobogan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
 * Created by LuoboGan
 * Date:2021/7/25
 */

/*
 * 连接工具类，从数据源中获取一个连接，并将实现和线程的绑定
 * ThreadLocal 线程内部的存储类，可以在指定的线程内存储数据  key:(ThreadLocal 当前线程) value:任意类型的值
 */
@Component
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;
    /**
     * 获取当前线程上的连接
     *
     * @return Connection
     */
    public Connection getThreadConnection() {
        // 1.先从ThreadLocal上获取
        Connection connection = threadLocal.get();
        // 2.判断当前线程是否有连接
        if (connection == null) {
            try {
        // 3.从数据源中获取一个连接，并存入到ThreadLocal中
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 解除当前线程的连接绑定
     */
    public void removeThreadConnection() {
        threadLocal.remove();
    }

}
