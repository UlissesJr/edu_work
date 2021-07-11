package top.luobogan.mapper;

import top.luobogan.pojo.Orders;

import java.util.List;

public interface OrdersMapper {

    /*
    一对一关联查询：查询所有订单，与此同时还要查询出每个订单所属的用户信息
     */
    public List<Orders> findAllWithUser();

    /*
    一对多关联查询：查询所有用户，与此同时还要查询出每个用户拥有的订单信息
     */
    public List<Orders> findAllWithOrders();


}
