package top.luobogan.mapper;

import top.luobogan.pojo.Orders;
import top.luobogan.pojo.User;

import java.util.List;

public interface OrdersMapper {

    /*
    一对一关联查询：查询所有订单，与此同时还要查询出每个订单所属的用户信息
     */
    public List<Orders> findAllWithUser();

    /*
        一对一嵌套查询
     */
    public List<Orders> findAllWithUser1On1();




}
