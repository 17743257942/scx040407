package _5_spring.spring._0myspring.dao;

import _5_spring.spring._0myspring.model.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();

    Account findOne(Integer id);

    void save(Account account);

    void update(Account account);

    void delete(Integer id);
}
