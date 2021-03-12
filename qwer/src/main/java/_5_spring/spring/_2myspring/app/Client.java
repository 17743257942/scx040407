package _5_spring.spring._2myspring.app;

import _5_spring.spring._0myspring.dao.IAccountDao;
import _5_spring.spring._0myspring.model.Account;
import _5_spring.spring._2myspring.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("mybeans.xml");
        IAccountService as = (IAccountService) ac.getBean("service");

        System.out.println(as);
        as.saveAccount();
    }
}
