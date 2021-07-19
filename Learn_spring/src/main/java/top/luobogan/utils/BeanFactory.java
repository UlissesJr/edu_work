package top.luobogan.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LuoboGan
 * Date:2021/7/19
 */
public class BeanFactory {

    private static Map<String,Object> iocmap = new HashMap<String,Object>();


    // 程序启动时，初始化对象实例
    static{
        // 1.读取配置文件
        InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("Beans.xml");

        // 2.解析xml （dom4j）
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(resourceAsStream);

            // 3. 编写xpath表达式
            String xpath = "//bean";

            // 4. 获取所有的bean标签
            List<Element> list = document.selectNodes(xpath);

            // 5.遍历并使用反射创建对象实例，存到map集合（IOC容器）中
            for (Element element : list) {
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                //使用反射生成实例对象
                Object o = Class.forName(className).newInstance();
                // 存到map中
                iocmap.put(id,o);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static Object getBean(String beanId){
        Object o = iocmap.get(beanId);
        return o;
    }




}
