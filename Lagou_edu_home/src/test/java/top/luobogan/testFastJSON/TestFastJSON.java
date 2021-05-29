package top.luobogan.testFastJSON;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by LuoboGan
 * Date:2021/5/29
 */
public class TestFastJSON {

    // Java对象转换为JSON
    @Test
    public void method(){
        // 创建Person对象
        Person p = new Person("小王",25,"2020-05-01");
        // 使用Json对象，将person对象转换为Json数据
        String jsonString = JSON.toJSONString(p);

        System.out.println(jsonString);
    }

    @Test
    public void listToJSON(){
        // 创建Person对象
        Person p1 = new Person("小王1",25,"2020-05-01");
        Person p2 = new Person("小王2",25,"2020-05-01");
        Person p3 = new Person("小王3",25,"2020-05-01");

        // 创建集合，并将数据导入到集合中
        List<Person> list = new ArrayList<>();
        Collections.addAll(list,p1,p2,p3);

        // 转成JSON对象
        String listToJSONString = JSON.toJSONString(list);
        System.out.println(listToJSONString);
    }

    @Test
    public void JsonToObject(){
        String JsonString = "{\"age\":25,\"birthday\":\"2020-05-01\",\"userName\":\"小王1\"}";
        Person person = JSON.parseObject(JsonString, Person.class);
        System.out.println(person);
    }
}
