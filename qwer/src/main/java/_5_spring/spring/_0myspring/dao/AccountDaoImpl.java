package _5_spring.spring._0myspring.dao;

import _5_spring.spring._0myspring.model.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;

    public AccountDaoImpl() {
        System.out.println("AccountDaoImpl obj has been created ... ");
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public String toString() {
        return "AccountDaoImpl{" +
                "runner=" + runner +
                '}';
    }

    @Override
    public List<Account> findAll() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findOne(Integer id) {
        try {
            return runner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Account account) {
        try {
            runner.update("insert into account(name,money) values(?,?)", account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Account account) {
        try {
            runner.update("update account set name=?, money=? where id=?", account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            runner.update("delete from account where id=?", id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
