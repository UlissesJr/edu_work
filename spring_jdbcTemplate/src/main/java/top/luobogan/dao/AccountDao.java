package top.luobogan.dao;

import top.luobogan.pojo.Account;

import java.util.List;

public interface AccountDao {

    public List<Account> findAll();
    public Account findById(Integer id);
    public void save(Account account);
    public void update(Account account);
    public void delete(Integer id);

}
