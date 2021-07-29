package top.luobogan.dao;

/**
 * Created by LuoboGan
 * Date:2021/7/25
 */
public interface AccountDao {

    // 转出操作
    public void out(String outUser, Double money);


    // 转入操作
    public void in(String inUser, Double money);


}
