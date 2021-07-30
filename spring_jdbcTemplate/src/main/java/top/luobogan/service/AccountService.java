package top.luobogan.service;

import org.springframework.stereotype.Service;
import top.luobogan.pojo.Account;

import java.util.List;

@Service
public interface AccountService {

    public List<Account> findAll();
    public Account findById(Integer id);
    public void save(Account account);
    public void update(Account account);
    public void delete(Integer id);

}
