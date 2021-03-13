package _5_spring.spring._4spring_jdbc.app;

import _5_spring.spring._4spring_jdbc.config.SpringConfiguration;
import _5_spring.spring._4spring_jdbc.dao.AccountDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountDaoImpl dao = ac.getBean("accountDao", AccountDaoImpl.class);
        System.out.println(dao);
        System.out.println("----all datas----" + dao.findAll());
    }
}
