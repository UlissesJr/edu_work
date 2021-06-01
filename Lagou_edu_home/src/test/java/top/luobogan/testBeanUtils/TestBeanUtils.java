package top.luobogan.testBeanUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;
import top.luobogan.pojo.Course;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LuoboGan
 * Date:2021/6/1
 */
public class TestBeanUtils {

    @Test
    public void test01(){
        try {
            // 1. 创建Course对象
            Course course = new Course();
            // 2. 创建map
            Map<String,Object> map = new HashMap<>();
            // 3. 向map集合中添加数据 key要与course的属性名保持一致，value的数据类型与course的属性的累心保持一致
            map.put("id",1);
            map.put("course_name","大数据");
            map.put("brief","课程包含所有大数据流行的技术");
            map.put("teacher_name","周星星");
            map.put("info","非著名演员");

            // 将map中的数据封装到 BeanUtils
            BeanUtils.populate(course,map);

            System.out.println(course.getId());

            // 设置属性
            BeanUtils.setProperty(course,"price",100.0);
            String price = BeanUtils.getProperty(course, "price");
            System.out.println(price);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIndexOfMethod(){
        String str = "http://localhost:8080/lagou_edu_home";
        int llo = str.indexOf("lagou_edu_home");
        String substring = str.substring(0, llo);
        System.out.println(llo);
        System.out.println(substring);

    }

}
