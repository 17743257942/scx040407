package _5_spring.spring._5springTx;

import _5_spring.spring._4spring_jdbc.config.SpringConfiguration;
import _5_spring.spring._4spring_jdbc.dao.AccountDaoImpl;
import _5_spring.spring._4spring_jdbc.service.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountServiceImpl service = ac.getBean("service", AccountServiceImpl.class);
        System.out.println(service);
        service.transfer(1,2,200f);
    }
}
