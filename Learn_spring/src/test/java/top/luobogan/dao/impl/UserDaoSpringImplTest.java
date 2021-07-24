package top.luobogan.dao.impl;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import top.luobogan.config.SpringConfig;
import top.luobogan.dao.IUserDaoSpring;

import static org.junit.Assert.*;

public class UserDaoSpringImplTest {



    @Test
    public void testSaveSpring(){

        /*
            获取到了Spring上下文对象，借助上下文对象获取到IOC容器中的bean对象
            加载applicationContext.xml的同时就创建了Bean对象，存到了容器中。
            ApplicationContext 代表应用上下文对象，可以获得spring中IOC容器的Bean对象。
            特点：在spring容器启动时，加载并创建所有对象的实例
            常用实现类
            1. ClassPathXmlApplicationContext
             它是从类的根路径下加载配置文件 推荐使用这种。
            2. FileSystemXmlApplicationContext
             它是从磁盘路径上加载配置文件，配置文件可以在磁盘的任意位置。
            3. AnnotationConfigApplicationContext
             当使用注解配置容器对象时，需要使用此类来创建 spring 容器。它用来读取注解。
            常用方法：
            1. Object getBean(String name);
             根据Bean的id从容器中获得Bean实例，返回是Object，需要强转。
            2. <T> T getBean(Class<T> requiredType);
             根据类型从容器中匹配Bean实例，当容器中相同类型的Bean有多个时，则此方法会报错。
            3. <T> T getBean(String name,Class<T> requiredType);
             根据Bean的id和类型获得Bean实例，解决容器中相同类型Bean有多个情况。
         */
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        IUserDaoSpring userDaoSpring = (IUserDaoSpring) applicationContext.getBean("userDao");
        IUserDaoSpring userDaoSpring2 = (IUserDaoSpring) applicationContext.getBean("userDao");
        // scope 选择 prototype，初始化方法执行了两次
        userDaoSpring.save();
        userDaoSpring2.save();

    }

    public void testBeanFactory(){

        /*
            BeanFactory是 IOC 容器的核心接口，它定义了IOC的基本功能。
            特点：在第一次调用getBean()方法时，创建指定对象的实例.
         */
        BeanFactory beanFactory =
                new XmlBeanFactory(new
                        ClassPathResource("applicationContext.xml"));
        IUserDaoSpring userDaoSpring = (IUserDaoSpring) beanFactory.getBean("userDao");
        userDaoSpring.save();
    }

    /*
        测试纯注解方式的Spring
     */
    @Test
    public void testAnno(){

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        Object userDao = annotationConfigApplicationContext.getBean("userDao");
        System.out.println(userDao);
    }


}