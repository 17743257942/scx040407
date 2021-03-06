package _5_spring.spring._0myspring.service;

import _5_spring.spring._0myspring.model.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();

    Account findOne(Integer id);

    void save(Account account);

    void update(Account account);

    void delete(Integer id);
}
