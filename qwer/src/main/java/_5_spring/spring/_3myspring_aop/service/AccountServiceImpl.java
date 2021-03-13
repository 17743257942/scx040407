package _5_spring.spring._3myspring_aop.service;

import _5_spring.spring._3myspring_aop.model.Account;
import org.springframework.stereotype.Service;

@Service("service")
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("----saveAccount---11111----");
//        System.out.println(1 / 0);
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
