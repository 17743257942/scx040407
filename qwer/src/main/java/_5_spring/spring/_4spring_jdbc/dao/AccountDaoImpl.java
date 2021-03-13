package _5_spring.spring._4spring_jdbc.dao;

import _5_spring.spring._1myspring.model.Account;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    @Qualifier("tp")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> findAll() {
        try {
            return jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findOne(Integer id) {
        try {
            return jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), id).get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Account account) {
        try {
            jdbcTemplate.update("insert into account(name,money) values(?,?)", account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Account account) {
        try {
            jdbcTemplate.update("update account set name=?, money=? where id=?", account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            jdbcTemplate.update("delete from account where id=?", id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
