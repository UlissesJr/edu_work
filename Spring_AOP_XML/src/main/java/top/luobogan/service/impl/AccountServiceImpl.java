package top.luobogan.service.impl;

import org.springframework.stereotype.Service;
import top.luobogan.service.AccountService;

/**
 * Created by LuoboGan
 * Date:2021/7/29
 */
@Service
public class AccountServiceImpl implements AccountService {

    public void transfer() {
        System.out.println("转账方法执行了");
    }

}
