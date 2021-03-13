package _5_spring.spring._3myspring.app;

import _5_spring.spring._3myspring.config.SpringConfiguration;
import _5_spring.spring._3myspring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService as = (IAccountService) ac.getBean("service");

        System.out.println(as);
        as.saveAccount();
    }
}
