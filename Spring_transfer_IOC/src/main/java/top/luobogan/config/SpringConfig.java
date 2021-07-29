package top.luobogan.config;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

/**
 * Created by LuoboGan
 * Date:2021/7/24
 */
@Configuration // 标明为配置类
@ComponentScan("top.luobogan")
@Import(DatasourceConfig.class)
public class SpringConfig {

    @Bean
    public QueryRunner getQueryRunner(@Autowired DataSource dataSource){

        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;

    }

}
