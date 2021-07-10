package top.luobogan.dao;

import top.luobogan.pojo.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {

    public List<User> findAll() throws IOException;

}
