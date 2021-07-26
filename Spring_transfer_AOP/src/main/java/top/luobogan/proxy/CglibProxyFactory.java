package top.luobogan.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;
import top.luobogan.service.AccountService;
import top.luobogan.utils.TransactionManager;

import java.lang.reflect.Method;

/**
 * Created by LuoboGan
 * Date:2021/7/26
 * 该类就是采用cglib动态代理对目标类（AccountServiceImpl）进行方法（transfer）的动态增强
 */
@Component
public class CglibProxyFactory {

    @Autowired
    private AccountService accountService;
    @Autowired
    private TransactionManager transactionManager;

    public AccountService createAccountServiceCglibProxy() {
        AccountService accountServiceProxy = null;
        /*
         * 参数一：目标对象的字节码对象
         * 参数二：动作类，实现增强功能
         * */
        accountServiceProxy = (AccountService)
                Enhancer.create(accountService.getClass(), new MethodInterceptor() {
                    @Override
                    // o代表生成的代理对象、method调用目标方法的引用、objects方法入参、methodProxy代理方法
                    public Object intercept(Object o, Method method, Object[] objects,
                                            MethodProxy methodProxy) throws Throwable {
                        Object result = null;
                        try {
                            // 1.开启事务
                            transactionManager.beginTransaction();
                            // 2.业务操作
                            result = method.invoke(accountService, objects);
                            // 3.提交事务
                            transactionManager.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                            // 4.回滚事务
                            transactionManager.rollback();
                        } finally {
                            // 5.释放资源
                            transactionManager.release();
                        }
                        return result;
                    }
                });
        return accountServiceProxy;
    }


}
