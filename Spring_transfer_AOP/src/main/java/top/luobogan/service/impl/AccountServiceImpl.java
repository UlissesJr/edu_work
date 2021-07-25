package top.luobogan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.luobogan.dao.AccountDao;
import top.luobogan.service.AccountService;

/**
 * Created by LuoboGan
 * Date:2021/7/25
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    /*
        转账方法
     */
    public void transfer(String outUser, String inUser, Double money) {

        accountDao.out(outUser,money);
        accountDao.in(inUser,money);

    }
}
