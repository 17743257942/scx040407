package _5_spring.spring._2myspring.service;

import _5_spring.spring._2myspring.model.Account;

public interface IAccountService {

    void saveAccount();

    void updateAccount(Account account);

    int deleteAccount();
}
