package _5_spring.spring._2myspring_aop.app;

import _5_spring.spring._2myspring_aop.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("mybeans.xml");
        IAccountService as = (IAccountService) ac.getBean("service");

        System.out.println(as);
        as.saveAccount();
    }
}
