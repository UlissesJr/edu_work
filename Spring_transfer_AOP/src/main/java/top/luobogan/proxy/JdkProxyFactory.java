package top.luobogan.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.luobogan.service.AccountService;
import top.luobogan.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by LuoboGan
 * Date:2021/7/25
 */
@Component
public class JdkProxyFactory {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager transactionManager;

    /*
        采用JDK动态代理技术来生成目标类的代理对象
        ClassLoader loader : 类加载器：借助被代理对象获取到类加载器
        Class<?>[] interfaces : 被代理类所需要实现的全部接口
        InvocationHandler : 当被代理对象调用接口中的任意方法时，那么都会执行InvocationHandler中的invoke方法
     */
    public AccountService createAccountServiceJdkProxy() {

        AccountService accountServiceProxy = null;
        accountServiceProxy = (AccountService)
                Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                        accountService.getClass().getInterfaces(), new
                                InvocationHandler() {
                                    @Override
                                    /*
                                        proxy 当前代理对象引用 method 被调用的目标方法的引用
                                        args 被调用的目标方法所用到的参数
                                     */
                                    public Object invoke(Object proxy, Method method, Object[] args)
                                            throws Throwable {
                                        Object result = null;
                                        try {
                                            // 1.开启事务
                                            transactionManager.beginTransaction();
                                            // 2.业务操作
                                            result = method.invoke(accountService, args);
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
