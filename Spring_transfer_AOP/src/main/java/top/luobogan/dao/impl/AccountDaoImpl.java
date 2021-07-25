package top.luobogan.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.luobogan.dao.AccountDao;
import top.luobogan.utils.ConnectionUtils;

import java.sql.SQLException;

/**
 * Created by LuoboGan
 * Date:2021/7/25
 */
@Repository("accountDao") // 生成该类实例存到IOC容器中
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner queryRunner;

    @Autowired
    private ConnectionUtils connectionUtils;

    /*
        转出操作
     */
    public void out(String outUser, Double money) {

        String sql = "update account set money = money - ? where name = ? ;";
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),sql,money,outUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    /*
        转入操作
    */
    public void in(String inUser, Double money) {

        String sql = "update account set money = money + ? where name = ? ;";
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),sql,money,inUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
