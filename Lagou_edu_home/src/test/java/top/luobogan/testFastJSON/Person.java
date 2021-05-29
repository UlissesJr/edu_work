package top.luobogan.testFastJSON;

import com.alibaba.fastjson.annotation.JSONField;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by LuoboGan
 * Date:2021/5/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    // 可以通过name属性去指定JSON输出的名称
    // ordinal指定输出的顺序
    // serialize 指定是否序列化
    @JSONField(name="USERNAME",ordinal=1)
    private String userName;

    @JSONField(name="AGE")
    private int age;

    @JSONField(serialize = false)
    private String birthday;

}
