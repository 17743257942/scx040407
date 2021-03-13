package _5_spring.spring._3myspring_aop.service;

import _5_spring.spring._3myspring_aop.model.Account;

public interface IAccountService {

    void saveAccount();

    void updateAccount(Account account);

    int deleteAccount();
}
