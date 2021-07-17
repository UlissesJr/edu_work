package top.luobogan.pojo;

/**
 * Created by LuoboGan
 * Date:2021/7/11
 */
public class Orders {

    private Integer id;
    private String ordertime;
    private double total;
    private Integer uid;

    // 为关联查询做准备  orders.uid 为外键  注意为user创建 get set 方法
    private User user;

    private Orders(){};

    public Orders(Integer id, String ordertime, double total, Integer uid, User user) {
        this.id = id;
        this.ordertime = ordertime;
        this.total = total;
        this.uid = uid;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", ordertime='" + ordertime + '\'' +
                ", total=" + total +
                ", uid=" + uid +
                ", user=" + user +
                '}';
    }
}
