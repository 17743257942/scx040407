package _5_spring.spring._0myspring.service;

import _5_spring.spring._0myspring.dao.IAccountDao;
import _5_spring.spring._0myspring.model.Account;

import java.util.List;

public class AccountServiceImpl implements IAccountService {


    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
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
