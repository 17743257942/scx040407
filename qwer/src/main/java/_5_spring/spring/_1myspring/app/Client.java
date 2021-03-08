package _5_spring.spring._1myspring.app;

import _5_spring.spring._1myspring.dao.IAccountDao;
import _5_spring.spring._1myspring.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("mybeans.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);

        System.out.println(as);
//        System.out.println(as);
        System.out.println(adao);
        ac.close();


    }
}
