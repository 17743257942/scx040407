package _5_spring.spring._1myspring.service;

import _5_spring.spring._1myspring.dao.IAccountDao;
import _5_spring.spring._1myspring.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.*;
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

//    @Autowired
//    @Qualifier("accountDao")
//    private IAccountDao accountDao;

    @Resource(name = "accountDao")
    private IAccountDao accountDao;

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "accountDao=" + accountDao +
                '}';
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findOne(Integer id) {
        return accountDao.findOne(id);
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        accountDao.save(account);
    }

    @Override
    public void delete(Integer id) {
        accountDao.delete(id);
    }
}
