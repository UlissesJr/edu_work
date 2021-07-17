package top.luobogan.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import top.luobogan.pojo.Orders;
import top.luobogan.pojo.User;

import java.util.List;

public interface OrderMapperAnno {

    @Select("select * from orders")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(column = "uid", property = "uid"),
            @Result(property = "user", javaType = User.class,
                    column = "uid", one = @One(select =
                    "top.luobogan.mapper.UserMapperAnno.findById", fetchType = FetchType.EAGER))
    })
    public List<Orders> findAllWithUser();

    @Select("select * from orders where uid = #{uid}")
    public List<Orders> findByUid(Integer uid);


}
