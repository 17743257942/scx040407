package _5_spring.spring._0myspring.service;

import _5_spring.spring._0myspring.dao.IAccountDao;
import _5_spring.spring._0myspring.model.Account;
import lombok.Data;

import java.util.*;
@Data
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    private String name;
    private Integer age;
    private Date birthday;
    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties myProps;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public AccountServiceImpl() {
    }

    public void init() {
        System.out.println("init ...................");
    }


    public void destroy() {
        System.out.println("destroy ...................");
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
