package top.luobogan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.luobogan.dao.AccountDao;
import top.luobogan.service.AccountService;
import top.luobogan.utils.TransactionManager;

/**
 * Created by LuoboGan
 * Date:2021/7/25
 */

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionManager transactionManager;

    /*
        转账方法
     */
    public void transfer(String outUser, String inUser, Double money) {

        // 手动开启事务
        transactionManager.beginTransaction();

        try {
            accountDao.out(outUser,money);
            accountDao.in(inUser,money);

            // 手动提交事务
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
            e.printStackTrace();
        }

        // 释放资源
        transactionManager.release();


    }
}
