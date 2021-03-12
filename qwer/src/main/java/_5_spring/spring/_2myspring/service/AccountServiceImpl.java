package _5_spring.spring._2myspring.service;

import _5_spring.spring._2myspring.model.Account;

public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("----saveAccount---11111----");
    }

    @Override
    public void updateAccount(Account account) {
        System.out.println("----updateAccount----22222----");
    }

    @Override
    public int deleteAccount() {
        System.out.println("----deleteAccount----33333----");
        return 0;
    }
}
