package top.luobogan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by LuoboGan
 * Date:2021/7/31
 */
@Configuration // 声明为spring配置类
@ComponentScan("top.luobogan") // 扫描包
@Import(DataSourceConfig.class) // 导入其他配置类
@EnableTransactionManagement // 事务的注解驱动

public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("transactionManager")
    public PlatformTransactionManager getPlatformTransactionManager(@Autowired
                                                                                DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
