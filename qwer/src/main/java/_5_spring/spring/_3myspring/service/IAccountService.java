package _5_spring.spring._3myspring.service;

import _5_spring.spring._3myspring.model.Account;

public interface IAccountService {

    void saveAccount();

    void updateAccount(Account account);

    int deleteAccount();
}
