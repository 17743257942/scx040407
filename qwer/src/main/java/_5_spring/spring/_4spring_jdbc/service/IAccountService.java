package _5_spring.spring._4spring_jdbc.service;

import _5_spring.spring._4spring_jdbc.model.Account;

public interface IAccountService {

    void saveAccount();

    void updateAccount(Account account);

    int deleteAccount();

    void transfer(int source, int target, Float money);
}
