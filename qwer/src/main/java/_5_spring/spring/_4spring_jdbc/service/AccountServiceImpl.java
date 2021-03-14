package _5_spring.spring._4spring_jdbc.service;

import _5_spring.spring._4spring_jdbc.dao.AccountDaoImpl;
import _5_spring.spring._4spring_jdbc.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("service")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class AccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier("accountDao")
    private AccountDaoImpl accountDao;

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

    @Override
    @Transactional(timeout = 100000, propagation = Propagation.SUPPORTS)
    public void transfer(int source, int target, Float money) {
        System.out.println("----transfer----44444----");
        Account sAccount = accountDao.findOne(source);
        Account tAccount = accountDao.findOne(target);
        sAccount.setMoney(sAccount.getMoney() - money);
        tAccount.setMoney(tAccount.getMoney() + money);
        accountDao.update(sAccount);
        System.out.println(1 / 0);
        accountDao.update(tAccount);
    }


}
