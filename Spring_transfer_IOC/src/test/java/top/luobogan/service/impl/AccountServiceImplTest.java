package top.luobogan.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.luobogan.config.SpringConfig;
import top.luobogan.service.AccountService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
// RunWith指定Junit的运行环境，SpringJUnit4ClassRunner是Spring提供的作为Junit运行环境的一个类
// @ContextConfiguration(value = {"classpath:applicationContext.xml"}) 加载spring核心配置文件
@ContextConfiguration(classes = {SpringConfig.class})
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransfer(){
        accountService.transfer("tom","jerry",500.0);

    }

}