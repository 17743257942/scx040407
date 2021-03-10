package _5_spring.spring._0myspring.app;

import _5_spring.spring._0myspring.dao.IAccountDao;
import _5_spring.spring._0myspring.model.Account;
import _5_spring.spring._0myspring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("mybeans.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(as);
//        System.out.println(as);
        System.out.println(adao);
//        ac.close();
        List<Account> result = as.findAll();
        System.out.println(result);
        Account rs1 = as.findOne(2);
        System.out.println(rs1);
        Account account = new Account();
        account.setMoney(2000f);
        account.setName("ddd");
        as.save(account);
        as.delete(3);
    }
}
