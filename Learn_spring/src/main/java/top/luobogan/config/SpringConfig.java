package top.luobogan.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Created by LuoboGan
 * Date:2021/7/24
 */
@Configuration
@ComponentScan("top.luobogan")
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {

    @Value("${jdbc.driverClassName}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    @Bean // 将方法的返回值存储到容器中
    public DataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        return druidDataSource;

    }

    @Bean
    public QueryRunner getQueryRunner(@Autowired DataSource dataSource){

        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;

    }















}
