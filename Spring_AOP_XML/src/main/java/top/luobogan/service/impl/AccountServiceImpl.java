package top.luobogan.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.luobogan.service.AccountService;

/**
 * Created by LuoboGan
 * Date:2021/7/29
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Transactional(propagation = Propagation.REQUIRED,
    isolation = Isolation.REPEATABLE_READ , timeout = -1 , readOnly = false)
    public void transfer() {
        System.out.println("转账方法执行了");
    }

}
