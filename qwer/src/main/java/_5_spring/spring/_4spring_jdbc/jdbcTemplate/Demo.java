package _5_spring.spring._4spring_jdbc.jdbcTemplate;

import _5_spring.spring._4spring_jdbc.config.SpringConfiguration;
import _5_spring.spring._4spring_jdbc.model.Account;
import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        JdbcTemplate tp = ac.getBean("tp", JdbcTemplate.class);
        /**
         * 增删改可以都用update
         */
//        tp.execute("insert into account(name,money) values('eee',2100);");
//        tp.update("insert into account(name,money) values(?,?)", "fff", 3333);
//        tp.update("update account set name=? ,money=? where id=?", "asdf", 5555, 4);
//        tp.update("delete from account where id=?", 4);
        /**
         * 查询要用rowmapper对象
         */
//        List<Account> result = tp.query("select * from account where money > ?", new AccountRowMapper(), 1000f);
        List<Account> result = tp.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 1000f);
        System.out.println(result);

        List<Account> result1 = tp.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 1);
        System.out.println(result1.isEmpty() ? "没有内容" : result1.get(0));
        // 返回一行一列（使用聚合函数但不加 group by 子句）
        Long result2 = tp.queryForObject("select count(*) from account where money>? ", Long.class, 1000f);
        System.out.println(result2);
    }
}


class AccountRowMapper implements RowMapper<Account> {

    /**
     * 重写封装策略，把结果集的数据封装到Account中，由spring把每个Account加到集合中
     *
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}