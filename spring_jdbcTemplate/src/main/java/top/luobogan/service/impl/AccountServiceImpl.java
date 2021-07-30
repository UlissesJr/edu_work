package top.luobogan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.luobogan.dao.AccountDao;
import top.luobogan.pojo.Account;
import top.luobogan.service.AccountService;

import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/7/30
 */
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void delete(Integer id) {
        accountDao.delete(id);
    }
}
