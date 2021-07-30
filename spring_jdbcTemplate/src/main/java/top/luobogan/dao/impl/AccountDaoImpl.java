package top.luobogan.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.luobogan.dao.AccountDao;
import top.luobogan.pojo.Account;

import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/7/30
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> findAll() {
        // 编写sql
        String sql = "select * from account";
        // 执行sql
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>
                (Account.class));
    }

    @Override
    public Account findById(Integer id) {
        // 编写sql
        String sql = "select * from account where id = ?";
        // 执行sql
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>
                (Account.class),id);
    }

    @Override
    public void save(Account account) {
        // 编写sql
        String sql = "insert into account values(null,?,?)";
        // 执行sql
        jdbcTemplate.update(sql, account.getName(), account.getMoney());
    }

    @Override
    public void update(Account account) {
        // 编写sql
        String sql = "update account set name = ?,money = ? where id = ?";
        // 执行sql
        jdbcTemplate.update(sql, account.getName(),
                account.getMoney(),account.getId());
    }

    @Override
    public void delete(Integer id) {
        // 编写sql
        String sql = "delete from account where id = ?";
        // 执行sql
        jdbcTemplate.update(sql, id);
    }
}
