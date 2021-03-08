package _5_spring.spring._1myspring.service;

import _5_spring.spring._1myspring.model.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();

    Account findOne(Integer id);

    void save(Account account);

    void update(Account account);

    void delete(Integer id);
}
