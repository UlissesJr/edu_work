package top.luobogan.config;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * Created by LuoboGan
 * Date:2021/7/24
 */
@Configuration
@ComponentScan("top.luobogan")
@Import(DatasourceConfig.class)
@EnableAspectJAutoProxy //替代 <aop:aspectj-autoproxy />
public class SpringConfig {

    @Bean
    public QueryRunner getQueryRunner(@Autowired DataSource dataSource){

        QueryRunner queryRunner = new QueryRunner(dataSource);
        return queryRunner;

    }















}
